sommeDeXaY x y = if x > y then 0
                 else x+sommeDeXaY (x+1) y

sommeListe ns = sum ns

sommeListe3 [] = 0
sommeListe3(n:ns) = n + sommeListe3 ns


der ns = if (tail ns) == [] then (head ns)
         else der (tail ns)

ini(n:[]) = []
ini(n:ns) = n:ini(ns)


pointexcla ns i = if i == 0 then (head ns)
                  else pointexcla (tail ns) (i-1)

plusplus ns ns1 = if (tail ns) == 0 then ((last ns):ns1)
                  else plusplus (init ns) (ns1)
