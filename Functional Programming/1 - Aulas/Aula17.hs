module Main where

import Control.Parallel
import Control.Parallel.Strategies

x :: Int
x = runEval computation where
  computation = rpar (sum [1..10000000000]) >>= \x1 ->
                rpar (sum [2..10000000001]) >>= \x2 ->
                rpar (sum [3..10000000002]) >>= \x3 ->
                rpar (sum [4..10000000003]) >>= \x4 ->
                pure $ x1 + x2 + x3 + x4

main :: IO ()
main = putStrLn $ show x
