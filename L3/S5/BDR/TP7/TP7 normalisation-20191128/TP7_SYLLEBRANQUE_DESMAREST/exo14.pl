schema([modelno,year,p,mp,c]).

fds([ [[modelno],[mp]],[[modelno,year],[p]],[[mp],[c]] ]).

answer1 :- schema(R),fds(F),candkey(R,F,[modelno]).

answer2 :- schema(R),fds(F),candkey(R,F,[modelno,year]).

answer3 :- schema(R),fds(F),candkey(R,F,[modelno,c]).

answer3NF :- schema(R), fds(F), is3NF(R,F).

answerBCNF :- schema(R), fds(F), isBCNF(R,F).


decomp([ [modelno,year,p], [modelno,mp,c],[modelno,mp,c] ]).


answer :- schema(R), fds(F), decomp(D), ljd(R,F,D).

/*
?- ['exo14.pl'].
true.

?- answer1.
false.

?- answer2.
true .

?- answer3.
false.

?- answer3NF.
false.

?- answerBCNF.
false.

?- answer.
[[a,1],[a,2],[a,3],[a,4],[a,5]]
[[a,1],[b,2,2],[b,2,3],[a,4],[a,5]]
[[a,1],[b,3,2],[b,3,3],[a,4],[a,5]]

true .

*/
