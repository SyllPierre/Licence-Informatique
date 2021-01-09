GetPixelRGBATask=function(opt_options) {
  this.x=opt_options.x;
  this.y=opt_options.y;
  this.output=opt_options.output;
};

GetPixelRGBATask.prototype.process=function(imageData) {
  this.output.innerHTML=this.x+"x"+this.y+" : ";
  this.output.innerHTML+="<font color='red'>"+r+"</font> | ";
  this.output.innerHTML+="<font color='green'>"+g+"</font> | ";
  this.output.innerHTML+="<font color='blue'>"+b+"</font> | ";
  this.output.innerHTML+="<font color='gray'>"+a+"</font>";
};

GetRandomRGBAPixelTask = function (opt_options) {
    this.output = opt_options.output;
};

GetRandomRGBAPixelTask.prototype.process = function (imageData) {
    var pixelTask = new GetPixelRGBATask({
        x: Math.floor((Math.random() * imageData.width)),
        y: Math.floor((Math.random() * imageData.height)),
        output: this.output
    });
    pixelTask.process(imageData);
};

GetMeanPixel = function (args) {
    this.output = args.output;
};

GetMeanPixel.prototype.process = function (imageData) {
    var r = 0;
    var g = 0;
    var b = 0;
    var a = 0;
    var pixels = imageData.data;
    for (var x = 0; x < imageData.width; x++) {
        for (var y = 0; y < imageData.height; y++) {
            var pos = (y * imageData.width + x) << 2;

            r += pixels[pos + 0];
            g += pixels[pos + 1];
            b += pixels[pos + 2];
            a += pixels[pos + 3];
        }
    }

    var allPixels = imageData.width * imageData.height;
    var moyenneR = Math.floor(r / allPixels);
    var moyenneG = Math.floor(g / allPixels);
    var moyenneB = Math.floor(b / allPixels);
    var moyenneA = Math.floor(a / allPixels);

    var mean = Math.floor((moyenneR + moyenneG + moyenneB) / 3);

    this.output.innerHTML = " Moyenne : ";
    this.output.innerHTML += "<font color='red'>" + moyenneR + "</font> | ";
    this.output.innerHTML += "<font color='green'>" + moyenneG + "</font> | ";
    this.output.innerHTML += "<font color='blue'>" + moyenneB + "</font> | ";
    this.output.innerHTML += "<font color='gray'>" + moyenneA + "</font> | ";
    this.output.innerHTML += "<font color='black'> Mean : " + mean + "</font>";
};

var pixels_features={};

/*
  pixels_features.mean_rgb
  - computes RGB mean of all pixels having A>0 within imageData
*/
pixels_features.mean_rgb=function(imageData,opt_options) {
  return pixels_features.mean_rgb_per_region(imageData,{x0:0,y0:0,dx:imageData.width,dy:imageData.height});
}

/*
  pixels_features.mean_gray
  - computes gray mean of all pixels having A>0 within imageData
*/
pixels_features.mean_gray=function(imageData,opt_options) {
  return pixels_features.mean_gray_per_region(imageData,{x0:0,y0:0,dx:imageData.width,dy:imageData.height});
}

/*
  pixels_features.gray_hist

  - computes the gray histogram of the full picture
*/
pixels_features.gray_hist=function(imageData,opt_options) {
  return pixels_features.gray_hist_per_region(imageData,{x0:0,y0:0,dx:imageData.width,dy:imageData.height, span:opt_options.span});
}

/*
  pixels_features.rgb_hist

  - computes the rgb histogram of the full picture
*/
pixels_features.rgb_hist=function(imageData,opt_options) {
  return pixels_features.rgb_hist_per_region(imageData,{x0:0,y0:0,dx:imageData.width,dy:imageData.height, span:opt_options.span});
}

/*
  pixels_features.mean_rgb_per_region
  - computes RGB mean of all pixels having A>0 within opt_options.x0 .y0 .dx .dy
  - if opt_options missing partially,
      replace partially with defaults 0, 0, imageData.width, imageData.height
  - returns undefined if none available
*/
pixels_features.mean_rgb_per_region=function(imageData,opt_options) {
  x0=opt_options&&opt_options.x0?opt_options.x0:0;
  y0=opt_options&&opt_options.y0?opt_options.y0:0;
  dx=opt_options&&opt_options.dx?opt_options.dx:imageData.width;
  dy=opt_options&&opt_options.dy?opt_options.dy:imageData.height;


  //BLOC1
  // On parcours tous les pixels d'une région, si son opacité est supérieur à 0 alors on récupère la valeur du pixel.
  // Si le nombre de pixels est supérieur à 0 alors on récupère le pixel moyen de l'image.
  var mean=[];
  mean[0]=0; mean[1]=0; mean[2]=0;
  var pos=0; var count=0;
  for (var y=y0;y<y0+dy;y++)
    for (var x=x0;x<x0+dx;x++) {
      pos=(y*imageData.width+x)<<2;
      if (imageData.data[pos+3]>0) {
        for (var i=0;i<3;i++) {
          mean[i]+=imageData.data[pos+i];
        }
        count++;
      }
    }
  if (count>0) {
    for (var i=0;i<3;i++) {
      mean[i]=Math.round(mean[i]/count);
    }
    return mean;
  }
  return undefined;
}

