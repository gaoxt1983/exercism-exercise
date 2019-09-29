module Strain (keep, discard) where

discard :: (a -> Bool) -> [a] -> [a]
discard p xs = myFilter (not . p) xs

keep :: (a -> Bool) -> [a] -> [a]
keep p xs = myFilter p xs

myFilter :: (a -> Bool) -> [a] -> [a]
myFilter p xs = case xs of
    x:tail -> if p x then x:(myFilter p tail) else myFilter p tail
    _ -> []