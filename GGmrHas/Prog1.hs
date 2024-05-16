{- ##################################
   Name: Maxwell Mendenhall
   Date: 2/2/24
   Homework Assignment: 1
    if fromIntegral x > averageThree x y z then (if fromIntegral y > averageThree x y z then (if fromIntegral z > averageThree x y z then (3) else 2) else 1) else (0)
   ################################## -}

module Prog1 where


isThreeDigitPositive :: Int -> Bool
isThreeDigitPositive x = (x >= 100) && (x < 1000)


dividesEvenly :: Integer -> Integer -> Bool
dividesEvenly x y = (x `div` y) * y == x


middle :: Integer -> Integer -> Integer -> Integer
middle x y z
  | (x >= y && y >= z) || (z >= y && y >= x) = y
  | (y >= x && x >= z) || (z >= x && x >= y) = x
  | otherwise = z


nor :: Bool -> Bool -> Bool
nor a b = not (a || b)


f2c :: Float -> Float
f2c x = (x-32)*(5/9)


floorDecimal :: Float -> Float
floorDecimal x = fromIntegral (floor x)


letterGrade :: Integer -> String
letterGrade x
  | x >= 93 = "A"
  | x >= 90 && x <= 92 = "A-"
  | x >= 87 && x <= 89 = "B+"
  | x >= 83 && x <= 86 = "B"
  | x >= 80 && x <= 82 = "B-"
  | x >= 77 && x <= 79 = "C+"
  | x >= 73 && x <= 76 = "C"
  | x >= 70 && x <= 72 = "C-"
  | x >= 67 && x <= 69 = "D+"
  | x >= 63 && x <= 66 = "D"
  | x >= 60 && x <= 22 = "D-"
  | x <= 59 = "F"


averageThree :: Integer -> Integer -> Integer -> Float
averageThree x y z = fromIntegral(x + y + z)/3


howManyAboveAverage :: Integer -> Integer -> Integer -> Integer
howManyAboveAverage x y z = 
  if fromIntegral x > averageThree x y z 
  then (if fromIntegral y > averageThree x y z 
    then (if fromIntegral z > averageThree x y z then 3 else 2) 
    else (if fromIntegral z > averageThree x y z then 2 else 1)) 
  else (if fromIntegral y > averageThree x y z 
    then (if fromIntegral z > averageThree x y z then 2 else 1) 
    else (if fromIntegral z > averageThree x y z then 1 else 0))
