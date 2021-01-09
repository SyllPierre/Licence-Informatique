TP8 Mathilde DESMAREST et Pierre SYLLEBRANQUE

# Récuperer le projet
- Dans le dossier cloné avec git, taper dans un terminal la commande: `git pull`

# Présentation du TP7 et de ses objectifs
Dans ce TP, on a recrée le jeu de l'Oie
On a appris à:
- Structurer correctement notre zone de travail.
- Gérer une interface.
- Manipuler des collections.
- Utiliser l'héritage.

# Génerer et consulter la documentation
- Générer: Se placer dans le dossier *src*, taper la commande:
`javadoc goosegame -d ../docs `
- Consulter : Se placer dans le dossier "docs" puis lancer, à l'aide d'un navigateur, le fichier *index.html*.

# Compiler les sources du projet
- Dans le dossier racine *oie*, créer un dossier *classes*. (non obligatoire mais en salle de tp on en avait besoin)
- Se placer dans le dossier *src* avec le terminal, taper la commande :
- `javac goosegame/* -d ../classes`


# Compiler et exécuter les tests
- Compiler: Se placer dans le dossier *oie*, dans un terminal, taper la commande: `javac -classpath .:test-1.7.jar test/goosegame/classeTest.java` (en remplaçant *classeTest* par le nom du fichier test)
- Exécuter: Toujours dans le dossier *oie* , taper la commande suivante: `java -jar test-1.7.jar goosegame.classeTest` (en remplaçant *classeTest* par le nom du fichier test)

# Executer le programme (sans archive)
- Dans le dossier *classes*, exécuter la commande :
`java goosegame.GameMain 3` (cela va lancer une partie à 3 joueurs)

`java goosegame.GameMain 4` (cela va lancer une partie à 4 joueurs)

# Créer une archive exécutable
- Dans le dossier *classes*, exécuter la commande: `jar cvf ../goosegame.jar goosegame`
Vous avez généré l'archive exécutable avec le manifeste *manifest*, qui définit la classe goosegame.GameMain comme la classe principale de l'archive.

# Exécuter l'archives
- Dans le dossier *oie* (racine), taper la commande `java -classpath goosegame.jar goosegame.GameMain 4` (Cela va exécuter avec le jar exécutable le partie du jeu de l'oie avec 4 joueurs.)