/*
  pixels_features.mean_gray_per_region
  - computes gray mean of all pixels having A>0 within opt_options.x0 .y0 .dx .dy
  - if opt_options missing partially,
      replace partially with defaults 0, 0, imageData.width, imageData.height
  - returns undefined if none available
*/
pixels_features.mean_gray_per_region=function(imageData,opt_options) {
  x0=opt_options&&opt_options.x0?opt_options.x0:0;
  y0=opt_options&&opt_options.y0?opt_options.y0:0;
  dx=opt_options&&opt_options.dx?opt_options.dx:imageData.width;
  dy=opt_options&&opt_options.dy?opt_options.dy:imageData.height;

  var mean=0;
  var pos=0; var count=0;
  for (var y=y0;y<y0+dy;y++)
    for (var x=x0;x<x0+dx;x++) {
      pos=(y*imageData.width+x)<<2;
      if (imageData.data[pos+3]>0) {
        mean+= (imageData.data[pos]+imageData.data[pos+1]+imageData.data[pos+2])/3
        count++;
      }
    }
  if (count>0) {
    mean=Math.round(mean/count);
    return mean;
  }
  return undefined;
}

/*
  pixels_features.gray_hist_per_region
  - computes gray histogram within opt_options.x0 .y0 .dx .dy
  - opt_options.span gives the number of columns to have in the histogram. Defaults to 8 if missing.
  - if opt_options missing partially,
      replace partially with defaults 0, 0, imageData.width, imageData.height
  - returns undefined if none available
*/
pixels_features.gray_hist_per_region=function(imageData,opt_options) {
  x0=opt_options&&opt_options.x0?opt_options.x0:0;
  y0=opt_options&&opt_options.y0?opt_options.y0:0;
  dx=opt_options&&opt_options.dx?opt_options.dx:imageData.width;
  dy=opt_options&&opt_options.dy?opt_options.dy:imageData.height;
  span=opt_options&&opt_options.span?opt_options.span:8;

  var index=0; var count=0;
  var divider = Math.floor(256/span);
  var pos=0;
  var hist_gray= new Array(span).fill(0);
  for (var y=y0;y<y0+dy;y++)
    for (var x=x0;x<x0+dx;x++) {
      pos=(y*imageData.width+x)<<2;
      if (imageData.data[pos+3]>0) {
        index = Math.floor(((imageData.data[pos]+imageData.data[pos+1]+imageData.data[pos+2])/3)/divider);
        hist_gray[index]++;
        count++;
      }
    }

  if (count>0) {
    return hist_gray;
  }
  return undefined;
}


/*
  pixels_features.rgb_hist_per_region
  - computes gray histogram within opt_options.x0 .y0 .dx .dy
  - opt_options.span gives the number of columns to have in the histogram. Defaults to 8 if missing.
  - if opt_options missing partially,
      replace partially with defaults 0, 0, imageData.width, imageData.height
  - returns undefined if none available
*/
pixels_features.rgb_hist_per_region=function(imageData,opt_options) {
  x0=opt_options&&opt_options.x0?opt_options.x0:0;
  y0=opt_options&&opt_options.y0?opt_options.y0:0;
  dx=opt_options&&opt_options.dx?opt_options.dx:imageData.width;
  dy=opt_options&&opt_options.dy?opt_options.dy:imageData.height;
  span=opt_options&&opt_options.span?opt_options.span:8;

  var index_red   = 0;
  var index_green = 0;
  var index_blue  = 0;
  var count=0;
  var divider = Math.floor(256/span);
  var pos=0;
  var hist_red   = new Array(span).fill(0);
  var hist_green = new Array(span).fill(0);
  var hist_blue  = new Array(span).fill(0);
  for (var y=y0;y<y0+dy;y++)
    for (var x=x0;x<x0+dx;x++) {
      pos=(y*imageData.width+x)<<2;
      if (imageData.data[pos+3]>0) {
        index_red   = Math.floor((imageData.data[pos])/divider);
        index_green = Math.floor((imageData.data[pos+1])/divider);
        index_blue  = Math.floor((imageData.data[pos+2])/divider);
        hist_red[index_red]++;
        hist_green[index_green]++;
        hist_blue[index_blue]++;
        count++;
      }
    }

  if (count>0) {
    return {r:hist_red, g:hist_green, b:hist_blue};
  }
  return undefined;
}

/*
  pixels_features.grid_mean_rgb
  - computes RGB mean of all pixels having A>0 in all grid cells
  - grid params are defined as opt_options.nb_lines x opt_options.nb_columns
  - returns a generic_features.grid_descriptor (grid.cells - array)
*/
pixels_features.grid_mean_rgb=function(imageData, opt_options) {

  console.log("construct grid mean rgb");
  console.log(opt_options);

  return generic_features.grid_descriptor(imageData,
    pixels_features.mean_rgb_per_region,
    opt_options);
}

