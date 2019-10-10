module DNA (nucleotideCounts, Nucleotide(..)) where

import qualified Data.Map as Map
import Text.Read

data Nucleotide = A | C | G | T deriving (Eq, Ord, Show, Enum, Read)

nucleotideCounts :: String -> Either String (Map.Map Nucleotide Int)
nucleotideCounts xs = fmap ((Map.unionsWith (+)) 
    . (init :) 
    . (map (\y -> Map.fromList [(y, 1)]))) 
    $ traverse translate xs
    where
        translate c = readEither [c] :: (Either String Nucleotide)
        init = Map.fromList [(A, 0), (C, 0), (G, 0), (T, 0)]