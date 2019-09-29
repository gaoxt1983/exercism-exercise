module Prime (nth) where

nth :: Int -> Maybe Integer
nth 0 = Nothing
nth n = Just $ (filter isPrime [2..])!!(n - 1)
    where isPrime p = foldl (\acc x -> acc * x `mod` p) 1 [2..(p-2)] == 1

