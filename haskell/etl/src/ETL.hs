module ETL (transform) where

import Data.Map (Map, toList, fromList)
import Data.Char

transform :: Map a String -> Map Char a
transform legacyData = fromList . concat . Prelude.map reverseKV $ toList legacyData
    where
        reverseKV (k, vs) = Prelude.map (\x -> (toLower x, k)) vs