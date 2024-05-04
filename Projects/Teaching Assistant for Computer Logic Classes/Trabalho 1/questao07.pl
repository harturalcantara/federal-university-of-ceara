progenitor(jose, joao).
progenitor(jose, ana).

progenitor(maria, joao).
progenitor(maria, ana).

progenitor(ana, helena).
progenitor(ana, joana).

progenitor(joao, mario).

progenitor(helela, carlos).

progenitor(mario, carlos).

sexo(jose, masculino).
sexo(joao, masculino).
sexo(mario, masculino).
sexo(ana, feminino).
sexo(helena, feminino).
sexo(joana, feminino).


irmaos(X, Y) :- progenitor(Z, X), progenitor(Z, Y).
irma(X, Y) :- irmaos(X, Y), sexo(Y, feminino).
irmao(X, Y) :- irmaos(X, Y), sexo(Y, masculino).

descendentes(X, Y) :- progenitor(X, Y).
descendentes(X, Y) :- progenitor(X, Z), descendentes(Z, Y).

pai(X, Y) :- progenitor(Y, X), sexo(Y, masculino).
mae(X, Y) :- progenitor(Y, X), sexo(Y, feminino).

