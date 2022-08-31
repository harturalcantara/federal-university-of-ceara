module Lista1 where


--FUNÇÕES AUXILIARES
myTakeWhile :: (a -> Bool) -> [a] -> [a]
myTakeWhile p [] = []
myTakeWhile p (x:xs) = myIf (p x) (x : myTakeWhile p xs) []

myDropWhile :: (a -> Bool) -> [a] -> [a]
myDropWhile p [] = []
myDropWhile p l@(x:xs) = myIf (p x) (myDropWhile p xs) l

myIf :: Bool -> a -> a -> a
myIf True x y = x
myIf False x y = y

myReverse :: [a] -> [a]
myReverse [] = []
myReverse xs =  auxiliar xs [] where
                auxiliar [] ys = ys
                auxiliar (x : xs) ys = auxiliar xs (x : ys)

myLength :: [a] -> Int
myLength [] = 0
myLength (x : xs) = 1 + myLength xs

--Questão 1
ucons :: [a] -> Maybe (a , [a]) 
ucons [] = Nothing
ucons (x : xs) = Just (x, xs) -- ucons xs

--Questão 2
myIterate :: (a -> a) -> a -> [a]
myIterate f x = x : myIterate f y where
					y = f(x)

--Questão 3
myReplicate :: Int -> a -> [a]
myReplicate 0 a = []
myReplicate n a =  a : myReplicate (n-1) a

--Questão 4
myGroup :: Eq a => [a] -> [[a]]
myGroup [] = []
myGroup (x:xs) = (x : myTakeWhile (== x) xs) :  myGroup (myDropWhile (== x) xs)

--Questão 5
myInits :: [a] -> [[a]]
myInits [] = []
myInits (x:xs) = [x] : myInits xs 

--Questão 6
myTails :: [a] -> [[a]]
myTails [] = []
myTails l@(x:xs) = (myInits ms) where
				ms = myReverse l

--Questão 7
myIsSubsequenceOf :: (Eq a) => [a] -> [a] -> Bool
myIsSubsequenceOf [] ys = True
myIsSubsequenceOf xs [] =  False
myIsSubsequenceOf [] [] = False
myIsSubsequenceOf l@(x:xs) (y:ys) = myIf(x == y) (myIsSubsequenceOf xs ys) (myIsSubsequenceOf l ys)	where
				  myif(x == y)  (myIsSubsequenceOf xs ys) 

myFilter :: (a -> Bool) -> [a] -> [a]
myFilter p [] = []
myFilter p (x:xs) = myIf (p x) (x : ms) ms where
                    ms = myFilter p xs








--Questão 8





