/**

Item a) OK
A classe P consiste nos problemas que podem ser resolvidos em tempo polinomial.
Mais especificamente, são problemas que podem ser resolvidos no tempo O(nk ) para
alguma constante k, onde n é o tamanho da entrada para o problema.

Item b) OK
A classe NP consiste nos problemas que são “verificáveis” em tempo polinomial,

O que significa ser verificável? Se tivéssemos algum tipo de “certificado” de uma solução,
poderíamos verificar se o certificado é correto em tempo polinomial para o tamanho da
entrada para o problema.

Item c) OK
um algoritmo não determinístico é um algoritmo em que, dada uma certa entrada, 
pode apresentar comportamentos diferentes em diferentes execuções, ao contrário 
de um algoritmo determinístico.


Item d) OK

R: (Eis outra maneira, mais ou menos equivalente, de definir redução polinomial:  Um problema Y é polinomialmente redutível
a um problema X  se existe um algoritmo que resolve Y usando uma subrotina hipotética que resolve X de tal modo que se
a subrotina for polinomial o algoritmo para Y também é polinomial.)  

Em outras palavras, “reduzindo” a solução do problema A à solução do problema B,
usamos a “facilidade” de B para provar a “facilidade” de A

O status de muitos problemas da classe NP é desconhecido:  não se sabe se o problema está na classe P ou não.  Diante disso, é uma boa ideia investigar a complexidade relativa dos problemas da classe NP.  
Trata-se de verificar se um dado problema Y é mais fácil ou mais difícil que um outro problema X (talvez mais bem-conhecido). 


Exemplos:
O problema do quadrado perfeito não é mais difícil que o problema da equação do segundo grau.
O problema do ciclo hamiltoniano não é mais difícil que o problema do ciclo longo.
O problema da soma de subconjunto não é mais difícil que o problema da mochila valiosa.
O problema da cobertura pequena de um grafo não é mais difícil que o problema da clique grande.

Item e) OK

Na teoria da complexidade computacional, a classe de complexidade é o subconjunto dos problemas NP de tal modo que todo problema em NP se pode reduzir,
com uma redução de tempo polinomial, a um dos problemas NP-completo. 

R: Pode-se dizer que os problemas de NP-completo são os problemas mais difíceis de NP
e muito provavelmente não formem parte da classe de complexidade P. 

A razão é que se conseguisse encontrar uma maneira de resolver qualquer problema NP-completo rapidamente (em tempo polinomial) , 
então poderiam ser utilizados algoritmos para resolver todos problemas NP rapidamente. 


Item f) OK
A redutibilidade sempre envolve dois problemas, que denominamos A e B
Se A se reduz a B, podemos usar uma solução para B para resolver A
Assim, em nosso exemplo, A é o problema de se orientar na cidade e B é o problema de se
obter um mapa
Note que redutibilidade não diz nada sobre resolver A ou B sozinhos, mas somente sobre a
solubilidade de A na presença de uma solução para B

Item g) 
Se alguém conseguir reduzir um problema, resolvera todos os outros problemas NP-Completos, pois pode se reduzir um ao outro.

Item h) Gera um absurdo, pois percebe que se

*/







