---------------
 tp-iterateurs
---------------


.. toctree::
   :maxdepth: 1

   listiterator.rst

~~~~~~~~~~
Etat du TP
~~~~~~~~~~

RAS.

~~~~~~~~~~~~~~~~~~~~~~
Réponses aux questions
~~~~~~~~~~~~~~~~~~~~~~


Suppression avec des itérateurs
-------------------------------

#. Question 1 :

   Notre implémentation est compatible avec des opérations de suppression. L'élément
   supprimé sera le :code:`previous` de l'itérateur. L'itérateur quant à lui reste à sa place i.e après l'élément
   à supprimer.

#. Question 3 :

   Interdire deux appels à :code:`remove` successifs sans avoir réalisé au moins un appel à :code:`next`
   entre deux est nécessaire car la façon dont on a implémenté les listes nous nous permet pas d'avoir
   l'information sur trois cellules simultanément. Il nous faudrait 2 itérateurs.
   Notre méthode nous permet de faire une suppression à la tête et à la queue de la liste.

#. Question 4 :

   Pour supprimer tous les éléments de la liste il faudra faire une succession de :code:`next` et :code:`remove`
   jusqu'à ce que la fonction :code:`hasNext` renvoie :code:`false`.


Performance de l’accès au i-ème élément
---------------------------------------

#. Question 3 :

   .. note::

      La deuxième courbe n'est pas visible mais elle existe. Elle est sur la droite :math:`y = 0`.

      Les données pour representer ces courbes sont dans le fichier test12.dat dans le dossier src.


   .. figure:: ../images/test12.png
      :width: 600px
      :align: center
      :alt: Étude du temps de parcours effectué pour le parcours d une liste doublement chaînée à l aide de la fonction et de la méthode next

   On remarque que la fonction :code:`get` est largement plus couteuse que la méthode :code:`next`.
   Le comportement de :code:`get` est en :math:`θ(n^2)` tandis que le comportement de la méthode :code:`next` est en
   :math:`θ(1)`.
