#include <stdio.h>
#include <stdlib.h>
#include "bench.h"
#include "ordenacaoVetor.h"
#include "ordenacaoLista.h"


#define BENCH 1
#define MAX 131080

#define T 15

void vetorAleatorio(int* v, unsigned int len){

    unsigned int i =0;
    for(i=0;i<len;i++)
    {
        v[i]=rand();
    }

}

int testa(int n, int *v){

	int i;
	int r = v[1];
	for(i=2;i<n;i++){
		if(r > v[i]) return 0;
		r = v[i];
	}
	return 1;
	
}

int main(){

	/*==================================================================================================================================*/
	/*=====================================Area de testes usando os algoritimos de Ordenação Vetores!===================================*/
	/*==================================================================================================================================*/

	// int  vetor[T]={0, 3, 11 ,2 ,5 ,17, 7, 13, 4, 6, 7, 3, 7, 10, 54};
	
	// printf("\tVetor normal que temos:\n");
	// imprimirVetor(T, vetor);

		/*Testando os algoritimos Recursivos*/

	//bubbleSortRec(16,vetor); 			//Feito

	//insertionSortRec(16,vetor);		//Feito

	//selectionSortRec(16,vetor);	//Feito

	//mergeSortRec(0, 16, vetor);		//Feito

	//quickSortRec(0, 16, vetor);		//Feito

	//heapSortRec(16, vetor);			//Feito

		/*Testando os algoritimos Interativos*/

	//bubbleSortInt(16, vetor);			//Feito

	//insertionSortInt(16, vetor);		//Feito

	//selectionSortInt(16, vetor);		//Feito

	//mergeSortInt(16, vetor);			//Feito

	//heapSortInt(16, vetor);			//Feito

	//quickSortInt(vetor,0,16);			//Feito
	
	//novos
	// bubbleSortSeg(vetor,T);	 //Segunda implementação
	// selectionSortSeg(vetor,T); //Segunda implementação
	// insertionSortSeg(vetor,T); //Segunda implementação
	// heapSortSeg(vetor,T);   //Segunda implementação


	// printf("\tVetor Ordenado:\n");
	// imprimirVetor(T, vetor);




	/*===============================================================================================================================*/
	/*==========================Area de tesdes dos algoritimos de Ordenação em Lista Duplamente Encadeada!===========================*/
	/*===============================================================================================================================*/

	// Lista* listinha = criaListaNull();

	// inserirNovaLista(&listinha, 21);
	// inserirNovaLista(&listinha, 10);
	// inserirNovaLista(&listinha, 342);
	// inserirNovaLista(&listinha, 31);
	// inserirNovaLista(&listinha, 42);
	// inserirNovaLista(&listinha, 32);
	// inserirNovaLista(&listinha, 1);

	// printf("[Main] - Lista Encadeada Atualmente:\n");
	// imprimir(listinha);
	
	// Testando Algoritimos de Ordenação Interativos


	// //bubbleSortListaInt(&teste, 3);		// - Feito
	//InsertionSortIntLista(&listinha, 7);		// - OK
	// //selectionSortListaInt(&teste, 7);		// ok




	// Testando Algoritimos de Ordenação Recursivos

	// //quickSortListaEnd(listinha);			// ok

	// // bubbleListaRec(&listinha,6);


	// printf("Main - Lista Encadeada Ordenada:\n");
	// imprimir(listinha);




	/*==================================================================================================================================*/
	/*========================================Comparações usando os algoritimos de Ordenação Vetores!===================================*/
	/*==================================================================================================================================*/
	
	// int i, k=0;

	// int bubbleRec=0, insertionRec=0, selectionRec=0,heapRec=0,mergeRec=0, quickRec=0;

	// int bubbleInt=0,insertionInt=0, selectionInt=0, mergeInt=0, heapInt=0, quickInt=0;

	// int bubbleSeg=0, insertionSeg=0, selectionSeg=0, heapSeg=0,bubbleRecSeg=0;

	// int *v = (int*)malloc(MAX*sizeof(int));
	
	// for(i=128; i<MAX; i = i*8){

	// 	printf("-----Vetores de tamanho %d------\n", i);

		//--------------------------Algoritimmos Recursivos

		//vetorAleatorio(v,i);
		//BENCH_FUNCTION(bubbleSortRec, i, v);
		//bubbleRec+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(insertionSortRec,i,v);
		// insertionRec+=testa(i,v);
		
		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(selectionCallRec,i,v);
		// selectionRec+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(mergeCallRec,i,v);
		// mergeRec+=testa(i,v);


		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(heapSortRec,i,v);
		// heapRec+=testa(i,v);


		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(quickCallRec,i,v);
		// quickRec+=testa(i,v);
		
		//--------------------------------------Algoritimos Interativos


		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(bubbleSortInt, i, v);
		// bubbleInt+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(insertionSortInt,i,v);
		// insertionInt+=testa(i,v);
		
		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(selectionSortInt,i,v);
		// selectionInt+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(mergeSortInt,i,v);
		// mergeInt+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(heapSortInt,i,v);
		// heapInt+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(quickCallInt,i,v);
		// quickInt+=testa(i,v);

		//---------------------------------------Outros Algoritimos

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(bubbleSortSeg,v,i);
		// bubbleSeg+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(insertionSortSeg,v,i);
		// insertionSeg+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(selectionSortSeg,v,i);
		// selectionSeg+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(heapSortSeg,v,i);
		// heapSeg+=testa(i,v);

		// vetorAleatorio(v,i);
		// BENCH_FUNCTION(bubbleSortRecSeg,v,i);
		// bubbleRecSeg+=testa(i,v);

	// 	k++;
		
	// 	printf("---------------------------------\n");
	// 	//break;
	// }


	// printf("Bolha 		Vetor Recursivo: [%s]\n", bubbleRec==k?"Yes":"No");
	// printf("Inserção 	Vetor Recursivo: [%s]\n", insertionRec ==k?"Yes":"No");
	// printf("Seleção 	Vetor Recursivo: [%s]\n", selectionRec==k?"Yes":"No");
	// printf("Merge 		Vetor Recursivo: [%s]\n", mergeRec==k?"Yes":"No");
	// printf("Heap		Vetor Recursivo: [%s]\n", heapRec ==k?"Yes":"No");
	// printf("Quick 		Vetor Recursivo: [%s]\n", quickRec==k?"Yes":"No");
	// printf("\n\n");
	
	// printf("Bolha 		Vetor Interativo: [%s]\n", bubbleInt==k?"Yes":"No");
	// printf("Inserção 	Vetor Interativo: [%s]\n", insertionInt==k?"Yes":"No");
	// printf("Seleção 	Vetor Interativo: [%s]\n", selectionInt==k?"Yes":"No");
	// printf("Heap 		Vetor Interativo: [%s]\n", mergeInt==k?"Yes":"No");
	// printf("Merge 		Vetor Interativo: [%s]\n", heapInt==k?"Yes":"No");
	// printf("Quick		Vetor Interativo: [%s]\n", quickInt==k?"Yes":"No");


	// free(v);
	// printf("\n\n\n");

	

	/*==================================================================================================================================*/
	/*==========================================Comparações com Lista Duplamente Encadeada==============================================*/
	/*==================================================================================================================================*/
	
	
	// Lista* teste = criaListaNull();

	// int j, cont=0,bubble=0, insertion=0, selection=0;

	// int bubbleRec=0,quickRec=0;

	// for(j=128; j<MAX; j = j*8){

	// 	printf("-----Lista de tamanho %d------\n", j);

	// 	listaAleatorio(&teste,j);

	// 	//RECURSIVO

	// 	// BENCH_FUNCTION(bubbleListaRec, &teste, j);
	// 	// bubbleRec+=testaLista(&teste);

	// 	BENCH_FUNCTION(quickSortListaEnd, teste);
	// 	quickRec+=testaLista(&teste);

	// 	//INTERATIVOS

	// 	BENCH_FUNCTION(bubbleSortListaInt,&teste, j);
	// 	bubble+=testaLista(&teste);

	// 	BENCH_FUNCTION(InsertionSortIntLista,&teste, j);
	// 	insertion+=testaLista(&teste);

	// 	BENCH_FUNCTION(selectionSortListaInt,&teste, j);
	// 	selection+=testaLista(&teste);

								
	// 	cont++;
		
	// 	printf("-------------------------------\n");
	// 	//break;		
	// }

	// printf("Lista Duplamente Encadeada Bubble: [%s]\n", bubble==cont?"Yes":"No");
	// printf("Lista Duplamente Encadeada Insertion: [%s]\n", insertion==cont?"Yes":"No");
	// printf("Lista Duplamente Encadeada Selection: [%s]\n", selection==cont?"Yes":"No");

	// printf("Lista Duplamente Encadeada BubbleRec: [%s]\n", bubbleRec==cont?"Yes":"No");
	// printf("Lista Duplamente Encadeada QuickRec: [%s]\n", quickRec==cont?"Yes":"No");

	// printf("\n\n");

	//exit(1);
	

	/*==============================================================================================================================*/
	return 0;
}