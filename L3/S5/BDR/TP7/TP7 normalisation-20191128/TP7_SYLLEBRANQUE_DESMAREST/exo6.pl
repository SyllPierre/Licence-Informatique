schema([a,b,c,d,e]).

fds([ [[a,b],[c]],[[c,d],[e]],[[d,e],[b]] ]).

answer1 :- schema(R),fds(F),candkey(R,F,[a,b]).

answer2 :- schema(R),fds(F),candkey(R,F,[a,b,d]).

/*
?- ['exo6.pl'].
true.

?- answer1.
false.

?- answer2.
true .
*/
