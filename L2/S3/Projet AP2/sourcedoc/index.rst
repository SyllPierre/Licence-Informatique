-----------------------------------
 Hamiltonian Path Research Program
-----------------------------------

Project description
-------------------

Dans ce projet, nous avons réalisé 3 fichiers :
'polyhedre' qui est un fichier contenant une fonction qui va chercher les données necessaires
dans le fichier .off; et une classe 'Polyhedre' qui contient diverses fonctions qui
nous permettent de calculer tout les chemins Hamiltonien d'un polyhedre choisi(par le fichier.off).

'writefile' qui est un fichier contenant plusieurs fonctions permettant d'écrire un fichier .dot
comme demandé dans l'énoncé. En effet ce fichier sert de module pour le fichier suivant.

'writehamiltonien' est le fichier qui permet grâce aux fonctions de 'writefile' va pouvoir écrire TOUT
les fichiers .dot correspondant au polyhedre choisi (un fichier .dot pour un chemin hamiltonien)
il permet dans un second temps de construire toutes les images de tout les chemins hamiltoniens grâce aux
fichiers .dot.

Nous avons malheureusement perdu un membre en route et nous somme seulement deux sur ce projet :
Pierre c'est plus occupé du fichier 'polyhedre' et 'writehamiltonien'
Robin a de son côté travaillé sur le fichier 'writefile'



Pour lancer notre programme, grâce à au terminal de linux il suffit de rentrer la commande suivante :

python3 writehamiltonien.py LeFichier.off LeNomDuPolyhedre

Attention !! Les fichiers .off sont placés dans un dossier nommé : polyhèdres
Les fichiers .dot et .jpg seront donc créés dans le dossier src.



Table of Contents
-----------------


.. toctree::
   :maxdepth: 1

   polyhedre
   writefile
   writehamiltonien
