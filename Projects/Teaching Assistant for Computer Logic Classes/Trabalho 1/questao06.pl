%Relacao pai(x, y) retorna true se y for pai de x
pai(eva, ivo).
pai(rai, gil).
pai(clo, gil).
pai(ary, gil).
pai(noe, rai).
pai(gal, ary).

%Relacao mae(x, y) retorna true se y for mae de x
mae(eva, ana).
mae(rai, bia).
mae(clo, bia).
mae(ary, bia).
mae(noe, eva).
mae(gal, lia).

%Relacao homem(x)
homem(ivo).
homem(gil).
homem(rai).
homem(ary).
homem(noe).

%Relacao mulher(x)
mulher(ana).
mulher(bia).
mulher(eva).
mulher(clo).
mulher(lia).
mulher(gal).

%Relacao gerou(X, Y) se X gerou Y
gerou(X, Y) :-  pai(Y, X) ; mae(Y, X).

%Relacao sexo(x)
sexo(ivo, masculino).
sexo(gil, masculino).
sexo(rai, masculino).
sexo(ary, masculino).
sexo(noe, masculino).
sexo(ana, feminino).
sexo(bia, feminino).
sexo(eva, feminino).
sexo(clo, feminino).
sexo(lia, feminino).
sexo(gal, feminino).



%Relacao irmaos(X, Y) verifica de X e irmao de Y (sem olhar o sexo)
irmaos(X, Y) :- pai(X, P), mae(X, M), pai(Y, P), mae(Y, M), X \== Y.
irma(X, Y) :- irmaos(X, Y), mulher(Y).
irmao(X, Y) :- irmaos(X, Y), homem(Y).

descendentes(X, Y) :- pai(Y, X) ; mae(Y, X) .
descendentes(X, Y) :- (pai(Z, X) ; mae(Z, X)) ,  descendentes(Z, Y).

avo(X, Y) :- (pai(X, Z); mae(X, Z)), pai(Z, Y).

tio(X, Y) :- (pai(X, Z); mae(X, Z)) , irmao(Z, Y).

primos(X, Y) :- (pai(X, Z) ; mae(X, Z)) , irmaos(Z, H), (pai(Y, H) ; mae(Y, H)).
