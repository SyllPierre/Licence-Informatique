schema([a,b,c,d,e,f,g,h,i,j]).

fds([ [[a,b],[c]],[[b,d],[e,f]],[[b],[f]],[[f],[g,h]],[[d],[i,j]] ]).

answer(K) :- schema(R),fds(G),candkey(R,G,K).

answer(R3NF) :- schema(R), fds(G), threenf(R,G,R3NF).

/*
?- answer(K).
K = [a, b, d] .

?- answer(R3NF).
R3NF = [a, b, d] 
*/
