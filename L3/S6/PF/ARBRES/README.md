#   Des arbres et des couleurs

Ce dépôt correspond au TP de PF « Des arbres et des couleurs ».

La commande `make arbre1` sert à voir l'évolution et les ajouts
successifs de l'arbre `"gcfxieqzrujlmdoywnbakhpvst"`.

La commande `make arbreAtoZ` sert à voir l'évolution et les ajouts
successifs de l'arbre `['a'..'z']`.

La commande `make arbreComplet` sert à voir un exemple d'arbre complet.

##  Contenu du dépôt

Ce dépôt ne contient initialement qu’un fichier presque vide et la
règle d’intégration continue pour vérifier que ce source compile
correctement.
N’hésitez pas à modifier le fichier `.gitlab-ci.yml` pour effectuer
plus de tests, ou au contraire le supprimer si l’intégration continue
ne vous sert pas.

Pour traiter ce TP, vous aurez besoin de QuickCheck en plus des
bibliothèques de base.
N’hésitez pas à vous inspirer des fichiers du dépôt du 1^er dépôt de
TP, en particulier `premiers-contacts.cabal`, etc. si vous voulez
utiliser les outils comme `stack` et/ou `cabal` pour travailler sur
votre machine personnelle : il vous suffira de remplacer la ligne
indiquant la dépendance `gloss` par une mentionnant `QuickCheck` pour
avoir un fichier `.cabal` exploitable.
