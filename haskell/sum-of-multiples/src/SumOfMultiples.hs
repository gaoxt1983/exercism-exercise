module SumOfMultiples (sumOfMultiples) where

import Data.List

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit = sum . nub . concat $ map (\x -> takeWhile (< limit) [x * y | y <- [1..]]) effectiveFactors
    where
        effectiveFactors = filter (/= 0) factors
