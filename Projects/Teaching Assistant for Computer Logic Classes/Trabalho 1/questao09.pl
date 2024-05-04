

entre(X, A, B) :- X >= A , X =< B.

par(X) :- 0 is X mod 2.

impar(X) :- 1 is X mod 2.

fatorial(0, 1).
fatorial(X, Y) :- X > 0, X1 is X - 1, fatorial(X1, Y1), Y is X*Y1.

sucessor(X, Y) :- X is Y+1.
