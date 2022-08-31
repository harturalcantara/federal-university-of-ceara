module Trabalho1 where

--Nome: Francisco Hartur Lopes de Alcântara - CC - 2018.1

{-Funções auxiliares, eu poderia ter importado, mas em casos
de não ter o arquivo. -}

myZipWith :: (a -> b -> c) -> [a] -> [b] -> [c]
myZipWith f [] ys = []
myZipWith f xs [] = []
myZipWith f (x:xs) (y:ys) = f x y : myZipWith f xs ys

myIterate :: (a -> a) -> a -> [a]
myIterate f x = [x] ++ myIterate f (f x)

myTail :: [a] ->[a]
myTail [] = error "Lista vazia não tem cauda!"
myTail (x : xs) = xs


{- Questão 1 -}

--Ela vai deriva no ponto a minha função.
myDerivation :: (Fractional a) => (a -> a) -> a -> (a -> a)
myDerivation f h x = ((f(x + h) -  f(x)) /  h)

--Newton, ela irá faz uma lista inifinita de aplicações
myNewton :: (Fractional a) => (a -> a) -> a -> [a]
myNewton f x0 = xn : myIterate f xn where
                xn = x0 - ((f x0) / (myDerivation f 0.01 x0)) 
--creio que está funcionando (o.O)


{- Questão 02 -}

--Lista infinita de números Fibononacci.
myFibonacci :: [Float]
myFibonacci = 1 : 1 : myZipWith (+) myFibonacci (myTail myFibonacci)

--Lista infinita de número Primos.
myPrimes :: [Int]
myPrimes = sieve (2 : [3, 5..]) where
           sieve (p:xs) = p : sieve [x |x <- xs, x `mod` p > 0]

--Lista infinita da Proporção Aurea.
myProAurea :: (Fractional a) =>  [Float]
myProAurea = myZipWith (/) (myTail myFibonacci) myFibonacci
----------------------

