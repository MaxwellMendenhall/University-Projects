{- ##################################
   Name: Maxwell Mendenhall
   Date: 4/25/24
   Homework Assignment: 7
   ################################## -}

module Prog7 where

countOccurrences :: Eq a => [a] -> [(a, Int)]
countOccurrences [] = []
countOccurrences (x:xs) = updateCount x (countOccurrences xs)
  where
    updateCount x [] = [(x, 1)]
    updateCount x ((y, cnt):ys)
      | x == y    = (y, cnt + 1) : ys
      | otherwise = (y, cnt) : updateCount x ys

unique :: Eq a => [a] -> [a]
unique xs = reverse [x | (x, count) <- countOccurrences xs, count == 1]

isVowel :: Char -> Bool
isVowel c = c `elem` "aeiouAEIOU"

getBeforeVowel :: String -> String
getBeforeVowel [] = []
getBeforeVowel (x:xs) = if isVowel x then [] else x : getBeforeVowel xs

getAfterVowel :: String -> String
getAfterVowel [] = []
getAfterVowel (x:xs) = if isVowel x then x : xs else getAfterVowel xs

checkFirst :: String -> Bool
checkFirst (x:xs) = if isVowel x then True else False

piglatinize :: String -> String
piglatinize xs = if checkFirst xs then xs ++ "yay" else (getAfterVowel xs ++ getBeforeVowel xs ++ "ay")

data Expr = Val Int
          | Add Expr Expr
          | Sub Expr Expr
          | Mul Expr Expr
          | Div Expr Expr
          | Mod Expr Expr

value1 :: Expr -> Int
value1 (Val n)       = n
value1 (Add e1 e2)   = value1 e1 + value1 e2
value1 (Sub e1 e2)   = value1 e1 - value1 e2
value1 (Mul e1 e2)   = value1 e1 * value1 e2
value1 (Div e1 e2)   = value1 e1 `div` value1 e2
value1 (Mod e1 e2)   = value1 e1 `mod` value1 e2

value2 :: Expr -> Maybe Int
value2 (Val n)       = Just n
value2 (Add e1 e2)   = case (value2 e1, value2 e2) of
                          (Just n1, Just n2) -> Just (n1 + n2)
                          _ -> Nothing
value2 (Sub e1 e2)   = case (value2 e1, value2 e2) of
                          (Just n1, Just n2) -> Just (n1 - n2)
                          _ -> Nothing
value2 (Mul e1 e2)   = case (value2 e1, value2 e2) of
                          (Just n1, Just n2) -> Just (n1 * n2)
                          _ -> Nothing
value2 (Div e1 e2)   = case (value2 e1, value2 e2) of
                          (Just n1, Just 0)  -> Nothing  -- Avoid division by zero
                          (Just n1, Just n2) -> Just (n1 `div` n2)
                          _ -> Nothing
value2 (Mod e1 e2)   = case (value2 e1, value2 e2) of
                          (Just n1, Just 0)  -> Nothing  -- Avoid modulo by zero
                          (Just n1, Just n2) -> Just (n1 `mod` n2)
                          _ -> Nothing

isNegative :: Int -> Bool
isNegative x = x < 0

square :: Int -> Int
square x = x * x

-- Higher order functions are functions that take in other functions as a param
-- map : applies the provided function to every element in a list
-- -> map :: (a -> b) -> [a] -> [b]
-- filter : takes a bool function and applies it every element in the list
-- -> filter :: (a -> Bool) -> [a] -> [a]
-- foldr : reduces a list to a single value by recursively applying a function
-- -> foldr :: (a -> b -> b) -> b -> [a] -> b
sumSqNeg :: [Int] -> Int
sumSqNeg x = sum (map square (filter isNegative x))

isEqual :: Eq a => a -> [a] -> Bool
isEqual x xs = elem x xs

containing :: Eq a => [a] -> [a] -> Bool
containing [] _ = True
containing (x:xs) ys = if (isEqual x ys) then (containing xs ys) else False

total :: (Int -> Int) -> [Int] -> Int
total f xs = sum (map f xs)

containing' :: Eq a => [a] -> [a] -> Bool
containing' xs ys = foldr (&&) True (map (`elem` ys) xs)

countChar :: String -> Int
countChar [] = 0
countChar (x:xs) = 1 + (countChar xs)

lengths :: [String] -> [Int]
lengths xs = map countChar xs