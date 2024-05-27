#include <stdio.h>
#include <stdlib.h>
#include "ordenacaoVetor.h"

#define troca(a,b)	a = b+a; b = a-b; a = a-b;




/*------------------------------------------------------------------------------------------------*/
/*--------------------------------Funções auxiliares----------------------------------------------*/
/*------------------------------------------------------------------------------------------------*/

void imprimirVetor(int n, int *v){
	int i;
	for(i=0;i<n;i++){
		printf("[%d]\n",v[i]);
	}
	printf("\n");
}

/*------------------------------------------------------------------------------------------------*/
/*---------------------Algoritimos de Ordenação Elementar Crescentes Recursivos-------------------*/
/*------------------------------------------------------------------------------------------------*/

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
			//imprimirVetor(n, v);
			bubbleSortRec(n-1,v);
		}
	}
}


/*Insertion Sort Crescente Recursivo */
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







int i=0;

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
	//i++;
	selectionSortRec(n,i+1,v);
}

void selectionCallRec(int n, int *v){
	selectionSortRec(n ,0, v);
}


/*------------------------------------------------------------------------------------------------*/
/*---------------------Algoritimos de Ordenação Elementar Crescentes Interativos------------------*/
/*------------------------------------------------------------------------------------------------*/

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
/*insertionSort Crescente Interativo --- OK*/
void insertionSortInt(int n, int *v){
	int i, j, x;

	for(j=1;j<n;j++){
		x = v[j];
		for(i=j-1;i>=0 && v[i] > x; i--){
			v[i+1] = v[i];
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

/*------------------------------------------------------------------------------------------------*/
/*---------------------Algoritimos de Ordenação MergeSort Crescentes Int e Rec--------------------*/
/*------------------------------------------------------------------------------------------------*/

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
void mergeSortRec(int p, int r, int *v){
	if (p < r-1) {
		int q = (p + r)/2;
		mergeSortRec(p, q, v);
		mergeSortRec(q, r, v);	
		intercala1(p, q, r, v);
	}
}

/*Funcao MergeSortInterativo*/
void mergeSortInt(int n, int *v){

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

/*------------------------------------------------------------------------------------------------*/
/*----------------------Algoritimos de Ordenação HeapSort Crescentes Int e Rec--------------------*/
/*------------------------------------------------------------------------------------------------*/

	/*FUNCAO HEAP SORT CRESCENTE*/
void constroiHeapMax(int m, int v[]){//ESTA FUNCAO VAI DEIXAR O VETOR EM MODO HEAP, OU SEJA, DEIXA O CARA MAIOR maior que os seus filhos.
   int k; 
   for (k = 1; k < m; ++k) {                   
     
      int f = k+1;  // v[1..k] é um heap
      while (f > 1 && v[f/2] < v[f]) {  //---APOS && verifico QUAL E O MAIOR PARA COMPARAR COM PAI 
         
         troca (v[f/2], v[f]);          //SE FOR EU VOU TROCAR
         f /= 2; // FICO DIVIDINDO F, PARA CHEGAR ATE 1, eu nao vejo 1 porque ele e pai e raiz!!
                                
      }
   }
   /*
   printf("Estou dentro da funcao Constroi - CORRETO\n");
   int i;
   for(i=1;i<11;i++){
		printf("%d\n",v[i]);
	}*/
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


   /*
   printf("Estou dentro da funcao Peneira\n");
   int i;
   for(i=1;i<11;i++){
      printf("%d\n",v[i]);
   }
   */

}

void heapSortRec(int n, int *v){
   int m,i;

   constroiHeapMax(n, v);/*Deixo o meu vetor em uma Heap de máximo*/

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

void heapSortInt(int n, int *a) {

   int i = n / 2, filho, t;
   int pai;

    while(1) {

        if (i > 0) {
          i--;
          t = a[i];
      	} 
      	else {
          n--;
          
          if (n == 0) 
          	return;
          
          t = a[n];
          
          a[n] = a[0];
      	}
      
      	pai = i;
      	filho = i * 2 + 1;
      
      	while (filho < n) {
          	if ((filho + 1 < n)  &&  (a[filho + 1] > a[filho]))
              filho++;

          	if (a[filho] > t) {
            	a[pai] = a[filho];
             	pai = filho;
             	filho = pai * 2 + 1;
          	}
          	else {
             	break;
          	}
     	}

      	a[pai] = t;

   }
}



/*------------------------------------------------------------------------------------------------*/
/*---------------------Algoritimos de Ordenação QuickSort Crescentes Int e Rec--------------------*/
/*------------------------------------------------------------------------------------------------*/

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


void quickSortRec(int p, int r, int *v){
   int j;                         // 1
   if (p < r) {                   // 2
      j = separa (p, r, v);       // 3
      quickSortRec (p, j-1, v);      // 4
      quickSortRec (j+1, r, v);      // 5
   }
}


void quickSortInt (int v[], int p, int r){

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



void mergeCallRec(int tam, int *v){
	mergeSortRec(0, tam, v);
}

void quickCallInt(int tam, int *v){
	quickSortInt(v, 0, tam);
}

void quickCallRec(int tam, int *v){
	quickSortRec(0, tam, v);
}


/*-------------------------------------------------------------------END-----------------------------------------------------------*/


/*----------------------------------------------Outros algoritimos feitos para fazer comarações------------------------------------*/

/*Bubble Sort Crescente Recursivo*/

void bubbleSortRecSeg(int *v, int n){
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





/*Selection Sort segunda implementação*/
void selectionSortSeg(int* v, int n){
    int i, j, menor, troca;

    for(i=0; i<n; i++){

        menor = i;

        for(j=i+1; j < n;j++){
            if(v[j] < v[menor]){
                menor = j;
            }
        }
        if(i != menor){
            troca = v[i];
            v[i] = v[menor];
            v[menor] = troca;
        }
    }
}

/*Bubble Sort segunda implementação*/
void bubbleSortSeg(int *v, int n){
    int i, continua,aux, fim = n;
    do{
        continua =0;
        for(i=0; i<fim-1; i++){
            if(v[i]>v[i+1]){
                aux = v[i];
                v[i] = v[i+1];
                v[i+1] = aux;
                continua = i;
            }
        }
        fim--;
    }while(continua !=0 );
}


/*Insertion Sort segunda implementação*/
void insertionSortSeg(int* v, int n){
    int i,j,aux;
    for(i=0; i<n; i++){
        aux = v[i];
        for(j=i; (j>0)&&(aux < v[j-1]); j--){//Voltando os indice j e copiando os elementos para frente 
            v[j] = v[j-1];
        }
        v[j] = aux;

    }
}	


/*Heap sort uma segunda implementação*/

void heapSortSeg(int* v, int n){

    int i, aux;
    /*Cria heap apartir dos dados*/
    for(i=(n-1)/2; i>=0; i--){
        criaHeapSeg(v,i , n-1);
    }   


    for(i=n-1; i >= 1; i--){
        /*Pega o maior elemento da heap
        e coloca na posição correspondente no array*/
        aux = v[0];
        v[0] = v[i];
        v[i] = aux;

        criaHeapSeg(v,0,i-1); //Reconstruir heap
    }

}



/*CriaHeap Segunda implementação*/

void criaHeapSeg(int *vet, int i, int f ){
    int aux = vet[i]; //Posição PAI

    int j = i*2+1; //filho


    while(j <= f ){
        if(j < f){
            if(vet[j] < vet[j+1]){ /*Pai tem dois filhos. Quem é o maior*/

                j=j+1;
            }
        }
        if(aux < vet[j] ){ /*FILHO maior que o PAI?*/
            vet[i] = vet[j];//FILHO se torna PAI
            i = j;
            j = 2 * i +1;   //Repetir o processo
        }else{
            j = f + 1;
        }
    }
    vet[i] = aux; //Antigo PAI ocupa lugar do último filho analisado 

}



/*Essa é a melhor implementação? Daria para tornar essa implementação mais eficiente? Tente responder essas poerguntas no relátório*/
void bubbleSort(int n, int *v){
	int i, j, aux,k;
	k=n-1;
	for(i=0;i<n;i++){
		for(j=0;j<k; j++){
			if(v[j] > v[j+1]){
				aux = v[j];
				v[j] = v[j+1];
				v[j+1] = aux;
			}
		}
		k--;
	}
}

/*Essa é a melhor implementação? Daria para tornar essa implementação mais eficiente? Tente responder essas poerguntas no relátório*/
void insertionSort(int n, int *v){
	int i, j, x;
	for(j=1;j<n;j++){
		x = v[j];
		for(i=j-1;i>=0 && v[i] > x; i--){
			v[i+1] = v[i];
		}
		v[i+1] = x;
	}
}

/*Essa é a melhor implementação? Daria para tornar essa implementação mais eficiente? Tente responder essas poerguntas no relátório*/
void selectionSort(int n, int *v){
	int i, j, min, x;
	for(i=0;i<n-1;i++){
		min = i;
		for(j=i+1;j<n; j++){
			if(v[j] < v[min]) min =j;
		}
		x = v[i];
		v[i] = v[min];
		v[min] = x;
	}
}