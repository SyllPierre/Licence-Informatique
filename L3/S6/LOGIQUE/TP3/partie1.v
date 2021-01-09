Lemma hilbertS (A B C : Prop) :  (A -> B -> C) -> (A -> B) -> A -> C.
Proof.
intros abc ab a.
apply abc.
exact a.
apply ab.
exact a.
Show Proof.
Qed.

Lemma q2 (A B : Prop) :  A -> (B -> A).
Proof.
intros a.
intros b.
exact a.
Show Proof.
Qed.

Lemma q3 (A B : Prop) :  A -> (~A -> B).
Proof.
intros a.
intros na.
destruct na.
apply a.
Show Proof.
Qed.

Lemma q4 (A B C : Prop) :  (A -> B) -> ((B -> C) -> (A -> C)).
Proof.
intros ab.
intros bc.
intros a.
apply bc.
apply ab.
exact a.
Show Proof.
Qed.

Lemma q5 (A B : Prop) :  (A -> B) -> (~B -> ~A).
Proof.
intros ab.
intros nb.
intros a.
destruct nb.
apply ab.
apply a.
Show Proof.
Qed.

Require Import Classical.

Lemma tiersexclus (A : Prop) : A \/ ~A.
Proof.
apply NNPP.
intros aa.
apply aa.
right.
intro a.
apply aa.
left.
apply a.
Show Proof.
Qed.

Lemma bottom_c (A : Prop) : (~A -> False) -> A.
Proof.
apply NNPP.
Show Proof.
Qed.

Lemma q8 (A B : Prop) : (~B -> ~A) -> (A -> B).
Proof.
intros nbna.
intros a.
apply NNPP.
intro nb.
apply nbna.
apply nb.
apply a.
Show Proof.
Qed.

Lemma q9 (A : Prop) : ~~A <-> A.
Proof.
split.
- apply NNPP.
- intro a.
intro na.
apply na.
apply a.
Show Proof.
Qed.

Lemma q10 (A : Prop) :  (A /\ ~A) <-> False.
Proof.
split.
- intro aETna.
  destruct aETna.
  apply H0.
  apply H.
-intro false.
  destruct false.
Show Proof.
Qed.

Lemma q11 (A B : Prop) :  (A \/ B) <-> ~(~A /\ ~B).
Proof.
split.
- intro aOUb.
  intro naETnb.
  destruct naETnb.
  destruct aOUb.
  + apply H.
    apply H1.
  + apply H0.
    exact H1.
- intro nnaETna.
  apply NNPP.
  intro naOUb.
  apply nnaETna.
  split.
  + intro a.
    apply naOUb.
    left.
    exact a.
  + intro b.
    apply naOUb.
    right.
    exact b.
Show Proof.
Qed.

Lemma q12 (A : Prop) :  ~A <-> (A -> False).
Proof.
split.
- intro na.
  intro a.
  apply na.
  exact a.
- intro af.
  intro a.
  apply af.
  exact a.
Show Proof.
Qed.

Lemma q13 (A B : Prop) :  (A <-> B) <-> (A -> B) /\ (B -> A).
Proof.
split.
- intro aeqb.
  split.
  + intro a.
    apply aeqb.
    exact a.
  + intro b.
    apply aeqb.
    exact b.
- intro abETba.
  split.
  + intro a.
    apply abETba.
    exact a.
  + intro b.
    apply abETba.
    exact b.
Show Proof.
Qed.

Lemma q14 (A B C : Prop) :  (A /\ B -> C) <-> (A -> B -> C).
Proof.
split.
- intro aETbc.
  intro a.
  intro b.
  apply aETbc.
  split.
  + apply a.
  + apply b.
- intro abc.
  intro aETb.
  destruct aETb.
  apply abc.
  + apply H.
  + apply H0.
Show Proof.
Qed.

Lemma q15 (A B C : Prop) :  (C -> A)\/ (C -> B) <-> (C -> A \/ B).
Proof.
split.
- intro caOUcb.
  intro c.
  destruct caOUcb.
  + left.
    apply H.
    exact c.
  + right.
    apply H.
    exact c.
- intro caOUb.
  apply NNPP.
  intro caOUcb.
  apply caOUcb.
  left ; intro c.
  destruct caOUcb.
  destruct (caOUb c).
  + left; intro; apply H.
  + right; intro; apply H.
Show Proof.
Qed.


Lemma q16 (X : Type) (A B : X -> Prop) : ((forall x, A x) \/ (forall x, B x)) -> forall x, A x \/ B x.
Proof.
intro fAOUfB.
intro x.
destruct fAOUfB as [fA|fB].
+ left.
  apply fA.
+ right.
  apply fB.
Show Proof.
Qed.

Lemma q17 (X : Type) (A B : X -> Prop) : (exists x, A x /\ B x) -> ((exists x, A x) /\ (exists x, B x)).
Proof.
intro existsAxETBx.
destruct existsAxETBx as [x axbx].
destruct axbx as [ax bx].
exists.
+ exists x.
  exact ax.
+ exists x.
  exact bx.
Show Proof.
Qed.

Lemma q18 (A B : Prop) : ~ (A /\ B) -> (~ A \/ ~ B).


Lemma q19 (X : Type) : forall (x1 x2 : X), x1 = x2 -> x2 = x1.
Proof.
intros a b l.
rewrite l.
reflexivity.
Qed.

Lemma q20 (X : Type) : forall (x1 x2 x3 : X), x1 = x2 /\ x2 = x3 -> x1 = x3.
Proof.
intros a b c l.
destruct l as [l1 lr].
rewrite l1.
rewrite lr.
reflexivity.
Qed.

