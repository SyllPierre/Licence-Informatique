TP7 Mathilde DESMAREST et Pierre SYLLEBRANQUE

# Récuperer le projet
- Dans le dossier cloné avec git, taper dans un terminal la commande: `git pull`

# Présentation du TP7 et de ses objectifs
Dans ce TP, on a recrée une 'Agence' de voiture.
On a appris à:
- Structurer correctement notre zone de travail.
- Gérer une interface.
- Manipuler des collections.
- Utiliser l'héritage.

# Génerer et consulter la documentation
- Générer: Se placer dans le dossier *src*, taper la commande:
`javadoc rental -d ../docs/rental`
- Consulter : Se placer dans le dossier "docs" puis lancer, à l'aide d'un navigateur, le fichier *index.html*.

# Compiler les sources du projet
- Dans le dossier racine *agence*, créer un dossier *classes*.
- Pour avoir les différents Main :
- Se placer dans le dossier *src* avec le terminal, taper la commande :
- `javac rental/Main_Q2.java -d ../classes`
- `javac rental/MainSuspicious.java -d ../classes`
- `javac rental/Main_Q6.java -d ../classes`

# Compiler et exécuter les tests
- Se placer dans le dossier *agence*.
- Taper les commandes :
- `javac -classpath test-1.7.jar test/rental/BrandFilterTest.java`
et
`java -jar test-1.7.jar rental.BrandFilterTest`

- `javac -classpath test-1.7.jar test/rental/CarTest.java`
et
`java -jar test-1.7.jar rental.CarTest`

- `javac -classpath test-1.7.jar test/rental/ClientTest.java`
et
`java -jar test-1.7.jar rental.ClientTest`

- `javac -classpath test-1.7.jar test/rental/MaxPriceFilterTest.java`
et
`java -jar test-1.7.jar rental.MaxPriceFilterTest`

- `javac -classpath test-1.7.jar test/rental/MotorbikeTest.java`
et
`java -jar test-1.7.jar rental.MotorbikeTest`

- `javac -classpath test-1.7.jar test/rental/RentalAgencyTest.java`
et
`java -jar test-1.7.jar rental.RentalAgencyTest`

- `javac -classpath test-1.7.jar test/rental/VehicleTest.java`
et
`java -jar test-1.7.jar rental.VehicleTest`

# Exécution

Pour exécuter les différents Main, on peut se placer dans le dossier *agence* et utiliser ces commandes :

- `java -classpath classes rental.Main_Q2`

- `java -classpath classes rental.Main_Q6`

- `java -classpath classes rental.MainSuspicious`

# Création d'une archive exécutable

Pour créer une archive exécutable, on peut se placer dans le dossier *agence* :

- `jar cvfm Main_Q2.jar manifest-Q2 docs -C classes rental`

- `jar cvfm Main_Q6.jar manifest-Q6 docs -C classes rental`

- `jar cvfm MainSuspicious.jar manifest-suspicious docs -C classes rental`

Pour exécuter ces archives, on peut se placer dans le dossier *agence* :

- `java -jar Main_Q2.jar`

- `java -jar Main_Q6.jar`

- `java -jar MainSuspicious.jar`




