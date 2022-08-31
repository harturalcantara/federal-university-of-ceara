module Main where

import Control.Parallel
import Control.Parallel.Strategies

data Matrix a = M Int [[a]] | Empty deriving (Show)
data Lines a = L Int [a] | Null deriving (Show)

    
main :: IO()
main = print x



x = multiplyAB'' mA' mB'

m1 = M 4 [[1,2,1,2],[1,3,4,2],[5,1,3,2],[4,6,1,3]]
m2 = M 4 [[2,1,1,1],[4,2,3,4],[5,1,3,5],[7,1,1,6]]

--mA' = createM 100 [1..10000]
--mB' = createM 100 [10001..20000]

--mA' = createM 150 [1..22500]
--mB' = createM 150 [22501..45000]

--mA' = createM 200 [1..40000]
--mB' = createM 200 [40001..80000]

mA' = createM 250 [1..62500]
mB' = createM 250 [62501..125000]


m = createM 3 [1..9]

--essa função gera uma matriz de ordem N, ex: generateM 4 [1..16],= 4*4 = 16,  precisa passar cada componente da matriz lista
generateM :: (Num a) => Int -> [a]-> [[a]]
generateM _ [] = []
generateM n l@(x:xs) = newMatrix where
                       newMatrix = par a (pseq b (a : b)) where
                       a = take n l
                       b = generateM n (drop n l)
                         

createM :: (Num a) => Int -> [a] -> Matrix a
createM 0 _ = Empty
createM n yss = M n tss where
                tss = generateM n yss

getOrder :: Matrix a -> Int
getOrder Empty = 0
getOrder (M n _) = n


--função que multiplica uma linha inteira por cada uma das colunas da matriz B
multiplyM :: (Num a) => [a] -> Matrix a -> Int -> [a] 
multiplyM [] _ _= [] 
multiplyM xs m@(M n l@(y:yss)) i = runEval comp where
                          comp = rpar (multiplyM' xs l i) >>= \n ->
                           pure $ n where
                          multiplyM' [] _ _ = []
                          multiplyM' xs' p@(t:tss) i = if (i <= n) then (prod') else [] where
                           prod' = par a (pseq b (a : b)) where
                            a = prodLine' xs' (separate' p i) 
                           b = multiplyM' xs' p (i + 1)
                          
--(prodLine' xs' (separate' p i)) : multiplyM' xs' p (i + 1)             
                                              
--essa função é basicamente uma produto de dois vetores u e v, só abstrair a linha e coluna como vetores

prodLine' :: Num a => [a] -> [a] -> a
prodLine' [] [] = 0 
prodLine' v@(x:xs) u@(y:ys) = prod where
                              prod = par a (pseq b (a + b)) where
                              a = x * y 
                              b = prodLine' xs ys 
                                              
                 
--função que varre uma linha inteira ou coluna por indice,  ou seja M = [[1,2],[3,4]] para i = 1 = [1,3]

separate' :: Num a => [[a]] -> Int -> [a] 
separate' [] _= [] 
separate' (x:xs) i = result where
                  result = par a (pseq b (a : b)) where
                  a = (x !! (i-1))
                  b = separate' xs i


multiplyAB'' :: (Num a) => Matrix a -> Matrix a -> Matrix a
multiplyAB'' mA mB = runEval computation where
             computation = rpar (multiplyAB xs mB) >>= \x ->
                           rpar (multiplyAB ts mB) >>= \y ->
                           pure $ (joinMatrix x y) where
                           (xs,ts) = halfMatrix ((getOrder mA)^2 `div` 2) mA
                          
                           
joinMatrix :: Matrix a -> Matrix a -> Matrix a
joinMatrix Empty xss = xss
joinMatrix yss Empty = yss
joinMatrix (M n xss) (M n' yss) = M n (xss++yss)
                          
--função usada para dar um Split na matriz  
halfMatrix :: Int -> Matrix a -> (Matrix a, Matrix a)
halfMatrix _ Empty = (Empty,Empty)
halfMatrix n (M n' yss) = (M n tss, M (n' - n) pss) where
                          (tss,pss) = mySplitAt n yss

mySplitAt :: Int -> [a] -> ([a],[a])
mySplitAt n [] = ([],[])
mySplitAt n l@(x:xs) = if (n > 0) then (x : ms, ns) else ([], l) where
                       (ms,ns) = mySplitAt (n - 1) xs 
                        
      
--essa função gera uma matriz de ordem N, ex: generateM 4 [1..16],= 4*4 = 16,  precisa passar cada componente da matriz lista

multiplyAB :: (Num a) => Matrix a -> Matrix a -> Matrix a
multiplyAB Empty qss = Empty 
multiplyAB pss qss = runEval prod' where     
                             prod' = rpar (multiplyAB' nss qss) >>= \x ->
                                     rpar (multiplyAB' yss qss) >>= \y ->
                                     pure $ (joinMatrix x y) where
                                     (nss,yss) = halfMatrix ((getOrder pss)^2 `div` 2) pss where
                                     multiplyAB' Empty qss = Empty
                                     multiplyAB' t@(M k wss) rss = if (True) 
                                     then (M k (multiplyAB'' wss rss))
                                     else error "number of rows is different from number of row!"  where
                                     multiplyAB'' [] qss = []
                                     multiplyAB'' (y:yss) qss = m : multiplyAB'' yss qss where 
                                      m = multiplyM y (qss) 1
                                     
                                 
