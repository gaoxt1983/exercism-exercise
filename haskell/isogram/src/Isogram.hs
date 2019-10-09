module Isogram (isIsogram) where

import Data.Char
import Data.List

isIsogram :: String -> Bool
isIsogram [] = True
isIsogram xs = all (\x -> length x == 1) $ groupBy (==) $ sort $ map toLower $ filter isAlpha xs
