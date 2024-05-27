#include <stdio.h>
#include <stdlib.h>
#include "sort.h"

void printVetor(int n, int *v){
  int i;
  for(i=0;i<n;i++)
    printf("%d ", v[i]);
}

int main(){
	int v[] = {5,6,0,1,2,6,9,8,7,3};		
	int i,n=10,op;
	printf("Vetor Atual!\n");
	printVetor(n,v);

	printf("1 - Bubble Sort decrescente \n");
	printf("2 - Insertion Sort decrescente \n");
	printf("3 - Selection Sort decrescente \n");
	
	printf("4 - Bubble Sort crescente recursivo\n");
	printf("5 - Insertion Sort crescente recursivo \n");
	printf("6 - Selection Sort crescente recursivo \n");
	printf("Entre com a opção desejada: \n");
	scanf("%d", &op);
	switch(op){
	  case 1:
	    bubbleSort(n,v);
	    break;
	  case 2:
	    insertionSort(n,v);
	    break;
 	  case 3:
 	    selectionSort(n,v);
 	    break;
 	  case 4:
 	    bubbleSortRec(n,v);
 	    break;
	  case 5:
	    insertionSortRec(n,v);
	    break;
 	  case 6:
 	    selectionSortRec(n,v);
 	    break;
	  default:
	    printf("Está opção não está disponível!");
	    break;
	}
	printVetor(n,v);
	return 0;
}
