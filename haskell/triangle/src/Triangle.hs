module Triangle (TriangleType(..), triangleType) where

data TriangleType = Equilateral
                  | Isosceles
                  | Scalene
                  | Illegal
                  deriving (Eq, Show)

triangleType :: (Num a, Ord a) => a -> a -> a -> TriangleType
triangleType a b c 
    | or [a <= 0, b <=0, c <= 0] = Illegal
    | or [a + b <= c, b + c <= a, a + c <= b] = Illegal
    | otherwise =
        if all id pairs then 
            Equilateral else
            if any id pairs then 
                Isosceles
            else
                Scalene
            where
                pairs = [a == b, a == c, b == c]