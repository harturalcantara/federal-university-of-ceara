module Main where

import Aula2 (myReverse)
import Aula3 (myIf)
import Aula5 (myDropWhile)


-- Escreva a funcao enumerate.

enumerate :: [a] -> [(Int, a)]
enumerate [] = []
enumerate (xs) = aux 1 xs where
                 aux acc [] = []
                 aux acc (x:xs) = (acc , x) : aux (1+acc) xs

-- Escrea uma função que determina se uma lista é um palíndromo.

palindrome :: (Eq a) => [a] -> Bool
palindrome [] = True
palindrome xs = aux xs (myReverse xs) where
				  aux [] [] = True
				  aux (q:qs) (y:ys) = myIf (q == y) (aux qs ys) (False)


-- Escreva uma função que elimina elementos duplicados consecutivos de uma lista
-- Ex: removeDuplicates [1,2,2,3,3,3,4,5,5] == [1,2,3,4,5]

removeDuplicates :: Eq a => [a] -> [a]
removeDuplicates [] = []
removeDuplicates (x:xs) = x : removeDuplicates (myDropWhile (==x) xs)

main :: IO ()
main = program1

--Troquei o nome main por programa3
programa3 :: IO ()
programa3 =  readFile "texto.txt" >>=
        pure . words >>=
        print

program1 :: IO ()
program1 =  readFile "texto.txt" >>=
            pure . removeDuplicates . words >>=
            print

-- Escreva um programa que determina se o conteúdo de texto.txt é um palíndromo.
program2 :: IO ()
program2 = readFile "texto.txt" >>=
            pure . palindrome . words >>=
            print


{-
Anotações

words :: String -> [String]
readFile

-}