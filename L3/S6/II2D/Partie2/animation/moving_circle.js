var animations=[]

animations.MovingCircle=function(output_canvas_id,opt_options) {
  this.radius=opt_options&&opt_options.radius?opt_options.radius:5;

  this.x0=opt_options&&opt_options.x0?opt_options.x0:5;
  this.y0=opt_options&&opt_options.y0?opt_options.y0:5;

  this.step_x=opt_options&&opt_options.step_x?opt_options.step_x:1;
  this.step_y=opt_options&&opt_options.step_x?opt_options.step_y:0;

  this.random=opt_options&&opt_options.random?true:false;

  this.output_cvs=document.getElementById(output_canvas_id);
  this.output_ctxt=this.output_cvs.getContext("2d");
  this.fillColor=opt_options&&opt_options.fillColor?opt_options.fillColor:[255,0,0,255];

}

animations.MovingCircle.prototype.move=function() {
  var local_dx=Math.round(this.step_x*(!this.random?1:Math.random()));
  var local_dy=Math.round(this.step_y*(!this.random?1:Math.random()));

  this.x0+=local_dx; this.y0+=local_dy;

  if ((this.x0+this.radius)>this.output_cvs.width) {
    this.x0=this.output_cvs.width-this.radius; this.step_x=-this.step_x;
  } else if (this.x0 < this.radius ) {
      this.x0=this.radius; this.step_x=-this.step_x;
  }

  if ((this.y0+this.radius) > this.output_cvs.height) {
    this.y0=this.output_cvs.height-this.radius; this.step_y=-this.step_y;
  } else if (this.y0 < this.radius ) {
    this.y0=this.radius; this.step_y=-this.step_y;
  }
}

animations.MovingCircle.prototype.draw=function() {
  this.output_ctxt.fillStyle="rgba("+this.fillColor.join(",")+")";
  this.output_ctxt.beginPath();
  this.output_ctxt.arc(this.x0,this.y0,this.radius,0,2*Math.PI);
  this.output_ctxt.fill();
}
animations.MovingCircle.prototype.clean=function() {
  this.output_ctxt.beginPath();
  this.output_ctxt.clearRect(this.x0-this.radius,this.y0-this.radius,this.radius*2,this.radius*2);
}

animations.MovingCircle.prototype.animate=function() {
  this.clean();
  this.move();
  this.draw();
}


animations.MovingCircleHChangingColor=function(output_canvas_id,opt_options) {
  this.moving_circle=new animations.MovingCircle(output_canvas_id,opt_options);

  this.fillColor0=opt_options&&opt_options.fillColor0?opt_options.fillColor0:[255,0,0,0];
  this.fillColor1=opt_options&&opt_options.fillColor1?opt_options.fillColor1:[0,255,0,0];
  this.fillColorNbSteps=opt_options&&opt_options.fillColorNbSteps?opt_options.fillColorNbSteps:5;
  this.fillColorIncrement=[];
  for (i=0;i<4;i++) {
    this.fillColorIncrement[i]=(this.fillColor1[i]-this.fillColor0[i])/this.fillColorNbSteps;
  };
  this.moving_circle.fillColor=this.fillColor0;
  this.fillColorStepCount=0;
  this.fillColorIncrementSign=1;

}

animations.MovingCircleHChangingColor.prototype.move=function() {


  if (this.fillColorStepCount==this.fillColorNbSteps) {
    this.fillColorIncrementSign=-this.fillColorIncrementSign;
    this.fillColorStepCount=0;
  };

  for (i=0;i<4;i++) {
    this.moving_circle.fillColor[i]+=this.fillColorIncrementSign*this.fillColorIncrement[i];
  };
  this.fillColorStepCount++;

  this.moving_circle.move();
}

animations.MovingCircleHChangingColor.prototype.draw=function() {
  this.moving_circle.draw();
}

animations.MovingCircleHChangingColor.prototype.clean=function() {
  this.moving_circle.clean();
}

animations.MovingCircleHChangingColor.prototype.animate=function() {
  this.clean();
  this.move();
  this.draw();
}


animations.MovingCircleHChangingColorChangingBackground=function(output_canvas_id,opt_options) {
  this.moving_circle=new animations.MovingCircleHChangingColor(output_canvas_id,opt_options);

  this.output_cvs=document.getElementById(output_canvas_id);
  this.output_ctxt=this.output_cvs.getContext("2d");

  this.bgColor0=opt_options&&opt_options.bgColor0?opt_options.bgColor0:[255,0,0,255];
  this.bgColor1=opt_options&&opt_options.bgColor1?opt_options.bgColor1:[0,255,0,255];
  this.bgColorNbSteps=opt_options&&opt_options.bgColorNbSteps?opt_options.bgColorNbSteps:5;
  this.bgColorIncrement=[];
  for (i=0;i<4;i++) {
    this.bgColorIncrement[i]=(this.bgColor1[i]-this.bgColor0[i])/this.bgColorNbSteps;
  };
  this.bgColor=this.bgColor0;
  this.bgColorStepCount=0;
  this.bgColorIncrementSign=1;

}

