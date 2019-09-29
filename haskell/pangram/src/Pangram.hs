module Pangram (isPangram) where

import Data.Set (fromList, fromAscList, isSubsetOf)
import Data.Char (toLower)

isPangram :: String -> Bool
isPangram text =
    alphabet `isSubsetOf` fromList (map toLower text)
    where
        alphabet = fromAscList ['a' .. 'z']