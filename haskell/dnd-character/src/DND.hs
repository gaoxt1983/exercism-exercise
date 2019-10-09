module DND ( Character(..)
           , ability
           , modifier
           , character
           ) where

import Test.QuickCheck (Gen, choose)
import Data.List

data Character = Character
  { strength     :: Int
  , dexterity    :: Int
  , constitution :: Int
  , intelligence :: Int
  , wisdom       :: Int
  , charisma     :: Int
  , hitpoints    :: Int
  }
  deriving (Show, Eq)

modifier :: Int -> Int
modifier num = (num - 10) `div` 2
  

ability :: Gen Int
ability = fmap (\x -> sum $ take 3 $ reverse $ sort x) $ sequence $ repeatFun (choose (1, 6)) 4
  

character :: Gen Character
character = do
  strength <- ability
  dexterity <- ability
  constitution <- ability
  intelligence <- ability
  wisdom <- ability
  charisma <- ability
  return Character {
    strength = strength,
    dexterity = dexterity,
    constitution = constitution,
    intelligence = intelligence,
    wisdom = wisdom,
    charisma = charisma,
    hitpoints = 10 + (modifier constitution)
  }

repeatFun :: a -> Int -> [a]
repeatFun f n
  | n == 0 = []
  | otherwise = f : repeatFun f (n - 1)