var photo_fill={};

//Fonction constructrice qui récupére les attributs dataset et les options de la tâche
photo_fill.PhotoFillPixelsFromDatasetTask=function(dataset,opt_options){
  this.dataset=dataset;
  this.similarity_task=new pixels_similarity.MeanRGBSimilarityTask(_dataset,{});
;
}

photo_fill.PhotoFillPixelsFromDatasetTask.prototype.process=function(in_imageData,out_imageData) {
  var w=0;
  for (var y=0;y<in_imageData.height;y++) {
    for (var x=0;x<in_imageData.width;x++,w+=4) {
      //Si l'opacité == 0, on traite pas le pixel
      if (in_imageData.data[w+3]==0)
        continue;

      //On stocke les niveaux R(rouge)G(vert)B(bleu) dans un tableau
      var rgb_pixel=[in_imageData.data[w],in_imageData.data[w+1],in_imageData.data[w+2]];

      //Calcule des descripteurs les plus proches du rgb_pixel
      var sim_res=this.similarity_task.process_descriptor(rgb_pixel);

      //Récupèration de l'indice dans le dataset du descripteur le plus proche du rgb_pixel
      var min_idx=sim_res[1].idx;

      //Récupèration de l'image la plus proche du pixel et augmentation de la taille du pixel
      var pixel_image=this.similarity_task.dataset.imageDatas[min_idx];
      x_dest=x*pixel_image.width;
      y_dest=y*pixel_image.height;

      //Copie de l'image la plus semblable au pixel dans le canvas
      Tools.copy_imageData_into_imageData(pixel_image,out_imageData,x_dest,y_dest);
    }
  }
}

/*
Fonction qui prend un rôle de constructeur en récupérant les attributs dataset et les options de la tâche
*/
photo_fill.PhotoFillPixelsFromDatasetTask2=function(dataset,opt_options){
  this.dataset=dataset;
  this.similarity_task=new pixels_similarity.MeanGraySimilarityTask(_dataset,{});
;
}

photo_fill.PhotoFillPixelsFromDatasetTask2.prototype.process=function(in_imageData,out_imageData) {
  var w=0;
  for (var y=0;y<in_imageData.height;y++) {
    for (var x=0;x<in_imageData.width;x++,w+=4) {
      if (in_imageData.data[w+3]==0)
        continue;


      var gray_pixel=(in_imageData.data[w]+in_imageData.data[w+1]+in_imageData.data[w+2])/3;
      var sim_res=this.similarity_task.process_descriptor(gray_pixel);


      var min_idx=sim_res[1].idx;

      var pixel_image=this.similarity_task.dataset.imageDatas[min_idx];
      x_dest=x*pixel_image.width;
      y_dest=y*pixel_image.height;

      Tools.copy_imageData_into_imageData(pixel_image,out_imageData,x_dest,y_dest);
    }
  }
}
