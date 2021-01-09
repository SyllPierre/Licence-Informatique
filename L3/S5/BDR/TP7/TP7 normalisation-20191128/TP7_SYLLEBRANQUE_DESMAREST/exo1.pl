schema([a,b,c,d,e,f,h]).

fds1([ [[a],[c]],[[a,c],[d]],[[e],[a,d]],[[e],[h]] ]).

fds2([ [[a],[c,d]],[[e],[a,h]] ]).

answer :- schema(R),fds1(F),fds2(G), implies(R,F,G).



/*
?- ['exo1.pl'].
true.

?- answer.
true 
*/
