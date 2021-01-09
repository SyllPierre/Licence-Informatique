module PremierContact where

-- Fonction sommeQ1, fait une somme des nombres de 1 à n
sommeQ1 :: (Num a, Enum a) => a -> a
sommeQ1 n = sum [1..n]

-- Exercice 3
sommeDeXaY :: (Num a, Ord a) => a->a->a
sommeDeXaY x y = if x>y then
	sommeDeXaY y x else if x<y then
		x + sommeDeXaY (x+1) y else x;

-- Exercice 4
sommeListe :: Num a => [a]->a
sommeListe [] = 0;
sommeListe (t:q) = t + sommeListe q;

-- Exercice 5
	--Last
myLast :: [t]->t
myLast t = head(reverse t);
	--Init
myInit :: [t]->[t]
myInit t = reverse (drop 1 (reverse t));

-- Exercice 6
	-- !!
recupValue :: (Num a,Ord a) => a->[t]->t
recupValue x (t:q) = if x>0 then
	(recupValue (x-1) q) else t;

	-- ++
concatList :: [t]->[t]->[t]
concatList [t] list = t : list;
concatList (t1:q1) list = t1 : (concatList q1 list);

	-- concat
concatLists :: [[t]]->[t]
concatLists [] = []
concatLists (t:q) = concatList t (concatLists q)

	-- map
myMap :: (a->b)->[a]->[b]
myMap f [] = []
myMap f (t:q) = f t : (myMap f q)

-- Exercice 7
-- On affecte à x le début de la fonction (!!) avec une liste
-- Par conséquent, x attends maintenant un second argument qui est un entier
-- pour exécuter la fonction (!!) et retourner l'élément du tableau souhaité

-- Exercice 8
longueurListe :: [t]->Int
longueurListe l = sommeListe (myMap (\x->1) l)

-- Exercice 9
uneFonction :: (Num a) => a->a
uneFonction x = x+1

exo9 :: (Num a) => (a->a)->a->Int->[a]
exo9 f x n = if n<=0 then [] else x : (exo9 f (f x) (n-1))

-- Exercice 10
consecutif :: Int->[Int]
consecutif n = exo9 succ 0 (n+1)

main :: IO ()
main = do
  print "Q1 - Result of sommeQ1 3 :"
  print (sommeQ1 3)
  print "-------"
  print "Q3 - Result of sommeDeXaY 1 3 :"
  print (sommeDeXaY 1 3)
  print "-------"
  print "Q4 - Result of sommeListe [1, 2, 3] :" 
  print (sommeListe [1, 2, 3])
  print "-------"
  print "Q5 - Result of myLast [4, 3, 2] :"
  print (myLast [4, 3, 2])
  print "-------"
  print "Q5 - Result of myInit [4, 3, 2] :"
  print (myInit [4, 3, 2])
  print "-------"
  print "Q6 - Result of (!!) recupValue [1, 42, 56, 3] :"
  print (recupValue 2 [1, 42, 56, 3])
  print "-------"
  print "Q6 - Result of (++) concatList [4, 2] [6, 7] :"
  print (concatList [4, 2] [6, 7])
  print "-------"
  print "Q6 - Result of (concat) concatLists [[1, 2], [3, 4], [5]] :"
  print (concatLists [[1, 2], [3, 4], [5]])
  print "-------"
  print "Q6 - Result of (map) myMap abs [-1, -10, 5, -8] :"
  print (myMap abs [-1, -10, 5, -8])
  print "-------"
  print "Q8 - Result of longueurListe ['a', 'd', 'd'] :"
  print (longueurListe ['a', 'd', 'd'])
  print "-------"
  print "Q9 - Result of exo9 uneFonction 1 6 :  "
  print (exo9 uneFonction 1 6)
  print "-------"
  print "Q10 - Result of consecutif 5 : "
  print (consecutif 5)
