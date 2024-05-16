{- ##################################
   Name: Maxwell Mendenhall
   Date: 3/19/24
   Homework Assignment: 4
   ################################## -}

module Prog4 where

sumLastPart :: Int -> [Int] -> Int
sumLastPart x xs = sum $ drop ((length xs) - x) xs

middleProduct :: [Int] -> Int
middleProduct xs
  | length xs < 2 = 0
  | otherwise = product (init (drop 1 xs))

init' :: [Int] -> [Int]
init' xs = take ((length xs) - 1) xs

tripleAll :: [Int] -> [(Int, Int)]
tripleAll [] = []                             -- Base case
tripleAll (x:xs) = (x, x * 3) : tripleAll xs  -- Recursive case
-- (x:xs) this is a way of decontructing a list into pattern matching VERY USEFUL
-- x acts as current element in xs

flip' :: [(Int, Int)] -> [(Int, Int)]
flip' [] = []
flip' ((x,s):xs) = (s,x) : flip' xs

myLength :: [a] -> Int
myLength [] = 0 -- BC, If list is empty return 0
myLength (_:xs) = 1 + myLength xs  -- RC, If list is not emtpy add 1 and move forward 1 element

sumLastPart' :: Int -> [Int] -> Int
sumLastPart' x xs = sumLastPart'' (myLength xs - x) xs
  where
    sumLastPart'' :: Int -> [Int] -> Int
    sumLastPart'' _ [] = 0
    sumLastPart'' n (s:ys)
      | n <= 0 = s + sumLastPart'' n ys
      | otherwise = sumLastPart'' (n - 1) ys


myDrop :: Int -> [Int] -> [Int]
myDrop n xs -- BC, if n is less < or = 0 return the new list
  | n <= 0 = xs
myDrop _ [] = []  -- BC, list is empty return empty list
myDrop n (_:xs) = myDrop (n-1) xs  -- RC, keep subtract 1 from n for each element until n <= 0

middleProduct' :: [Int] -> Int
middleProduct' xs = middleProduct'' (init'' (myDrop 1 xs))
  where
    middleProduct'' :: [Int] -> Int
    middleProduct'' [] = 1 -- BC, return 1 when list is empty
    middleProduct'' (x:xs) = x * middleProduct'' xs -- RC, multiply the current index with the returned index

init'' :: [Int] -> [Int]
init'' [] = [] --BC, If list is empty return empty list
init'' [x] = [] -- BC, If 1 element resides in list, return empty list
init'' (x:xs) = x : init'' xs -- RC, created a new list by appending the returned list

iSort' :: [(String, Int)] -> [(String, Int)]
iSort' [] = []
iSort' ((x,s):xs) = insert (x,s) (iSort' xs)
  where
    insert :: (String, Int) -> [(String, Int)] -> [(String, Int)]
    insert (x,s) [] = [(x,s)]
    insert (x,s) ((y,n):yn)
      | s <= n = (x,s):((y,n):yn)
      | otherwise = (y,n):(insert (x,s) yn)