animations.MovingCircleHChangingColorChangingBackground.prototype.draw=function() {
  this.output_ctxt.fillStyle="rgba("+this.bgColor.join(",")+")";
  this.output_ctxt.beginPath();
  this.output_ctxt.fillRect(0,0,this.output_cvs.width,this.output_cvs.height);

  this.moving_circle.draw();
}

animations.MovingCircleHChangingColorChangingBackground.prototype.move=function() {

  if (this.bgColorStepCount==this.bgColorNbSteps) {
    this.bgColorIncrementSign=-this.bgColorIncrementSign;
    this.bgColorStepCount=0;
  };

  for (i=0;i<4;i++) {
    this.bgColor[i]+=this.bgColorIncrementSign*this.bgColorIncrement[i];
  };
  this.bgColorStepCount++;

  this.moving_circle.move();
}

animations.MovingCircleHChangingColorChangingBackground.prototype.clean=function(){
  this.moving_circle.clean();
}

animations.MovingCircleHChangingColorChangingBackground.prototype.animate=function(){
  this.clean();
  this.move();
  this.draw();
}



animations.MovingTwoCircle=function(output_canvas_id,opt_options) {
  this.radius1=opt_options&&opt_options.radius1?opt_options.radius1:5;

  this.x0=opt_options&&opt_options.x0?opt_options.x0:5;
  this.y0=opt_options&&opt_options.y0?opt_options.y0:5;

  this.step_x1=opt_options&&opt_options.step_x1?opt_options.step_x1:1;
  this.step_y1=opt_options&&opt_options.step_x1?opt_options.step_y1:0;

  this.random1=opt_options&&opt_options.random1?true:false;

  this.output_cvs=document.getElementById(output_canvas_id);
  this.output_ctxt=this.output_cvs.getContext("2d");
  this.fillColor1=opt_options&&opt_options.fillColor1?opt_options.fillColor1:[255,0,0,255];


  this.radius2=opt_options&&opt_options.radius2?opt_options.radius2:5;

  this.x2=opt_options&&opt_options.x2?opt_options.x2:5;
  this.y2=opt_options&&opt_options.y2?opt_options.y2:5;

  this.step_x2=opt_options&&opt_options.step_x2?opt_options.step_x2:1;
  this.step_y2=opt_options&&opt_options.step_x2?opt_options.step_y2:0;

  this.random2=opt_options&&opt_options.random2?true:false;
  this.fillColor2=opt_options&&opt_options.fillColor2?opt_options.fillColor2:[255,0,0,255];
}

animations.MovingTwoCircle.prototype.move=function() {
  var local_dx1=Math.round(this.step_x1*(!this.random1?1:Math.random()));
  var local_dy1=Math.round(this.step_y1*(!this.random1?1:Math.random()));

  this.x0+=local_dx1; this.y0+=local_dy1;

  if ((this.x0+this.radius1)>this.output_cvs.width) {
    this.x0=this.output_cvs.width-this.radius1; this.step_x1=-this.step_x1;
  } else if (this.x0 < this.radius1 ) {
      this.x0=this.radius1; this.step_x1=-this.step_x1;
  }

  if ((this.y0+this.radius1) > this.output_cvs.height) {
    this.y0=this.output_cvs.height-this.radius1; this.step_y1=-this.step_y1;
  } else if (this.y0 < this.radius1 ) {
    this.y0=this.radius1; this.step_y1=-this.step_y1;
  }


  var local_dx2=Math.round(this.step_x2*(!this.random2?1:Math.random()));
  var local_dy2=Math.round(this.step_y2*(!this.random2?1:Math.random()));

  this.x2+=local_dx2; this.y2+=local_dy2;

  if ((this.x2+this.radius2)>this.output_cvs.width) {
    this.x2=this.output_cvs.width-this.radius2; this.step_x2=-this.step_x2;
  } else if (this.x2 < this.radius2 ) {
      this.x2=this.radius2; this.step_x2=-this.step_x2;
  }

  if ((this.y2+this.radius2) > this.output_cvs.height) {
    this.y2=this.output_cvs.height-this.radius2; this.step_y2=-this.step_y2;
  } else if (this.y2 < this.radius2 ) {
    this.y2=this.radius2; this.step_y2=-this.step_y2;
  }
}

animations.MovingTwoCircle.prototype.draw=function() {
  this.output_ctxt.fillStyle="rgba("+this.fillColor1.join(",")+")";
  this.output_ctxt.beginPath();
  this.output_ctxt.arc(this.x0,this.y0,this.radius1,0,2*Math.PI);
  this.output_ctxt.fill();


  this.output_ctxt.fillStyle="rgba("+this.fillColor2.join(",")+")";
  this.output_ctxt.beginPath();
  this.output_ctxt.arc(this.x2,this.y2,this.radius2,0,2*Math.PI);
  this.output_ctxt.fill();
}
animations.MovingTwoCircle.prototype.clean=function() {
  this.output_ctxt.beginPath();
  this.output_ctxt.clearRect(this.x0-this.radius1,this.y0-this.radius1,this.radius1*2,this.radius1*2);

  this.output_ctxt.beginPath();
  this.output_ctxt.clearRect(this.x2-this.radius2,this.y2-this.radius2,this.radius2*2,this.radius2*2);
}

animations.MovingTwoCircle.prototype.animate=function() {
  this.clean();
  this.move();
  this.draw();
}
