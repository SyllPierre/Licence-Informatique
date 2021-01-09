ToGrayTask=function(opt_options) { }

ToGrayTask.prototype.process=function(imageData) {
  var pixels=imageData.data;
  var w=0;
  for (var i = 0; i < imageData.height; i++)
      for (var j = 0; j < imageData.width; j++) {
        var mean=(pixels[w+1]+pixels[w+2]+pixels[w+3])/3;
        pixels[w]=mean; pixels[w+1]=mean; pixels[w+2]=mean;
        w+=4;
      }
}

PartialGrayTask=function(opt_options) {
  this.reg_x=opt_options.reg_x; this.reg_y=opt_options.reg_y;
  this.reg_w=opt_options.reg_w; this.reg_h=opt_options.reg_h;
}

PartialGrayTask.prototype.process=function(imageData) {
  var pixels=imageData.data;
  for (var i = this.reg_y; i < this.reg_y+this.reg_h; i++)
      for (var j = this.reg_x; j < this.reg_x+this.reg_w; j++) {
        var pos=(i*imageData.width+j)<<2;
        var mean=(pixels[pos+1]+pixels[pos+2]+pixels[pos+3])/3;
        pixels[pos]=mean; pixels[pos+1]=mean; pixels[pos+2]=mean;
      }
}

RandomPartialGrayTask=function(opt_options) {
  this.reg_x=opt_options.reg_x; this.reg_y=opt_options.reg_y;
  this.reg_w=opt_options.reg_w; this.reg_h=opt_options.reg_h;
  this.cvs_w=opt_options.cvs_w; this.cvs_h=opt_options.csv_h;
}

RandomPartialGrayTask.prototype.process=function(imageData) {
  var pixels=imageData.data;
  for (var i = this.reg_y; i < this.reg_y+this.reg_h; i++)
      for (var j = this.reg_x; j < this.reg_x+this.reg_w; j++) {
        var pos=(i*imageData.width+j)<<2;
        var mean=(pixels[pos+1]+pixels[pos+2]+pixels[pos+3])/3;
        pixels[pos]=mean; pixels[pos+1]=mean; pixels[pos+2]=mean;
      }
}

RandomPartialGrayTask.prototype.random_focus=function() {
    this.reg_y=Math.trunc(Math.random()*(this.cvs_h-this.reg_h));
    this.reg_x=Math.trunc(Math.random()*(this.cvs_w-this.reg_w));
}



ToBlackWhiteWithThresholdTask=function(opt_options) {
  this.threshold = opt_options.threshold;
  this.ctx = opt_options.ctx;
  this.canvas = opt_options.canvas;
}

ToBlackWhiteWithThresholdTask.prototype.process=function(imageData) {
  var pixels=imageData.data;
  for (var x = 0; x <imageData.width ; x++)
      for (var y = 0; y<imageData.height; y++) {


        var pos = (y * imageData.width + x)<<2;

        var r = pixels[pos + 0], g = pixels[pos + 1], b = pixels[pos + 2], a = pixels[pos + 3];

        var mean=(r+g+b)/3;
        var v = 0;
        if(mean >= this.threshold){
          v= 255;
        }
        pixels[pos + 0] = v;  pixels[pos + 1] = v; pixels[pos + 2] = v; 
      }


    this.ctx.putImageData(imageData,0,0);

}


ToGrayIfRMinTask=function(opt_options) {
  this.ctx = opt_options.ctx;
  this.canvas = opt_options.canvas;
}

ToGrayIfRMinTask.prototype.process=function(imageData) {
  var pixels=imageData.data;
  for (var x = 0; x <imageData.width ; x++)
      for (var y = 0; y<imageData.height; y++) {


        var pos = (y * imageData.width + x)<<2;

        var r = pixels[pos + 0], g = pixels[pos + 1], b = pixels[pos + 2], a = pixels[pos + 3];

        var mean=(r+g+b)/3;
        var gray = r < b || r < g;
        if(gray){
        pixels[pos + 0] = mean;  pixels[pos + 1] = mean; pixels[pos + 2] = mean; 
        }
      }


    this.ctx.putImageData(imageData,0,0);

}


ToGrayWithWeightTask=function(opt_options) {
  this.ctx = opt_options.ctx;
  this.canvas = opt_options.canvas;
  this.weight = opt_options.weight;
}

