module Main where

import Graphics.Gloss

main = animate (InWindow "Dragon" (500, 500) (0, 0)) white (dragonAnime (50,250) (450,250))

dragonAnime a b t = Line (dragon a b !! (round t `mod` 20))

pointAintercaler :: Point -> Point -> Point
pointAintercaler (x1, y1) (x2, y2) =  ((x1 + x2)/2 + (y2 - y1)/2, (y1 + y2)/2 +(x1 - x2)/2)

pasDragon :: Path -> Path
pasDragon [] = []
pasDragon [x] = [x]
pasDragon [x, y] = [x, pointAintercaler x y, y]
pasDragon (x:y:z:xs) = x : pointAintercaler x y : y : pointAintercaler z y : pasDragon (z:xs)

dragon :: Point -> Point -> [Path]
dragon a b  = iterate pasDragon [a,b]

dragonOrdre :: Point -> Point -> Int -> Path
dragonOrdre a c 0 = [a,c]
dragonOrdre a c 1 = pasDragon [a,c]
dragonOrdre a c n = dragonOrdre (pointAintercaler a c) c (n - 1) ++ dragonOrdre a c (n - 1)
