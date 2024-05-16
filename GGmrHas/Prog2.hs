{- ##################################
   Name: Maxwell Mendenhall
   Date: 2/13/24
   Homework Assignment: 2
   ################################## -}

module Prog2 where
import Prelude

tripleNumber :: Integer -> Integer
tripleNumber x = if x <= 100 then x * 3 else x

twoSame :: Integer -> Integer -> Integer -> Bool
twoSame x y z = (x == y) || (y == z) || (x == z)

triangleArea :: Integer -> Integer -> Float
triangleArea x y = fromIntegral (x * y)/2

product' :: Integer -> Integer
product' n 
  | n == 1 = n
  | otherwise = n * product'(n - 1)

or' :: Bool -> Bool -> Bool
or' True _ = True
or' _ True = True
or' _ _ = False

integerSqrt :: Integer -> Integer
integerSqrt x = floor (sqrt (fromIntegral x))

exponent' :: Integer -> Integer -> Integer
exponent' b e
  | e == 1 = b
  | e == 0 = 1
  | otherwise = b * exponent' b (e - 1)

