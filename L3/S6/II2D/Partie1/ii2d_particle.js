/**
 *
 *
 *
 * */

class GeneratorBox {
  constructor() {
    this.nbBirth=0;
    this.birthRate=2;
    this.min = new Vector(10,10);
    this.max = new Vector(250,250);
    this.lifeMin = 450;
    this.lifeMax = 500;
    this.vMin = new Vector(0,0);
    this.vMax = new Vector(0,0);
  }

  initParticle(p) {
    p.position.setRandInt(this.min,this.max);
    p.color.r = randInt(0,255);
    p.color.g = randInt(0,255);
    p.color.b = randInt(0,255);
    p.Initlife = randInt(this.lifeMin,this.lifeMax);
    p.life = p.Initlife;
    p.color.alpha=(p.life / p.Initlife);
    p.velocity.setRandInt(this.vMin, this.vMax);
  }

  distance(m){
    return Math.sqrt( Math.pow(this.min.x - m.x,2) + Math.pow(this.min.y - m.y,2));
  }

  move(dx,dy){
    //var oldMin=this.min;
    //var oldMax=this.max;
    this.min.x += dx;
    this.min.y += dy;
    this.max.x += dx
    this.max.y += dy;
    //this.max = new Vector(m.x+(oldMax.x-oldMin.x),m.y+(oldMax.y-oldMin.y));

  }
};



/**
 *
 *
 *
 *  */
class Particle {
  constructor() {
    this.position=new Vector(0,0);
    this.color={r:0,g:0,b:0,alpha:1};
    this.isAlive=false;
    this.life=0;
    this.velocity=new Vector(0,0);
    this.forcity=new Vector(0,0);
    this.oldPosition=new Vector(0,0);
    this.oldVelocity=new Vector(0,0);
  }

  draw() {
    ctx.fillStyle = 'rgba('+this.color.r+','+this.color.g+','+this.color.b+','+this.color.alpha+')';
    ctx.fillRect(this.position.x,this.position.y,5,5);
  }

  motion(t){
    this.oldPosition.setXY(this.position.x,this.position.y);
    this.oldVelocity.setXY(this.velocity.x,this.velocity.y);
    var pos = this.position;
    var velo = this.velocity;
    var a_new = this.forcity;

    velo.x = velo.x+a_new.x*t;
    velo.y = velo.y+a_new.y*t;

    pos.x = pos.x + velo.x*t;
    pos.y = pos.y + velo.y*t;
  }

  force(){
    var g = new Vector(0,9000.81);
    var f = this.forcity;
    f.x = g.x;
    f.y = g.y;
  }

};

/**
 *
 *
 *
 *
 * */


class ParticleManager {
  constructor() {
    this.all=[]
    this.nbAliveMax=5000;
    //this.genrator = new GeneratorBox();
    this.generatorList=[];
    this.selected = null;

    for(var i=0;i<this.nbAliveMax;++i) {
      this.all.push(new Particle());
    }
  }

  select(m){
    this.selected = null;
    var res = 51;
    for(var g=0;g<this.generatorList.length;++g){
      if(this.generatorList[g].distance(m)<res){
        res = this.generatorList[g].distance(m);
        this.selected = this.generatorList[g];
      }
    }
  }

  update() {
    //var p1 = (this.all.length)/2

    //for(var i=0;i<p1;++i){
      //this.all[i].position.setRandInt(new Vector(10,10),new Vector(250,100));
      //this.generatorList[0].initParticle(this.all[i]);
    //}

    //for(var i=p1;i<this.all.length;++i){
      //this.all[i].position.setRandInt(new Vector(10,10),new Vector(250,100));
      //this.generatorList[1].initParticle(this.all[i]);
    //}

    for(var g=0;g<this.generatorList.length;++g){
      this.generatorList[g].nbBirth+= this.generatorList[g].birthRate;
    }

    for(var j=0;j<this.all.length;++j){
      if(this.all[j].isAlive==false){
        var i =0;
        while(!this.all[j].isAlive && i<this.generatorList.length){
          if(this.generatorList[i].nbBirth>=1){
            this.generatorList[i].nbBirth--;
            this.all[j].isAlive = true;
            this.generatorList[i].initParticle(this.all[j]);
          }
          i++;
        }
      }
      else{
        this.all[j].life--;
        if(this.all[j].life==0){
          this.all[j].isAlive = false;
        }
        if(this.all[j].life<10){
          this.all[j].color.alpha -= 0.05;
        }
      }
    }

  }

  draw() {
    for(var i=0;i<this.all.length;++i){
      if(this.all[i].isAlive == true){
        this.all[i].draw();
      }
    }
  }

  motion(t){
    for(var i=0;i<this.all.length;++i){
      this.all[i].motion(t);
    }
  }

  force(){
    for(var i=0;i<this.all.length;++i){
      this.all[i].force();
    }
  }
};
