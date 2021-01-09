# Auteurs

Houppe Tanguy, Vennin Jason

# Documentation

Pour crée la documentation il faut utiliser la commande :
```
make doc
```

Pour consulter cette documentation, il faut ouvrir le fichier index.html du dossier date de docs dans un navigateur web.

# Compilation 

Pour compiler, on utilise la commande :
```
make all
```

# Test

Pour exécuter les tests, il faut utiliser la commande :
```
make test1

Pour le Trie
```

Et

```
make test2

Pour le CompactTrie
```

Un environnement JUnit s'affiche, on peux voir le temps d'execution et les tests qui ont échoué.

# Exécution

## Première partie
Pour créer le pdf du Trie, on utilise la commande :
```
make figure1
```


## Seconde partie
Pour créer le pdf du CompactTrie, on utilise la commande :
```
make figure2
```

# Création d'une archive exécutable

Pour créer une archive exécutable, on utilise la commande :
```
make archiveExec
```

Et pour exécuter l'archive, on utilise la commande :
```
java -jar monjar.jar mot1 mot2 mot3 ...

où mot1, mot2, mot3, etc sont les mots qu'on ajoutera à un Trie.
```

L'exécution produira un fichier dot de nom "trie.dot" du Trie construit.

