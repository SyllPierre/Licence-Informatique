var lookup_windows={};


lookup_windows.MeanRGBSameSizeTemplate=function(
  template_imgElt_id,threshold
) {
  this.template_imageData=Tools.get_imageData_from_imgEltId(template_imgElt_id);
  this.threshold=threshold;
}

lookup_windows.MeanRGBSameSizeTemplate.prototype.process=function(in_imageData) {

  //BLOC1
  //Grace à une image, on a une collection d'images grace à la hauteur et la largeur du modèle
  //avec comme pas le quart de la hauteur et de la largeur du modèle
  var lookup_dataset=new datasets.PartsOfImageDataset(
    in_imageData,
    sizes_and_steps=
      [{width:this.template_imageData.width,height:this.template_imageData.height,
        x:this.template_imageData.width/4,y:this.template_imageData.height/4}]
  );

  //BLOC2
  //Initialisation de la task pour trouver l'image la plus ressemblante au modèle parmis la collection
  var similarity_task=new pixels_similarity.MeanRGBSimilarityTask(lookup_dataset,{});

  //BLOC3
  //Exécution de la task sur le modèle
  var sim_res=similarity_task.process(this.template_imageData);

  if (document.getElementById("res")) {
    document.getElementById("res").appendChild(document.createTextNode("Selected windows"));
    document.getElementById("res").appendChild(document.createElement("br"));
  }

  var windows=[];

  //BLOC4
  //On parcourt les images les plus ressemblantes. Et pour chauqe images, si sa valeur de similarité est
  //inférieure au seuil, on considère l'image comme valide et on l'ajoute à une liste et on l'affiche.
  for (idx in sim_res) {

    if (sim_res[idx].sim>this.threshold)
      break;

    sim_imageData=lookup_dataset.imageDatas[sim_res[idx].idx];
    windows.push({sim:sim_res[idx].sim,idx:sim_res[idx].idx,
                  x:sim_imageData.orig_x,y:sim_imageData.orig_x,
                  dx:sim_imageData.width,dy:sim_imageData.height});
    document.getElementById("res")
      .appendChild(Tools.create_canvasElt_from_imageData(sim_imageData));
  }

  return windows;
}


//Même chose mais on ne prends ici la moitié de la hauteur et de la largeur du modèle comme pas

lookup_windows.GridMeanRGBSameSizeTemplate=function(
  template_imgElt_id,threshold
) {
  this.template_imageData=Tools.get_imageData_from_imgEltId(template_imgElt_id);
  this.threshold=threshold;
}

lookup_windows.GridMeanRGBSameSizeTemplate.prototype.process=function(in_imageData) {


  var lookup_dataset=new datasets.PartsOfImageDataset(
    in_imageData,
    sizes_and_steps=
      [{width:this.template_imageData.width,height:this.template_imageData.height,
        x:this.template_imageData.width/2,y:this.template_imageData.height/2}]
  );


  var similarity_task=new pixels_similarity.GridMeanRGBSimilarityTask(lookup_dataset,{desc_opt_options:{nb_lines:2,nb_columns:2},metric_opt_options:{}});


  var sim_res=similarity_task.process(this.template_imageData);

  if (document.getElementById("res")) {
    document.getElementById("res").appendChild(document.createTextNode("Selected windows"));
    document.getElementById("res").appendChild(document.createElement("br"));
  }

  var windows=[];

  for (idx in sim_res) {

    if (sim_res[idx].sim>this.threshold)
      break;

    sim_imageData=lookup_dataset.imageDatas[sim_res[idx].idx];
    windows.push({sim:sim_res[idx].sim,idx:sim_res[idx].idx,
                  x:sim_imageData.orig_x,y:sim_imageData.orig_x,
                  dx:sim_imageData.width,dy:sim_imageData.height});
    document.getElementById("res")
      .appendChild(Tools.create_canvasElt_from_imageData(sim_imageData));
  }

  return windows;
}
