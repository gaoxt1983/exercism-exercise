module Bob (responseFor) where

import Data.Text as T
import Data.Char

responseFor :: String -> String
responseFor xs
    | trimedSentence == T.empty = "Fine. Be that way!"
    | isQuestion && isYelling = "Calm down, I know what I'm doing!"
    | isYelling = "Whoa, chill out!"
    | isQuestion = "Sure."
    | otherwise = "Whatever."

    where
        trimedSentence = T.strip $ pack xs
        chars = T.filter isAlpha trimedSentence
        isYelling = if T.null chars then False else T.all isUpper chars
        lastCharMaybe = T.unsnoc trimedSentence
        isQuestion = case lastCharMaybe of
            Just (_, lastChar) -> lastChar == '?'
            _ -> False