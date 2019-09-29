module LeapYear (isLeapYear) where

isLeapYear :: Integer -> Bool
isLeapYear year 
    | isDivisible year 400 = True
    | isDivisible year 100 = False
    | isDivisible year 4   = True
    | otherwise = False
    where
        isDivisible x y = x `mod` y == 0
