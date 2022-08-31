module Main where


data Matrix a = M Int [[a]] | Empty deriving (Show)
data Lines a = L Int [a] | Null deriving (Show)


main :: IO()
main = putStrLn $ show x


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


--essa função gera uma matriz de ordem N, ex: generateM 4 [1..16],= 4*4 = 16,  precisa passar cada componente da matriz lista
generateM :: (Num a) => Int -> [a]-> [[a]]
generateM _ [] = []
generateM n l@(x:xs) = take n l: generateM n (drop n l)

createM :: (Num a) => Int -> [a] -> Matrix a
createM 0 _ = Empty
createM n yss = M n tss where
                tss = generateM n yss


m = createM 3 [1..9]

getOrder :: Matrix a -> Int
getOrder Empty = 0
getOrder (M n _) = n


--função que multiplica uma linha inteira por cada uma das colunas da matriz B
multiplyM :: (Num a) => [a] -> Matrix a -> Int -> [a] 
multiplyM [] _ _= [] 
multiplyM xs m@(M n (y:yss)) i = multiplyM' xs (y:yss) i where
                         multiplyM' [] _ _ = []
                         multiplyM' xs' (t:tss) i = if (i <= n) 
                         then ((prodLine' xs' (separate' (t:tss) i)) : multiplyM' xs' (t:tss) (i + 1)) 
                         else [] 
                          
              
                                              
--essa função é basicamente uma produto de dois vetores u e v, só abstrair a linha e coluna como vetores
prodLine :: (Num a) => Lines a -> Lines a -> a 
prodLine  Null Null = 0 
prodLine (L n (x:xs)) (L p (y:ys)) = if (n == p) 
                         then (x * y + prodLine' xs ys) 
                         else 0 where 
                         prodLine' [] [] = 0
                         prodLine' (x:xs) (y:ys) = x * y + prodLine' xs ys

prodLine' :: Num a => [a] -> [a] -> a
prodLine' [] [] = 0 
prodLine' v@(x:xs) u@(y:ys) = x * y + prodLine' xs ys 
                                              
                 
--função que varre uma linha inteira ou coluna por indice,  ou seja M = [[1,2],[3,4]] para i = 1 = [1,3]
separate :: (Num a) => Matrix a -> Int -> [a] 
separate Empty _ = [] 
separate (M n (x:xs)) i = (x !! (i-1)) : separate' xs i where
                          separate' [] _ = []
                          separate' (x:xs) n = (x !! (i-1)) : separate' xs i


separate' :: Num a => [[a]] -> Int -> [a] 
separate' [] _= [] 
separate' (x:xs) i = (x !! (i-1)): separate' xs i


x = multiplyAB mA' mB'


multiplyAB ::(Num a) => Matrix a -> Matrix a -> Matrix a
multiplyAB Empty qss = Empty 
multiplyAB (M n pss) qss =  if (n == getOrder qss) 
                                  then (M n (multiplyAB' pss qss))
                                  else error "number of rows is different from number of row!"  where 
                                  multiplyAB' [] qss = []
                                  multiplyAB' (p:pss) qss = m : multiplyAB' pss qss where 
                                   m = multiplyM p (qss) 1
