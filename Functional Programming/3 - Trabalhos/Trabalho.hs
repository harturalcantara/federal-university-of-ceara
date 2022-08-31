module Trabalho where

import Auxiliar (myZipWith,myTail,myTake,
                 myTakeWhile,myFilter,myMap,
                 myIf,myHead,myDiv,divAurea,
                 myIterate,myLast,mySubtrai,
                 myEpsilon)

------------------------------ 1 QUESTÃO -----------------------------





-- nao consegui criar uma funcao que conseguisse encontrar  derivada de f,
-- ou seja f' , por isso foi preciso passar um argumento a mais... 

metodoDeNewton :: (Ord a, Num a, Fractional a)  => (a -> a) -> (a -> a) -> a -> a
metodoDeNewton f f' x
              | f x < myEpsilon = x
              | otherwise = 
                metodoDeNewton f f' (x - (f x / f' x)) 


------------------------------ 2 QUESTÃO -----------------------------

------------------------------ LETRA A -------------------------------
-- fibonacci infinito ------------------------------------------------

fibonacci :: (Num a) => [a]
fibonacci = 0 : 1 : myZipWith (+) fibonacci (myTail fibonacci)

------------------------------ LETRA B -------------------------------
-- Lista infinita de todos os primos ---------------------------------

infinitosPrimos = 2 : (myFilter primo [3,5..])
  where
    primo n = all (/= 0) . myMap (n  `mod`) $ [2 .. raiz n]
    raiz = truncate . sqrt . fromIntegral
    
            -- Auxiliares para os primos infinitos ---
            
-- Lista todos os primos que sejam <= n ----
listaprimos n | n >= 2    = myTakeWhile (<= n) infinitosPrimos
              | otherwise = []
              
-- Lista os n primeiros primos -------------------
primeirosprimos n = myTake n infinitosPrimos
 
------------------------------ LETRA C --------------------------------
-- Lista infinita da proporção aurea ----------------------------------
aurea :: [Int] -> [Float]
aurea [] = []
aurea (x:xs) = divAurea y x : aurea xs where
                                        y = myHead xs

------------------------------ 3 QUESTÃO -----------------------------
--- ver arquivo Avl.hs

