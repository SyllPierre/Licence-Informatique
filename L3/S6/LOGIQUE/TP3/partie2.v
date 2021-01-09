Definition faux := forall (P : Prop), P.
Definition non (A : Prop) := forall (P : Prop), ((A -> faux) -> P) -> P.
Definition et (A B : Prop) := forall (P : Prop), (A -> B -> P) -> P.
Definition ou (A B : Prop) := forall (P : Prop), ((A -> P) -> (B -> P) -> P).
Definition existe (A : Type) (P : A -> Prop) := forall (Q : Prop), (forall a, P a -> Q) -> Q.
Definition egal (A : Type) (a a' : A) := forall (P : A -> Prop), P a -> P a'.

Lemma bottom_e (A : Prop) : faux -> A.
Proof.
intro faux.
apply faux.
Show Proof.
Qed.

Lemma non_intro (A : Prop) : (A -> faux) -> non A.
Proof.
intro aVFaux.
intro a.
intro aVFauxVA.
now apply aVFauxVA.
Show Proof.
Qed.

Lemma non_elim (A : Prop) : A -> non A -> faux.
Proof.
intro a.
intro nonA.
apply nonA.
intro aVFaux.
intro faux.
apply aVFaux.
exact a.
Show Proof.
Qed.

Lemma et_intro (A B : Prop) : A -> B -> et A B.
Proof.
intro a.
intro b.
intro et.
intro aVbVet.
apply aVbVet.
  + exact a.
  + exact b.
Show Proof.
Qed.

Lemma et_elim_g (A B : Prop) : et A B -> A.
Proof.
intro etAB.
apply etAB.
intro a.
intro b.
exact a.
Show Proof.
Qed.

Lemma et_elim_d (A B : Prop) : et A B -> B.
Proof.
intro etAB.
apply etAB.
intro a.
intro b.
exact b.
Show Proof.
Qed.

Lemma ou_intro_g (A B : Prop) : A -> ou A B.
Proof.
intro a.
intro prop.
intro aVProp.
intro bVProp.
now apply aVProp.
Show Proof.
Qed.

Lemma ou_intro_d (A B : Prop) : B -> ou A B.
Proof.
intro b.
intro prop.
intro aVProp.
intro bVProp.
now apply bVProp.
Show Proof.
Qed.

Lemma ou_elim (A B C : Prop) : ou A B -> (A -> C) -> (B -> C) -> C.
Proof.
intro l.
apply l.
Show Proof.
Qed.

Lemma existe_intro (A : Type) (P : A -> Prop) : forall x : A, P x -> existe A P.
Proof.
intro a.
intro pa.
intro p.
intro fpa.
apply (fpa a).
apply pa.
Show Proof.
Qed.

Lemma existe_elim (A : Type) (P : A -> Prop) (Q : Prop) : existe A P -> (forall x : A, P x -> Q) -> Q.
Proof.
intro existAP.
intro fpxq.
apply existAP.
now apply fpxq.
Show Proof.
Qed.

Lemma faux_false : faux <-> False.
Proof.
split.
  + intro faux.
    apply faux.
  + intro false.
    intro faux.
    destruct false.
Show Proof.
Qed.

Lemma non_not (A : Prop) : non A <-> ~A.
Proof.
split.
  + intro nonA.
    intro a.
    apply nonA.
    intro aVFaux.
    apply aVFaux.
    exact a.
  + intro nonA.
    intro nonAprop.
    intro aVFauxVnonAprop.
    now apply aVFauxVnonAprop.
Show Proof.
Qed.

Lemma et_and (A B : Prop) : et A B <-> A /\ B.
Proof.
split.
  + intro etAB.
    apply etAB.
    now apply etAB.
  + intro AETB.
    destruct AETB as [a b].
    intro etAB.
    intro aVbVetAB.
    now apply aVbVetAB.
Show Proof.
Qed.

Lemma ou_or (A B : Prop) : ou A B <-> A \/ B.
Proof.
split.
  + intro ouAB.
    apply ouAB.
    - intro a.
      left.
      exact a.
    - intro b.
      right.
      exact b.
  + intro aOUb.
    destruct aOUb as [a|b].
    - intro aProp.
      intro aVaProp.
      intro bVaProp.
      apply aVaProp.
      exact a.
    - intro bProp.
      intro aVbProp.
      intro bVbProp.
      apply bVbProp.
      exact b.
Show Proof.
Qed.

Lemma existe_exists (A : Type) (P : A -> Prop) : existe A P <-> exists a, P a.
Proof.

Lemma egal_eq (A : Type) (a a' : A) : egal _ a a' <-> a = a'.
Proof.
split.
  + intro egalAa'.
    apply egalAa'.
    reflexivity.
  + intro aEgalA'.
    rewrite aEgalA'.
    intro AVProp.
    intro AVPropA'.
    apply AVPropA'.
Show Proof.
Qed.
