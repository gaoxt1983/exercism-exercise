module IsbnVerifier (isbn) where

import Data.Char

isbn :: String -> Bool
isbn code 
    | codeLength /= 10 = False
    | not allValid = False
    | otherwise = if checkSum `mod` 11 == 0 then True else False
    where
        availableCheckCodes = ['0'..'9'] ++ ['X']
        normalizedCode = filter isAlphaNum code
        codeWithIndex = zip [0..] $ normalizedCode
        isValid (i, c) = if i == 9 then c `elem` availableCheckCodes else isDigit c
        allValid = all isValid codeWithIndex
        codeLength = length normalizedCode
        translate c = if c == 'X' then 10 else read [c] :: Int
        calculate (i, c) = (10 - i) * (translate c)
        checkSum = sum $ map calculate $ codeWithIndex