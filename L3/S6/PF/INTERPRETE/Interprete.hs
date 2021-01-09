import Parser
import Data.Char
import Data.Maybe
import Data.Either
import Control.Monad (liftM, ap)
import System.IO

type Nom = String

type Environnement a = [(Nom, a)]


data Expression = Lam Nom Expression
                | App Expression Expression
                | Var Nom
                | Lit Litteral
                deriving (Show,Eq)

data Litteral = Entier Integer
              | Bool   Bool
              deriving (Show,Eq)



data ValeurA = VLitteralA Litteral
             | VFonctionA (ValeurA -> ValeurA)




-- Q1
espacesP :: Parser ()
espacesP = do _ <- many (car ' ')
              return ()

-- Q2
nomP :: Parser Nom
nomP = do xs <- some (carQuand (`elem` ['a'..'z']))
          espacesP
          return xs

-- Q3
varP :: Parser Expression
varP = do xs<-nomP
          return (Var xs)

-- Q4
applique :: [Expression] -> Expression
applique = foldl1 App

-- Q5-7-8b
exprP :: Parser Expression
exprP = varP <|> lambdaP <|> exprParentheseeP <|> nombreP <|> booleenP

exprsP :: Parser Expression
exprsP = do exps <- some exprP
            espacesP
            return (applique exps)

-- Q6
lambdaP :: Parser Expression
lambdaP = do _ <- ((car '\\') <|> (car 'λ'))
             espacesP
             x <- nomP
             espacesP
             _ <- chaine "->"
             espacesP
             e <- exprsP
             return (Lam x e)


-- Q8
exprParentheseeP :: Parser Expression
exprParentheseeP = do car '('
                      espacesP
                      e <- exprsP
                      espacesP
                      car ')'
                      espacesP
                      return e

-- Q9
nombreP :: Parser Expression
nombreP = do xs <- some (carQuand isDigit)
             espacesP
             return (Lit (Entier (read xs)))


-- Q10
booleenP :: Parser Expression
booleenP = do x <- chaine "True" <|> chaine "False"
              espacesP
              return (Lit (Bool (read x)))

-- Q11
expressionP :: Parser Expression
expressionP = do espacesP
                 exprsP

-- Q12
ras :: String -> Expression
ras xs = case runParser expressionP xs of
         Nothing   -> error "Erreur d’analyse syntaxique"
         Just(e, "") -> e
         otherwise -> error "Erreur d’analyse syntaxique. Chaine incomplète"

-- Interprète simple

-- Q13
-- Comme expliqué dans le sujet, haskell nous répond
-- "no instance for (Show (ValeurA -> ValeurA))" car il ne peut générer automatiquement le code
-- pour afficher des ValeurA.

-- Q14
instance Show ValeurA where
    show (VFonctionA _) = "λ"
                       -- ^ ou "VFonctionA _", ou "<fun>" ou toute
                       --   autre représentation des fonctions de
                       --   votre choix
    show (VLitteralA (Bool e)) = show e
    show (VLitteralA (Entier e)) = show e



-- Q15
interpreteA :: Environnement ValeurA -> Expression -> ValeurA
interpreteA _ (Lit e) = VLitteralA e
interpreteA es (Var n) = fromJust(lookup n es)
interpreteA es (Lam n e) = VFonctionA (\x -> interpreteA ((n, x):es) e)
interpreteA es (App e1 e2) = i (interpreteA es e2)
                            where i = case interpreteA es e1 of (VLitteralA _) -> error ""
                                                                (VFonctionA x) -> x


-- Q16
negA :: ValeurA
negA = VFonctionA (\(VLitteralA (Entier e)) -> VLitteralA (Entier (-e)))

-- Q17
addA :: ValeurA
addA = VFonctionA (\(VLitteralA (Entier e1)) -> VFonctionA (\(VLitteralA (Entier e2)) -> VLitteralA (Entier ((+) e1 e2))))
-- Q18

