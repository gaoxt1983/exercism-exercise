module SpaceAge (Planet(..), ageOn) where

data Planet = Mercury
            | Venus
            | Earth
            | Mars
            | Jupiter
            | Saturn
            | Uranus
            | Neptune

ageOn :: Planet -> Float -> Float
ageOn planet seconds = 
    case planet of
       Mercury -> calcAgeWithCoeffient 0.2408467
       Venus   -> calcAgeWithCoeffient 0.61519726
       Earth   -> calcAgeWithCoeffient 1.0
       Mars    -> calcAgeWithCoeffient 1.8808158
       Jupiter -> calcAgeWithCoeffient 11.862615
       Saturn  -> calcAgeWithCoeffient 29.447498
       Uranus  -> calcAgeWithCoeffient 84.016846
       Neptune -> calcAgeWithCoeffient 164.79132
    where
        earthAge = 31557600
        calcAgeWithCoeffient coeffient = seconds / (earthAge * coeffient)
