schema([ename,ssn,bdate,address,dnumber,dname,dmgrssn]).

fds([ [[ssn],[ename,bdate,address,dnumber]], [[dnumber],[dname,dmgrssn]] ]).




answer(MinF) :- schema(EMP_DEPT),fds(G),mincover(EMP_DEPT,G,MinF).

answer :- schema(EMP_DEPT),fds(G),answer(MinF),implies(EMP_DEPT,G,MinF).




/*
?- ['exo3.pl'].
true.

?- answer.
true 

The functional dependencies G in exercise 2 is minimal.
*/
