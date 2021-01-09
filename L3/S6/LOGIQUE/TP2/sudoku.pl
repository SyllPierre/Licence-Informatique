/*
  Mathilde DESMAREST
  Pierre SYLLEBRANQUE
*/

/* Introduction */

grille([[_,_,_,_,_,_,_,_,_],
        [_,_,_,_,_,3,_,8,5],
        [_,_,1,_,2,_,_,_,_],
        [_,_,_,5,_,7,_,_,_],
        [_,_,4,_,_,_,1,_,_],
        [_,9,_,_,_,_,_,_,_],
        [5,_,_,_,_,_,_,7,3],
        [_,_,2,_,1,_,_,_,_],
        [_,_,_,_,4,_,_,_,9]]).

grillehex([[2,_,_,3],
           [_,_,2,_],
           [_,4,1,_],
           [1,_,_,_]]).

grillehex2([[11,2,_,7,_,_,_,15,6,14,_,_,_,3,_,13],
           [_,_,_,9,11,_,2,_,_,_,_,_,15,1,_,6],
           [_,10,_,12,_,_,7,_,4,_,8,_,_,_,14,_],
           [_,8,_,3,_,_,1,_,_,_,15,12,10,_,4,2],
           [_,_,14,_,_,_,_,_,1,6,10,_,_,_,3,_],
           [3,_,_,_,_,_,_,_,_,4,_,15,8,_,6,11],
           [_,_,_,13,2,_,_,_,_,11,_,_,7,4,_,_],
           [_,11,8,4,0,_,_,13,7,_,9,3,14,_,_,_],
           [_,_,_,15,3,7,_,4,5,_,_,9,0,13,12,_],
           [_,_,12,8,_,_,10,_,_,_,_,11,4,_,_,_],
           [4,9,_,5,14,_,13,_,_,_,_,_,_,_,_,10],
           [_,13,_,_,_,6,12,1,_,_,_,_,_,7,_,_],
           [9,1,_,14,7,4,_,_,_,15,_,_,3,_,13,_],
           [_,3,_,_,_,9,_,2,_,1,_,_,5,_,0,_],
           [15,_,4,11,_,_,_,_,_,3,_,13,1,_,_,_],
           [5,_,13,_,_,_,15,14,9,_,_,_,2,_,11,4]]).

/* Question 1 */

printline([]) :- writeln('|').
printline([X | L]) :- integer(X),!, write('|'), write(X), printline(L).
printline([_ | L]) :- write('|'), write(' '), printline(L).

/* Question 2 */

print([]).
print([X | L]) :- printline(X), print(L).

/* Vérification de la structure */

/* Question 3 */

bonnelongueur([],0).
bonnelongueur([_ | L], R):- bonnelongueur(L, TMP), R is TMP+1.

/* Question 4 */

bonnetaille([],_).
bonnetaille([X | L], R):- bonnelongueur(X,R), bonnetaille(L,R).

/* Vérification du domaine */

:- use_module(library(clpfd)).

/* Question 5 */

verifie([]).
verifie([X | L]) :- X ins 1..9, all_distinct(X), verifie(L).

/* Vérification des colonnes */

/* Question 6 */

eclate([],R,R).
eclate([X | L], [], [[X] | R]):- eclate(L,[],R).
eclate([X1 | L1], [X2 | L2], [[X1 | X2] | L3]) :- eclate(L1, L2, L3).

/* Question 7 */

transp([],[]).
transp([X | L],R):- transp(L,L1), eclate(X, L1, R).

/* Vérification des carrés */

/* Question 8 */

decoupe([],[],[], []).
decoupe([X1,X2,X3|XS],[Y1,Y2,Y3|YS],[Z1,Z2,Z3|ZS], [[X1,X2,X3,Y1,Y2,Y3,Z1,Z2,Z3]|RS]) :-decoupe(XS,YS,ZS,RS).

/* Question 9 */

carres([], []).
carres([X1,X2,X3|XS], [R1,R2,R3|RS]) :-decoupe(X1, X2, X3, [R1, R2, R3]), carres(XS, RS).

/* Solution */

/* Question 10 */
/* bonnetaille(X): Toutes les lignes sont de longueur 9.
   transp(X,Y), bonnetaille(Y): Toutes les lignes sont de longueur 9.
   verifie(X) : Chaque ligne contient des valeurs de 1 à 9 différentes.
   verifie(Y) : Chaque colonne contient des valeurs de 1 à 9 différentes.
   carres(Y, Z), verifie(Z): chaque carré contient des valeurs de 1 à 9 différentes.
   solution(X) :- verifie(X), transp(X,Y), verifie(Y), carres(X, Z), verifie(Z).
*/

