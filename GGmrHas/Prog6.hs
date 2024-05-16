{- ##################################
   Name: Maxwell Mendenhall
   Date: 4/10/24
   Homework Assignment: 6
   ################################## -}

module Prog6 where

safeInit :: [Int] -> Maybe [Int]
safeInit [] = Nothing   
safeInit xs = Just (init xs) 

safeCount :: Int -> [Int] -> Maybe Int
safeCount y xs =  if xs == [] then Nothing else Just (continue y xs)
  where 
    continue :: Int -> [Int] -> Int
    continue y [] = 0
    continue y (x:xs) = if y == x then 1 + (continue y xs) else 0 + (continue y xs)
 

{----------}

data Set345 = NonEmptySet [Int]
            | EmptySet
      deriving Show

singletonOrEmpty :: Set345 -> Bool
singletonOrEmpty (EmptySet) = True
singletonOrEmpty (NonEmptySet xs) = if (length xs) == 1 then True else False    

member :: Int -> Set345 -> Bool
member y (EmptySet) = False
member y (NonEmptySet []) = False 
member y (NonEmptySet (x:xs)) = if y == x then True else (member y (NonEmptySet xs))

size :: Set345 -> Int
size (EmptySet) = 0
size (NonEmptySet []) = 0
size (NonEmptySet (x:xs)) = 1 + (size (NonEmptySet xs))

-- Inserts an integer into Set345
ins :: Int -> Set345 -> Set345
ins x EmptySet = NonEmptySet [x]  -- Inserting into an empty set
ins x (NonEmptySet xs)
  | x `elem` xs = NonEmptySet xs  -- If x is already in the set, return the set unmodified
  | otherwise = NonEmptySet (x : xs)  -- Otherwise, add x to the list

-- Function to convert Set345 to a list of Int
toList :: Set345 -> [Int]
toList (NonEmptySet xs) = xs
toList EmptySet = []

-- Function to convert a list of Int to Set345, removing duplicates
toSet345 :: [Int] -> Set345
toSet345 [] = EmptySet
toSet345 xs = NonEmptySet (removeDuplicates xs)

-- Function to remove duplicates from a list
removeDuplicates :: [Int] -> [Int]
removeDuplicates [] = []
removeDuplicates (x:xs)
  | x `elem` xs = removeDuplicates xs
  | otherwise = x : removeDuplicates xs

-- Union function for Set345
union' :: Set345 -> Set345 -> Set345
union' a b = toSet345 (removeDuplicates (toList a ++ toList b))

intersection' :: Set345 -> Set345 -> Set345
intersection' EmptySet _ = EmptySet  -- Intersection with an empty set is empty.
intersection' _ EmptySet = EmptySet
intersection' (NonEmptySet xs) (NonEmptySet ys) = NonEmptySet (filter (`elem` ys) xs)  -- Keep only elements present in both

{----------}
countLettersInString :: String -> Int
countLettersInString xs = length xs

countLetters :: IO [Int]
countLetters = do
  putStrLn "Enter the first string:"
  str1 <- getLine
  putStrLn "Enter the second string:"
  str2 <- getLine
  putStrLn "Enter the third string:"
  str3 <- getLine
  let counts = map countLettersInString [str1, str2, str3]
  return counts

or' :: Bool -> IO Bool
or' x = do
  putStrLn "Enter 'True' or 'False':"
  userInput <- getLine
  return (x || read userInput)
