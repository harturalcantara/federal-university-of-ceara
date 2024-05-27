
#include <stdio.h>
#include <stdlib.h>
#define troca(A, B)	A=A+B; B = A-B; A = A-B;

/*
void troca(int *x, int *y){ 
   int temp;
   temp=*x;
   *x=*y;
   *y=temp;
}
*/
void constroiHeap (int m, int v[]){
   int k;

   for (k = 1; k < m; ++k) {                   
      // v[1..k] é um heap
      int f = k+1;
      while (f > 1 && v[f/2] > v[f]) {
         troca (v[f/2], v[f]);          
         f /= 2;                        
      }
   }
   printf("Estou dentro da funcao Constroi\n");
   int i;
   for(i=1;i<11;i++){
      printf("%d\n",v[i]);
   }

}


void peneira (int m, int v[]) {
   int f = 2;
   while (f <= m) {
      if (f < m && v[f] > v[f+1])  
         ++f;
      // f é o filho mais valioso de f/2
      if (v[f/2] <= v[f]) 
         break;
      troca (v[f/2], v[f]);
      f *= 2;
   }
}


void heapsort (int n, int v[]){
   int m;
   constroiHeap(n, v);/*DEIXO O MEU VETOR EM HEAP- ou seja, */ 

   for (m = n; m >= 2; --m) {

      troca (v[1], v[m]);
      peneira (m-1, v);

   }
}

int main(){
   /*Devo sempre comecar de 1 pois estou trabalhando com HEAP*/
	int i;
	int vetor[11]={0,61,7,6,43,32,565,32,65,76,34};//MEU VETOR TEM TAMANHO 10, ou seja, o valor 0 não conto no começo!!!
   printf("FUNCAO MAIN:\n");
	for(i=1;i<11;i++){
		printf("%d\n",vetor[i]);
	}

	heapsort(10,vetor);//VAI ORDENAR O VETOR

	
	printf("Vetor ordenado HeapSort:\n");
	for(i=1;i<11;i++){
		printf("%d\n",vetor[i]);
	}
}