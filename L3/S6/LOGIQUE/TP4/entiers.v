Require Import Setoid.

Inductive entier : Type :=
| O : entier
| S : entier -> entier.

(* Addition *)

Fixpoint plus (n m : entier) : entier :=
  match n with
  | O => m
  | S n' => S (plus n' m)
  end.


(* Question 1 *)

Theorem associativite (n m p : entier) : plus n (plus m p) = plus (plus n m) p.
Proof.
induction n.
  -reflexivity.
  -simpl.
rewrite IHn.
reflexivity.
Qed.

(* Symétrie *)

(* Question 2 *)

Lemma plus0 (n : entier) : plus n O = n.
Proof.
induction n.
  -reflexivity.
  -simpl.
rewrite IHn.
reflexivity.
Qed.

(* Question 3 *)

Lemma plusS (n p : entier) : plus n (S p) = S (plus n p).
Proof.
induction n.
  -reflexivity.
  -simpl.
rewrite IHn.
reflexivity.
Qed.

(* Question 4 *)

Theorem symetrie (n m : entier) : plus n m = plus m n.
Proof.
induction n.
- rewrite plus0.
  simpl.
  reflexivity.
- simpl.
  rewrite plusS.
  rewrite IHn.
  reflexivity.
Qed.

(* Simplification *)

(* Question 5 *)

Lemma egalS (n m : entier) : n = m <-> S n = S m.
Proof.
split.
  - intro a.
    rewrite a.
    reflexivity.
  - intro b.
    injection b.
    intro c.
    apply c.
Qed.

(* Question 6 *)

Theorem simplification (a n m : entier) : plus a n = plus a m <-> n = m.
Proof.
induction a.
simpl.
- split.
  + intro b.
    apply b.
  + intro c.
    apply c.
- split.
  + intro d.
    injection d.
    apply IHa.
  + intro e.
    rewrite e.
    reflexivity.
Qed.

Theorem simplification2 (a n m : entier) : plus a n = plus a m <-> n = m.
Proof.
induction a.
- now simpl.
- simpl.
  rewrite <- egalS.
  rewrite IHa.
  reflexivity.
Qed.


(* Multiplication *)

Fixpoint mult (n m : entier) : entier :=
  match n with
  | O => O
  | S n' => plus m (mult n' m)
  end.

(* Symétrie *)

(* Question 7 *)

Lemma multO (n : entier) : mult n O = O.
Proof.
induction n.
 - reflexivity.
 - simpl.
   rewrite IHn.
   reflexivity.
Qed.

(* Question 8 *)

Lemma assoc2 (n m p : entier) : plus n (plus m p) = plus m (plus n p).
Proof.
induction n.
- simpl.
  reflexivity.
- simpl.
  rewrite plusS.
  rewrite IHn.
  reflexivity.
Qed.

(* Question 9 *)

Lemma multsn (n m : entier) : mult n (S m) = plus n (mult n m).
Proof.
induction n.
- simpl.
  reflexivity.
- simpl.
  rewrite IHn.
  rewrite assoc2.
  reflexivity.
Qed.

(* Question 10 *)

Theorem symetriemult (n m : entier) : mult n m = mult m n.
Proof.
induction n.
- simpl.
  rewrite multO.
  reflexivity.
-simpl.
  rewrite multsn.
  rewrite IHn.
  reflexivity.
Qed.

(* Distributivité *)

(* Question 11 *)

Theorem distributivite (n m p : entier) : mult (plus n m) p = plus (mult n p) (mult m p).
Proof.
induction n.
- simpl.
  reflexivity.
- simpl.
  rewrite IHn.
  rewrite associativite.
  reflexivity.
Qed.

(* Associativité *)

(* Question 12 *)

Theorem associativitemult (n m p : entier) : mult n (mult m p) = mult (mult n m) p.
Proof.
induction n.
- simpl.
  reflexivity.
- simpl.
  rewrite distributivite.
  rewrite IHn.
  reflexivity.
Qed.
