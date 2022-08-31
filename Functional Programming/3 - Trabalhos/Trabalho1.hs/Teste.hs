{-}
data Dual a = !a :+? !a deriving (Eq, Read, Show)
infix 6 :+?

instance Num a => Num (Dual a) where
  (a :+? b) + (c :+? d) = (a+c) :+? (b+d)
  (a :+? b) - (c :+? d) = (a-c) :+? (b-d)
  (a :+? b) * (c :+? d) = (a*c) :+? (b*c + a*d)
  negate (a :+? b)      = (-a) :+? (-b)
  fromInteger n         = fromInteger n :+? 0
  -- abs and signum might actually exist, but I'm not sure what they are.
  abs    _              = error "No abs for dual numbers."
  signum _              = error "No signum for dual numbers."

-- Instances for Fractional, Floating, etc., are all possible too.

differentiate :: Num a => (Dual a -> Dual a) -> (a -> a)
differentiate f x = case f (x :+? 1) of _ :+? f'x -> f'x

-- Your original f, but with a more general type signature.  This polymorphism is
-- essential!  Otherwise, we can't pass f to differentiate.
-}

f :: Num a => a -> a
f x = 3*x^2 + 5*x + 9

f' :: Num a => a -> a
f' x = 6*x + 5



newton :: (Num a) => (a -> a) -> a -> [a]
newton f x = [x+1] : myIterate(f x)






myIterate :: (a -> a) -> a -> [a]
myIterate f x = x : myIterate f y where
					y = f(x)
{-
x1 = x0 - (f x0)/(f' x0)

f  x    = x^2 - 4*x + 2
f' x    = 2*x - 4
delta x = (f x) / (f' x)

naoConvergiu x = abs (delta x) > 1e-10
atualiza     x = x - (delta x)
-}



--(Fractional a) => 
--myNewton :: (a -> a) -> a -> [a]
--myNewton f x = myIterate (differentiate f) (x)