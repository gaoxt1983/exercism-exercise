module ResistorColors (Color(..), value) where

import Data.List

data Color =
    Black
  | Brown
  | Red
  | Orange
  | Yellow
  | Green
  | Blue
  | Violet
  | Grey
  | White
  deriving (Eq, Show, Read)

value :: [Color] -> Int
value cs = case indexesMaybe of
    Just xs -> sum $ map (\x -> (snd x) * 10 ^ (fst x)) $ zip [0..] $ reverse xs
    Nothing -> error "error"
  where
    indexes = [Black, Brown, Red, Orange, Yellow, Green, Blue, Violet, Grey, White]
    indexesMaybe = sequence $ map (\x -> (elemIndex x indexes)) $ take 2 cs