ToGrayWithWeightTask.prototype.process=function(imageData) {
  var pixels=imageData.data;
  for (var x = 0; x <imageData.width ; x++)
      for (var y = 0; y<imageData.height; y++) {


        var pos = (y * imageData.width + x)<<2;

        var r = pixels[pos + 0], g = pixels[pos + 1], b = pixels[pos + 2], a = pixels[pos + 3];

        var mean=(r*this.weight.r+g*this.weight.g+b*this.weight.b)/(this.weight.r+this.weight.g+this.weight.b);
        pixels[pos + 0] = mean;  pixels[pos + 1] = mean; pixels[pos + 2] = mean; 
      }


    this.ctx.putImageData(imageData,0,0);

}


ToGrayOutsideRadiusTask=function(opt_options) {
  this.ctx = opt_options.ctx;
  this.canvas = opt_options.canvas;
  this.radius = opt_options.radius;
  this.pixel = opt_options.pixel;
}

ToGrayOutsideRadiusTask.prototype.process=function(imageData) {
  var pixels=imageData.data;
  for (var x = 0; x <imageData.width ; x++)
      for (var y = 0; y<imageData.height; y++) {


        var pos = (y * imageData.width + x)<<2;

        var r = pixels[pos + 0], g = pixels[pos + 1], b = pixels[pos + 2], a = pixels[pos + 3];

        var dist = Math.sqrt(Math.pow(this.pixel[0] - x, 2) + Math.pow(this.pixel[1] - y, 2));
        if(dist >= this.radius){
          var mean=(r+g+b)/(3);
          pixels[pos + 0] = mean;  pixels[pos + 1] = mean; pixels[pos + 2] = mean; 
         }
      }


    this.ctx.putImageData(imageData,0,0);

}

ToGrayOutsideRadiusMovingTask=function(opt_options) {
  this.ctx = opt_options.ctx;
  this.canvas = opt_options.canvas;
  this.radius = opt_options.radius;
  this.pixel = opt_options.pixel;
  this.dx = opt_options.dx;
  this.dy = opt_options.dy;
}

ToGrayOutsideRadiusMovingTask.prototype.process=function(imageData) {
  var pixels=imageData.data;

  this.pixel[0] += this.dx;
  this.pixel[1] += this.dy;

  if((this.pixel[0]+this.radius) > imageData.width || this.pixel[0] < this.radius){
      this.dx *= -1;
  }

  if((this.pixel[1]+this.radius) > imageData.height 
    || 
    this.pixel[1] < this.radius){
    this.dy *= -1;
  }

console.log(this.pixel[1]+":"+imageData.height);

  for (var x = 0; x <imageData.width ; x++)
      for (var y = 0; y<imageData.height; y++) {


        var pos = (y * imageData.width + x)<<2;

        var r = pixels[pos + 0], g = pixels[pos + 1], b = pixels[pos + 2], a = pixels[pos + 3];

        var dist = Math.sqrt(Math.pow(this.pixel[0] - x, 2) + Math.pow(this.pixel[1] - y, 2));
        if(dist >= this.radius){
          var mean=(r+g+b)/(3);
          pixels[pos + 0] = mean;  pixels[pos + 1] = mean; pixels[pos + 2] = mean; 
         }
      }


    this.ctx.putImageData(imageData,0,0);

}


ToGrayOutsideRadiusMovingx2Task=function(opt_options) {
  this.ctx = opt_options.ctx;
  this.canvas = opt_options.canvas;
  this.radius = opt_options.radius;
  this.pixel = opt_options.pixel;
  this.dx = opt_options.dx;
  this.dy = opt_options.dy;
}

ToGrayOutsideRadiusMovingx2Task.prototype.process=function(imageData) {
  var pixels=imageData.data;

  this.pixel[0] += this.dx;
  this.pixel[1] += this.dy;

  if((this.pixel[0]+this.radius) > imageData.width || this.pixel[0] < this.radius){
      this.dx *= -1;
  }

  if((this.pixel[1]+this.radius) > imageData.height 
    || 
    this.pixel[1] < this.radius){
    this.dy *= -1;
  }

console.log(this.pixel[1]+":"+imageData.height);

  for (var x = 0; x <imageData.width ; x++)
      for (var y = 0; y<imageData.height; y++) {


        var pos = (y * imageData.width + x)<<2;

        var r = pixels[pos + 0], g = pixels[pos + 1], b = pixels[pos + 2], a = pixels[pos + 3];

        var dist = Math.sqrt(Math.pow(this.pixel[0] - x, 2) + Math.pow(this.pixel[1] - y, 2));
        if(dist >= this.radius){
          var mean=(r+g+b)/(3);
          pixels[pos + 0] = mean;  pixels[pos + 1] = mean; pixels[pos + 2] = mean; 
         } else {


         }
      }


    this.ctx.putImageData(imageData,0,0);

}


