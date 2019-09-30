module DNA (nucleotideCounts, Nucleotide(..)) where

import Data.Map (Map, fromList, unionsWith)
import Text.Read

data Nucleotide = A | C | G | T deriving (Eq, Ord, Show, Enum, Read)

nucleotideCounts :: String -> Either String (Map Nucleotide Int)
nucleotideCounts xs = fmap ((unionsWith (+)) . (\x -> init : x) . (\x -> Prelude.map (\y -> fromList [(y, 1)]) x)) $ traverse translate xs
    where
        translate c = readEither [c] :: (Either String Nucleotide)
        init = fromList [(A, 0), (C, 0), (G, 0), (T, 0)]