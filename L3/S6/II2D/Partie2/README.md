# Préambule
Voici mon rendu pour tout les TPs de II2D-Image.
Je tiens à m'excuser car je n'ai pas commit au fur et à mesure mais n'ayant pas de binôme et avec le confinement j'ai travaillé uniquement depuis chez moi et je n'ai pas pensé à en faire au fur et à mesure, c'est une négligence de ma part et je m'en excuse.

Pour le TP1, il se situe dans un dossier à part `tp1` car j'ai eu des problèmes quand j'ai voulu lui apporter des modifications et avec les différents merge, j'ai donc décidé de le ré-implanter dans un dossier à part. TOUT les autres TPs se trouvent dans le dossier racine.

J'ai traité tout le TP1 (sauf Q22, Q23, Q24), TP2 (sauf questions bonus) et le TP3 (sauf Q5 et Q6.d)

# TP1 (TP1 se trouve dans le dossier /tp1)
## Images
* Q4: La MessageBox indique que les composantes du pixel sont (0,0,0,0) quand l'image n'est pas chargée
* Q5: Le code n'est executé qu'une fois que l'image est chargée, ce qui évite le problème obtenu avant
* Q6: Il n'y a pas de niveaux de gris alors que c'est ce qui est attendu.
* Q7: La cause du changement de comportement est l'ajout du canvas au document. (`document.body.append(canvas);`)

## Vidéos
* Q8: La page reste blanche car la vidéo n'existe pas
* Q9: Le canvas n'affiche que la première image de la vidéo en niveaux de gris
* Q10: Le canvas affiche toutes les images de la vidéo en niveaux de gris car le code s'execute dans une boucle appelée à chaque frame (`requestAnimationFrame(loop);`)

## Pixels RGBA
* Q11: [ici](http://127.0.0.1:8080/tp1/processing_samples/image_get_random_pixel.html)
* Q12: [ici](http://127.0.0.1:8080/tp1/processing_samples/image_get_mean_pixel.html)
* Q13: [ici](http://127.0.0.1:8080/tp1/processing_samples/image_detection_plans.html)

## Transformation d’images
* Q14: [ici](http://127.0.0.1:8080/tp1/samples/video_black_white_threshold.html) et tâche ToBlackWhiteWithThresholdTask dans `filters/gray_filters.js`
* Q15: [ici](http://127.0.0.1:8080/tp1/samples/video_q15.html) et tâche ToGrayIfRMinTask dans `filters/gray_filters.js`
* Q16: [ici](http://127.0.0.1:8080/tp1/samples/video_q16.html) et tâche ToGrayWithWeightTask dans `filters/gray_filters.js`
* Q17: [ici](http://127.0.0.1:8080/tp1/samples/video_q17.html) et tâche InvertRBTask dans `filters/myrgb_filters.js`
* Q18: [ici](http://127.0.0.1:8080/tp1/samples/video_q18.html) et tâche ToGrayOutsideRadiusTask dans `filters/gray_filters.js`
* Q19: [ici](http://127.0.0.1:8080/tp1/samples/video_q19.html) et tâche ToGrayOutsideRadiusMovingTask dans `filters/gray_filters.js`
* Q20: (ne fonctionne pas) [ici](http://127.0.0.1:8080/tp1/samples/video_q20.html) et tâche ToGrayOutsideRadiusMovingx2Task dans `filters/gray_filters.js`

## Fusion d'images
* Q25: [ici](http://127.0.0.1:8080/tp1/samples/image_fusion_poid_img1.html) et tâche MeanFuseMultiImagesTask dans `filters/filters.js`
* Q26: [ici](http://127.0.0.1:8080/tp1/samples/image_fusion_rouge.html) et tâche MeanFuseMultiImagesTaskRed dans `filters/filters.js`
* Q27: [ici](http://127.0.0.1:8080/tp1/samples/image_fusion_partiel.html) et tâche MeanFuseMultiImagesTaskPartiel dans `filters/filters.js`

# TP2
## Gris
* Q1.4: [ici](http://127.0.0.1:8080/similarity_samples/similarity_images_3.html) et tâches dans `similarity/pixels.js` (ne fonctionne pas, j'ai une erreur que je ne comprends pas -> `this.similarity_metric_func is not a function` mais je pense que mes tâche sont corrects)
* Q1.4: [ici](http://127.0.0.1:8080/similarity_samples/similarity_images_4.html) et tâches dans `similarity/pixels.js` (ne fonctionne pas, j'ai une erreur que je ne comprends pas -> `this.similarity_metric_func is not a function` mais je pense que mes tâche sont corrects)

## Histogrammes en niveaux de gris
* Q2.4: [ici](http://127.0.0.1:8080/similarity_samples/similarity_images_7.html) et tâches dans `similarity/pixels.js`
* Q2.4: [ici](http://127.0.0.1:8080/similarity_samples/similarity_images_8.html) et tâches dans `similarity/pixels.js`

## Histogrammes couleurs
* Q3.4: [ici](http://127.0.0.1:8080/similarity_samples/similarity_images_9.html) et tâches dans `similarity/pixels.js`
* Q3.4: [ici](http://127.0.0.1:8080/similarity_samples/similarity_images_10.html) et tâches dans `similarity/pixels.js`

## Photo Fill
* Q4.1: [ici](http://127.0.0.1:8080/effects_samples/photo_fill_2.html) et tâches dans `effects/photo_fill.js`

## Détection/Recherche
* Q5.1: [ici](http://127.0.0.1:8080/lookup_samples/lookup_template.html) et tâches dans `lookup/windows.js`

# TP3
## Suivi à base d'apparence
* Q1.a: On observe que le tacking de la cible est de plus en plus difficile à cause des changements sur la cible et le background. Et de plus, le model de recherche n'est pas mis à jour.

* Q1.e: [ici](http://127.0.0.1:8080/tracking_samples/circular_meanshift_circle.html)

## Différence d'images
* Q2.g: [ici](http://127.0.0.1:8080/difference_samples/difference_effect_2G.html)

## Filtres morphologiques
* Q3.d: [ici](http://127.0.0.1:8080/morpho_samples/morpho_dilatation_erosion_2.html) et tâche dans `effects/morpho.js`

## Composants connexes (je ne pense pas que ça fonctionne je n'ai pas bien compris cette partie)
* Q4.c: [ici](http://127.0.0.1:8080/blobs_samples/blobs_appearance_q4d.html) et tâche dans `segmentation/blobs.js`

## Suivi mixte
* Q6.c: [ici](http://127.0.0.1:8080/animation_samples/tracking_circle.html) et tâche dans `animation/moving_circle.js`. On remarque aussi que quand les deux cercles sont proches, le cercle suivi par la zone peut changer.
