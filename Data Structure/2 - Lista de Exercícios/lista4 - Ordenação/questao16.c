
#include <stdio.h>
#include <stdlib.h>


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


int main(){
	int n;
	scanf("%d",&n);
	int *vetor;
	vetor = (int*)malloc(sizeof(int)*n);
	int i;
	printf("Vetor Recebido");
	for(i=0;i<n;i++){
		scanf("%d",&vetor[i]);
	}


	insertionSort(n,vetor);

	printf("Vetor Ordenado\n");
	for(i=0;i<n;i++){
		printf("%d\n",vetor[i]);
	}


}
