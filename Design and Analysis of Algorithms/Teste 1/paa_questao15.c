#include <stdlib.h> 
#include <stdio.h> 

void merge(int vetor[], int comeco, int meio, int fim) {

    int i = comeco;
    int j = meio+1; 
    int k = 0;
    int tam = fim-comeco+1;

    int *vetAux;
    vetAux = (int*)malloc(tam * sizeof(int));

    while(i <= meio && j <= fim){
        
        if(vetor[i] == -1){
            i++;
            k--;
        }
        else if(vetor[j] == -1){
            j++;
            k--;
        }

        else if(vetor[i] < vetor[j]) {
            vetAux[k] = vetor[i];
            i++;
        } 
        else {
            //printf("%d == %d\n",R[j],L[i]);
            if(vetor[j] == vetor[i]){
                vetor[j] = -1;
                j++;
                vetAux[k] = vetor[i]; 
                i++; 
                //k--;
            }
            else {
                vetAux[k] = vetor[j];
                j++;
            }
        }
        k++;
    }


    while(i <= meio){  //Caso ainda haja elementos na primeira metade
        if(vetor[i] == -1){
            i++;
           // k--;
        }
        else{
            vetAux[k] = vetor[i];
            k++;
            i++;
        }
    }


    while(j <= fim) {   //Caso ainda haja elementos na segunda metade
        if(vetor[j] == -1){
            j++;
           // k--;
        }
        else {
            vetAux[k] = vetor[j];
            k++;
            j++;
        }
    }


    for(k = comeco; k <= fim; k++){    //Move os elementos de volta para o vetor original
        //if(vetAux[k-comeco] == -1)
          //  k--;
        //else
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



void printArray(int *array, int array_length) { 
    int i; 
    for (i=0; i < array_length; i++) 
        printf("%d ", array[i]); 
    printf("\n"); 
} 

void remove_element(int *array, int index, int array_length) {
   int i;
   for(i = index; i < array_length; i++) {
        array[i] = array[i + 1];
   }
}

//void target_element(int *array, int index) {
  //  array[index] = -1;
//}

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

    printf("tamanho n: %d", n);
    printf("Vetor sem os elementos repetidos: \n");
    printArray(array, n); // vetor ordenado
    printf("\n");

            
    printf("tamanho n: %d", n);
    int t=n;
    for(i=0; i<n; i++){
        if(array[i] == 0){
            remove_element(array, i, n);
            n--;
            i--;
            //t--;
        }
        printf("tamanho n: [%d]\n", n);
        printArray(array, n);
        //printf("%d")
    }
    printf("array sem elementos repetidos\n");
    printArray(array, n); // vetor ordenado
    printf("\n");
}