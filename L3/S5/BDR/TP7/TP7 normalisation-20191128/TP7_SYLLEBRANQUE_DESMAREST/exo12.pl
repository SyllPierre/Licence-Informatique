schema([a,b,c,d,e]).

fds([ [[a,b],[c]],[[c,d],[e]],[[d,e],[b]] ]).

answer(K) :- schema(R),fds(F),candkey(R,F,K).

answer(R3NF) :- schema(R), fds(F), threenf(R,F,R3NF).

answer(D) :- schema(R),fds(F),bcnf(R,F,D).


/*
?- ['exo12.pl'].
true.

?- answer(K).
K = [a, d, e] .

?- answer(R3NF).
R3NF = [a, d, e] .

?- answer(D).
D = [a, d, e] .
*/

schema2([courseno,secno,offeringdept,credithours,courselevel,instructorssn,semester,year,dayshours,roomno,noofstudents]).

fds2([ [[courseno],[offeringdept,credithours,courselevel]],[[courseno,secno,semester,year],[dayshours,roomno,noofstudents,instructorssn]],[[roomno,dayshours,semester,year],[instructorssn,courseno,secno]] ]).

answer2(K) :- schema2(R),fds2(F),candkey(R,F,K).

answer2(R3NF) :- schema2(R), fds2(F), threenf(R,F,R3NF).

answer2(D) :- schema2(R),fds2(F),bcnf(R,F,D).

/*
?- answer2(K).
K = [semester, year, dayshours, roomno] .

?- answer2(R3NF).
R3NF = [semester, year, dayshours, roomno] .

?- answer2(D).
D = [semester, year, dayshours, roomno] .
*/

