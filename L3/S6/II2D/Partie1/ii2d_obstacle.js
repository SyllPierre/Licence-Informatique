class Circle {
	constructor(center, radius) {
		this.center = center;
		this.oldCenter = new Vector(0,0);
		this.radius = radius;
		this.color = 'red';
		this.velocity = new Vector(0,0);
	}

	draw() {
		ctx.strokeStyle = this.color;
		ctx.beginPath();
		ctx.arc(this.center.x, this.center.y, this.radius, 0, 2 * Math.PI);
		ctx.stroke();
		ctx.strokeStyle = 'rgb(0,0,0)';
	}

	move(dx, dy) {
		this.center.setXY(this.center.x + dx, this.center.y + dy);
	}

	distance(m) {
		return Math.abs(Math.sqrt(Math.pow(this.center.x - m.x, 2) + Math.pow(this.center.y - m.y, 2)) - this.radius);
	}

	distance2(m){
		return Math.sqrt(Math.pow(this.center.x - m.x, 2) + Math.pow(this.center.y - m.y, 2));
	}

	intersect(p1,p2){
		var normale = new Vector(1,0);
		if ((this.distance2(p2)<=this.radius && this.distance2(p1)>=this.radius)||(this.distance2(p2)>=this.radius && this.distance2(p1)<=this.radius)){
			var n = Math.sqrt(Math.pow((p1.x - this.center.x),2) + Math.pow((p1.y - this.center.y),2));
			var oldM = Vector.createVector(p1, this.center);
			normale = new Vector(oldM.x / n, oldM.y / n);
			return {isIntersect : true, normal : normale, position : p1};
		}
		return {isIntersect : false, normal : normale, position : p1};
	}

	oldPosCorrec(p) {
		var res = Vector.createVector(this.oldCenter, this.center);
		var cOldc = Vector.division(Vector.soustraction(this.center,this.oldCenter).y, Vector.soustraction(this.center,this.oldCenter).x);
		var oldcp = Vector.division(Vector.soustraction(p.oldPosition, p.position).y, Vector.soustraction(p.oldPosition, p.position).x);
		if (cOldc != oldcp){
			return new Vector(p.oldPosition.x + res.x, p.oldPosition.y + res.y);
		}
		else{
			return p.oldPosition;
		}
	}
}

class Segment {
	constructor(a,b) {
		this.a = a;
		this.b = b;
		this.olda = new Vector(0,0);
		this.oldb = new Vector(0,0);
		this.color = 'red';
		this.zone = null;
		this.velocity = new Vector(0,0);
	}

	draw() {
		ctx.strokeStyle = this.color;
		ctx.beginPath();
		ctx.moveTo(this.a.x, this.a.y);
		ctx.lineTo(this.b.x, this.b.y);
		ctx.stroke();
		ctx.strokeStyle = 'rgb(0,0,0)';
	}

	move(dx, dy) {
		if (this.zone == 'a'){
      this.a.setXY(this.a.x + dx, this.a.y + dy);
    }
		else if (this.zone == 'b'){
      this.b.setXY(this.b.x + dx, this.b.y + dy);
    }
		else if(this.zone == 'line') {
			this.a.setXY(this.a.x + dx, this.a.y + dy);
			this.b.setXY(this.b.x + dx, this.b.y + dy);
		}
	}

	distance(m) {

		var ab = Vector.createVector(this.a, this.b);
		var dab = Math.sqrt(Math.pow(this.a.x - this.b.x, 2) + Math.pow(this.a.y - this.b.y, 2));
		var am = Vector.createVector(this.a, m);
		var ba = Vector.createVector(this.b, this.a);
		var bm = Vector.createVector(this.b, m);
		var normale = new Vector((ab.y * (-1)) / dab, ab.x / dab);


		if(Vector.scalaire(am, ab) < 0) {
			this.zone = 'a';
			return Math.sqrt(Math.pow(this.a.x - m.x, 2) + Math.pow(this.a.y - m.y, 2));
		}

		else if(Vector.scalaire(bm, ba) < 0) {
			this.zone = 'b';
			return Math.sqrt(Math.pow(this.b.x - m.x, 2) + Math.pow(this.b.y - m.y, 2));
		}

		else {
			var distA = Math.sqrt(Math.pow(this.a.x - m.x, 2) + Math.pow(this.a.y - m.y, 2));
			var distB = Math.sqrt(Math.pow(this.b.x - m.x, 2) + Math.pow(this.b.y - m.y, 2));
			if (distA < 15) {
				this.zone = 'a';
				return distA;
			}

			else if(distB < 15) {
				this.zone = 'b';
				return distB;
			}
			else {
				this.zone = 'line';
				return Math.abs(Vector.scalaire(am, normale));
			}
		}
	}

	getZone(m){
		var ab = Vector.createVector(this.a, this.b);
		var am = Vector.createVector(this.a, m);
		var ba = Vector.createVector(this.b, this.a);
		var bm = Vector.createVector(this.b, m);
		if(Vector.scalaire(am, ab) < 0) {
			return 'a';
		}
		else if(Vector.scalaire(bm, ba) < 0) {
			return 'b';
		}

		else{
			return 'line';
		}
	}

	intersect(p1,p2){
		var ab = Vector.createVector(this.a, this.b);
		var dab = Math.sqrt(Math.pow(this.a.x - this.b.x, 2) + Math.pow(this.a.y - this.b.y, 2));
		var normaleAB = new Vector((ab.y * (-1)) / dab, ab.x / dab);
		var p1A = Vector.createVector(p1, this.a);
		var p2A = Vector.createVector(p2, this.a);
		var signe1 = Vector.scalaire(p1A,normaleAB);
		var signe2 = Vector.scalaire(p2A,normaleAB);
		var zone = this.getZone(p1);

		if(((signe1>=0 && signe2<=0) || (signe1<=0 && signe2>=0)) && zone == 'line'){
			return {isIntersect : true, normal : normaleAB, position : p1};
		}
		else{
			return {isIntersect : false, normal : new Vector(1,0), position : p1};
		}
	}

	oldPosCorrec(p) {
		var oldP = new Vector((this.olda.x + this.oldb.x) / 2, (this.olda.y + this.oldb.y) / 2);
		var newP = new Vector((this.a.x + this.b.x) / 2, (this.a.y + this.b.y) / 2);
		var res = Vector.createVector(oldP, newP);
		return new Vector(p.oldPosition.x + res.x, p.oldPosition.y + res.y);
	}

}

class ObstacleManager {
	constructor() {
		this.obstacleList = [];
		this.selected = null;
	}

	draw() {
		for (var i = 0; i < this.obstacleList.length; i++) {
			this.obstacleList[i].draw();
		}
	}

	select(m) {
		this.selected = null;
		var res = 51;
  		for (var i = 0; i < this.obstacleList.length; i++) {
  			if (this.obstacleList[i].distance(m) < res) {
  				res = this.obstacleList[i].distance(m);
  				this.selected = this.obstacleList[i];
  			}
  		}
	}
}
