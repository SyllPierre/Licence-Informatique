Require Import List.
(* Require Import FunInd. *)(* module permettant d'utiliser l'induction fonctionnelle. À utiliser avec coq 8.9 *)

Set Implicit Arguments.

(* Définition de la relation de permutation entre listes. Cette définition se
base sur le fait que toute permutation peut se décomposer en un nombre fini de
transpositions. *)

Inductive permutation (A:Type): list A -> list A -> Prop:=
| permRefl : forall l, permutation l l
(* Une liste est permutation d'elle-même *)

| permCons: forall l1 l2, permutation l1 l2 -> forall a, permutation (a::l1) (a::l2)
(* lorsque deux listes sont permutations l'une de l'autre ajouter un même
élément a à leur tête crée deux listes qui sont permutation l'une de l'autre. *)

| permTransposition: forall l1 l2, permutation l1 l2 ->  forall a b, permutation (a::b::l1) (b::a::l2)
(* Mettre dans un ordre différent deux éléments en tête deux listes qui sont
permutation l'une de l'autre produit deux listes qui sont permutation l'une de
l'autre. *)

| permTransitive: forall l1 l2 l3, permutation l1 l2 -> permutation l2 l3 -> permutation l1 l3.
(* Enfin la relation de permutation entre liste est transitive. *)

(* Question 1 *)

(* Lorsque vous utilisez le constructeur permTransitive, il faut indiquer la
valeur de l2. Pour cela il y deux possibilités :

1. apply (permTransitive _ listeIntermediaire).
2. apply permTransitive with (l2:=listeIntermediaire).

*)

Example exPermutation1  : permutation (1::2::3::nil) (3::1::2::nil).
Proof.
  apply permTransitive with (l2:=1::3::2::nil).
  - apply permCons.
    apply permTransposition.
    apply permRefl.
  - apply permTransposition.
    apply permRefl.
Qed.

(* Démontrer que (1::2::3::4::nil) est une permutation de (3::4::1::2::nil)*)
(* Conseil : lorsque vous utilisez permTransitive with (l2=l') pour démontrer
permutation l l'' faites en sorte que l' soit obtenu en transposant deux élément
de l ou de l''. *)
Example exPermutation2 : permutation (1::2::3::4::nil) (3::4::1::2::nil).
Proof.
apply permTransitive with (l2:=1::3::2::4::nil).
  apply permCons.
  apply permTransposition.
  apply permRefl.

  apply permTransitive with (l2:=3::1::2::4::nil).
    apply permTransposition.
    apply permRefl.

    apply permTransitive with (l2:=3::1::4::2::nil).
      apply permCons.
      apply permCons.
      apply permTransposition.
      apply permRefl.

      apply permTransitive with (l2:=3::4::1::2::nil).
        apply permCons.
        apply permTransposition.
        apply permRefl.

apply permRefl.

Qed.

(* Fonction qui permet de construire la propriétés que toute paire d'éléments
   consécutifs d'une liste vérifie une propriété. *)

Fixpoint relationListe (A:Type) (pred: A -> A -> Prop) (l:list A) : Prop:=
  match l with
  | nil => True
  | a::l' =>
    match l' with
    | nil => True
    | b::_ => pred a b /\ relationListe pred (l')
    end
  end.

(* Question 2 *)

(* Montrer le lemme suivant *)

(* Il faut songer que relationListe est:

1. soit de la forme True

2. soit de la forme P /\ Q.

Dans le premier cas, apply I suffit pour résoudre le but, dans le second il faut utiliser split. *)

Example exRelationListe: relationListe eq (1::1::1::nil).
Proof.
split.
reflexivity.
split.
reflexivity.
split.
Qed.

Section ordre.
  (* On se donne un type A *)
  Variable A:Type.

  (* On se donne une relation sur A *)
  Variable preOrdre : A -> A -> Prop.

  (* Cette relation est transitive et totale: il s'agit d'un pré-ordre total *)
  Variable preOrdre_total:
    forall a b, preOrdre a b \/ preOrdre b a.

  Variable preOrdre_transitif:
    forall a b c, preOrdre a b -> preOrdre b c -> preOrdre a c.


  (* Question 3 *)

  (* Montrer le lemme suivant *)

  (* Pour démontrer ce lemme, il faut utiliser la tactique destruct sur un terme
  bien choisi.

   Indice: rappelez-vous que l'ordre est total.*)

  Lemma preOrdre_reflexif:
    forall a, preOrdre a a.
  Proof.
  intro a.
  destruct preOrdre_total with a a.
  + apply H.
  + apply H.
  Qed.

  (* Nous pouvons maintenant définir ce qu'est une liste ordonnée relativement à ce pré-ordre. *)
  Definition listeOrdonnée := relationListe preOrdre.

  (* Nous avons maintenant tous les éléments qui nous permettent de spécifier ce qu'est un algorithme de tri. *)

  Definition specificationTri (tri :  list A -> list A):=
    forall l, listeOrdonnée (tri l) /\ permutation l (tri l).


  (* Nous allons maintenant nous tourner vers la définition d'un algorithme de
  tri. Pour cela, il faut supposer que l'on dispose d'un algorithme capable de
  décider si deux éléments de type A sont dans la reation preOrdre. *)
  
  (* On suppose maintenant que l'on dispose d'un tel algorithme. *)
  Variable preOrdreImplem : A -> A -> bool.

  (* On spécifie que cet algorithme est une implémentation de la relation preOrdre. *)
  Variable preOrdreImplem_implementation_de_preOrdre: forall (a b:A),
    preOrdreImplem a b =true <-> preOrdre a b.


  (* Question 4 *)

  (* Montrer le lemme suivant. *)

  (* Pour réussir cette question, il faut :

     1. utiliser l'hypothèse qui stipule que preOrdreImplem est une
     implémentation de preOrdre

     2. utiliser une analyse de cas concernant la valeur de preOrdreImplem. Pour cela, on pourra utiliser l'une des deux tactiques suivantes:
        a. destruct (preOrdreImplem a b).
        b. case_eq (preOrdreImplem a b).
   *)

  Lemma preOrdreImplem_notPreOrdre:
    forall a b, preOrdreImplem a b = false <-> ~ preOrdre a b.
  Proof.
  intros a b.
  destruct (preOrdreImplem_implementation_de_preOrdre a b).
  destruct (preOrdreImplem a b).
  - split.
    + intro contract.
      discriminate.
    + intro contract.
      destruct contract.
      now apply H.
  - split ; trivial.
    intros Eq a_inf_b.
    apply H0 in a_inf_b as contract.
    discriminate.
  Qed.

  (* Question 5 *)

  (* Démontrer le lemme suivant. *)

  Lemma preOrdreImplem_false:
    forall a b, preOrdreImplem a b = false -> preOrdre b a.
  Proof.
  intros a b.
  destruct (preOrdreImplem_implementation_de_preOrdre a b).
  destruct (preOrdreImplem_implementation_de_preOrdre b a).
  destruct (preOrdreImplem a b).
  - intro c.
    discriminate.
  - intro d.
    apply H1.
    destruct (preOrdreImplem b a).
    + trivial.
    + destruct (preOrdre_total a b).
      now apply H0.
      now apply H2.
  Qed.

  (* Question 6 *)

  (* Démontrer le lemme suivant. *)

  Lemma preOrdreImplem_neq:
    forall a b,  preOrdreImplem a b = false -> a<>b.
  Proof.
  intros a b Eqfalse Eq.
  rewrite Eq in Eqfalse.
  apply preOrdreImplem_notPreOrdre in Eqfalse.
  apply Eqfalse.
  apply preOrdre_reflexif.
  Qed.

  (* Nous pouvons désormais implémenter le tri par insertion. *)

  (* Tout d'abord la fonction d'insertion. *)

  Fixpoint insert l a :=
    match l with
    | nil => (a::nil)
    | (b::l) =>
      match preOrdreImplem a b with
      | true => a::b::l
      | false => b:: (insert l a)
      end
    end.

  (* Question 7 *)

  (* Démontrer le lemme suivant. *)

  (* Ce lemme permet de raisonner par induction sur l'ordre de terminaison de la
  fonction insert. Utiliser une telle induction simplifie les démonstrations de
  concernant la fonction insert.*)

  (* Conseil : dans cette démonstration il faut préférer case_eq à destruct. *)

  Lemma insert_induction (a:A):
    forall (P: list A -> A -> list A -> Prop),
      (* P représente une relation entre la liste argument de insert, l'élément
      à insérer et le résultat produit par la fonction. *)
      P nil a (a::nil) ->
      (* Démonstration que la relation est vérifiée en cas d'insertion dans la
      liste vide *)
      (forall b, preOrdreImplem a b = true ->forall l, P (b::l) a (a::b::l)) ->
      (* Démonstration que la relation est vérifiée en cas d'insertion en tête
      de la liste. *)
      (forall b, preOrdreImplem a b = false -> forall l, P l a (insert l a) -> P (b::l) a (b::(insert l a))) ->
      (* Démonstration du cas inductif. *)
      forall l, P l a (insert l a).
  (* Conclusion que la relation est vérifiée pour tout triplet 
  liste/élément/résultat. *)
  Proof.
  intros.
  induction l.
  - assumption.
  - simpl.
    case_eq (preOrdreImplem a a0).
    + intro x.
      now apply H0.
    + intro x.
      now apply H1.
  Qed.

  (* Coq est capable de démontrer automatiquement un principe d'induction un peu
  plus général. *)

  Functional Scheme insert_ind := Induction for insert Sort Prop.

  Check insert_ind.

  (* Utiliser ce mécanisme de coq permet de l'intégrer au système des tactiques
  de coq. En particulier, il suffit d'utiliser

  functional induction (insert l a).

  Afin d'effectuer une démonstration par induction sur l'ordre de terminaison de insert pour la liste l et l'élément a.
   *)

  (* Nous définissons maintenant l'algorithme de tri par insertion. *)

  Fixpoint triParInsertion l :=
    match l with
    | nil => nil
    | a::l => insert (triParInsertion l) a
    end.

  (* Question 8 *)

  (* Démontrer le lemme suivant. *)

  (* Vous pouvez essayer d'utiliser une induction fonctionnelle. *)

  (* Indice : l'un des cas requiert une utilisation de permTransitive bien
  choisie . *)

  Lemma insert_permutation:
    forall (a:A) l, permutation (a::l) (insert l a).
  Proof.
  intros a l.
  functional induction (insert l a).
  + apply permRefl.
  + apply permRefl.
  + apply permTransitive with (l2:=b::a::l0).
    - apply permTransposition.
      apply permRefl.
    - apply permCons.
      trivial.
  Qed.


  (* Question 9 *)

  (* Démontrer le lemme suivant *)

  (* Il s'agit de la démonstration la plus difficile du TP. Il est normal
     que y passiez plus de temps que pour les autres.
   *)

  Lemma insert_ordonne:
    forall a l, listeOrdonnée l -> listeOrdonnée (insert l a).
  Proof.
  intros a l.
  intro lOrd.
  functional induction (insert l a).
  - trivial.
  - split.
    + destruct (preOrdreImplem_implementation_de_preOrdre a b).
      now apply H.
    + trivial.
  - destruct l0.
    + split.
      * now apply preOrdreImplem_false.
      * trivial.
    + simpl in *.
      inversion lOrd.
      destruct (preOrdreImplem_implementation_de_preOrdre a a0).
      destruct (preOrdreImplem a a0).
      * split.
        ** now apply preOrdreImplem_false.
        ** now apply IHl0.
      * split.
        ** trivial.
        ** now apply IHl0.
  Qed.

  (* Question 10 *)

  (* Démontrer le lemme suivant. *)

  Lemma triParInsertion_ordonne :
    forall l, listeOrdonnée (triParInsertion l).
  Proof.
  Admitted.

  (* Question 11 *)

  (* Démontrer le lemme suivant. *)

  (* Indice : cette démonstration requiert l'utilisation de la transitivité de
  la relation de permutation. *)


  Lemma triParInsertion_permutation:
    forall l, permutation l (triParInsertion l).
  Proof.
  Admitted.

  (* Question 12 *)

  (* Démontrer le théorème principal. *)

  Theorem triParInsertion_tri:
    specificationTri triParInsertion.
  Proof.
  Admitted.

 