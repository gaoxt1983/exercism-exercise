module Robot
    ( Bearing(East,North,South,West)
    , bearing
    , coordinates
    , mkRobot
    , move
    ) where

data Bearing = North
             | East
             | South
             | West
             deriving (Eq, Show, Enum, Bounded)

data Robot = Robot Bearing Integer Integer

bearing :: Robot -> Bearing
bearing (Robot b _ _) = b

coordinates :: Robot -> (Integer, Integer)
coordinates (Robot _ x y) = (x, y)

mkRobot :: Bearing -> (Integer, Integer) -> Robot
mkRobot direction coordinates = Robot direction (fst coordinates) (snd coordinates)

move :: Robot -> String -> Robot
move robot instructions = foldl instruct robot instructions
    where
        instruct r i
            | i == 'L' = mkRobot (if robotBearing == minBound then maxBound else pred robotBearing) robotCoords
            | i == 'R' = mkRobot (if robotBearing == maxBound then minBound else succ robotBearing) robotCoords
            | i == 'A' = mkRobot robotBearing (fst robotCoords + fst robotAdvanceCoords, snd robotCoords + snd robotAdvanceCoords)
            | otherwise = error "panic"
            where
                robotBearing = bearing r
                robotCoords  = coordinates r
                getAdvanceCoords North = (0, 1)
                getAdvanceCoords South = (0, -1)
                getAdvanceCoords East  = (1, 0)
                getAdvanceCoords West  = (-1, 0)
                robotAdvanceCoords = getAdvanceCoords robotBearing