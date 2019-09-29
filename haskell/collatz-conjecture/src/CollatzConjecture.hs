module CollatzConjecture (collatz) where

collatz :: Integer -> Maybe Integer
collatz n
    | n <= 0 = Nothing
    | otherwise = Just $ findCollatz n
    where
        next i = if even i then i `div` 2 else i * 3 + 1
        findCollatz i = toInteger $ length $ takeWhile (\x -> x /= 1) $ iterate next n