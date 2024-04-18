#include <stdlib.h> 
#include <stdio.h> 



//IDEIA POSSO DIVIDIR NO ULTIMO PASSO FAZER UM IF PERGUNTANDO APOS
//TER FEITO TODAS RECURSOES E ESQ TA ORDENADO E DIR TA ORDENADO
//ASSIM EU SETO A POSICOES COM 0, CASO SEJA REPETIDO NO VETORAUX
//E POR FIM REMOVO OS 0'S

//Funcoes auxiliates


void printArray(int A[], int array_length) { 
    int i; 
    for (i=0; i < array_length; i++) 
        printf("%d ", A[i]); 
    printf("\n"); 
}
//new
void printArrayIndex(int A[],int ini, int fim, int array_length) { 
    int i; 
    for (i=ini; i <= fim; i++) 
        printf("%d ", A[i]); 
    printf("\n"); 
} 

void remove_element(int *array, int index, int length) {
   int i;
   for(i = index; i < length; i++) 
        array[i] = array[i + 1];
}

int verd(int *arr, int array_length, int x) {
    int i;
    for(i = 0; i < array_length; i++)
        if(arr[i] == x)    
            return 1;
    return 0;
} 



void merge(int vetor[], int comeco, int meio, int fim) {
    
    int i = comeco;
    int j = meio+1; 
    int tam = fim-comeco+1;
    
    printf("Novo array: ");
    printArrayIndex(vetor, comeco, fim, tam);
    //printArray(vetor, tam);
    printf("Indices - [ini:%d] - [meio:%d] - [fim:%d]\n", comeco, meio, fim);
    //printf("tam - %d\n",tam);
    

    int *vetAux;
    int k = 0;
    vetAux = (int*)malloc(tam * sizeof(int));

    while(i <= meio && j <= fim){
        //if(vetor[i] == -1){
          //  i++;
           // k--;
        //}
        //else if(vetor[j] == -1){
           // j++;
          //  k--;
        //}
        if(vetor[i] < vetor[j]) {
            vetAux[k] = vetor[i];
            i++;
        } 
        else if(vetor[j] == vetor[i]){
            vetor[j] = 0;
            //printf("Dir --%d\n ",vetor[j]);
            j++;
            vetAux[k] = vetor[i]; 
            i++; 
        }
        else {
            vetAux[k] = vetor[j];
            j++;
        }
        k++;
    }

    //printArray(vetAux, tam);
    //O PROBLEMA ESTÁ AQUI, OU SEJA, QUANDO ELE COLOCA O RESTANTE
    while(i <= meio){  //Caso ainda haja elementos na primeira metade
        
        int y, count=0;
        for(y=0; y<k; y++)
            if(vetAux[y] == vetor[i])    
                count = 1;
        
        if(count==1){
            i++;
        }
        else{
            vetAux[k] = vetor[i];
            k++;
            i++;
        }
        //}
    }
    while(j <= fim) {   //Caso ainda haja elementos na segunda metade
        
        int y, count=0;
        for(y=0; y<k; y++)
            if(vetAux[y] == vetor[j])    
                count = 1;
        
        if(count==1){
            j++;
        }
        else{
            vetAux[k] = vetor[j];
            k++;
            j++;
        }
    }

    printf("--NEW array: ");
    //printArrayIndex(vetAux, comeco, fim, tam);
    printArray(vetAux, k);
    printf("--Indices - [ini:%d] - [meio:%d] - [fim:%d]\n", comeco, meio, fim);
    //printArray(vetAux, k);
    printf("\n");

    for(k = comeco; k <= fim; k++){    //Move os elementos de volta para o vetor original
        vetor[k] = vetAux[k-comeco];
    }
    free(vetAux);
}

void mergeSort(int arr[], int p, int r){
    if (p < r) {
        int q = (r+p)/2;
        mergeSort(arr, p, q);
        mergeSort(arr, q+1, r);
        merge(arr, p, q, r);
    }
}

void main() { 
    int n , i;
	int *array;
    printf("Digite o tamanho do array:\n");
    scanf("%d",&n);
    array = (int*) malloc(sizeof(int)*n);
	
    printf("Array max element %d: \n", n);
	for(i=0; i<n; i++)
		scanf("%d", &array[i]);

    printArray(array, n); ///vetor recebido
    mergeSort(array, 0, n-1);
    printArray(array, n); ///vetor recebido

    for(i=0; i <n; i++){ //operacao para remocao dos 0's
        if(array[i] == 0 ) {
            remove_element(array, i , n-1);
            n--;
            i--;
        }
    }
    printf("Vetor sem os elementos repetidos: \n");
    printArray(array, n);
}

