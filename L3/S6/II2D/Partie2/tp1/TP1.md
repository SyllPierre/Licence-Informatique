# TP1
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