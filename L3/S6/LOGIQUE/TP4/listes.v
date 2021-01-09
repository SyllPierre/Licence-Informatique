(* Listes *)

Inductive liste : Type :=
| nil : liste
| C : nat -> liste -> liste.


(* Question 13 *)
(* Définition de la fonction longueur *)
Fixpoint longueur (l:liste) : nat :=
  match l with
    | nil => 0
    | C _ l => S (longueur l)
    end.


(* Question 14 *)
(* Définition de la fonction concat *)
Fixpoint concat (l1 l2:liste) : liste :=
  match l1 with
    | nil => l2
    | C x l => C x (concat l l2)
    end.

(* Question 15 *)
Theorem long (l m : liste) : longueur(concat l m) = longueur l + longueur m.
Proof.
induction l.
- simpl.
  reflexivity.
- simpl.
  rewrite IHl.
  reflexivity.
Qed.

(* Question 16 *)
(* Définition de la fonction ajoutqueue *)
Definition ajoutqueue x l : liste := concat l (C x nil).

(* Question 17 *)
Theorem lgajout (x : nat) (l : liste) : longueur(ajoutqueue x l) = 1 + longueur l.
Proof.
induction l; simpl.
+ trivial.
+ simpl.
  simpl in IHl.
  rewrite <- IHl.
  now unfold ajoutqueue.
Qed.
