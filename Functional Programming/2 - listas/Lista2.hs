module Lista2 where


import Aula3 (myIf)

{- QUESTAO 1 - [Okay]-}

data SeqTree a = SEmpty | SLeaf a | SBranch Int Int (SeqTree a) (SeqTree a)

instance Functor SeqTree where
        fmap f SEmpty                = SEmpty
        fmap f (SLeaf x)             = SLeaf (f x)
        fmap f (SBranch s h lt rt) = SBranch s h (fmap f lt) (fmap f rt)



{- Questão 2  - [Okay] -}

numeber3a7b :: Int -> Maybe (Int, Int)
numeber3a7b n = complex n 0 0 where 
                complex n a b = myIf(n == (3*a + 7*b)) (Just (a,b))  
                                                       (myIf (3 * a > n) (complex n 0 (b + 1)) (myIf (7 * b > n) (Nothing) (complex n (a + 1) b)))

{- Questão 3 -  -} 

--ISSO DAQUI É BUSCA POR PROFUNDIDADE COMO UMA BUSCA NORMAL, OU SEJA, A BUSCA ESQ|RAIZ|DIR
inOrderWalk :: BSTree k v -> [(k, v)]
inOrderWalk Empty = []
inOrderWalk (Branch (k, v) Empty rb) = (k, v) : inOrderWalk (rb)
inOrderWalk (Branch (k, v) lb Empty) = inOrderWalk (lb) ++ [(k, v)]
inOrderWalk (Branch (k, v) lb rb) = inOrderWalk (lb) ++ [(k, v)] ++ inOrderWalk (rb)



{- Questão 4 -  -} 



data BSTree k v = Empty | Branch (k, v) (BSTree k v) (BSTree k v)
--ISSSO DAQUI E POR LARGURA, OU SEJA, E POR NIVEL RAIZ, RAIZ-ESQ, RAIZ-DIR... POR NIVELL!!!!
breadthWalk :: BSTree k v -> [(k,v)]
breadthWalk tree = walk tree [] where
                   walk Empty [] = []
                   walk Empty (tree:trees) = walk tree trees
                   walk (Branch (key, val) lt rt) [] = (,) key val : walk lt [rt]
                   walk (Branch (key, val) lt rt) (tree:trees) = (,) key val : walk tree (trees ++ [lt, rt])

--isso aqui foi para compara com a brearWalk
preOrderWalk :: BSTree k v -> [(k, v)] --RAIZ|ESQUERDA|DIREITA
preOrderWalk Empty = []
preOrderWalk (Branch (k, v) Empty rb) = (k, v) : preOrderWalk (rb)
preOrderWalk (Branch (k, v) lb Empty) = [(k, v)] ++ preOrderWalk (lb)
preOrderWalk (Branch (k, v) lb rb) =  [(k, v)] ++ preOrderWalk (lb) ++ preOrderWalk (rb)

{- Questao 5 - Okay -}
primeFactors :: Int -> [Int]
primeFactors x = dcp x primes where
              dcp 1 ps = []
              dcp x ps = q : dcp (x `div` q) qs where
                         qs = dropWhile (not . divides x) ps
                         q  = head qs
                         divides a = (== 0) . (mod a)

primes :: [Int]
primes = sieve $ 2 : odds where
         odds         = iterate (+2) 3
         sieve []     = []
         sieve (x : xs) = x : filter ((>0) . (`mod` x)) (sieve xs)


--outro metodo
primesFactors :: Int -> [Int]
primesFactors n = 
    case factors of
        [] -> [n]
        _ -> factors ++ primesFactors (n `div` (head factors)) 
        where factors = take 1 $ filter(\x -> (n `mod` x)==0) [2..n-1]




{-QUESTAO 6 Okay-}

cents = [100, 50, 25, 10, 5]

moedas :: Int -> [Int]
moedas n = myIf ((mod n 5) == 0) (coins n cents) ([]) where
    coins n []  = []
    coins 0 l   = []
    coins 5 l   = [5]
    coins 10 l  = [10]
    coins 25 l  = [25]
    coins 50 l  = [50]
    coins 100 l = [100]
    coins n l@(x : xs) = myIf (n >= x) (x : coins (n - x) l) (coins n xs)