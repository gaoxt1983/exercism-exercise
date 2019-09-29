module DNA (toRNA) where

import Control.Monad

toRNA :: String -> Either Char String
toRNA xs =
        sequence $ map translateRNA xs
    where
        translateRNA x = case x of
            'G' -> Right 'C'
            'C' -> Right 'G'
            'T' -> Right 'A'
            'A' -> Right 'U'
            ch  -> Left ch