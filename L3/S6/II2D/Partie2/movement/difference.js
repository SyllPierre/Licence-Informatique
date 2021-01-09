var diff={}

diff.DifferenceImageRGB=function(opt_options) {
  this.difference = document.createElement("canvas");
  this.previous = document.createElement("canvas");

  this.width=opt_options.width;
  this.height=opt_options.height;

  this.difference.width=this.width; this.difference.height=this.height;
  this.previous.width=this.width; this.previous.height=this.height;

  this.difference_ctxt = this.difference.getContext("2d");
  this.previous_ctxt = this.previous.getContext("2d");
}

diff.DifferenceImageRGB.prototype.set_first_frame_imgData=function(imgData) {
  this.previous_ctxt.putImageData(imgData,0,0);
}

diff.DifferenceImageRGB.prototype.set_first_frame_from_eltId=function(eltId) {
  var elt=document.getElementById(eltId);
  var cvs=document.createElement("canvas");
  cvs.width=elt.width; cvs.height=elt.height;
  var ctxt=cvs.getContext("2d");
  ctxt.drawImage(elt,0,0);
  this.set_first_frame_imgData(ctxt.getImageData(0,0,cvs.width,cvs.height));
}

diff.DifferenceImageRGB.prototype.process=function(in_imgData, out_imgData) {

  //BLOC1
  //Récupération de l'image précédente que l'on stock dans previous_imgData
  var previous_imgData = this.previous_ctxt.
                            getImageData(0, 0, this.width, this.height);

  //BLOC2
  //On regarde tout les pixels et on y leurs canaux
  //On stock ensuite le pixel dans out_imgData avec l'opacité au max
  //et l'image actuelle devient l'ancienne
  var w=0;
  for (var x=0; x<this.width ; x++)
    for (var y=0; y<this.height ; y++) {
        for (var i=0; i<3; i++) {
          out_imgData.data[w+i] =
          Math.abs(in_imgData.data[w+i] - previous_imgData.data[w+i]);
        }
        out_imgData.data[w+3] = 255;
        w+=4;
    }
  this.previous_ctxt.putImageData(in_imgData,0,0);
}

diff.NormalizedDifferenceImageRGB=function(opt_options) {
  this.diffImageRGB=new diff.DifferenceImageRGB(opt_options);
}

diff.NormalizedDifferenceImageRGB.prototype.set_first_frame_imgData=function(imgData) {
  this.diffImageRGB.set_first_frame_from_imgData(imgData);
}

diff.NormalizedDifferenceImageRGB.prototype.set_first_frame_from_eltId=function(eltId) {
  this.diffImageRGB.set_first_frame_from_eltId(eltId);
}

diff.NormalizedDifferenceImageRGB.prototype.process=function(in_imgData, out_imgData) {
  //BLOC3
  //On fait la différence du BLOC2 entre l'image précédente et in_imgData
  //On stock le résultat dans out_imgData
  this.diffImageRGB.process(in_imgData,out_imgData);

  //BLOC4
  //On cherche les max et min pour tout les canaux de l'image out_imgData
  var w=0;
  var min=[255,255,255], max=[0,0,0];
  for (var x=0; x<this.diffImageRGB.width ; x++)
    for (var y=0; y<this.diffImageRGB.height ; y++) {
        for (var i=0; i<3; i++) {
          if (min[i]>out_imgData.data[w+i]) min[i]=out_imgData.data[w+i];
          if (max[i]<out_imgData.data[w+i]) max[i]=out_imgData.data[w+i];
        }
        w+=4;
    }

  //BLOC5
  //...
  w=0;
  for (var x=0; x<this.diffImageRGB.width ; x++)
    for (var y=0; y<this.diffImageRGB.height ; y++) {
        for (var i=0; i<3; i++) {
          out_imgData.data[w+i] = (out_imgData.data[w+i]-min[i])*255/(max[i]-min[i]);
        }
        out_imgData.data[w+3] = 255;
        w+=4;
    }
  this.diffImageRGB.previous_ctxt.putImageData(in_imgData,0,0);
}



diff.DifferenceImageGray=function(opt_options) {
  this.difference = document.createElement("canvas");
  this.previous = document.createElement("canvas");

  this.width=opt_options.width;
  this.height=opt_options.height;

  this.threshold=opt_options.threshold;

  this.difference.width=this.width; this.difference.height=this.height;
  this.previous.width=this.width; this.previous.height=this.height;

  this.difference_ctxt = this.difference.getContext("2d");
  this.previous_ctxt = this.previous.getContext("2d");
}

