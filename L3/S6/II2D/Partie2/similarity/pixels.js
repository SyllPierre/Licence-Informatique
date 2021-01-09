var pixels_similarity={}

/*
pixels_similarity.MeanRGBSimilarityTask

Task that allows similarity measures between a source image and a collection of
images contained in a Dataset object. The similartiy is measured considering the pixels_features.mean_rgb descriptor and the pixel_metrics.rgb_edist metric.

This task inherits from generic_similarity.SimilarityTask and, upon processing an imgData object using pixels_similarity.MeanRGBSimilarityTask.prototype.process(imgData), it provides the list of most similar images to imgData within the dataset.
*/

pixels_similarity.MeanRGBSimilarityTask=function(dataset,opt_options) {
  this.generic_sim=new generic_similarity.SimilarityTask(
    dataset,
    pixels_features.mean_rgb,
    pixel_metrics.rgb_edist,
    opt_options
  );
  this.dataset=dataset;
}

pixels_similarity.MeanRGBSimilarityTask.prototype.process=function(in_imageData) {
  return this.generic_sim.process(in_imageData);
}

pixels_similarity.MeanRGBSimilarityTask.prototype.process_descriptor=function(in_descriptor) {
  return this.generic_sim.process_descriptor(in_descriptor);
}

/*
pixels_similarity.HistoGraySimilarityTask

Task that allows similarity measures between a source image and a collection of
images contained in a Dataset object. The similartiy is measured considering the pixels_features.gray_hist descriptor and the pixel_metrics.gray_hist_edist metric.

This task inherits from generic_similarity.SimilarityTask and, upon processing an imgData object using pixels_similarity.HistoGraySimilarityTask.prototype.process(imgData), it provides the list of most similar images to imgData within the dataset.
*/

pixels_similarity.HistoGraySimilarityTask=function(dataset,opt_options) {
  this.generic_sim=new generic_similarity.SimilarityTask(
    dataset,
    pixels_features.gray_hist,
    pixel_metrics.gray_hist_edist,
    opt_options
  );
  this.dataset=dataset;
}

pixels_similarity.HistoGraySimilarityTask.prototype.process=function(in_imageData) {
  return this.generic_sim.process(in_imageData);
}

pixels_similarity.HistoGraySimilarityTask.prototype.process_descriptor=function(in_descriptor) {
  return this.generic_sim.process_descriptor(in_descriptor);
}


/*
pixels_similarity.HistoRGBSimilarityTask

Task that allows similarity measures between a source image and a collection of
images contained in a Dataset object. The similartiy is measured considering the pixels_features.rgb_hist descriptor and the pixel_metrics.rgb_hist_edist metric.

This task inherits from generic_similarity.SimilarityTask and, upon processing an imgData object using pixels_similarity.HistoRGBSimilarityTask.prototype.process(imgData), it provides the list of most similar images to imgData within the dataset.
*/

pixels_similarity.HistoRGBSimilarityTask=function(dataset,opt_options) {
  this.generic_sim=new generic_similarity.SimilarityTask(
    dataset,
    pixels_features.rgb_hist,
    pixel_metrics.rgb_hist_edist,
    opt_options
  );
  this.dataset=dataset;
}

pixels_similarity.HistoRGBSimilarityTask.prototype.process=function(in_imageData) {
  return this.generic_sim.process(in_imageData);
}

pixels_similarity.HistoRGBSimilarityTask.prototype.process_descriptor=function(in_descriptor) {
  return this.generic_sim.process_descriptor(in_descriptor);
}


pixels_similarity.MeanGraySimilarityTask=function(dataset,opt_options) {
  this.generic_sim=new generic_similarity.SimilarityTask(
    dataset,
    pixels_features.mean_gray,
    pixel_metrics.gray_edist,
    opt_options
  );
  this.dataset=dataset;
}

pixels_similarity.MeanGraySimilarityTask.prototype.process=function(in_imageData) {
  return this.generic_sim.process(in_imageData);
}

pixels_similarity.MeanGraySimilarityTask.prototype.process_descriptor=function(in_descriptor) {
  return this.generic_sim.process_descriptor(in_descriptor);
}

