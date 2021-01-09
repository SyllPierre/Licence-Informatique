# TP N°4
## Auteurs
```
DESMAREST Mathilde / SYLLEBRANQUE Pierre
```

## Date de rendu
```
Février 2019
```

## TP

### Objectifs du TP :
Le TP4 nous apprends à faire des tests unitaires ainsi que les manipulations à effectuer lors d'un tp.


### Générer et consulter la documentation :
Se placer dans le dossier TP4.
Aller dans le dossier src.
````
javadoc example example.util -d ../docs
````
Pour consulter la documentation, se placer dans le dossier docs généré ci-dessus puis ouvrir index.html dans un navigateur.
Consulter la doc.

### Compiler les classes du TP :
Se placer dans le dossier src.
````
javac example/Robot.java -d ../classes
````


### Compiler et exécuter des tests:
A faire obligatoirement après avoir compilé les classes!
Se placer dans le dossier TP4.
````
javac -classpath test-1.7.jar test/BoxTest.java
````
Un nouveau fichier BoxTest.class a été créé si tout s'est bien passé.
````
 java -jar test-1.7.jar BoxTest
````
Les tests de BoxTest sont alors effectués.

````
javac -classpath test-1.7.jar test/RobotTest.java
````
Un nouveau fichier RobotTest.class a été créé si tout s'est bien passé.

````
 java -jar test-1.7.jar RobotTest
````
Les tests de RobotTest sont alors effectués.

### Générer le fichier.jar :
Se placer dans le dossier classes.
````
jar cvf ../appli.jar example
````

### Executer le programme:
Se placer dans le dossier TP4.
````
java -classpath appli.jar example.Robot
````
Cela va executer avec le jar executable.
Se placer dans le dossier classes.
````
java example.Robot
````
