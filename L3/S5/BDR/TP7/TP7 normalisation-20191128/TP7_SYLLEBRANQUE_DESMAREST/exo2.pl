schema([ename,ssn,bdate,address,dnumber,dname,dmgrssn]).

fds([ [[ssn],[ename,bdate,address,dnumber]], [[dnumber],[dname,dmgrssn]] ]).

answer1(Xplus) :- schema(EMP_DEPT),fds(G),xplus(EMP_DEPT,G,[[ssn],[ename,bdate,address,dnumber]],Xplus).

answer2(Xplus) :- schema(EMP_DEPT),fds(G),xplus(EMP_DEPT,G,[[dnumber],[dname,dmgrssn]],Xplus).


/*
?- ['exo2.pl'].
true.

?- answer1(Xplus).
Xplus = [[ename, bdate, address, dnumber], [ssn]].

?- answer2(Xplus).
Xplus = [[dname, dmgrssn], [dnumber]].
*/
