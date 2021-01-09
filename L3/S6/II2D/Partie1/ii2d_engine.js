/**
 *
 *
 * */


var randInt=function(a,b) {
	return Math.floor(Math.random()*(b-a)+a);
}


class Engine {
  constructor() {
    this.particleManager = new ParticleManager();
		this.obstacleManager = new ObstacleManager();
    this.time=0;
    this.deltaTime=0.01;
  }

  draw() {
    ctx.clearRect(0,0,500,500);
		/**
		ctx.fillStyle = 'green';
		var c = new Vector(0,0);
		c.setRandInt(new Vector(100,150),new Vector(200,250))
		ctx.fillRect(c.x,c.y,100,150);
		**/
		this.particleManager.draw();
		this.obstacleManager.draw();
  }

  updateData() {
		this.particleManager.update();
		this.force();
		this.motion();
		this.collision();
		this.oldPosObs();
  }

  loop() {
    this.time+=this.deltaTime;
    this.updateData();
    this.draw();
    window.requestAnimationFrame(this.loop.bind(this));
	}

  start() {
    this.loop();
  }

	motion(){
		this.particleManager.motion(this.deltaTime);
	}

	force(){
		this.particleManager.force();
	}

	collision(){
		for(var i = 0;i<this.particleManager.all.length;i++){
			for(var j = 0;j<this.obstacleManager.obstacleList.length;j++){
				this.solveCollision(this.particleManager.all[i],this.obstacleManager.obstacleList[j]);
			}
		}
	}

	solveCollision(une_particule, un_obstacle){
		//var oldPos= une_particule.oldPosition;
		var oldPos = un_obstacle.oldPosCorrec(une_particule);
    var res = un_obstacle.intersect(oldPos, une_particule.position);
    if(res.isIntersect == true){
      if (un_obstacle instanceof Circle)
        this.impulseCircle(une_particule, res.normal, res.position, un_obstacle);
      else if (un_obstacle instanceof Segment)
        this.impulseSegment(une_particule, res.normal, res.position, un_obstacle);
    }
	}

	impulseSegment(p,ncol,pcol, o) {
    var normCol = Vector.normalisation(ncol);
    ncol = Vector.division(ncol, normCol);
    var xNew = Vector.createVector(p.position, pcol);
    var h = Vector.multiplication(Vector.scalaire(xNew, ncol), ncol);
    h = Vector.multiplication(h, 1.5);
    var xcol = Vector.addition(p.position, h);
		var vnew = Vector.multiplication(Vector.scalaire(p.velocity, ncol), ncol);
		vnew = Vector.multiplication(vnew, 1.5);
		var vcol = Vector.soustraction(p.velocity, vnew);
    p.velocity.setXY(vcol.x, vcol.y);
    p.position.setXY(xcol.x, xcol.y);
  }

	impulseCircle(p,ncol,pcol, o) {
    var normCol = Vector.normalisation(ncol);
    ncol = Vector.division(ncol, normCol);
    var xNew = Vector.createVector(p.position, pcol);
    var h = Vector.multiplication(Vector.scalaire(xNew, ncol), ncol);
    h = Vector.multiplication(h, 2);
    var xcol = Vector.addition(p.position, h);
    var vnew = Vector.multiplication(Vector.scalaire(p.velocity, ncol), ncol);
    vnew = Vector.multiplication(vnew, 2);
    var vcol = Vector.soustraction(p.velocity, vnew);
    p.velocity.setXY(vcol.x, vcol.y);
    p.position.setXY(xcol.x, xcol.y);
  }

	oldPosObs(){
    for (var i = 0; i < this.obstacleManager.obstacleList.length; i++) {
			if (this.obstacleManager.obstacleList[i] instanceof Segment) {
        this.obstacleManager.obstacleList[i].olda.setXY(this.obstacleManager.obstacleList[i].a.x, this.obstacleManager.obstacleList[i].a.y);
        this.obstacleManager.obstacleList[i].oldb.setXY(this.obstacleManager.obstacleList[i].b.x, this.obstacleManager.obstacleList[i].b.y);
      }
			else if (this.obstacleManager.obstacleList[i] instanceof Circle){
				this.obstacleManager.obstacleList[i].oldCenter.setXY(this.obstacleManager.obstacleList[i].center.x, this.obstacleManager.obstacleList[i].center.y);
			}
    }
  }

}