/*

  pixels_features.grid_mean_gray
  - computes gray mean of all pixels having A>0 in all grid cells
  - grid params are defined as opt_options.nb_lines x opt_options.nb_columns
  - returns a generic_features.grid_descriptor (grid.cells - array)
*/
pixels_features.grid_mean_gray=function(imageData, opt_options) {

  console.log("construct grid mean gray");
  console.log(opt_options);

  return generic_features.grid_descriptor(imageData,
    pixels_features.mean_gray_per_region,
    opt_options);
}

/*
  pixels_features.grid_gray_hist
  - computes gray histogram of all regions having A>0 in all grid cells
  - grid params are defined as opt_options.nb_lines x opt_options.nb_columns
  - returns a generic_features.grid_descriptor (grid.cells - array)
*/
pixels_features.grid_gray_hist=function(imageData, opt_options) {

  console.log("construct grid gray hist");
  console.log(opt_options);

  return generic_features.grid_descriptor(imageData,
    pixels_features.gray_hist_per_region,
    opt_options);
}

/*
  pixels_features.grid_rgb_hist
  - computes rgb histograms of all regions having A>0 in all grid cells
  - grid params are defined as opt_options.nb_lines x opt_options.nb_columns
  - returns a generic_features.grid_descriptor (grid.cells - array)
*/
pixels_features.grid_rgb_hist=function(imageData, opt_options) {

  console.log("construct grid rgb hist");
  console.log(opt_options);

  return generic_features.grid_descriptor(imageData,
    pixels_features.rgb_hist_per_region,
    opt_options);
}


/*
  pixels_features.mean_rgb_afactor_per_region
  - computes RGB mean of all pixels considering A as a weight of RGB channels
  within opt_options.x0 .y0 .dx .dy
  - if opt_options missing partially,
      replace partially with defaults 0, 0, imageData.width, imageData.height
  - returns undefined if none available
*/
pixels_features.mean_rgb_afactor_per_region=function(imageData,opt_options) {
  x0=opt_options&&opt_options.x0?opt_options.x0:0;
  y0=opt_options&&opt_options.y0?opt_options.y0:0;
  dx=opt_options&&opt_options.dx?opt_options.dx:imageData.width;
  dy=opt_options&&opt_options.dy?opt_options.dy:imageData.height;


  var mean=[];
  mean[0]=0; mean[1]=0; mean[2]=0;
  var pos=0; var count=0;
  for (var y=y0;y<y0+dy;y++)
    for (var x=x0;x<x0+dx;x++) {
      pos=(y*imageData.width+x)<<2;
      for (var i=0;i<3;i++) {
        mean[i]+=(imageData.data[pos+i]*imageData.data[pos+3]);
      }
      count++;
    }
  if (count>0) {
    for (var i=0;i<3;i++) {
      mean[i]=Math.round(mean[i]/count);
    }
    return mean;
  }
  return undefined;
}

/*
  pixels_features.circle_mean_rgb_afactor_per_region
  - computes RGB mean of all pixels in a circular area of radius opt_options.radius
  from the center of the region, considering A as a weight of RGB channels
  - if opt_options missing partially,
      replace partially with defaults 0, 0, imageData.width, imageData.height, radius=min(width/2,height/2)
  - returns undefined if none available
*/
pixels_features.circle_mean_rgb_afactor_per_region=function(imageData,opt_options) {
  x0=opt_options&&opt_options.x0?opt_options.x0:0;
  y0=opt_options&&opt_options.y0?opt_options.y0:0;
  dx=opt_options&&opt_options.dx?opt_options.dx:imageData.width;
  dy=opt_options&&opt_options.dy?opt_options.dy:imageData.height;
  if (opt_options&&opt_options.radius&&opt_options.radius<=imageData.width/2&&opt_options.radius<=imageData.height/2) {
    radius = opt_options.radius;
  } else {
    radius = Math.min(imageData.width, imageData.height)/2;
  }

  var center = {x:Math.floor(x0+(dx/2)),y:Math.floor(y0+(dy/2))};
  var mean=[];
  mean[0]=0; mean[1]=0; mean[2]=0;
  var pos=0; var count=0;
  for (var y=y0;y<y0+dy;y++)
    for (var x=x0;x<x0+dx;x++) {
      if (Math.sqrt((center.x-x)**2+(center.y-y)**2) < radius ) {

        pos=(y*imageData.width+x)<<2;
        for (var i=0;i<3;i++) {
          mean[i]+=(imageData.data[pos+i]*imageData.data[pos+3]);
        }
        count++;
      }
    }
  if (count>0) {
    for (var i=0;i<3;i++) {
      mean[i]=Math.round(mean[i]/count);
    }
    return mean;
  }
  return undefined;

}
