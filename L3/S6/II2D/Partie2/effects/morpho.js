var morpho_effects={}

//Constructeur de DilatationWindow
morpho_effects.DilatationWindow = function(opt_options) {
  this.window_width=opt_options.window_width;
  this.window_height=opt_options.window_height;
}

//Sur in_imgData vers out_imgData on applique le filtre max_from_region
morpho_effects.DilatationWindow.prototype.process=function(in_imgData,out_imgData) {
  return generic_effect.apply_region_filter(
      in_imgData,out_imgData,this.window_width,this.window_height,
      morpho_filters.max_from_region
    );
}

// Constructeur de ErosionWindow
morpho_effects.ErosionWindow = function(opt_options) {
  this.window_width=opt_options.window_width;
  this.window_height=opt_options.window_height;
}

//Sur in_imgData vers out_imgData on applique le filtre min_from_region
morpho_effects.ErosionWindow.prototype.process=function(in_imgData,out_imgData) {
  generic_effect.apply_region_filter(
      in_imgData,out_imgData,this.window_width,this.window_height,
      morpho_filters.min_from_region);
}

// Constructeur de DilatationErosionWindow
morpho_effects.DilatationErosionWindow = function(opt_options) {
  this.dilatation_width=opt_options.dilatation_width;
  this.dilatation_height=opt_options.dilatation_height;
  this.erosion_width=opt_options.erosion_width;
  this.erosion_height=opt_options.erosion_height;
  this.aux_cvs=document.createElement("canvas");
}

//Sur in_imgData vers une aux_imgData temporaire on applique le filtre max_from_region
//Ensuite sur aux_imgData vers out_imgData on applique le filtre min_from_region
morpho_effects.DilatationErosionWindow.prototype.process=function(in_imgData,out_imgData) {
  aux_imgData ={data:[],width:out_imgData.width,height:out_imgData.height};
  generic_effect.apply_region_filter(
      in_imgData,aux_imgData,this.dilatation_width,this.dilatation_height,
      morpho_filters.max_from_region);
  generic_effect.apply_region_filter(
      aux_imgData,out_imgData,this.erosion_width,this.erosion_height,
      morpho_filters.min_from_region);
}

// Constructeur de DilatationErosionWindow
morpho_effects.DilatationErosionWindow = function(opt_options) {
  this.dilatation_width=opt_options.dilatation_width;
  this.dilatation_height=opt_options.dilatation_height;
  this.erosion_width=opt_options.erosion_width;
  this.erosion_height=opt_options.erosion_height;
  this.aux_cvs=document.createElement("canvas");
}

// On applique d'abord le filtre max_from_region depuis in_imgData vers une aux_imgData temporaire
// On applique ensuite le filtre min_from_region depuis aux_imgData vers out_imgData
morpho_effects.DilatationErosionWindow.prototype.process=function(in_imgData,out_imgData) {
  aux_imgData ={data:[],width:out_imgData.width,height:out_imgData.height};
  generic_effect.apply_region_filter(
      in_imgData,aux_imgData,this.dilatation_width,this.dilatation_height,
      morpho_filters.max_from_region);
  generic_effect.apply_region_filter(
      aux_imgData,out_imgData,this.erosion_width,this.erosion_height,
      morpho_filters.min_from_region);
}


morpho_effects.DilatationWindow_2 = function(opt_options) {
  this.window_width=opt_options.window_width;
  this.window_height=opt_options.window_height;
}

morpho_effects.DilatationWindow_2.prototype.process=function(in_imgData,out_imgData) {
  return generic_effect.apply_region_filter(
      in_imgData,out_imgData,this.window_width,this.window_height,
      morpho_filters.max_from_region_2
    );
}

morpho_effects.ErosionWindow_2 = function(opt_options) {
  this.window_width=opt_options.window_width;
  this.window_height=opt_options.window_height;
}

morpho_effects.ErosionWindow_2.prototype.process=function(in_imgData,out_imgData) {
  generic_effect.apply_region_filter(
      in_imgData,out_imgData,this.window_width,this.window_height,
      morpho_filters.min_from_region_2);
}

morpho_effects.DilatationErosionWindow_2 = function(opt_options) {
  this.dilatation_width=opt_options.dilatation_width;
  this.dilatation_height=opt_options.dilatation_height;
  this.erosion_width=opt_options.erosion_width;
  this.erosion_height=opt_options.erosion_height;
  this.aux_cvs=document.createElement("canvas");
}

morpho_effects.DilatationErosionWindow_2.prototype.process=function(in_imgData,out_imgData) {
  aux_imgData ={data:[],width:out_imgData.width,height:out_imgData.height};
  generic_effect.apply_region_filter(
      in_imgData,aux_imgData,this.dilatation_width,this.dilatation_height,
      morpho_filters.max_from_region_2);
  generic_effect.apply_region_filter(
      aux_imgData,out_imgData,this.erosion_width,this.erosion_height,
      morpho_filters.min_from_region_2);
}
