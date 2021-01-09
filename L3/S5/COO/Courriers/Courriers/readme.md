Projet Courriers
===================

DESMAREST Mathilde / SYLLEBRANQUE Pierre
COO GROUPE 6

-------------
Introduction
-------------

Voici notre projet Courrier.

Le projet fonctionne ainsi :
 - Le Main permet de pouvoir générer la simulation dite regulière où on peut choisir le nombre d'habitants désiré pour la ville, le montant maximum que les habitants peuvent avoir sur leurs comptes en banque, le nombre de jour où la simulation va tourner, le nombre de lettres que l'on peut envoyer par jour.
 - On peut aussi générer une simulation dite « Chaı̂ne des naı̈fs » qui demande le nombre d'habitants que l'on souhaite dans la ville et le montant maximum que les habitants peuvent avoir sur leurs comptes en banque.
 - Le deux simulations fonctionnent bien. Nous autions aimé que la simulation « Chaı̂ne des naı̈fs » montre tout les détails de transaction.
 - Nous avions conscience qu'il y a peu de tests mais nous avons rencontré des difficultés pour reussir à les faire.

 - Pendant la pause pédagogique, Pierre n'a pas eu accès à internet (pas cool le retour à la campagne :(), il est donc revenu en 'pushant' d'un coup beaucoup de code. De plus nous avons changé énormément de choses la dernière semaine n'etant pas satisfait de la première version. 
 - Avant le commit du 6 novembre au matin, nous voulions essyaer d'inclure ce que Pierre avait fait pendant les vacances dans le code produit par Mathilde, n'y arrivant pas, dans la nuit du 5 au 6 nous avons tout changé et sommes repartis sur le code de Pierre.

How to
-------------
> **Récupération du dépot : **
Dans https://gitlab-etu.fil.univ-lille1.fr/desmarest/desmarest_syllebranque_coo/tree/master/Courriers/Courriers faire :

git pull

> **Pour générer la documentation : **
Toujours au même niveau dans l'arborescence faire :

mvn package

puis

mvn javadoc:javadoc

	: La documentation se trouve ensuite dans target/docs

> **Pour générer le projet: **
Toujours au même niveau dans l'arborescence faire :

mvn package

> **Pour éxécuter : **
Toujours au même niveau dans l'arborescence faire :

java -jar target/Courriers-1.0-SNAPSHOT.jar

> **Fonctionnement global du projet : **
Au lancement de l'exécutable, on vous demande quelle simulation vous voulez lancer.
On vous demande après un peu plus de détails sur celle ci.
