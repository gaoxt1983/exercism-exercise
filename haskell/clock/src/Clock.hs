module Clock (addDelta, fromHourMin, toString) where

data Clock = Clock { hour :: Int, minute :: Int } deriving(Eq)

fromHourMin :: Int -> Int -> Clock
fromHourMin hour min = Clock hour min

toString :: Clock -> String
toString (Clock {hour=h, minute=m}) = padding normalizedH ++ ":" ++ (padding normalizedM)
    where
        hourRoll   = if m >= 0 then m `div` 60 else -((-m) `div` 60 + 1)
        normalizedH = normalize (if h >= 0 then h + hourRoll else 24 + (hourRoll + (-h `mod` 24)))
        minuteRoll = if m >= 0 then 0 else 60 - ((-m) `mod` 60)
        normalizedM = (m + minuteRoll) `mod` 60

normalize :: Int -> Int 
normalize h = if h >= 24 then h `mod` 24 else h

padding :: Int -> String
padding x = if x < 10 then "0" ++ show x else show x

addDelta :: Int -> Int -> Clock -> Clock
addDelta hour min (Clock {hour=h, minute=m}) = Clock (h + hour) (m + min)