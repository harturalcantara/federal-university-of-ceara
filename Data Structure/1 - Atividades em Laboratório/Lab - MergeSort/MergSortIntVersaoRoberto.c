
#include <stdio.h>
#include <stdlib.h>


void intercala1(int p, int q, int r, int *v) {

	int i, j, k,*w;

	w = (int*)malloc((r-p)* sizeof(int));

	i = p; 

	j = q;
	
	k = 0;

	while (i < q && j < r) {
		if (v[i] <= v[j]){
			w[k++] = v[i++];
		}
		else{
			w[k++] = v[j++];
		}  	
	}
	while (i < q){
		w[k++] = v[i++];
	}  
	while (j < r){
		w[k++] = v[j++];
	} 

	for (i = p; i < r; ++i){
		v[i] = w[i-p];
	}

	free (w);
}

void mergeSortInterativo(int n, int *v){

	int p,r,b;

	for(b=1; b<n; b=b*2){
		p=0;
		while(p<n	){
			r = p+2*b;
			if(r > n){
				r = n;
			}
			intercala1(p,p+b,r,v);
			p= p+2*b;//p=r
		}
	}
}

int main(){
	int vetor[10]={1,2,54,76,34,65,21,65,76,13};
	int i;
	for(i=0;i<10;i++){
		printf("%d\n", vetor[i]);
	}
	mergeSortInterativo(10,vetor);

	printf("Vetor organizado:\n");
	for(i=0;i<10;i++){
		printf("%d\n", vetor[i]);
	}

}