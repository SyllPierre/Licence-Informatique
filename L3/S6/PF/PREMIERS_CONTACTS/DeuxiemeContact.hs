module DeuxiemeContact where

-- Échauffement

-- Exercice 1
alterne :: [a] -> [a]
alterne [] = []
alterne [x] = [x]
alterne (x:xs:xss) = x:alterne xss

-- Exercice 2
combine :: (a -> b -> c) -> [a] -> [b] -> [c]
combine f [] x = []
combine f x [] = []
combine f (x:xs) (y:ys) = f x y:combine f xs ys

-- Triangle de Pascal
pasPascal :: [Integer] -> [Integer]
pasPascal x = zipWith (+) (x ++ (0:[])) (0:x)

pasPascal2 :: [Integer] -> [Integer]
pasPascal2 [1] = [1,1]
pasPascal2 (x:xs) = [1] ++ zipWith (+) (x:xs) xs ++ [1]

pascal :: [[Integer]]
pascal = take 10 (iterate(pasPascal) [1])
