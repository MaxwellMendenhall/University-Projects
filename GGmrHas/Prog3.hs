{- ##################################
   Name:
   Date:
   Homework Assignment:
   ################################## -}

module Prog3 where
import Data.Char (ord)

swap :: (Char, Char, Char, Char, Char) -> (Char, Char, Char, Char, Char)
swap (a, b, c, d, e) = (e, d, c, b, a)

negateTwoDigits :: [Integer] -> [Integer]
negateTwoDigits xs = [if x > 9 || x < -9 then negate x else x | x <- xs]

matches :: Integer -> [Integer] -> [Integer]
matches x xs = [a | a <- xs, a == x]

element :: Integer -> [Integer] -> Bool
element x xs = if matches x xs == [] then False else True

absAll :: [Int] -> [(Int, Int, Bool)]
absAll xs = [(x, abs x, even x) | x <- xs]

flip' :: [(Int, Int)] -> [(Int, Int)]
flip' xs = [(s, x) | (x, s) <- xs]

maxOfThree :: (Int, Int, Int) -> Int
maxOfThree (x, y, z)
  | x >= y && x >= z = x
  | y >= x && y >= z = y
  | z >= x && z >= y = z

middleOfThree :: (Int, Int, Int) -> Int
middleOfThree (x, y, z)
  | x >= y && x <= z || x <= y && x >= z = x
  | y >= x && y <= z || y <= x && y >= z = y
  | z >= x && z <= y || z <= x && x >= y = z

minOfThree :: (Int, Int, Int) -> Int
minOfThree (x, y, z)
  | x <= y && x <= z = x
  | y <= x && y <= z = y
  | z <= x && z <= y = z

orderTriple :: (Int, Int, Int) -> (Int, Int, Int)
orderTriple (x, y, z) = (maxOfThree (x, y, z), middleOfThree (x, y, z), minOfThree (x, y, z))

asciiNums :: String -> [Int]
asciiNums x = map ord x

triads :: Int -> [(Int,Int,Int)]
triads n = [(x, y, z) | x <- [1..n], y <- [1..n], z <- [1..n], x^2 + y^2 == z^2, x <= y]