releveBinOpEntierA :: (Integer -> Integer -> Integer) -> ValeurA
releveBinOpEntierA op = VFonctionA (\(VLitteralA (Entier e1)) -> VFonctionA (\(VLitteralA (Entier e2)) -> VLitteralA (Entier (op e1 e2))))

envA :: Environnement ValeurA
envA = [ ("neg",   negA)
       , ("add",   releveBinOpEntierA (+))
       , ("soust", releveBinOpEntierA (-))
       , ("mult",  releveBinOpEntierA (*))
       , ("quot",  releveBinOpEntierA quot)
       , ("if", ifthenelseA) ]


getVLitteral :: ValeurA -> Litteral
getVLitteral (VLitteralA l) = l
getVLitteral _ = undefined

getBool :: Litteral -> Bool
getBool (Bool b) = b
getBool _ = undefined


-- Q19
ifthenelseA :: ValeurA
ifthenelseA = VFonctionA (\if_ -> VFonctionA
                             (\then_ -> VFonctionA
                                 (\else_ -> if getBool (getVLitteral if_)
                                            then then_
                                            else else_)
                                 )
                             )

-- Q21
data ValeurB = VLitteralB Litteral
             | VFonctionB (ValeurB -> ErrValB)

type MsgErreur = String
type ErrValB   = Either MsgErreur ValeurB


instance Show ValeurB where
    show (VFonctionB _) = "λ"
                       -- ^ ou "VFonctionA _", ou "<fun>" ou toute
                       --   autre représentation des fonctions de
                       --   votre choix
    show (VLitteralB (Bool e)) = show e
    show (VLitteralB (Entier e)) = show e



-- Q22
interpreteB :: Environnement ValeurB -> Expression -> ErrValB
interpreteB _ (Lit e) = Right (VLitteralB e)
interpreteB es (Var n) = maybe (Left ("La variable " ++ n ++ " n'est pas definie")) Right (lookup n es)
interpreteB es (Lam n e) = Right (VFonctionB (\x -> interpreteB ((n, x):es) e))
interpreteB es (App e1 e2) = case interpreteB es e1 of
                                err@(Left _)             -> err
                                (Right (VLitteralB l)) -> Left (show l ++ " n'est pas une fonction, application impossible")
                                (Right (VFonctionB f)) -> case interpreteB es e2 of
                                                            err'@(Left _) -> err'
                                                            (Right n)   -> f n


-- Q23
addB :: ValeurB
addB = VFonctionB (\x -> case x of
	                        (VLitteralB (Entier e1)) -> Right (VFonctionB (\x' -> case x' of
	                        	                                                  (VLitteralB (Entier e2)) -> Right (VLitteralB (Entier ((+) e1 e2)))
	                        	                                                  err' -> Left (show err' ++ " n'est pas un entier")))
	                        err -> Left (show err ++ " n'est pas un entier"))


-- Q24
quotB :: ValeurB
quotB = VFonctionB (\x -> case x of
	                        (VLitteralB (Entier e1)) -> Right (VFonctionB (\x' -> case x' of
	                        	                                                  (VLitteralB (Entier e2)) | e2 == 0 -> Left "Division par zero"
                                                                                                           | otherwise -> Right (VLitteralB (Entier (quot e1 e2)))
	                        	                                                  err' -> Left (show err' ++ " n'est pas un entier")))
	                        err -> Left (show err ++ " n'est pas un entier"))


-- Q25
data ValeurC = VLitteralC Litteral
             | VFonctionC (ValeurC -> OutValC)

type Trace   = String
type OutValC = (Trace, ValeurC)


instance Show ValeurC where
    show (VFonctionC _) = "λ"
                       -- ^ ou "VFonctionA _", ou "<fun>" ou toute
                       --   autre représentation des fonctions de
                       --   votre choix
    show (VLitteralC (Bool e)) = show e
    show (VLitteralC (Entier e)) = show e



