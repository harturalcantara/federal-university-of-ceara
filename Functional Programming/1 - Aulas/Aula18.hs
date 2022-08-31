module Main where

import Data.List

-- Questao 1
-- A funcao abaixo computa a soma dos elementos de uma lista.

mySum :: [Int] -> Int
mySum []     = 0
mySum (x:xs) = x + mySum xs

-- Implemente uma funcao mySum', usando foldl'
mySum' :: [Int] -> Int
mySum' = undefined

-- Agora, veja a seguinte funcao:

disjoin :: [a] -> ([a], [a])
disjoin []         = ([], [])
disjoin [x]        = ([x], [])
disjoin (x1:x2:xs) = (x1:ps, x2:qs) where
                     (ps, qs) = disjoin xs

-- Seria possível utilizar a funcao disjoin para, usando rpar, rseq e runEval,
-- criar uma funcao mySum2 que computa a soma de uma lista em paralelo, usando
-- dois núcleos? Ao escrever a funcao, vc pode computar a soma das sublistas
-- usando sum.

-- Compile Main.hs, com main = program1, com o seguinte comando:
-- ghc -O2 -threaded Aula18.hs

-- Isso vai gerar um executavel Aula18. Rode Main com os parâmetros:
-- timer ./Main +RTS -N1 (usando um nucleo)
-- timer ./Main +RTS -N2 (usando dois nucleos)

-- Dados os tempos computados acima, qual o speedup obtido?

-- Questao 2

-- Descubra quantos nucleos o seu processador tem.
-- Use o comando lscpu
-- Refaça a Questao 1, mas adapte disjoin para que vc possa distribuir trabalho
-- para todos os seus nucleos.
