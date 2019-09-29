module Strain (keep, discard) where

discard :: (a -> Bool) -> [a] -> [a]
discard p xs = keep (not . p) xs

keep :: (a -> Bool) -> [a] -> [a]
keep p xs = case xs of
    x:tail -> if p x then x:(keep p tail) else keep p tail
    _ -> []