diff.DifferenceImageGray.prototype.set_first_frame_imgData=function(imgData) {
  this.previous_ctxt.putImageData(imgData,0,0);
}

diff.DifferenceImageGray.prototype.set_first_frame_from_eltId=function(eltId) {
  var elt=document.getElementById(eltId);
  var cvs=document.createElement("canvas");
  cvs.width=elt.width; cvs.height=elt.height;
  var ctxt=cvs.getContext("2d");
  ctxt.drawImage(elt,0,0);
  this.set_first_frame_imgData(ctxt.getImageData(0,0,cvs.width,cvs.height));
}

diff.DifferenceImageGray.prototype.process=function(in_imgData, out_imgData) {

  var previous_imgData = this.previous_ctxt.
                            getImageData(0, 0, this.width, this.height);


  var w=0;
  for (var x=0; x<this.width ; x++)
    for (var y=0; y<this.height ; y++) {
        mean = Math.abs((in_imgData.data[w]+in_imgData.data[w+1]+in_imgData.data[w+2])/3
          - (previous_imgData.data[w]+previous_imgData.data[w+1]+previous_imgData.data[w+2])/3)
        for (var i=0; i<3; i++) out_imgData.data[w+i] = mean;
        out_imgData.data[w+3] = 255;
        w+=4;
    }
  this.previous_ctxt.putImageData(in_imgData,0,0);
}

diff.NormalizedDifferenceImageGray=function(opt_options) {
  this.diffImageGray=new diff.DifferenceImageGray(opt_options);
}

diff.NormalizedDifferenceImageGray.prototype.set_first_frame_imgData=function(imgData) {
  this.diffImageGray.set_first_frame_from_imgData(imgData);
}

diff.NormalizedDifferenceImageGray.prototype.set_first_frame_from_eltId=function(eltId) {
  this.diffImageGray.set_first_frame_from_eltId(eltId);
}

diff.NormalizedDifferenceImageGray.prototype.process=function(in_imgData, out_imgData) {

  this.diffImageGray.process(in_imgData,out_imgData);


  var w=0;
  var min=255, max=0;
  for (var x=0; x<this.diffImageGray.width ; x++)
    for (var y=0; y<this.diffImageGray.height ; y++) {
        if (min>out_imgData.data[w]) min=out_imgData.data[w];
        if (max<out_imgData.data[w]) max=out_imgData.data[w];

        w+=4;
    }


  w=0;
  for (var x=0; x<this.diffImageGray.width ; x++)
    for (var y=0; y<this.diffImageGray.height ; y++) {
        for (var i=0; i<3; i++) {
          out_imgData.data[w+i] = (out_imgData.data[w+i]-min)*255/(max-min);
        }
        out_imgData.data[w+3] = 255;
        w+=4;
    }
  this.diffImageGray.previous_ctxt.putImageData(in_imgData,0,0);
}


diff.ThresholdedDifferenceImageGray=function(opt_options) {
  this.diffImageGray=new diff.DifferenceImageGray(opt_options);
}

diff.ThresholdedDifferenceImageGray.prototype.set_first_frame_imgData=function(imgData) {
  this.diffImageGray.set_first_frame_from_imgData(imgData);
}

diff.ThresholdedDifferenceImageGray.prototype.set_first_frame_from_eltId=function(eltId) {
  this.diffImageGray.set_first_frame_from_eltId(eltId);
}

diff.ThresholdedDifferenceImageGray.prototype.process=function(in_imgData, out_imgData) {


    var previous_imgData = this.diffImageGray.previous_ctxt.
                              getImageData(0, 0, this.diffImageGray.width, this.diffImageGray.height);


    var w=0;
    for (var x=0; x<this.diffImageGray.width ; x++)
      for (var y=0; y<this.diffImageGray.height ; y++) {
          mean = Math.abs((in_imgData.data[w]+in_imgData.data[w+1]+in_imgData.data[w+2])/3
            - (previous_imgData.data[w]+previous_imgData.data[w+1]+previous_imgData.data[w+2])/3)
          if(mean>this.diffImageGray.threshold)
            for (var i=0; i<3; i++) out_imgData.data[w+i] = 255;
          else
            for (var i=0; i<3; i++) out_imgData.data[w+i] = 0;
          out_imgData.data[w+3] = 255;
          w+=4;
        }
}