solution(X) :- bonnetaille(X,9), transp(X,Y), bonnetaille(Y,9), verifie(X), verifie(Y), carres(X,Z), verifie(Z).

/* Variantes */
/* Question 11 */
coupe([],[]).
coupe([[_|L]|G1],[L|G2]) :- coupe(G1,G2).

diagG([],[]).
diagG([[X|_]|G],[X|D]):-coupe(G,G1), diagG(G1,D).

diagD([],[]).
diagD(L1,L3):-reverse(L1,L2), diagG(L2,L3).

solutionDiago(X):- solution(X), diagG(X,L1), diagD(X,L2), verifie([L1,L2]).

/* Question 12 */
verifie_t4([]).
verifie_t4([L|LS]):-L ins 1..4,all_distinct(L),verifie_t4(LS).

decoupe_t4([],[],[]).
decoupe_t4([X1,X2|T1],[Y1,Y2|T2],[[X1,X2,Y1,Y2]|L]):-decoupe_t4(T1,T2,L).

carres_t4([],[]).
carres_t4([L1,L2|Q],[T1,T2|L]):-decoupe_t4(L1,L2,[T1,T2]),carres_t4(Q,L).

solution_t4(X) :- bonnetaille(X,4), transp(X,Y), bonnetaille(Y,4), verifie_t4(X), verifie_t4(Y), carres_t4(X,Z), verifie_t4(Z).

minidoku(X):-bonnetaille(X,4),transp(X,Y),bonnetaille(Y,4),verifie_t4(X),verifie_t4(Y),carres_t4(X,Z),verifie_t4(Z).
/* Question 13 */
convertie(X,X):-not(ground(X)).
convertie(a,10):-!.
convertie(b,11):-!.
convertie(c,12):-!.
convertie(d,13):-!.
convertie(e,14):-!.
convertie(f,15):-!.
convertie(X,X).

convListe([],[]).
convListe([X|L], [Y|LL]) :- convertie(X,Y), convListe(L,LL).

convGrille([],[]).
convGrille([L1|G1],[L2|G2]) :- convListe(L1,L2), convGrille(G1,G2).

printline_t16([]):-write("|").
printline_t16([X|XS]):-not(integer(X)),write("|"),write(" "),printline_t16(XS).
printline_t16([X|XS]):-integer(X),write("|"),convertie(Y,X),write(Y),printline_t16(XS).

print_t16([]).
print_t16([X|XS]):-printline_t16(X),write("\n"),print_t16(XS).

verifie_t16([]).
verifie_t16([H|T]):-H ins 0..15, all_distinct(H),verifie_t16(T).

decoupe_t16([],[],[],[],[]).
decoupe_t16([X1,X2,X3,X4|T1],[Y1,Y2,Y3,Y4|T2],[Z1,Z2,Z3,Z4|T3],[U1,U2,U3,U4|T4],[[X1,X2,X3,X4,Y1,Y2,Y3,Y4,Z1,Z2,Z3,Z4,U1,U2,U3,U4]|L]):-decoupe_t16(T1,T2,T3,T4,L).

carres_t16([],[]).
carres_t16([L1|[L2|[L3|[L4|Q]]]],[T1,T2,T3,T4|L]):-decoupe_t16(L1,L2,L3,L4,[T1,T2,T3,T4]),carres_t16(Q,L).

maxidoku(L):-bonnetaille(L,16),transp(L,TL),bonnetaille(TL,16),verifie_t16(L),verifie_t16(TL),carres_t16(L,CL),verifie_t16(CL).
/* Question 14 */
verifie3D([]).
verifie3D([X|L]):-verifie_t4(X),verifie3D(L).

decoupe3D([],[]).
decoupe3D([X|XS],[H|L]):-decoupe_t4(X,H),decoupe3D(XS,L).

print3D([]).
print3D([X|XS]):-print(X),write('---------\n'),print3D(XS).

carres3D([],[]).
carres3D([X|XS],[H|L]):- carres_t4(X,H),carres3D(XS,L).

transp3D([],[]).
transp3D([X|XS],[H|L]):-transp(X,H),transp3D(XS,L).

solution3D(L):-transp3D(L,TL),verifie3D(TL),verifie3D(L),carres3D(L,CL),verifie3D(CL).
