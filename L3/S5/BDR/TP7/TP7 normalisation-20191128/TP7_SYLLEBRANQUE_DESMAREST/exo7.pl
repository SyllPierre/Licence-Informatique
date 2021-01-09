schema([courseno,secno,offeringdept,credithours,courselevel,instructorssn,semester,year,dayshours,roomno,noofstudents]).

fds([ [[courseno],[offeringdept,credithours,courselevel]],[[courseno,secno,semester,year],[dayshours,roomno,noofstudents,instructorssn]],[[roomno,dayshours,semester,year],[instructorssn,courseno,secno]] ]).

answer(K) :- schema(R),fds(G),candkey(R,G,K).

answer(R3NF) :- schema(R), fds(G), threenf(R,G,R3NF).

/*
?- ['exo7.pl'].
true.

?- answer(K).
K = [semester, year, dayshours, roomno] .

?- answer(R3NF).
R3NF = [semester, year, dayshours, roomno] 
*/
