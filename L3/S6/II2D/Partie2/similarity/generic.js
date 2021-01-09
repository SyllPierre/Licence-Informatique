var generic_similarity={}

/*
  Generic task that allows similarity measures between a source image and a collection of images contained in a Dataset object.

  The similarity is evaluated considering descriptors that are extracted with descriptor_func from the source imageData and all images in the dataset.

  The similarity is measured using the similarity_metric_func that should be adapted with regard to descriptor_func.

  opt_options contains :
    * optional opt_options.desc_opt_options parameters for the descriptor_func
    * optional opt_options.similarity_metric_opt_options parameters for similarity_metric_func


*/

generic_similarity.SimilarityTask=function(dataset, descriptor_func,similarity_metric_func, opt_options)
{

  this.dataset=dataset;

  this.descriptor_func=descriptor_func;
  this.desc_opt_options=opt_options.desc_opt_options;

  console.log("constructing generic similarity task using the bellow descriptor and options (2 lines)");
  console.log(descriptor_func);
  console.log(opt_options.desc_opt_options);

  //BLOC1
  //Créer un data_set et le rempli avec chaque image de dataset.imageDatas analysé avec un descriptor avec les options données
  this.dataset_descriptors=[];
  for (var idx in this.dataset.imageDatas) {
    this.dataset_descriptors[idx]=
      this.descriptor_func(this.dataset.imageDatas[idx],this.desc_opt_options);
    console.log("descriptor for image "+idx+" in dataset : "+ this.dataset_descriptors[idx]);
  }

  this.similarity_metric_func=similarity_metric_func;
  this.similarity_metric_opt_options=opt_options.similarity_metric_opt_options;
}


generic_similarity.SimilarityTask.prototype.process_descriptor=function(in_descriptor)
{

  //BLOC2
  //Calcul chaque similarité a partir du tableaux d'image passé au descripteur avec les options metric
  //Stock dans order a la case idx l'idx de la valeur traité
  var sim=[],order=[];
  for (var idx in this.dataset_descriptors) {
    sim[idx]=this.similarity_metric_func(
      in_descriptor,this.dataset_descriptors[idx],this.metric_opt_options);
    order[idx]=idx;
  }

  //BLOC3
  //(Trie le tableau order)
  //Prends une valeur(n) dans order, puis une seconde(x), pour toute les valeurs possible
  //Si la valeur dans sim de n est inferieur a celle de n, si c'est le cas, inverse leurs place dans le tableau order
  for (var idx1 in order)
    for (var idx2 in order)
      if (sim[order[idx1]]<sim[order[idx2]])
        { aux=order[idx1]; order[idx1]=order[idx2]; order[idx2]=aux; }

  //BLOC4
  //Retourne les resultats dans le bon ordre
  var res=[];
  for (var idx in order) res[idx]={idx:order[idx],sim:sim[order[idx]]}
  return res;
}

generic_similarity.SimilarityTask.prototype.process=function(in_imageData){
  //BLOC5
  //Récupère une image en paramètre, lance le descriptor sur l'image, et renvoi le tableau créer par la fonction process_descriptor
  var in_descriptor=this.descriptor_func(in_imageData,this.desc_opt_options);
  return this.process_descriptor(in_descriptor);
}


generic_similarity.SimilarityTask.prototype.get_dataset_descriptor=function(idx) {
  //BLOC6
  //Récupère un idx en parametre et renvoi la valeur du tableau d'image passé au descripteur a l'index idx
  return this.dataset_descriptors[idx];
}
