/**
 *
 * Vector
 *
 *  */
class Vector {
  constructor(x,y) {
    this.x=x;
    this.y=y;
  }

  /// @return p1+p2
  static add(p1,p2) {
    return new Vector(p1.x+p2.x,p1.y+p2.y);
  }

  /// add u to this
  add(u) {
    this.x+=u.x;
    this.y+=u.y;
    return this;
  }

  /// @return a copy of this
  clone() {
    return new Vector(this.x,this.y);
  }

  /// copy p to this
  set(p) {
    this.x=p.x;
    this.y=p.y;
    return this;
  }

  setRandInt(p1,p2){
    this.x=randInt(p1.x,p2.x);
    this.y=randInt(p1.y,p2.y);
    return this;
  }

  setXY(xs,ys){
    this.x = xs;
    this.y = ys;
    return this;
  }

  static scalaire(u, v) {
    return ((u.x*v.x) + (u.y*v.y));
  }

  static createVector(a, b) {
    return new Vector(b.x - a.x, b.y - a.y);
  }

  static normalisation(n) {
    return (Math.sqrt(Math.pow(n.x, 2) + Math.pow(n.y, 2)));
  }

  static multiplication(a,b){
    var newX = 0;
    var newY = 0;
    if(a instanceof Vector && b instanceof Vector){
      newX = a.x*b.x;
      newY = a.y*b.y;
    }else if(a instanceof Vector){
      newX = a.x*b;
      newY = a.y*b;
    }else if(b instanceof Vector){
      newX = b.x*a;
      newY = b.y*a;
    }else{
      return a*b;
    }
    return new Vector(newX,newY);
  }

  static division(a,b){
    var newX = 0;
    var newY = 0;
    if(a instanceof Vector && b instanceof Vector){
      newX = a.x/b.x;
      newY = a.y/b.y;
    }else if(a instanceof Vector){
      newX = a.x/b;
      newY = a.y/b;
    }else if(b instanceof Vector){
      newX = b.x/a;
      newY = b.y/a;
    }else{
      return a/b;
    }
    return new Vector(newX,newY);
  }

  static addition(a,b){
    var newX = 0;
    var newY = 0;
    if(a instanceof Vector && b instanceof Vector){
      newX = a.x+b.x;
      newY = a.y+b.y;
    }else if(a instanceof Vector){
      newX = a.x+b;
      newY = a.y+b;
    }else if(b instanceof Vector){
      newX = b.x+a;
      newY = b.y+a;
    }else{
      return a+b;
    }
    return new Vector(newX,newY);
  }

  static soustraction(a,b){
    var newX = 0;
    var newY = 0;
    if(a instanceof Vector && b instanceof Vector){
      newX = a.x-b.x;
      newY = a.y-b.y;
    }else if(a instanceof Vector){
      newX = a.x-b;
      newY = a.y-b;
    }else if(b instanceof Vector){
      newX = b.x-a;
      newY = b.y-a;
    }else{
      return a-b;
    }
    return new Vector(newX,newY);
  }

 };
