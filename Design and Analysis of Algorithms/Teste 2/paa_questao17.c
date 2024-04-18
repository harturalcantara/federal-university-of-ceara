

//QUESTAO 17 E 18 INCLUIDAS, A 18 NAOTA ORGANIZADA


/** Item a) */ 
/*******************************
______BUSCA EM LARGURA

A busca em largura é um dos algoritmos mais simples para exploração de um grafo.

– Dados um grafo G = (V, E) e um vértice s, chamado de fonte, a busca em largura sistematicamente explora as arestas
de G de maneira a visitar todos os vértices alcançáveis a partir de s.
T
•Expande a fronteira entre vértices descobertos e não descobertos 
uniformemente através da largura da fronteira.

– O algoritmo descobre todos os vértices a uma distância k do vértice origem antes de descobrir qualquer vértice a uma distância k + 1.
• O grafo pode ser direcionado ou não direcionado.

_____BUSCA EM PROFUNDIDADE
A estratégia é buscar o vértice mais profundo no grafo sempre
que possível:

– As arestas são exploradas a partir do vértice v mais recentemente
descoberto que ainda possui arestas não exploradas saindo dele.

• Quando todas as arestas adjacentes a v tiverem sido
exploradas a busca anda para trás para explorar vértices que
saem do vértice do qual v foi descoberto (backtraking).

• O algoritmo é a base para muitos outros algoritmos
importantes, tais como verificação de grafos acíclicos,
ordenação topológica e componentes fortemente conectados.




******************************/

/** Item b) */ 
/**************************
Ambos os algoritmos de Kruskal e Prim seguem o esquema básico do algoritmo genérico apresentado na seção anterior. 
A diferença entre os dois está na forma como cada um escolhe uma aresta segura (na linha 3).

No algoritmo de Kruskal, o conjunto A é uma floresta cujas componentes conexas vão se unindo a cada iteração. 

Já no algoritmo de Prim, A nunca deixa de ser uma árvore, uma vez que a aresta segura incluída a cada passo une um
vértice que está fora da árvore a um vértice que já pertence a ela.
*******************************/



/** Item c) */
/*********************************
    //- O algoritmo de Dijkstra
O algoritmo de Dijkstra soluciona o problema do caminho mais curto num grafo dirigido ou não dirigido com arestas de peso não negativo


    FUNCIONAMENTO
1. O algoritmo considera um conjunto S de menores caminhos, iniciado com um vértice inicial I. 
2. A cada passo do algoritmo busca-se nas adjacências dos vértices pertencentes a S aquele vértice 
com menor distância relativa a I e adiciona-o a S e, então, repetindo os passos até que todos os 
vértices alcançáveis por I estejam em S. 
3. Arestas que ligam vértices já pertencentes a S são desconsideradas.

Um exemplo prático do problema que pode ser resolvido pelo algoritmo de Dijkstra é: alguém precisa se deslocar de uma cidade para outra.
Para isso, ela dispõe de várias estradas, que passam por diversas cidades.

    // --SUBESTRUTURA OTIMA DO DIJKSTRA
Se P é um a-f -caminho mínimo e v ∈ P, então a parte de P que vai de a até v é um a-v -caminho mínimo.
Pois caso contrário, existiria Q um a-v-caminho mínimo, e Q concatenado com P 00,
 a parte de P que vai de v até f , seria um a-f -caminho menor que P (que é mínimo)... um absurdo! 



  //- Algoritmo de Bellman-Ford 
 - O Algoritmo de Bellman-Ford é um algoritmo de busca de caminho mínimo em um dígrafo ponderado, ou seja, cujas arestas têm peso, inclusive negativo.
 - O Algoritmo de Dijkstra resolve o mesmo problema, num tempo menor, porém exige que todas as arestas tenham pesos positivos. 
Portanto, o algoritmo de Bellman-Ford é normalmente usado apenas quando existem arestas de peso negativo. 
 - O algoritmo de Bellman-Ford executa em tempo O ( V × E) onde V é o número de vértices e E o número de arestas.

    // O ALGORITMO DE FLOYD
O algoritmo de Floyd-Warshall recebe como entrada uma matriz de adjacência que representa um grafo  (V,E)} (V,E) orientado e valorado.
 O valor de um caminho entre dois vértices é a soma dos valores de todas as arestas ao longo desse caminho. 
 
 As arestas  E} E do grafo podem ter valores negativos, mas o grafo não pode conter nenhum ciclo de valor negativo.
  O algoritmo calcula, para cada par de vértices, o menor de todos os caminhos entre os vértices. 
  
  Por exemplo, o caminho de menor custo. Sua ordem de complexidade é  \Theta (|V|^{3})}  \Theta (|V|^{3})}.

O algoritmo se baseia nos passos abaixo:

Assumindo que os vértices de um grafo orientado G são  V={1,2,3,n}} V={1,2,3,\ldots ,n}, considere um subconjunto  {1,2,3\ldots ,k}} {1,2,3\ldots ,k};
Para qualquer par de vértices  (i,j)} (i,j) em  V} V, considere todos os caminhos de  i} i a  j} j cujos vértices intermédios pertencem ao subconjunto  {1,2,3\ldots ,k}} {1,2,3\ldots ,k}, e  p} p como o mais curto de todos eles;
O algoritmo explora um relacionamento entre o caminho  p} p e os caminhos mais curtos de  i} i a  j} j com todos os vértices intermédios em  {1,2,3\ldots ,k-1}} {1,2,3\ldots ,k-1};
O relacionamento depende de  k} k ser ou não um vértice intermédio do caminho  p} p.

****************************************/

