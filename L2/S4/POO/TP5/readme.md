TP5 Mathilde DESMAREST et Pierre SYLLEBRANQUE

# Récuperer le projet
- Dans le dossier cloné avec git, taper dans un terminal la commande: `git pull`

# Présentation du TP5 et de ses objectifs
Dans ce TP, on a recréé le jeu 'bataille navale'. On a appris à:
- Structurer correctement notre zone de travail.
- Écrire et exécuter les tests.
- Gérer des exceptions.


#  Générer et consulter la documentation
- Générer: Se placer dans le dossier *src*, taper la commande: `javadoc -d ../docs -subpackages battleship`
- Consulter: Se placer dans le dossier "docs" puis lancer, à l'aide d'un navigateur, le fichier *index.html*

# Compiler la classe *battleshipMain.java*
- Se placer dans le dossier *src*, et, dans un terminal, taper la commande: `javac battleship/battleshipMain.java -d ../classes`
Les autres classes du paquetages sont compilées automatiquement avec.


# Compiler et exécuter les tests
- Compiler: Se placer dans le dossier *TP5*, dans un terminal, taper la commande: `javac -classpath .:test-1.7.jar test/classeTest.java` (en remplaçant *classeTest* par le nom du fichier test)
- Exécuter: Toujours dans le dossier *TP5* , taper la commande suivante: `java -jar test-1.7.jar classeTest` (en remplaçant *classeTest* par le nom du fichier test)


# Exécuter le programme (sans archive)
- Dans le dossier *classes*, exécuter la commande: `java battleship.battleshipMain`

# Créer une archive exécutable
- Dans le dossier *classes*, exécuter la commande: `jar cvfm ../appli-battleship.jar ../manifest battleship`
Vous avez généré l'archive *appli-battleship.jar* exécutable avec le manifeste *manifest*, qui définit la classe battleship.battleshipMain comme classe principale de l'archive.

# Exécuter l'archive
- Dans le dossier *TP5* (racine), taper la commande `java -jar appli-battleship.jar`
