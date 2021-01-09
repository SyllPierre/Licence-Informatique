GetPixelRGBATask=function(opt_options) {
  this.x=opt_options.x;
  this.y=opt_options.y;
  this.output=opt_options.output;
}

GetPixelRGBATask.prototype.process=function(imageData) {
  var pos=(this.y*imageData.width+this.x)<<2;
  var r=imageData.data[pos];
  var g=imageData.data[pos+1];
  var b=imageData.data[pos+2];
  var a=imageData.data[pos+3];

  this.output.innerHTML=this.x+"x"+this.y+" : ";
  this.output.innerHTML+="<font color='red'>"+r+"</font> | ";
  this.output.innerHTML+="<font color='green'>"+g+"</font> | ";
  this.output.innerHTML+="<font color='blue'>"+b+"</font> | ";
  this.output.innerHTML+="<font color='gray'>"+a+"</font>";
}


GetRandomRGBAPixelTask =function(opt_options) {
  this.output=opt_options.output;
}

GetRandomRGBAPixelTask.prototype.process=function(imageData) {
  this.x= Math.floor(Math.random() * imageData.width);
  this.y= Math.floor(Math.random() * imageData.height);

  var pos=(this.y*imageData.width+this.x)<<2;
  var r=imageData.data[pos];
  var g=imageData.data[pos+1];
  var b=imageData.data[pos+2];
  var a=imageData.data[pos+3];

  this.output.innerHTML=this.x+"x"+this.y+" : ";
  this.output.innerHTML+="<font color='red'>"+r+"</font> | ";
  this.output.innerHTML+="<font color='green'>"+g+"</font> | ";
  this.output.innerHTML+="<font color='blue'>"+b+"</font> | ";
  this.output.innerHTML+="<font color='gray'>"+a+"</font>";
}



GetMeanPixelTask =function(opt_options) {
  this.output=opt_options.output;
}

GetMeanPixelTask.prototype.process=function(imageData) {

  var sumR = 0;
  var sumG = 0;
  var sumB = 0;
  var sumA = 0;
  var count = 0;
  var pixels = imageData.data;
  for (var x = 0; x <imageData.width ; x++)
    for (var y = 0; y<imageData.height; y++) {

      var pos = (y * imageData.width + x)<<2;

      var r = pixels[pos + 0], g = pixels[pos + 1], b = pixels[pos + 2], a = pixels[pos + 3];

      sumR += r;
      sumG += g;
      sumB += b;
      sumA += a;
      count++;
    }

  this.output.innerHTML="Mean pixel :";
  this.output.innerHTML+="<font color='red'>"+Math.floor(sumR/count)+"</font> | ";
  this.output.innerHTML+="<font color='green'>"+Math.floor(sumG/count)+"</font> | ";
  this.output.innerHTML+="<font color='blue'>"+Math.floor(sumB/count)+"</font> | ";
  this.output.innerHTML+="<font color='gray'>"+Math.floor(sumA/count)+"</font>";
}
