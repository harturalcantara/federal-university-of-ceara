module Main where


import Control.Parallel
import Control.Parallel.Strategies

myParPair :: Strategy (a, b)
myParPair (x, y) = rpar x >>= \x' ->
                 rpar y >>= \y' ->
                 pure $ (x', y')


xy :: (Double, Double)
xy = runEval $ myParPair xy' where
     xy' = (sum [1.0,2.0..1000000000.0], sum[1.1,2.1..1000000000.1])

with :: a -> Strategy a -> a
x `with` st = runEval $ st x

myEvalPair :: Strategy a -> Strategy b -> Strategy (a,b)
myEvalPair sta stb (x,y) = sta x >>= \x' ->
                           stb y >>= \y' ->
                           pure $ (x', y')

main :: IO ()
main = print a' where
   a = (sum [1.0,2.0..100000000.0], sum[1.1,2.1..100000000.1])
   a' = a `with` myParPair