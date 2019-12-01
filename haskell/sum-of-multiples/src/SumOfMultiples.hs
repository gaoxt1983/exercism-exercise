module SumOfMultiples (sumOfMultiples) where

import Data.List
import qualified Data.Set as Set

sumOfMultiples :: [Integer] -> Integer -> Integer
sumOfMultiples factors limit = sum . Set.unions $ map (\x -> Set.fromAscList $ takeWhile (< limit) [x * y | y <- [1..]]) effectiveFactors
    where
        effectiveFactors = filter (/= 0) factors
