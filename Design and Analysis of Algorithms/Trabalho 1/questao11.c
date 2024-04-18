#include<stdlib.h> 
#include<stdio.h> 

/* HARTUR ALCANTARA - PAA - 2018.2
*  QUESTAO: Dado um vetor diga se ele possui um elemento marjoritario
*            if true, return the element.
*/
void intercala(int arr[], int p, int m, int r) { 
    
    int i, j, k;
    int n1 = m - p + 1; 
    int n2 =  r - m; 
    /* create temp arrays */
    int L[n1], R[n2]; 
  
    /* Copy data to temp arrays L[] and R[] */
    for (i = 0; i < n1; i++) 
        L[i] = arr[p + i];

    for (j = 0; j < n2; j++) 
        R[j] = arr[m + 1+ j]; 
  
    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray 
    j = 0; // Initial index of second subarray 
    k = p; // Initial index of merged subarray 
    while (i < n1 && j < n2) { 
        if (L[i] <= R[j]) { 
            arr[k] = L[i]; 
            i++; 
        } 
        else{ 
            arr[k] = R[j]; 
            j++; 
        } 
        k++; 
    } 
  
    /* Copy the remaining elements of L[], if there are any */
    while (i < n1) { 
        arr[k] = L[i]; 
        i++; 
        k++; 
    } 

    /* Copy the remaining elements of R[], if there are any */
    while (j < n2) { 
        arr[k] = R[j]; 
        j++; 
        k++; 
    } 
} 
  
/* l is for left index and r is right index of the 
   sub-array of arr to be sorted */
void mergeSort(int array[], int p, int r) { 
    if (p < r) { 
        // Same as (l+r)/2, but avoids overflow for 
        // large l and h 
        int q = p + (r-p)/2; 
        // Sort first and second halves 
        mergeSort(array, p, q); 
        mergeSort(array, p+1, r); 
        intercala(array, p, q, r); 
    }
    //return array[1];
} 

void printArray(int A[], int array_length) { 
    int i; 
    for (i=0; i < array_length; i++) 
        printf("%d ", A[i]); 
    printf("\n"); 
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
    mergeSort(array, 0, n - 1); 
    printArray(array, n); // vetor ordenado
    printf("\n");
}