-- Q26
interpreteC :: Environnement ValeurC -> Expression -> OutValC
interpreteC _ (Lit e) = ("", VLitteralC e)
interpreteC es (Var e)    = ("", fromJust (lookup e es))
interpreteC es (Lam n e)  = ("", VFonctionC (\x -> interpreteC ((n, x):es) e))

interpreteC es (App e e') = (fst ft ++ fst r, snd r)
                            where ft = case interpreteC es e of
                                       ("", VLitteralC _) -> undefined
                                       (t', VFonctionC f') -> (t' ++ ".", f')
                                  r = snd ft (snd (interpreteC es e'))


-- Q27
pingC :: ValeurC
pingC = VFonctionC (\e -> ("p", e))


-- Q28
data ValeurM m = VLitteralM Litteral
               | VFonctionM (ValeurM m -> m (ValeurM m))


instance Show (ValeurM m) where
    show (VFonctionM _) = "λ"
                       -- ^ ou "VFonctionA _", ou "<fun>" ou toute
                       --   autre représentation des fonctions de
                       --   votre choix
    show (VLitteralM (Bool e)) = show e
    show (VLitteralM (Entier e)) = show e


-- Q29
data SimpleM v = S v
               deriving Show

noCons :: SimpleM (ValeurM SimpleM) -> ValeurM SimpleM
noCons (S r) = r


interpreteSimpleM :: Environnement (ValeurM SimpleM) -> Expression -> SimpleM (ValeurM SimpleM)
interpreteSimpleM _ (Lit e) = S (VLitteralM e)
interpreteSimpleM es (Var n) = S (fromJust(lookup n es))
interpreteSimpleM es (Lam n e) = S (VFonctionM (\x -> interpreteSimpleM ((n, x):es) e))
interpreteSimpleM es (App e1 e2) = i (noCons (interpreteSimpleM es e2))
                            where i = case interpreteSimpleM es e1 of (S (VLitteralM _)) -> error ""
                                                                      (S (VFonctionM x)) -> x


-- Q30
instance Functor SimpleM where
    fmap = liftM

instance Applicative SimpleM where
    pure  = S
    (<*>) = ap

instance Monad SimpleM where
    (S v) >>= f = f v


-- Q31

getF :: ValeurM m -> ValeurM m -> m (ValeurM m)
getF (VFonctionM f) = f
getF _ = undefined

interpreteM :: Monad m => Environnement (ValeurM m) -> Expression -> m (ValeurM m)
interpreteM _ (Lit e) = pure (VLitteralM e)
interpreteM es (Var n) = pure (fromJust(lookup n es))
interpreteM es (Lam n e) = pure (VFonctionM (\x -> interpreteM ((n, x):es) e))
interpreteM es (App e1 e2) = do x <- interpreteM es e1
                                y <- interpreteM es e2
                                getF x y


-- Q32
type InterpreteM m = Environnement (ValeurM m) -> Expression -> m (ValeurM m)

interpreteS :: InterpreteM SimpleM
interpreteS = interpreteM

-- Q33
data TraceM v = T (Trace, v)
              deriving Show


instance Monad TraceM where
    return x = T ("", x)
    (T (t1, v1)) >>= f = T (t1 ++ t2, v2)
      where (T (t2, v2)) = f v1

-- Note GHC 7.10

instance Applicative TraceM where
    pure  = return
    (<*>) = ap

instance Functor TraceM where
    fmap  = liftM

interpreteMT :: InterpreteM TraceM
interpreteMT = interpreteM

pingM :: ValeurM TraceM
pingM = VFonctionM (\v -> T ("p", v))


-- Q34
interpreteMT' :: InterpreteM TraceM
interpreteMT' es (App e1 e2) = do x <- interpreteMT' es e1
                                  y <- interpreteMT' es e2
                                  z <- T (".", x)
                                  getF z y
interpreteMT' es e = interpreteMT es e




main :: IO ()
main = do putStr "minilang> "
          hFlush stdout
          xs <- getLine
          putStrLn ("Vous avez saisi :  << " ++ xs ++ " >>")
          main
