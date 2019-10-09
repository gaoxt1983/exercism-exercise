module SecretHandshake (handshake) where

import Data.Bits
import Data.Maybe

handshake :: Int -> [String]
handshake n = if testBit n reverseSignal then reverse actionList else actionList

    where
        actions = [(0, "wink"), (1, "double blink"), (2, "close your eyes"), (3, "jump")]
        reverseSignal = 4
        getAction x = if testBit n $ fst x then Just $ snd x else Nothing
        actionList = [action | action <- mapMaybe getAction actions]
