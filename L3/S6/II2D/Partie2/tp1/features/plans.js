DetectionPlansTask =function(opt_options) {
  this.output=opt_options.output;
  this.previous = null;
  this.now = null;
}

DetectionPlansTask.prototype.process=function(imageData) {
  this.previous = this.now;

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


    this.now = [Math.floor(sumR/count),
                Math.floor(sumG/count),
                Math.floor(sumB/count)];

    if(this.previous == null){
      this.previous = this.now;
    }
    var r0 = this.previous[0];
    var g0 = this.previous[1];
    var b0 = this.previous[2];

    var r1 = this.now[0];
    var g1 = this.now[1];
    var b1 = this.now[2];
    var dist = Math.sqrt((r0-r1)*(r0-r1)+(b0-b1)*(b0-b1)+(g0-g1)*(g0-g1));
    if(dist > 5) {
      this.output.innerHTML+="<font color='green'>(+) Changement de plan</font><br> ";
    }

  //alert("Detected a plan");
}
