/*
  Prénom1 Nom1 Pierre Syllebranque
  Prénom2 Nom2 Mathilde Desmarest
*/

/* Question 1 */
longueur([],0).
longueur([_|X],Y):-longueur(X,Z), Y is Z+1.

/* Question 2 */
somme([],0).
somme([H|T],Y):-somme(T,Z), Y is Z+H.

/* Question 3 */
membre(X,[X|_]).
membre(X,[_|T]):-membre(X,T).

/* Question 4 */
ajoute_en_tete(X,Y,[X|Y]).

/* Question 5 */
ajoute_en_queue(X,[],[X]).
ajoute_en_queue(X,[H|T],[H|T1]):-ajoute_en_queue(X,T,T1).

/* Question 6 */
extraire_tete(X,Y,Z):-ajoute_en_tete(Y,Z,X).
extraire_teteV2([X|Q],X,Q).

/* Question 7 */
concatene([],L1,L1).
concatene([X|Tail],L2,[X|Tail1]):-concatene(Tail,L2,Tail1).

/* Question 8 */
retourne([],A,A).
retourne([X|L],A,R):-retourne(L,[X|A],R).

/* Tris sur les listes */

/* Question 9 */
insert_trie(E, [], [E]).
insert_trie(E, [X | L1], R) :- E =< X, !, ajoute_en_tete(E, [X | L1], R).
insert_trie(E, [X | L1], [X | L2]) :- E > X, insert_trie(E, L1, L2).

/* Question 10 */
tri_insert([], []).
tri_insert([X | L1], R) :- tri_insert(L1, T), insert_trie(X, T, R).

/* Question 11 */
divise([], [], []).
divise([E], [E], []).
divise([X | L], [X | L1], [X2 | L2]) :- extraire_teteV2(L, X2, Q), divise(Q, L1, L2).

/* Question 12 */
fusion(L1, L2, R) :- concatene(L1, L2, L), tri_insert(L, R).

/* Question 13 */
tri_fusion([], []).
tri_fusion([E], [E]).
tri_fusion([X1,X2|L], R) :- divise([X1,X2|L], L1, L2), tri_fusion(L1, TL1), tri_fusion(L2, TL2),
                    fusion(TL1, TL2, R).

/* Question 14 */
balance(_, [], [], []).
balance(E, [X | L], [X | L1], L2) :- X < E, balance(E, L, L1, L2).
balance(E, [X | L], L1, [X | L2]) :- X >= E, balance(E, L, L1, L2).

/* Question 15 */
tri_rapide([], []).
tri_rapide([X | L], R) :- balance(X, L, L1, L2),
                          tri_rapide(L1, TL1), tri_rapide(L2, TL2),
                          concatene(TL1, [X|TL2], R).

/* Opérations de base sur les ensembles */

/* Question 16 */
est_vide([]).

/* Question 17 */
ajoute_ensemble(E, [], [E]).
ajoute_ensemble(E, [E | L], [E | L]).
ajoute_ensemble(E, [X | L], [X | R]) :- X\=E, ajoute_ensemble(E, L, R).

/* Question 18 */
sous_ensemble([], _).
sous_ensemble([X | L1], L2) :- membre(X, L2), sous_ensemble(L1, L2).

/* Question 19 */
union([], L, L).
union(L, [], L).
union([X | L1], L2, R) :- ajoute_ensemble(X, L2, L3) , union(L1, L3, R).

/* Question 20 */
intersect([], _, []).
intersect(_, [], []).
intersect([X | L], L2, [X | R]) :- membre(X, L2), intersect(L, L2, R).
intersect([X | L], L2, R) :- not(membre(X,L2)), intersect(L, L2, R).

/* Question 21 */
diff([], _, []).
diff(L, [], L).
diff([X | L], L2, [X | R]) :- not(membre(X, L2)), diff(L, L2, R).
diff([X| L], L2, R) :- membre(X,L2), diff(L, L2, R).
