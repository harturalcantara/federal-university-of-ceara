#include <stdio.h>
#include <stdlib.h>

void intercala1(int p, int q, int r, int *v) {
	int i, j, k,*w;

	w = (int*)malloc((r-p)* sizeof(int));


	i = p; j = q;
	k = 0;
	while (i < q && j < r) {

		if (v[i] >= v[j]){
			w[k++] = v[i++];
		}
		else{
			w[k++] = v[j++];
		}  	
	}

	while (i < q){
		w[k++] = v[i++];
	}

	while (j < r)  w[k++] = v[j++];
	for (i = p; i < r; ++i)  v[i] = w[i-p];
	free (w);
}


void mergesort (int p, int r, int*v){
	if (p < r-1) {
		int q = (p + r)/2;
		mergesort (p, q, v);
		mergesort (q, r, v);	
		intercala1(p, q, r, v);
	}
}


int main(){
	int vetor[10]={1,2,54,76,34,65,21,65,76,13};
	int i;
	for(i=0;i<10;i++){
		printf("%d\n", vetor[i]);
	}
	mergesort(0,10,vetor);
	printf("Organizado:\n");
	for(i=0;i<10;i++){
		printf("%d\n", vetor[i]);
	}

}
