module Raindrops (convert) where

import Data.Maybe

convert :: Int -> String
convert n = if drops == "" then show n else drops
    where
        dict = [(3, "Pling"), (5, "Plang"), (7, "Plong")]
        drops = concat $ catMaybes [if n `mod` (fst r) == 0 then Just $ snd r else Nothing | r <- dict]
    
            