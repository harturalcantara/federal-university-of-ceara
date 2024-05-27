

/*
a)Explicação do Funcionamento dos Algoritimos:
	BubbleSort:A ideia do BubbleSort pegar o vetor e compara o se vetor procurando  i maior elemento,
	vc é maior que eu, manda pro final, coloca ele no final do vetor e mando comparar o tamanho do vertor
	restante n-1, pois seu tamanho era n.

	InsertionSort: Como se fosse inseir uma carta no baralho, e baralho na mao esta ordenado, quando recebe  uma 
	carta ele compara com todos o restante pra ver a posicao onde ele deve ficar corretamente, ele vai verificar 
	o ultimo cara e verifica com cada um.

	SelectionSort: Pega o indice do prmeiro 0,procura o menor elemento, ele guarda  indice do menor elemento, ele
	manda trocar o v[0] pelo v[i], pega o menor coloca no inicio, feito isso ele ordena quem sobrou.

	MergSort: Ele se trata de basicamente dividir para conquistar isso aplicado no vetor, ele utiliza uma funcao axiliar intercala que o ajuda 
	nesse processo de ordenacao ele ve tipo doi vetores mas é só um, e cria um vetor auxiliar que vai ficar contendo na ordem certa daquele vetor
	no final ele simplismente pega o vetor auxiliar e atribui no verdadeiro organizado, substituindo o valores e ordenando.
	Na funcao merge ele vai dividir o vetor e assim manda chmar diversar vezes um pro seu lado esquerdo e pro seu lado direito e fica intercalando 
	seu vetor ate estar totalmente ordenado.

	HeapSort:
	Usa um estrutura de dados de um maior(heap maximo), ele possu 2 funcoes constroi - a ideia q ele pega o 1 é por 
	ele si só já é uma heap, a ideai pega o proximo(para ser um heap o Pai tem q ser maior q tds seus filhos) proximo e ve ser é uma heap,
	e pega o proximo, e pergunta novamente isso é uma heap, assim por diante, pegunto sempre caso o proximo seja maior q o Pai ele faz a troca, até 
	seu devido lugar.(n log n)
	-peneira: , Pega o ultimo elemento, e compara com os filhos, quem é o maior e pega e troca e faz isso até levar a seu lugar. O(n log n)

	QuickSort:Divide pra conquisatar, ele usa uma funcao separa - conquistar conjunto de dados ele vai escolher um pivo e esse pivo para esquerda tem q ser menor e para direita
	tem q ser maior, (escolher esse pivo tem q ser importante pois isso vai variar ) chamo quisort para esquerda e para direita 
	(se o vetor estiver ordenado ele sera tao ruim quanto um outro algoritimo.
	(MELHOR CASO USAR UM PIVOR ALEATORIO)(escolher no meio é sempre bom)(depende)(se eu verificar q esta ordenado ele sai desempenho em O(n), )


b)Complexidade de melhor caso dos Algoritimos

BubbleSort:

InsertionSort

SelectionSort: n2

MergSort

HeapSort: O(n)

QuickSort

c)Complexidade de pior caso dos algoritimos

BubbleSort: O pior caso e O(n2)

InsertionSort Pior caso O(n2)

SelectionSort:  O pior caso do O(n2)

MergSort:  O pior caso do n*log(n)

HeapSort: n log (n)

QuickSort: O pior caso O(n2)



Busca binaria: Se o cara do meio for quem eu to procurando, se cara do meio for maior do que eu to procurando, (Ele de receber um vetor Ordenado),







*/