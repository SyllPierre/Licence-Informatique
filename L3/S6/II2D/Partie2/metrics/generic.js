var generic_metrics={};

/*
  generic_metrics.euclidian_distance_btw_feature_vectors
  - computes the euclidian distance between two feature vectors sharing
    a common structure
  - it requires feature_distance_func which computes the distance between
    individual components of the descriptor
  - return the euclidian distance in the R^n space,
    where n is descriptor_array_1.length
*/
generic_metrics.euclidian_distance_btw_feature_vectors=function(
  descriptor_array_1,
  descriptor_array_2,
  feature_distance_func) {

  //BLOC1
  //Calcul la distance entre chaque index des deux tableaux fait la somme de toutes les distances
  //pour chaque index mis au carré.
  //Puis on ajoute 1 au compteur.

  var sum=0, count=0, count1=0, count2=0;
  for (var idx in descriptor_array_1) {
    if (descriptor_array_1[idx]&&descriptor_array_2[idx]){
        var dist=feature_distance_func(descriptor_array_1[idx],descriptor_array_2[idx]);
        sum+=dist*dist;
        count++;
    }
    else {  // On compte le nombre de descriptor dans chaque array qui sont définis
        if (descriptor_array_1[idx]) count1++;
        if (descriptor_array_2[idx]) count2++;
    }
  }
  if (count>0) { //si les deux arrays sont non vides, on traite normalement
    return Math.sqrt(sum);
  } else {
    // si l'un est vide est pas l'autre, on renvoie la plus grande distance possible,
    // si les deux sont vides, ils sont exactements les mêmes, la distance est 0
    if (count1>0||count2>0)
        return 442;
    else return 0;
  }
}