/*
pixels_similarity.GridMeanRGBSimilarityTask

Task that allows similarity measures between a source image and a collection of
images contained in a Dataset object. The similartiy is measured considering the pixels_features.grid_mean_rgb descriptor and the pixel_metrics.grid_rgb_edist metric in each cell of a rectangular Grid.

This task inherits from generic_similarity.SimilarityTask and, upon processing an imgData object using pixels_similarity.GridMeanRGBSimilarityTask.prototype.process(imgData), it provides the list of most similar images to imgData within the dataset.
*/

pixels_similarity.GridMeanRGBSimilarityTask=function(dataset,opt_options){
  this.generic_sim=new generic_similarity.SimilarityTask(
      dataset,
      pixels_features.grid_mean_rgb,
      pixel_metrics.grid_rgb_edist,
      opt_options
    );
  this.dataset=dataset;
}

pixels_similarity.GridMeanRGBSimilarityTask.prototype.process_descriptor=function(in_descriptor) {
  return this.generic_sim.process_descriptor(in_descriptor);
}

pixels_similarity.GridMeanRGBSimilarityTask.prototype.process=function(in_imageData) {
  return this.generic_sim.process(in_imageData);
}

/*
pixels_similarity.GridHistoGraySimilarityTask

Task that allows similarity measures between a source image and a collection of
images contained in a Dataset object. The similartiy is measured considering the pixels_features.grid_gray_hist descriptor and the pixel_metrics.grid_gray_hist_edist metric in each cell of a rectangular Grid.

This task inherits from generic_similarity.SimilarityTask and, upon processing an imgData object using pixels_similarity.GridHistoGraySimilarityTask.prototype.process(imgData), it provides the list of most similar images to imgData within the dataset.
*/

pixels_similarity.GridHistoGraySimilarityTask=function(dataset,opt_options){
  this.generic_sim=new generic_similarity.SimilarityTask(
      dataset,
      pixels_features.grid_gray_hist,
      pixel_metrics.grid_gray_hist_edist,
      opt_options
    );
  this.dataset=dataset;
}

pixels_similarity.GridHistoGraySimilarityTask.prototype.process_descriptor=function(in_descriptor) {
  return this.generic_sim.process_descriptor(in_descriptor);
}

pixels_similarity.GridHistoGraySimilarityTask.prototype.process=function(in_imageData) {
  return this.generic_sim.process(in_imageData);
}


/*
pixels_similarity.GridHistoRGBSimilarityTask

Task that allows similarity measures between a source image and a collection of
images contained in a Dataset object. The similartiy is measured considering the pixels_features.grid_rgb_hist descriptor and the pixel_metrics.grid_rgb_hist_edist metric in each cell of a rectangular Grid.

This task inherits from generic_similarity.SimilarityTask and, upon processing an imgData object using pixels_similarity.GridHistoRGBSimilarityTask.prototype.process(imgData), it provides the list of most similar images to imgData within the dataset.
*/

pixels_similarity.GridHistoRGBSimilarityTask=function(dataset,opt_options){
  this.generic_sim=new generic_similarity.SimilarityTask(
      dataset,
      pixels_features.grid_rgb_hist,
      pixel_metrics.grid_rgb_hist_edist,
      opt_options
    );
  this.dataset=dataset;
}

pixels_similarity.GridHistoRGBSimilarityTask.prototype.process_descriptor=function(in_descriptor) {
  return this.generic_sim.process_descriptor(in_descriptor);
}

pixels_similarity.GridHistoRGBSimilarityTask.prototype.process=function(in_imageData) {
  return this.generic_sim.process(in_imageData);
}


pixels_similarity.GridMeanGraySimilarityTask=function(dataset,opt_options){
  this.generic_sim=new generic_similarity.SimilarityTask(
      dataset,
      pixels_features.grid_mean_gray,
      pixel_metrics.grid_gray_edist,
      opt_options
    );
  this.dataset=dataset;
}

pixels_similarity.GridMeanGraySimilarityTask.prototype.process_descriptor=function(in_descriptor) {
  return this.generic_sim.process_descriptor(in_descriptor);
}

pixels_similarity.GridMeanGraySimilarityTask.prototype.process=function(in_imageData) {
  return this.generic_sim.process(in_imageData);
}
