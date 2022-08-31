module Aula2 where

factorial :: Int -> Int
factorial 0 = 1
factorial n = n * factorial (n - 1)

myLength :: [a] -> Int
myLength [] = 0
myLength (x : xs) = 1 + myLength xs

myNull :: [a] -> Bool
myNull [] = True
myNull (x : xs) = False

myHead :: [a] -> a
myHead [] = error "lista vazia nao tem cabeca"
myHead (x : xs) = x

-- Comentário

myTail :: [a] -> [a]
myTail [] = error "lista vazia nao tem calda"
myTail (x : xs) = xs

myLast :: [a] -> a
myLast [] = error "lista vazia nao tem um ultimo elemnto"
myLast (x : []) = x
myLast (x : xs) = myLast xs

myInit :: [a] -> [a]
myInit [] = error "lista vazia nao tem um ultimo elemento"
myInit (x : []) = []
myInit (x : xs) = x : myInit xs

myCc :: [a] -> [a] -> [a]
myCc [] ys = ys
myCc (x : xs) ys = x : myCc xs ys

myConcat :: [[a]] -> [a]
myConcat [] = []
myConcat (xs : xss) = myCc xs (myConcat xss)

myReverse :: [a] -> [a]
myReverse [] = []
myReverse xs =  auxiliar xs [] where
                auxiliar [] ys = ys
                auxiliar (x : xs) ys = auxiliar xs (x : ys)

myAnd :: [Bool] -> Bool
myAnd [] = True
myAnd (False : xs) = False
myAnd (True : xs) = myAnd xs

myOr :: [Bool] -> Bool
myOr [] = False
myOr (True : xs) = True
myOr (False : xs) = myOr xs

















