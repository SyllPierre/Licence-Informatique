//Q25.

MeanFuseMultiImagesTask=function(opt_options){}

MeanFuseMultiImagesTask.prototype.process_multi=function(imageDatas,fused) {
  var w=0;
  for (var y=0;y<fused.height;y++) {
    for (var x=0;x<fused.width;x++) {

      fused.data[w]=0;
      fused.data[w+1]=0;
      fused.data[w+2]=0;
      fused.data[w+3]=0;

      var for2Images = 0;

      for (idx in imageDatas) {
        for (var i=0; i<4; i++) {
            if(for2Images%2==0){
                fused.data[w+i]+=imageDatas[idx].data[w+i];
            }else{
                //Here we devide the value for decreasing the second image strong
                fused.data[w+i]+=imageDatas[idx].data[w+i]/4;
            }
        }
            for2Images++;
      }

      for (var i=0; i<4; i++) {
        fused[w+i]=Math.round(fused[w+i]/imageDatas.length);
      }
      w+=4;

    }
  }
}

//Q26.

MeanFuseMultiImagesTaskRed=function(opt_options){}

MeanFuseMultiImagesTaskRed.prototype.process_multi=function(imageDatas,fused) {
  var w=0;
  for (var y=0;y<fused.height;y++) {
    for (var x=0;x<fused.width;x++) {

      fused.data[w]=0;
      fused.data[w+1]=0;
      fused.data[w+2]=0;
      fused.data[w+3]=0;

      var for2Images = 0;
      var fstRed = 0;
      var scdRed = 0;

      for (idx in imageDatas) {


            if(for2Images%2==0){
                fstRed = imageDatas[idx].data[w];
            }else{
                scdRed = imageDatas[idx].data[w];
            }

        for (var i=0; i<4; i++) {
            if(scdRed >= fstRed){
                fused.data[w+i]+=imageDatas[idx].data[w+i];
            }
        }
        for2Images++;
      }

      for (var i=0; i<4; i++) {
        fused[w+i]=Math.round(fused[w+i]/imageDatas.length);
      }
      w+=4;

    }
  }
}

//Q27.

MeanFuseMultiImagesTaskPartiel=function(opt_options){}

MeanFuseMultiImagesTaskPartiel.prototype.process_multi=function(imageDatas,fused) {
  var w=0;
  for (var y=0;y<fused.height;y++) {
    for (var x=0;x<fused.width;x++) {

      fused.data[w]=0;
      fused.data[w+1]=0;
      fused.data[w+2]=0;
      fused.data[w+3]=0;

      var for2Images = 0;

      for (idx in imageDatas) {
        for (var i=0; i<4; i++) {
            if(for2Images%2==0){
                if(x%2==0){
                    fused.data[w+i]+=imageDatas[idx].data[w+i];
                }else{
                    fused.data[w+i]+=imageDatas[idx].data[w+i]/2;
                }
            }else{
                if(x%2==0){
                    fused.data[w+i]+=imageDatas[idx].data[w+i]/2;
                }else{
                    fused.data[w+i]+=imageDatas[idx].data[w+i];

                }
            }
        }
            for2Images++;
      }

      for (var i=0; i<4; i++) {
        fused[w+i]=Math.round(fused[w+i]/imageDatas.length);
      }
      w+=4;

    }
  }
}
