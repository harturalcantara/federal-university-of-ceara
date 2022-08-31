module Auxiliar where

						-- Funcoes auxiliares --

-- myZipWith vai ser usado pelo fibbonaci --
myZipWith :: (a->b->c) -> [a]->[b]->[c]
myZipWith _f []     _bs    = []
myZipWith _f _as    []     = []
myZipWith f  (a:as) (b:bs) = f a b : myZipWith f as bs

-- myIf vai ser usado pela myTake --
myIf :: Bool -> a -> a -> a
myIf True x y = x
myIf False x y = y

-- myTail Tambem vai ser usado pelo fibonacci --
myTail :: [a] -> [a]
myTail [] = error "empty list"
myTail (x:xs) = xs

-- myTake vai ser usado pela funcao pra calcular primos infinitos --
myTake :: Int -> [a] -> [a]
myTake n [] = []
myTake n (x:xs) = myIf (n <= 0) ([])
                                (x : myTake (n - 1) xs)
                                
-- myTakeWhile vai ser usado pelos numeros primos --
myTakeWhile :: (a -> Bool) -> [a] -> [a]
myTakeWhile p [] = []
myTakeWhile p (x:xs) = myIf (p x) (x : myTakeWhile p xs) ([])

-- myFilter vai ser usado pelos numeros primos--
myFilter :: (a -> Bool) -> [a] -> [a]
myFilter p [] = []
myFilter p (x:xs) = myIf (p x) (x : myFilter p xs) (myFilter p xs)

-- myMap vai ser usado pelos numeros primos--
myMap :: (a -> b) -> [a] -> [b]
myMap f [] = []
myMap f (x:xs) = f x : myMap f xs

-- myHead --
myHead :: [Int] -> Int
myHead [] = 1
myHead (x:xs) = x

-- myDiv
myDiv :: Int -> Int -> Float
myDiv x y = ( a / b )
  where a = fromIntegral x :: Float
        b = fromIntegral y :: Float
 
-- Faz a divisao aurea
divAurea :: Int -> Int -> Float
divAurea 0 _ = 0.0
divAurea _ 0 = 0.0
divAurea a b = myDiv a b

-- myIterate 
myIterate :: (a -> a) -> a -> [a]
myIterate f x =  x : myIterate f (f x)

-- myLast
myLast :: [a] -> a
myLast [x] =  x
myLast (_:xs) =  myLast xs
myLast [] =  error "last"

-- mySubtrai
mySubtrai :: (Num a) => a -> a -> a
mySubtrai x y = y - x

-- myEpsilon
myEpsilon :: (Eq a, Fractional a) => a
myEpsilon = myLast . myMap (mySubtrai 1) . myTakeWhile (/= 1) 
          . myMap (+ 1) . myIterate(/2) $ 1
