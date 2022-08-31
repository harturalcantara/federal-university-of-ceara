module Aula4 where

--import Aula2 (myCc)

-- Vamos escrever as seguintes funcoes usando recursao por cauda:
--Tamanho de uma lista
myLength :: [a] -> Int
myLength xs = f xs 0 where
              f [] acc = acc
              f (x:xs) acc = f xs (acc + 1)





myCc :: [a] -> [a] -> [a]
myCc [] ys = ys
myCc (x : xs) ys = x : myCc xs ys



myConcat :: [[a]] -> [a]
myConcat xss = f xss [] where
			   f [] acc = acc
			   f (x : xss) acc = f (xss) (myCc acc x)




myReverse :: [a] -> [a]
myReverse xs = f xs [] where
			   f [] ys = ys
			   f (x : xs) ys = f xs (x : ys)

myReverseD :: [a] -> [a]
myReverseD xs = f xs [] where
			   f [] ys = ys
			   f (x : xs) ys = f xs ((x*x) : ys)

-- Agora, escreva funcoes que, dada uma lista de inteiros, retornam seu somatorio e produtorio, respectivamente:

mySum :: [Int] -> Int
mySum xs = f xs 0 where
		   f [] acc = acc
		   f (x : xs) acc = f xs (acc + x)

myProd :: [Int] -> Int
myProd xs = f xs 1 where
		    f [] acc = acc
		    f (x : xs) acc = f xs ( (acc) * (x) )



-- E uma funcao que, dada uma lista de inteiros, retorna a lista com o quadrado desses inteiros:

squares :: [Int] -> [Int]
squares [] = []
squares (x : xs) = (x*x) : squares xs




{-
Anotações

Recursao por cauda - não fica pedente alguma operação.
desaloca o frame atual, e proximo aponta pro atual o q ele tava apontando.
-}