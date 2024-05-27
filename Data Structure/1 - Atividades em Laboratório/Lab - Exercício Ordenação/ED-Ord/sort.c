
#include <stdio.h>
#include <stdlib.h>
#include "sort.h"

void bubbleSort(int n, int *v){
	int i, j, aux,k;
	k=n-1;
	for(i=0;i<n;i++){
		for(j=0;j<k; j++){
			if(v[j] < v[j+1]){
				aux = v[j];
				v[j] = v[j+1];
				v[j+1] = aux;
			}
		}
		k--;
	}
}

void insertionSort(int n, int *v){
	int i, j, x;
	for(j=1;j<n;j++){
		x = v[j];
		for(i=j-1; i>=0 && x > v[i]; i--){
			v[i+1] = v[i];
		}
		v[i+1] = x;
	}
}

void selectionSort(int n, int *v){
	printf("Estou no selectSort!\n");
	int i, j, min, x;
	for(i=0;i<n-1;i++){
		min = i;
		for(j=i+1;j<n; j++){
			if(v[j] > v[min])
				min = j;
		}
		x = v[i];
		v[i] = v[min];
		v[min] = x;
	}
}

void bubbleSortRec(int n, int *v){
	printf("Estou no blolha Recursiva!\n");
	int j;
	int troca=0;
	//n-1 porque ele vai pegar o vetor-1, e coloca o maior no final
	for(j=0;j<n-1;j++){
		if(v[j]<v[j+1]){
			int aux = v[j];
			v[j] = v[j+1];
			v[j+1]=aux;
			troca=1;
		}
		if(troca!=0){
			bubbleSortRec(n-1,v);
		}
	}
}

void insertionSortRec(int n, int *v){
	printf("ESTOU NO INSERTION RECURSIVO\n");
	int i,j,x;
	if(n>1){
		insertionSortRec(n-1,v);
		x=v[n-1];
		for(i = n-2;i>=0 && v[i]>x;i--){
			v[i+1]=v[i];
		}
		v[i+1]=x;
	}
}

void selectionSortRec(int n, int *v){
	printf("Estou no selectSortRec!\n");
	int i, j, min, x;
	if(n>1){
		min = 0;
		for(i=min+1;i<n; i++){
			if(v[min] < v[i])
				min = j;
		}
		x = v[i];
		v[i] = v[min];
		v[min] = x;

	}		
	selectionSortRec(n-1, v);
}
