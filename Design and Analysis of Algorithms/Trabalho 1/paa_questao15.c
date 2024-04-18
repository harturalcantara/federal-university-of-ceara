#include <stdlib.h> 
#include <stdio.h> 

/* HARTUR ALCANTARA - PAA - 2018.2
*  PROBLEMA: REMOVER ELEMENTOS DULICADOS O VETOR EM TEMPO O(N LOG N) */

void intercala(int arr[], int l, int m, int r) { 
    
    int i, j, k; 
    int n1 = m - l + 1; 
    int n2 =  r - m; 
    
    int *L, *R;
    L = (int*) malloc(sizeof(int)*n1);
    R = (int*) malloc(sizeof(int)*n2);
  
    for (i = 0; i < n1; i++) 
        L[i] = arr[l + i]; 
    for (j = 0; j < n2; j++) 
        R[j] = arr[m + 1+ j]; 
    
    //printf("Vetor L\n");
    //int c; 
    //for (c=0; c < i; c++) 
       // printf("%d ", L[c]); 
    //printf("\n"); 
    
    //printf("Vetor R\n");
    //int d; 
    //for (c=0; c < i; c++) 
       // printf("%d ", L[c]); 
    //printf("\n"); 

    i = 0; 
    j = 0; 
    k = l; 
    
    //remove_element(L, , i) 
    while (i < n1 && j < n2) {
        if (L[i] < R[j]) { 
            arr[k] = L[i]; 
            i++; 
        } 
        else if(R[j] == L[i]) {
            R[j] = -1;
            j++;
            arr[k] = L[i]; 
            i++; 
        }
        else { 
            arr[k] = R[j]; 
            j++;
        }
        k++;
    } 
    while (i < n1) { 
        arr[k] = L[i]; 
        i++; 
        k++;
    } 
    while (j < n2) { 
        arr[k] = R[j]; 
        j++; 
        k++; 
    } 
} 
  
/* p is for left index and r is right index of the 
   sub-array of arr to be sorted */
void mergeSort(int arr[], int p, int r) { 
    if (p < r) { 
        int m = p+(r-p)/2;
        mergeSort(arr, p, m); 
        mergeSort(arr, m+1, r); 
        intercala(arr, p, m, r); 
    } 
} 
  
void printArray(int A[], int array_length) { 
    int i; 
    for (i=0; i < array_length; i++) 
        printf("%d ", A[i]); 
    printf("\n"); 
} 

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

    printf("VETOR ORDENADO\n");
    printArray(array, n); // vetor ordenado
    printf("\n");
    /*
    int t=n;
    for(i=0; i<t; i++){
        if(array[i] == array[i+1]){
            remove_element(array, i, n);
            n= n-1;
            //array = (int *) realloc(array, n);
        }
    }
    printf("Vetor sem duplicacoes:");
    printArray(array, n); 
    */
} 

/*
void remove_element(array_type *array, int index, int array_length)
{
   int i;
   for(i = index; i < array_length - 1; i++) array[i] = array[i + 1];
}

Statically allocated arrays can not be resized. Dynamically allocated arrays can be resized with realloc(). This will potentially move the entire array to another location in memory, so all pointers to the array or to its elements will have to be updated. For example:

remove_element(array, index, array_length);  /* First shift the elements, then reallocate 
array_type *tmp = realloc(array, (array_length - 1) * sizeof(array_type) );
if (tmp == NULL && array_length > 1) {
   /* No memory available 
   exit(EXIT_FAILURE);
}
array_length = array_length - 1;
array = tmp;
*/