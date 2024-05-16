{- ##################################
   Name: Maxwell Mendenhall
   Date: 3/26/24
   Homework Assignment: 5
   ################################## -}

module Prog5 where

reverse' :: [a] -> [a]
reverse' [] = []
reverse' (x:xs) = reverse' xs ++ [x] -- ++ appends a list to another list, which in this case is the returning list

isPalindrome :: String -> Bool
isPalindrome x
  | x == reverse' x =True
  | otherwise = False

-- type TimeStamp = .. -- finish this type synonym definition
type TimeStamp = (Int, Int, Int)

isShorter :: TimeStamp -> TimeStamp -> Int
isShorter (h1,m1,s1) (h2,m2,s2)
  | totalSeconds (h1,m1,s1) < totalSeconds (h2,m2,s2) = 1
  | totalSeconds (h1,m1,s1) > totalSeconds (h2,m2,s2) = -1
  | otherwise = 0

totalSeconds :: TimeStamp -> Int
totalSeconds (h,m,s) = (h * 3600) + (m * 60) + s

isNegative :: TimeStamp -> Bool
isNegative (h,m,s)
  | h < 0 = False
  | m < 0 = False
  | s < 0 = False
  | otherwise = True

checkSeconds :: Int -> Bool
checkSeconds s
  | s > 59 = False
  | otherwise = True

checkMinutes :: Int -> Bool
checkMinutes m
  | m > 59 = False
  | otherwise = True

isValid :: TimeStamp -> Bool
isValid (h,m,s) = (isNegative (h,m,s)) && (checkSeconds s) && (checkMinutes m)

convertMilitary :: Int -> String
convertMilitary x
  | x < 10 = "0" ++ show x
  | otherwise = show x

time2Str :: TimeStamp -> String
time2Str (h,m,s) = (convertMilitary h) ++ ":" ++ (convertMilitary m) ++ ":" ++ (convertMilitary s)

-- type Date == .. -- finish this type synonym definition
type Date = (Int, Int, Int)

data Season = Winter | Spring | Summer | Fall
  deriving (Show, Eq)

monthLookup :: Int -> Int
monthLookup x
  | x >= 1 && x <= 31 = 1   -- January
  | x >= 32 && x <= 59 = 2  -- February
  | x >= 60 && x <= 90 = 3  -- March
  | x >= 91 && x <= 120 = 4 -- April
  | x >= 121 && x <= 151 = 5 -- May
  | x >= 152 && x <= 181 = 6 -- June
  | x >= 182 && x <= 212 = 7 -- July
  | x >= 213 && x <= 243 = 8 -- August
  | x >= 244 && x <= 273 = 9 -- September
  | x >= 274 && x <= 304 = 10 -- October
  | x >= 305 && x <= 334 = 11 -- November
  | x >= 335 && x <= 365 = 12 -- December
  | otherwise = error "Invalid day"


monthRange :: Int -> Int -> [Int]
monthRange x s = [(monthLookup x)..(monthLookup s)]

validDate :: Date -> Bool
validDate (month, day, _year) = case month of
    2 -> day >= 1 && day <= 28
    4 -> day >= 1 && day <= 30
    6 -> day >= 1 && day <= 30
    9 -> day >= 1 && day <= 30
    11 -> day >= 1 && day <= 30
    _ -> day >= 1 && day <= 31

season :: Date -> Season
season (month, _, _)
  | month `elem` [3, 4, 5] = Spring
  | month `elem` [6, 7, 8] = Summer
  | month `elem` [9, 10, 11] = Fall
  | otherwise = Winter
