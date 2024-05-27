
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

//ESTA FUNCAO VAI DEIXAR O VETOR EM MODO HEAP, OU SEJA, DEIXA O CARA MAIOR maior que os seus filhos.
void constroiHeap (int m, int v[]){
   int k; 
   for (k = 1; k < m; ++k) {                   
      // v[1..k] é um heap
      int f = k+1;
      while (f > 1 && v[f/2] < v[f]) {  //---APOS && verifico QUAL E O MAIOR PARA COMPARAR COM PAI 
         troca (v[f/2], v[f]);          //SE FOR EU VOU TROCAR
         f /= 2;                        // FICO DIVIDINDO F, PARA CHEGAR ATE 1, eu nao vejo 1 porque ele e pai e raiz!!
      }
   }

   printf("Estou dentro da funcao Constroi - CORRETO\n");
   int i;
   for(i=1;i<11;i++){
		printf("%d\n",v[i]);
	}

}


void peneira (int m, int v[]) {
   int f = 2;
   while (f <= m) {//
      if (f < m && v[f] < v[f+1])  
      	++f;
      // f é o filho mais valioso de f/2
      if (v[f/2] >= v[f]) 
      	break;
      troca (v[f/2], v[f]);
      f *= 2;//Ele vai descer para verificar o restante da heap
   }



   printf("Estou dentro da funcao Peneira\n");
   int i;
   for(i=1;i<11;i++){
      printf("%d\n",v[i]);
   }
}

//O (n log n)
void heapsort (int n, int v[]){
   int m,i;
   constroiHeap(n, v);//DEIXO OU MEU VETOR EM MODO HEAP COM MAXIMO

   for (m = n; m >= 2; --m) {
   		printf("Chamo a troca, troco a 1 com a ultima\n");
       troca (v[1], v[m]);//TROCO O 1 com o ULTIMO
	   
	   printf("Estou dentro da funcao heapsort\n");
	   for(i=1;i<11;i++){
	      printf("%d\n",v[i]);
	   }
	  printf("Chamo a funcao Peneira!!!\n");
      peneira (m-1, v);//A FUNCAO PENEIRA VAI VER A 1 POSICAO, VER A POSICAO CORRETA DELE ONDE ELE FICA NE HEAP
   }
}

int main(){
	int i;
	int vetor[11]={0,61,7,6,43,32,565,32,65,76,34};//MEU VETOR TEM TAMANHO 10, ou seja, o valor 0 não conto no começo!!!
	printf("Estou na funcao MAIN:\n");
	for(i=1;i<11;i++){
		printf("%d\n",vetor[i]);
	}

	heapsort(10,vetor);//VAI ORDENAR O VETOR

	
	printf("Vetor ordenado HeapSort:\n");
	for(i=1;i<11;i++){
		printf("%d\n",vetor[i]);
	}
}