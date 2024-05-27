#include <stdio.h>
#include <stdlib.h>	
#define troca(A, B)	A=A+B; B = A-B; A = A-B;
/*-------------------------------------------------------------------------*/
					/*ALGORITIMOS CRESCENTE RECURSIVOS*/
/*-------------------------------------------------------------------------*/
/*Bubble Sort Crescente Recursivo*/
/*
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
*/
/*Bubble Sort Crescente Recursivo --- OK*/
void bubbleSortRec(int n, int *v){
	int j;
	int troca=0;
	//n-1 porque ele vai pegar o vetor-1, e coloca o maior no final
	for(j=0;j<n-1;j++){

		if(v[j] > v[j+1]){
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


/*Insertion Sort Crescente Recursivo --- OK*/
void insertionSortRec(int n, int *v){
	int i,j,x;

	if(n > 1){
		insertionSortRec(n-1,v);
		x = v[n-1];

		for(i=n-2; i>=0 && v[i]> x; i--){

			v[i+1]=v[i];
		}

		v[i+1] = x;

	}
}


/*Selection Sort Crescente Recursivo*/

void selectionSortRec(int n, int i, int *v){
	int j, min, temp;

	if(i>=n-1){
		return;
	}

	min = i;

	for(j=i+1; j<n; j++){
		if(v[j]<v[min]){
			min = j;
		}
	}

	temp = v[i];
	v[i] = v[min];
	v[min] = temp;
	selectionSortRec(n, i+1,v);
}

/*-------------------------------------------------------------------------*/
					/*ALGORITIMOS DECRESCENTE RECURSIVOS*/
/*-------------------------------------------------------------------------*/
/*Bubble Sort Decrescente Recursivo --- OK*/
void bubbleSortDecRec(int n, int *v){
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
/*Insertion Sort Decrescente Recursivo --- OK*/
void insertionSortDecRec(int n, int *v){
	//printf("ESTOU NO INSERTION RECURSIVO\n");
	int i,j,x;
	if(n>1){
		insertionSortDecRec(n-1,v);
		x=v[n-1];
		for(i = n-2;i>=0 && v[i] < x; i--){
			v[i+1]=v[i];
		}
		v[i+1]=x;
	}
}


/*Selection Sort Decrescente Recursivo*/



/*-------------------------------------------------------------------------*/
						/*ALGORITIMOS CRESCENTE INTERATIVO*/
/*-------------------------------------------------------------------------*/
/*Bubble Sort Crescente --- OK*/
void bubbleSortInt(int n, int *v){
	int i, j, aux, k;

	k = n-1;
	for(i=0; i<n; i++){
		for(j=0; j<k; j++){

			if(v[j] > v[j+1]){
				aux = v[j];
				v[j] = v[j+1];
				v[j+1] = aux;
			}
		}
		k--;
	}

}
/*InsertionSort Crescente Interativo --- OK*/
void insertionSortInt(int n, int *v){
	int i, j, x;
	for(j=1;j<n;j++){
		x = v[j];
		for(i=j-1; i>=0; i--){
			if(x<v[i]){
				v[i+1] = v[i];	
			}
			
		}
		v[i+1] = x;
	}
}
/*SelectionSort Crescente Interativo --- OK*/
void selectionSortInt(int n, int *v){
	int i, j, min, x;
	for(i=0;i<n-1;i++){
		min = i;
		for(j=i+1;j<n; j++){
			if(v[j] < v[min])
				min = j;
		}
		x = v[i];
		v[i] = v[min];
		v[min] = x;
	}
}

/*-------------------------------------------------------------------------*/
						/*ALGORITIMOS DECRESCENTE INTERATIVO*/
/*-------------------------------------------------------------------------*/
/*BubbleSort Decrescente Interativo -- OK*/
void bubbleSortDecInt(int n, int *v){
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
/*InsertionSort Decrescente Interativo --- OK*/
void insertionSortDecInt(int n, int *v){
	int i, j, x;
	for(j=1;j<n;j++){
		x = v[j];
		for(i=j-1; i>=0 && x > v[i]; i--){
			v[i+1] = v[i];
		}
		v[i+1] = x;
	}
}

/*SelectionSort Decrescente Interativo --- OK*/
void selectionSortDecInt(int n, int *v){
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
									/*ALGORITIMOS MERGESORT INTERATIVO E RECURSIVO*/
			/*-------------------------------------------------------------------------*/
/*Funcao auxiliar para o MergeSort*/
void intercala1(int p, int q, int r, int *v) {
	int i, j, k,*w;
	w = (int*)malloc((r-p)* sizeof(int));
	i = p; j = q;
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
	for (i = p; i < r; ++i) {
	 v[i] = w[i-p];
	}
	free (w);
}

/*Funcao MergeSortRecursivo*/
void mergesort (int p, int r, int*v){
	if (p < r-1) {
		int q = (p + r)/2;
		mergesort (p, q, v);
		mergesort (q, r, v);	
		intercala1(p, q, r, v);
	}
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





			/*-------------------------------------------------------------------------*/
									/*ALGORITIMOS HEAPSORT CRESCENTE E DECRESCENTE --- OK*/
			/*-------------------------------------------------------------------------*/

	/*FUNCAO HEAP SORT CRESCENTE*/

//ESTA FUNCAO VAI DEIXAR O VETOR EM MODO HEAP, OU SEJA, DEIXA O CARA MAIOR maior que os seus filhos.
void constroiHeapMax(int m, int v[]){
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


void peneiraMax(int m, int v[]) {
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
void heapsortMax(int n, int v[]){
   int m,i;
   constroiHeapMax(n, v);//DEIXO OU MEU VETOR EM MODO HEAP COM MAXIMO

   for (m = n; m >= 2; --m) {
   		//printf("Chamo a troca, troco a 1 com a ultima\n");
       troca (v[1], v[m]);//TROCO O 1 com o ULTIMO
	   
	   //printf("Estou dentro da funcao heapsort\n");
	   //for(i=1;i<11;i++){
	     // printf("%d\n",v[i]);
	   //}
	  //printf("Chamo a funcao Peneira!!!\n");
      peneiraMax (m-1, v);//A FUNCAO PENEIRA VAI VER A 1 POSICAO, VER A POSICAO CORRETA DELE ONDE ELE FICA NE HEAP
   }
}

/*-------------------------------------------------------------------------*/
						/*FUNCAO HEAP SORT DECRESCENTE --- OK*/
/*-------------------------------------------------------------------------*/

void constroiHeapMin(int m, int v[]){
   int k;

   for (k = 1; k < m; ++k) {                   
      // v[1..k] é um heap
      int f = k+1;
      while (f > 1 && v[f/2] > v[f]) {
         troca (v[f/2], v[f]);          
         f /= 2;                        
      }
   }	
   /*

   printf("Estou dentro da funcao Constroi\n");
   int i;
   for(i=1;i<11;i++){
      printf("%d\n",v[i]);
   }
   */

}


void peneiraMin(int m, int v[]) {
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


void heapsortMin(int n, int v[]){
   int m;
   constroiHeapMin(n, v);/*DEIXO O MEU VETOR EM HEAP- ou seja, */ 

   for (m = n; m >= 2; --m) {

      troca (v[1], v[m]);
      peneiraMin (m-1, v);

   }
}

/*-------------------------------------------------------------------------*/
	/*ALGORITIMO QUICKSORT RECURSIVO*/
/*-------------------------------------------------------------------------*/

int separa(int p, int r, int *v) {
   int c, j,k,t;
   c = v[r];//varivel c é oo pivo
   j = p;//variavel j é o inicio

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


void quicksort_it (int v[], int p, int r){
   int j, *pilhap, *pilhar, t;

   pilhap = malloc ((r-p+1) * sizeof (int));
   pilhar = malloc ((r-p+1) * sizeof (int));

   pilhap[0] = p; 
   pilhar[0] = r; 
   t = 0; 
   
   while (t >= 0) {      
      p = pilhap[t]; r = pilhar[t]; 
      --t;
      if (p < r) {
         j = separa (p, r,v);  

         ++t; 

         pilhap[t] = p; 
         
         pilhar[t] = j-1; 
         ++t; 

         pilhap[t] = j+1; 

         pilhar[t] = r; 
      }
   }
}

/*-------------------------------------------------------------------------*/


int main(){
	int vetor[16]={0, 3, 11 ,2 ,5 ,17, 7, 13, 4,6,7,3,7,10,54,13};
	int i;

	printf("Vetor Normal:\n");
	for(i=0;i<16;i++){
		printf("%d\n",vetor[i]);
	}
		//insertionSortRec(16,vetor);
		quicksort_it(vetor,0,16);
	printf("Vetor ordenado:\n");
	for(i=0;i<16;i++){
		printf("%d\n", vetor[i]);
	}
}