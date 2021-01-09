module LSysteme where

type Symbole  = Char
type Mot      = [Symbole]
type Axiome   = Mot
type Regles   = Symbole -> Mot
type LSysteme = [Mot]


-- Question 1

motSuivant :: Regles -> Mot -> Mot
motSuivant _ [] = []
motSuivant r (x:xs) = r x ++ motSuivant r xs

motSuivant' :: Regles -> Mot -> Mot
motSuivant' r m = concat [r x | x <- m]

motSuivant'' :: Regles -> Mot -> Mot
motSuivant'' = concatMap -- concat (map r m)

-- Question 2

regle :: Axiome
regle = "F"

regle' :: Axiome
regle' = "F-F++F-F"

regle'' :: Axiome
regle'' = "F-F++F-F-F-F++F-F++F-F++F-F-F-F++F-F"

vonKoch :: Symbole -> Mot
vonKoch '+' = "+"
vonKoch '-' = "-"
vonKoch 'F' = regle'
vonKoch _ = fail ""

--Question 3
lsysteme :: Axiome -> Regles -> LSysteme
lsysteme a r = iterate (motSuivant r) a
