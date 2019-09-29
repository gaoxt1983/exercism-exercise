module CryptoSquare (encode) where

import Data.Char

encode :: String -> String
encode xs = unwords $ breakString 8 $ concat $ words $ removePunc $ map toLower xs

breakString :: Int -> String -> [String]
breakString numCol xs = if numCol <= len then [take numCol xs] ++ (breakString numCol $ drop numCol xs) else [xs]
    where len = length xs

removePunc = filter (flip notElem "@,%.?!-;\'\"")
