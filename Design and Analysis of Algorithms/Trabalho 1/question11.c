#include <stdlib.h> 
#include <stdio.h> 

int intercala(int vetor[], int comeco, int meio, int fim, int m1[], int m2[]) {

    int i = comeco; 
    int j = meio+1; 
    int k = 0;
    int tam = fim-comeco+1;

    int *vetAux;
    vetAux = (int*)malloc(tam * sizeof(int));

    while(i <= meio && j <= fim){
        if(vetor[i] < vetor[j]) {
            vetAux[k] = vetor[i];
            i++;

        } 
        else {
            vetAux[k] = vetor[j];
            j++;
        }
        k++;
    }


    while(i <= meio){  //Caso ainda haja elementos na primeira metade
        vetAux[k] = vetor[i];
        k++;
        i++;
    }


    while(j <= fim) {   //Caso ainda haja elementos na segunda metade
        vetAux[k] = vetor[j];
        k++;
        j++;
    }

    for(k = comeco; k <= fim; k++){    //Move os elementos de volta para o vetor original
        vetor[k] = vetAux[k-comeco];
    }

    //ACRESCENTANDO
    if(m1 != NULL){
        int cont1=0;
        int i;
        for(i=0; i< k; i++){
            if(vetor[i] == *m1){
                cont1++;
            }
        }

        if(cont1 >= (meio+k)/2)
            return *m1;
        
    }

    free(vetAux);
    return -1;
}

int mergeSort(int arr[], int p, int r){
    int *m1;
    int *m2;
    int *m3;
    
    if (p < r) {
        int q = (r+p)/2;
        *m1 = mergeSort(arr, p, q);
        *m2 = mergeSort(arr, q+1, r);
        *m3 = intercala(arr, p, q, r , m1, m2);
    }
    return *m3;
}



void printArray(int A[], int array_length) { 
    int i; 
    for (i=0; i < array_length; i++) 
        printf("%d ", A[i]); 
    printf("\n"); 
} 
/*
void remove_element(int *array, int index, int array_length) {
   int i;
   for(i = index; i < array_length-1; i++) {
        if(array[i] == array[i + 1]){
           // target_element(array, i);
        }
        //array[i] = array[i + 1];
   }
}

void target_element(int *array, int index) {
    array[index] = -1;
}*/

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

    printf("VETOR ORDENADO\n");
    printArray(array, n); // vetor ordenado
    printf("\n");
}