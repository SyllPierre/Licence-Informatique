schema([a,b,c,d,e,f,g,h,i,j]).

fds1([ [[a,b],[c]],[[a],[d,e]],[[b],[f]],[[f],[g,h]],[[d],[i,j]] ]).

fds2([ [[a,b],[c]],[[b,d],[e,f]],[[b],[f]],[[f],[g,h]],[[d],[i,j]] ]).

answer(D1) :- schema(R),fds1(F),bcnf(R,F,D1).

answer(D2) :- schema(R),fds2(G),bcnf(R,G,D2).

/*?- ['exo11.pl'].
true.

?- answer(D1).
Scheme to decompose = [a,b,c,d,e,f,g,h,i,j] Offending FD: [a]-->[d,e,i,j]
Scheme to decompose = [a,b,c,f,g,h] Offending FD: [a,c,f]-->[g,h]
Scheme to decompose = [a,b,c,f] Offending FD: [b]-->[f]
Final Result is: 
[a,b,c]
[a,d,e,i,j]
[a,c,f,g,h]
[b,f]

D1 = [[a, b, c], [a, d, e, i, j], [a, c, f, g, h], [b, f]] .

?- answer(D2).
Scheme to decompose = [a,b,c,d,e,f,g,h,i,j] Offending FD: [a]-->[d,e,i,j]
Scheme to decompose = [a,b,c,f,g,h] Offending FD: [a,c,f]-->[g,h]
Scheme to decompose = [a,b,c,f] Offending FD: [b]-->[f]
Final Result is: 
[a,b,c]
[a,d,e,i,j]
[a,c,f,g,h]
[b,f]

D2 = [[a, b, c], [a, d, e, i, j], [a, c, f, g, h], [b, f]] .
*/
