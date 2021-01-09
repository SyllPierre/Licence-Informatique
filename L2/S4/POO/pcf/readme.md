TP6 Mathilde DESMAREST et Pierre SYLLEBRANQUE

# Récuperer le projet
- Dans le dossier cloné avec git, taper dans un terminal la commande: `git pull`

# Présentation du TP6 et de ses objectifs
Dans ce TP, on a recréé le jeu 'Pierre Feuille Ciseaux'. On a appris à:
- Structurer correctement notre zone de travail.
- Gérer une interface.
- Écrire et exécuter les tests.
- Gérer des exceptions.


#  Générer et consulter la documentation
- Générer: Se placer dans le dossier *src*, taper la commande: `javadoc -d ../docs -subpackages pcf util`
- Consulter: Se placer dans le dossier "docs" puis lancer, à l'aide d'un navigateur, le fichier *index.html*

# Compiler la classe *Main.java*
- Dans le dossier racine *pcf* créer un dossier *classes*.
- Se placer dans le dossier *src*, et, dans un terminal, taper la commande: `javac pcf/Main.java -d ../classes`
Les autres classes du paquetages sont compilées automatiquement avec.


# Compiler et exécuter les tests
- Compiler: Se placer dans le dossier *pcf*, dans un terminal, taper la commande: `javac -classpath .:test-1.7.jar test/classeTest.java` (en remplaçant *classeTest* par le nom du fichier test)
- Exécuter: Toujours dans le dossier *pcf* , taper la commande suivante: `java -jar test-1.7.jar classeTest` (en remplaçant *classeTest* par le nom du fichier test)


# Exécuter le programme (sans archive)
- Dans le dossier *classes*, exécuter la commande: `java pcf.Main`

# Créer une archive exécutable
- Dans le dossier *classes*, exécuter la commande: `jar cvfm ../appli-pcf.jar ../manifest pcf util`
Vous avez généré l'archive *appli-pcf.jar* exécutable avec le manifeste *manifest*, qui définit la classe pcf.Main comme classe principale de l'archive.

# Exécuter l'archive
- Dans le dossier *pcf* (racine), taper la commande `java -jar appli-pcf.jar`
