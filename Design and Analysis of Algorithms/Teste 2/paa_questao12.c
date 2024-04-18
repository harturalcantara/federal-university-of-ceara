


// PROPRIEDADE GULOSA

/*
    ESCOLHA GULOSA
1. Ordena o vetor de envelopes que contem os pesos em ordem crescente
2. Pega-se o menor, (que e 1º do vetor) e o maior(que e 'N' ultimo do vetor), dessa forma sera menor possibilidade de pegar
o peso para que seja '1'.
3. Se voce somar um certo 'i' do vetor (1º do vetor) com um certo 'j' (ultimo do vetor) e são os indices de n, podem ter dois casos
    Se i+j <= 1, entao vc anda com o indice i e decrementa o j.
    Se i+j > 1, entao vc mantem o indice i intacto, e e decrementa o j.
DESSA FORMA ESSE É A ESCOLHA GULOSA

    PROVA POR ABSURDO
Suponha que vc ordenou, e i(indice que contem o menor) e j(indice contem o maior), suponha que vc vai somar
vai somar em pares(ou seja i, i+) que obtem a menor quantidade envelopes, ao fazer isso vc chegara ao ponto em
que a soma entrara sempre no caso e que i+j é maior do que 1. Contendo mais envelopes o que é ABSURDO!.









*/