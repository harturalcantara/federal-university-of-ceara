






/* 
https://pt.wikipedia.org/wiki/Algoritmo_de_Kruskal
    

    //ALGORITIMO DE KRUSKAL
Ele encontra um subconjunto das arestas que forma uma árvore que inclui todos os vértices, onde o peso total, 
dado pela soma dos pesos das arestas da árvore, é minimizado.

Seu funcionamento é mostrado a seguir:

crie uma floresta F (um conjunto de árvores), onde cada vértice no grafo é uma árvore separada
crie um conjunto S contendo todas as arestas do grafo
enquanto S for não-vazio, faça:
remova uma aresta com peso mínimo de S
se essa aresta conecta duas árvores diferentes, adicione-a à floresta, combinando duas árvores numa única árvore parcial
do contrário, descarte a aresta
Ao fim do algoritmo, a floresta tem apenas um componente e forma uma árvore geradora mínima do grafo.

Com o uso de uma estrutura de dados eficiente, o algoritmo de Kruskal possui complexidade de tempo igual a O (m log n),
 onde m representa o número de arestas e n o número de vértices.

        ITEM E)   
https://pt.wikipedia.org/wiki/Algoritmo_de_Prim

//ALGORITIMO DE Prim
Algoritmo de Prim é um algoritmo guloso (greedy algorithm) empregado para encontrar uma árvore geradora mínima (minimal spanning tree) num grafo conectado, 
valorado e não direcionado. Isso significa que o algoritmo encontra um subgrafo do grafo original no qual a soma total das arestas é minimizada e todos os
 vértices estão interligados.

