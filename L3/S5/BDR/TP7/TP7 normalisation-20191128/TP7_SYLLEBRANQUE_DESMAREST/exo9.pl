schema([a,b,c,d,e,f,g,h,i,j]).

fds([ [[a,b],[c]],[[a],[d,e]],[[b],[f]],[[f],[g,h]],[[d],[i,j]] ]).

answer(K) :- schema(R),fds(F),candkey(R,F,K).

answer(MinF) :- schema(R),fds(F),mincover(R,F,MinF).

answer(R3NF) :- schema(R), fds(G), threenf(R,G,R3NF).

/*
?- ['exo9.pl'].
true.

?- answer(K).
K = [a, b] .

?- answer(MinF).
MinF = [a, b] .

?- answer(R3NF).
R3NF = [a, b] .

*/
