#include <stdio.h>
#include <stdlib.h>	
/*-------------------------------------------------------------------------*/
					/*ALGORITIMOS CRESCENTE RECURSIVOS*/
/*-------------------------------------------------------------------------*/
/*Bubble Sort Crescente Recursivo*/
void bubbleSortRec(int n, int *v){
	int i, j, aux, k;

	k = n-1;

	if(n>1){
	
		for(j=0; j<=k; j++){

			if(v[j] > v[j+1]){

				aux = v[j];
				v[j] = v[j+1];
				v[j+1] = aux;

				bubbleSortRec(n-1,v);	
			}
		}
	}
		k--;
}

/*Insertion Sort Crescente Recursivo*/
void insertionSortRec(int n, int *v){
	int i,j,x;

	if(n > 1){
		insertionSortRec(n-1,v);
		x = v[n-1];

		for(i=n-2; i>=0 && v[i] > x; i--){

			v[i+1]=v[i];
		}
		v[i+1] = x;
	}
}


/*Selection Sort Crescente Recursivo*/
void selectionSortRec(int n, int *v){
int min =0;
int i,x;
if(n>1){
	selectionSort(n-1,v);
	for(i= i+1;i< n;i++){
		if(v[i]<v[min]){
			min = i;
		}
	}
	X = vIj];
	v[I] = v[min];
	v[min]=x;
}
}
/*-------------------------------------------------------------------------*/
					/*ALGORITIMOS DECRESCENTE RECURSIVOS*/
/*-------------------------------------------------------------------------*/
void bubbleSortDecRec(int n, int *v){
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
			bubbleSortDecRec(n-1,v);
		}
	}
}

void insertionSortDecRec(int n, int *v){
	printf("ESTOU NO INSERTION RECURSIVO\n");
	int i,j,x;
	if(n>1){
		insertionSortDecRec(n-1,v);
		x=v[n-1];
		for(i = n-2;i>=0 && v[i]>x;i--){
			v[i+1]=v[i];
		}
		v[i+1]=x;
	}
}

/*Selection Sort Decrescente Recursivo*/



/*-------------------------------------------------------------------------*/
						/*ALGORITIMOS CRESCENTE INTERATIVO*/
/*-------------------------------------------------------------------------*/
/*Bubble Sort Crescente*/
void bubbleSort(int n, int *v){
	int i, j, aux, k;

	k = n-1;
	for(i=0; i<n; i++){
		for(j=0; j<k; j++){

			if(v[j] < v[j+1]){
				aux = v[j];
				v[j] = v[j+1];
				v[j+1] = aux;
			}
		}
		k--;
	}

}

/*-------------------------------------------------------------------------*/
						/*ALGORITIMOS DECRESCENTE INTERATIVO*/
/*-------------------------------------------------------------------------*/
/*BubbleSort Decrescente Interativo*/
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
/*InsertionSort Decrescente Interativo*/
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

/*SelectionSort Decrescente Interativo*/
void selectionSort(int n, int *v){
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


/*-------------------------------------------------------------------------*/


int main(){
	int vetor[]={13, 3, 11 ,2 ,5 ,17, 7, 13, 4,6,7,3,7,10,54,13};

}