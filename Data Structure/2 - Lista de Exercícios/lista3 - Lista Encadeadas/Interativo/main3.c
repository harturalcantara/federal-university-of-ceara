#include <stdio.h>
#include <stdlib.h>
#include "lista3.h"
int main(){


	/*
	Lista *TA;
	TA = cria();

	TA = inserir(TA,2);
	TA = inserir(TA,3);
	TA = inserir(TA,4);
	TA = inserir(TA,1);
	///IMPRIMINDO 1 LISTA ENCADEADA!
	printf("ELEMENTOS - GAVETA1:\n");
	imprimir(TA);

		
	printf("GAVETA1 - Valor minimo: %d\n",encontrarMinimo(TA));
	printf("GAVETA2 - Valor maximo: %d\n",encontrarMaximo(TA));
	
	Lista* Teste = retiraMaximo(TA);
	//E PARA IMPRIMIR OS VALORES DA 1 LISTA SEM O MAIOR NUMERO!
	printf("GAVETA1 - valor maximo retirado:\n");
	imprimir(Teste);

	printf("Numero de Celulas de GAVETA1: %d\n",contaCelulas(TA));

	//2 LISTA ENCADEADA
	Lista *gaveta2;
	gaveta2 = cria();

	gaveta2 = inserir(gaveta2,9);
	gaveta2 = inserir(gaveta2,8);
	gaveta2 = inserir(gaveta2,7);
	gaveta2 = inserir(gaveta2,3);
	gaveta2 = inserir(gaveta2,5);
	/*
	printf("ELEMENTOS - GAVETA1:\n");
	imprimir(TA);
	printf("ELEMENTOS - GAVETA2:\n");
	imprimir(gaveta2);

	TA = concatenarListas(TA,gaveta2);
	printf("CONCATECAO DA GAVETA1 COM A GAVETA2:\n");
	imprimir(TA);
	
	printf("GAVETA2 - REMOVENDO A KESIMA POSICAO;\n");
	gaveta2 = remover(gaveta2,9);
	imprimir(gaveta2);

	//CONTA QTS VEZES APARECEU NA LISTA
	int x = contarX(gaveta2,8);
	printf("APARECEU 8: %d\n", x);

	//QUESTAO 9
	printf("NUMERO DA GAVETA2:\n");
	imprimir(gaveta2);
	printf("QTD DE NUMEROS PRIMOS NA GAVETA2: %d\n",contaPrimos(gaveta2));
	printf("SOMATORIO DOS NUMEROS PRIMOS:%d\n", somaPrimos(gaveta2));

	//QUESTAO 19;
	Lista* soPRIMOS;
	soPRIMOS = listaPrimos(gaveta2);

	printf("LISTA DE PRIMOS\n");
	imprimir(soPRIMOS);

	libera(TA);
	libera(gaveta2);
	*/
	//-
	//QUESTAO 11;
	Lista *GAVETA1;
	Lista *GAVETA2;
	GAVETA1 = cria();
	GAVETA2 = cria();
	
	GAVETA1 = inserir(GAVETA1,1);
	GAVETA1 = inserir(GAVETA1,2);
	GAVETA1 = inserir(GAVETA1,3);
	GAVETA1 = inserir(GAVETA1,4);
	GAVETA1 = inserir(GAVETA1,5);

	GAVETA2 = inserir(GAVETA2,3);
	GAVETA2 = inserir(GAVETA2,2);
	GAVETA2 = inserir(GAVETA2,1);
	printf("NOVA GAVETA1:\n");
	imprimir(GAVETA1);
	printf("NOVA GAVETA2:\n");
	imprimir(GAVETA2);
	printf("IMPRIMINDO UM ELEMENTO:\n");
	imprimirUmElemento(GAVETA1);
	removeRepetidos(GAVETA1);
	printf("GAVETA1 SEM OS ELEMENTOS REPETIDOS:\n");
	imprimir(GAVETA1);

	Lista* menor= menorRecursivo(GAVETA1,GAVETA1);
	printf("MENOR ELEMENTO:\n");
	imprimir(GAVETA1);




	/*
//QUESTAO 11
	Lista *auxDeSomaListas = somaDuasLista(GAVETA1, GAVETA2);
	printf("SOMA DAS LSITAS DE GAVETA1 e GAVETA2:\n");
	imprimir(auxDeSomaListas);
	*/
//QUESTAO 12;
	/*
	printf("VERIFICANDO O CONTEUDO SEM ORDEM DE GAVETA1 e GAVETA2:\n");
	conteudoIguaisSemOrdem(GAVETA1, GAVETA2);
	
	*/
	/*
//QUESTAO 18;
	printf("VERIFICANDO O CONTEUDO DE GAVETA1 e GAVETA2:\n");
	conteudoIguais(GAVETA1, GAVETA2);
	*/
//QUESTAO 17
	/*
	Lista *nulosTeste = removerDaListaOsNulosQ17(GAVETA1);
	printf("GAVETA 1 SEM NULOS:\n");
	imprimir(nulosTeste);
	*/
//QUESTAO 06
	/*
	printf("GAVETA 1 COM ELEMENTO X REMOVIDO:\n");
	Lista *removidoX = removeElementoX(GAVETA1, 1);
	imprimir(removidoX);
	*/



	

}