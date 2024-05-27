#include <stdio.h>
#include <stdlib.h>


int separa(int p, int r, int *v) {
   int c, j,k,t;
   c = v[r];//varivel c é oo pivo
   j = p;

   for(k=p; k<r; k++){
      if(v[k] <= c){
         t=v[j];
         v[j] = v[k];
         v[k] = t;
         j++;
      }
   }
   v[r] = v[j];
   v[j] = c;
   return j;
}


void quicksort(int p, int r, int *v){
   int j;                         // 1
   if (p < r) {                   // 2
      j = separa (p, r, v);       // 3
      quicksort (p, j-1, v);      // 4
      quicksort (j+1, r, v);      // 5
   }
}

void imprimirVetor( int vetor[], int n ){
    int i;
    for ( i = 0; i < n; ++i ){
        printf( "%d ",vetor[i]);
    }
    printf("\n");
}


int main(){

	int vetor[]={3,546,456,233,23,54,23,2,43,53};
   printf("Vetor Recebido:\n");
   imprimirVetor(vetor,10);

	quicksort(0,10,vetor);

   printf("Vetor Ordenado:\n");
   imprimirVetor(vetor, 10);

}