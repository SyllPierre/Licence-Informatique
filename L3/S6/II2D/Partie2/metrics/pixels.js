var pixel_metrics={};

/*
    pixel_metrics.rgb_edist - computes euclidian distance between two rgb pixels
*/
pixel_metrics.rgb_edist=function(pixel_rgb1, pixel_rgb2) {
  var dist_fun=function(x,y){return x-y};

  //BLOC1
  //On calcule la distance euclidienne entre deux pixels gràce à la fonction définie juste au dessus.

  return generic_metrics.euclidian_distance_btw_feature_vectors(pixel_rgb1,pixel_rgb2,dist_fun);
}

/*
    pixel_metrics.gray_edist - computes euclidian distance between two gray pixels
*/
pixel_metrics.gray_edist=function(pixel_gray1, pixel_gray2) {
  return Math.abs(pixel_gray1-pixel_gray2);
}

/*
    pixel_metrics.gray_hist_edist - computes euclidian distance between two gray bins
*/
pixel_metrics.gray_hist_edist=function(gray_hist1, gray_hist2) {
  var dist_fun=function(x,y){return x-y};

  return generic_metrics.euclidian_distance_btw_feature_vectors(gray_hist1,gray_hist2,dist_fun);
}

/*
    pixel_metrics.rgb_hist_edist - computes euclidian distance between two rgb bins
*/
pixel_metrics.rgb_hist_edist=function(rgb_hist1, rgb_hist2) {
  var dist_fun=pixel_metrics.gray_hist_edist; // gray_hist_edist is a single canal hist_edist function

  return generic_metrics.euclidian_distance_btw_feature_vectors(rgb_hist1,rgb_hist2,dist_fun);
}


/*
    pixel_metrics.rgb_edist - computes euclidian distance between two grids
    containing in each cell an rgb pixel
*/
pixel_metrics.grid_rgb_edist=function(pixels_rgb_grid1, pixels_rgb_grid2) {
  var dist_fun=pixel_metrics.rgb_edist;

  //BLOC2
  //On calcule la distance euclidienne pour deux régions de pixels.

  return generic_metrics.euclidian_distance_btw_feature_vectors(pixels_rgb_grid1.cells,pixels_rgb_grid2.cells,dist_fun);
}

/*
    pixel_metrics.gray_rgb_edist - computes euclidian distance between two rgb pixels considering them as gray pixels.
*/
pixel_metrics.gray_rgb_edist=function(pixel_rgb1, pixel_rgb2) {

  return Math.abs(pixel_rgb1[0] - pixel_rgb2[0]+
                  pixel_rgb1[1] - pixel_rgb2[1]+
                  pixel_rgb1[2] - pixel_rgb2[2])/3;
}

/*
    pixel_metrics.gray_rgb_edist - computes euclidian distance between two rgb pixels considering them as gray pixels.
*/
pixel_metrics.gray_rgb_edist=function(pixel_rgb1, pixel_rgb2) {

  return Math.abs(pixel_rgb1[0] - pixel_rgb2[0]+
                  pixel_rgb1[1] - pixel_rgb2[1]+
                  pixel_rgb1[2] - pixel_rgb2[2])/3;
}

/*
    pixel_metrics.visible_edist - computes similarity between two rgb pixels considering them as B&W pixels. if both B or both W than distance=0 otherwise 255
*/
pixel_metrics.visible_edist=function(pixel_rgb1, pixel_rgb2) {
  var mean1=(pixel_rgb1[0]+pixel_rgb1[1]+pixel_rgb1[2]);
  var mean2=(pixel_rgb2[0]+pixel_rgb2[1]+pixel_rgb2[2]);

  return ((mean1==0 && mean2==0) || (mean1>0 && mean2>0))?0:255;
}

/*
    pixel_metrics.grid_gray_hist_edist - computes euclidian distance between two grids
    containing in each cell an rgb pixel
*/
pixel_metrics.grid_gray_hist_edist=function(gray_hist_grid1, gray_hist_grid2) {
  var dist_fun=pixel_metrics.gray_hist_edist;

  return generic_metrics.euclidian_distance_btw_feature_vectors(gray_hist_grid1.cells,gray_hist_grid2.cells,dist_fun);
}

/*
    pixel_metrics.grid_rgb_hist_edist - computes euclidian distance between two grids
    containing in each cell an rgb pixel
*/
pixel_metrics.grid_rgb_hist_edist=function(rgb_hist_grid1, rgb_hist_grid2) {
  var dist_fun=pixel_metrics.rgb_hist_edist;

  return generic_metrics.euclidian_distance_btw_feature_vectors(rgb_hist_grid1.cells,rgb_hist_grid2.cells,dist_fun);
}
