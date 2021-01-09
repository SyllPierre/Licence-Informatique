schema([a,b,c,d,e,f,g,h,i,j]).

fds([ [[a,b],[c]],[[a],[d,e]],[[b],[f]],[[f],[g,h]],[[d],[i,j]] ]).

answer(K) :- schema(R),fds(F),candkey(R,F,K).

answer(R3NF) :- schema(R), fds(F), threenf(R,F,R3NF).

/*
?- ['exo4.pl'].
true.

?- answer(K).
K = [a, b] 

?- answer(R3NF).
R3NF = [a, b] 

*/
