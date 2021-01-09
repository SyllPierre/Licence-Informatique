schema([a,b,c,d,e,f,h]).

fds([ [[a],[c]], [[ac],[d]], [[e],[ad]],
      [[e],[h]] ]).

fds([ [[a],[cd]], [[e],[ah]], [[e],[ad]],
      [[e],[h]] ]).

answer(K) :- schema(R),fds(F), candkey(R,F,K).
