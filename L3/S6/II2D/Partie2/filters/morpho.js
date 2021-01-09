var morpho_filters={}

morpho_filters.max_from_region=function(imgData,x0,y0,reg_width,reg_height) {
  var pixels=imgData.data;

  //On récup le pixel au centre de la région
  var w=((y0+Math.round(reg_height/2))*imgData.width
                                        +(x0+Math.round(reg_width/2)))<<2;

  //On initialise le max sur la valeur du pixel au centre
  var max_data=[pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
  var max=(pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];

  //On parcourt toute la région
  for (var y=Math.max(0,y0);y<Math.min(y0+reg_height,imgData.height);y++)
    for (var x=Math.max(0,x0);x<Math.min(x0+reg_width,imgData.width);x++) {

      //w devient l'indice pour le pixel courant
      w = (y*imgData.width+x)<<2;

      var val = (pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];
      if (max < val) {
        //Si la valeur de comparaison est > que le max,
        //on met l'opascité sur pixel au max (si ce n'est pas déjà le cas)
        //et on met cette valeur en nouveau max
        if (pixels[w+3]<255) pixels[w+3]=255;
        max = val; max_data = [pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
      }
    }
  return max_data;
}


morpho_filters.max_red_from_region=function(imgData,x0,y0,reg_width,reg_height) {
  var pixels=imgData.data;

  //On récup le pixel au centre de la région
  var w=((y0+Math.round(reg_height/2))*imgData.width+(x0+Math.round(reg_width/2)))<<2;

  //On initialise le max sur la valeur du pixel au centre
  var max_data=[pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
  var max=(pixels[w]-pixels[w+1]-pixels[w+2])*pixels[w+3];

  //On parcourt toute la région mais on ne sort pas des limites de l'image
  for (var y=y0;y<y0+reg_height;y++) {
    if (y<0 || y>imgData.height) continue;
    for (var x=x0;x<x0+reg_width;x++) {
      if (x<0 || x>imgData.width) continue;

      //w devient l'indice pour le pixel courant
      w = (y*imgData.width+x)<<2;
      var val = (pixels[w]-pixels[w+1]-pixels[w+2])*pixels[w+3];
      if (max < val) {
        //Si la valeur de comparaison est > que le max,
        //la valeur de comparaison devient max et max_data est mis à jour
        max = val;
        max_data=[pixels[w], pixels[w+1],
                  pixels[w+2], pixels[w+3]];
      }
    }
  }
  return max_data;
}

//La même chose que précédemment dans max_red_from_region mais ici
//on transforme max_data en niveau de gris
morpho_filters.max_gray_from_region=function(imgData,x0,y0,reg_width,reg_height) {
  var pixels=imgData.data;
  var w=((y0+Math.round(reg_height/2))*imgData.width+(x0+Math.round(reg_width/2)))<<2;
  var max_data=[pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
  var max=(pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];

  for (var y=y0;y<y0+reg_height;y++) {
    if (y<0 || y>imgData.height) continue;
    for (var x=x0;x<x0+reg_width;x++) {
      if (x<0 || x>imgData.width) continue;
      w = (y*imgData.width+x)<<2;
      var val = (pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];
      if (max < val) {
        max = val;
        max_data=[val/3, val/3,
                  val/3, pixels[w+3]];
      }
    }
  }
  return max_data;
}

//comme pour max_red_from_region mais avec le min cette fois ci
morpho_filters.min_from_region=function(imgData,x0,y0,reg_width,reg_height) {
  var pixels=imgData.data;
  var w=((y0+Math.round(reg_height/2))*imgData.width+(x0+Math.round(reg_width/2)))<<2;
  var min_data=[pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
  var min=(pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];
  for (var y=y0;y<y0+reg_height;y++) {
    if (y<0 || y>imgData.height) continue;
    for (var x=x0;x<x0+reg_width;x++) {
      if (x<0 || x>imgData.width) continue;
      w = (y*imgData.width+x)<<2;
      var val = (pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];
      if (min > val) {
        min = val;
        min_data=[pixels[w], pixels[w+1],
                  pixels[w+2], pixels[w+3]];
      }
    }
  }
  return min_data;
}


morpho_filters.max_from_region_2=function(imgData,x0,y0,reg_width,reg_height) {
  var pixels=imgData.data;
  var w=((y0+Math.round(reg_height/2))*imgData.width
                                        +(x0+Math.round(reg_width/2)))<<2;

  var max_data=[pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
  var max=(pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];

  for (var y=Math.max(0,y0);y<Math.min(y0+reg_height,imgData.height);y++)
    for (var x=Math.max(0,x0);x<Math.min(x0+reg_width,imgData.width);x++) {

      if (y!=y0+Math.floor((reg_height)/2))
        if (x!=x0+Math.floor((reg_width)/2)) continue;

      w = (y*imgData.width+x)<<2;

      var val = (pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];
      if (max < val) {
        if (pixels[w+3]<255) pixels[w+3]=255;
        max = val; max_data = [pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
      }
    }
  return max_data;
}

morpho_filters.max_red_from_region_2=function(imgData,x0,y0,reg_width,reg_height) {
  var pixels=imgData.data;

  var w=((y0+Math.round(reg_height/2))*imgData.width+(x0+Math.round(reg_width/2)))<<2;

  var max_data=[pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
  var max=(pixels[w]-pixels[w+1]-pixels[w+2])*pixels[w+3];

  for (var y=y0;y<y0+reg_height;y++) {
    if (y<0 || y>imgData.height) continue;
    for (var x=x0;x<x0+reg_width;x++) {
      if (x<0 || x>imgData.width) continue;
      if (y!=y0+Math.floor((reg_height)/2))
        if (x!=x0+Math.floor((reg_width)/2)) continue;
        w = (y*imgData.width+x)<<2;

      var val = (pixels[w]-pixels[w+1]-pixels[w+2])*pixels[w+3];
      if (max < val) {
        max = val;
        max_data=[pixels[w], pixels[w+1],
                  pixels[w+2], pixels[w+3]];
      }
    }
  }
  return max_data;
}

morpho_filters.max_gray_from_region_2=function(imgData,x0,y0,reg_width,reg_height) {
  var pixels=imgData.data;
  var w=((y0+Math.round(reg_height/2))*imgData.width+(x0+Math.round(reg_width/2)))<<2;
  var max_data=[pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
  var max=(pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];

  for (var y=y0;y<y0+reg_height;y++) {
    if (y<0 || y>imgData.height) continue;
    for (var x=x0;x<x0+reg_width;x++) {
      if (x<0 || x>imgData.width) continue;
      if (y!=y0+Math.floor((reg_height)/2))
        if (x!=x0+Math.floor((reg_width)/2)) continue;
      w = (y*imgData.width+x)<<2;
      var val = (pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];
      if (max < val) {
        max = val;
        // le pixel d'output est mis en niveaux de gris
        max_data=[val/3, val/3,
                  val/3, pixels[w+3]];
      }
    }
  }
  return max_data;
}

morpho_filters.min_from_region_2=function(imgData,x0,y0,reg_width,reg_height) {
  var pixels=imgData.data;
  var w=((y0+Math.round(reg_height/2))*imgData.width+(x0+Math.round(reg_width/2)))<<2;
  var min_data=[pixels[w],pixels[w+1],pixels[w+2],pixels[w+3]];
  var min=(pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];
  for (var y=y0;y<y0+reg_height;y++) {
    if (y<0 || y>imgData.height) continue;
    for (var x=x0;x<x0+reg_width;x++) {
      if (x<0 || x>imgData.width) continue;
      if (y!=y0+Math.floor((reg_height)/2))
        if (x!=x0+Math.floor((reg_width)/2)) continue;
      w = (y*imgData.width+x)<<2;
      var val = (pixels[w]+pixels[w+1]+pixels[w+2])*pixels[w+3];
      if (min > val) {
        min = val;
        min_data=[pixels[w], pixels[w+1],
                  pixels[w+2], pixels[w+3]];
      }
    }
  }
  return min_data;
}
