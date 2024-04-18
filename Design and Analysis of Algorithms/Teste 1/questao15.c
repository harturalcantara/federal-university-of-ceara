
#include<stdlib.h> 
#include<stdio.h> 
/* HARTUR ALCANTARA - PAA - 2018.2
*  QUESTAO: REMOVER ELEMENTOS DULICADOS O VETOR EM TEMPO O(N LOG N)
*/

// Merges two subarrays of arr[]. 
// First subarray is arr[l..m] 
// Second subarray is arr[m+1..r] 
void merge(int arr[], int l, int m, int r) { 
    int i, j, k; 
    int n1 = m - l + 1; 
    int n2 =  r - m; 
    /* create temp arrays */
    int L[n1], R[n2]; 
  
    /* Copy data to temp arrays L[] and R[] */
    for (i = 0; i < n1; i++) 
        L[i] = arr[l + i]; 
    for (j = 0; j < n2; j++) 
        R[j] = arr[m + 1+ j]; 
  
    /* Merge the temp arrays back into arr[l..r]*/
    i = 0; // Initial index of first subarray 
    j = 0; // Initial index of second subarray 
    k = l; // Initial index of merged subarray 
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
  
    /* Copy the remaining elements of L[], if there 
       are any */
    while (i < n1) { 
        arr[k] = L[i]; 
        i++; 
        k++; 
    } 
  
    /* Copy the remaining elements of R[], if there 
       are any */
    while (j < n2) 
    { 
        arr[k] = R[j]; 
        j++; 
        k++; 
    } 
} 
  
/* l is for left index and r is right index of the 
   sub-array of arr to be sorted */
void mergeSort(int arr[], int l, int r) { 
    if (l < r) 
    { 
        // Same as (l+r)/2, but avoids overflow for 
        // large l and h 
        int m = l+(r-l)/2; 
  
        // Sort first and second halves 
        mergeSort(arr, l, m); 
        mergeSort(arr, m+1, r); 
  
        merge(arr, l, m, r); 
    } 
} 
  
/* UTILITY FUNCTIONS */
void printArray(int A[], int array_length) { 
    int i; 
    for (i=0; i < array_length; i++) 
        printf("%d ", A[i]); 
    printf("\n"); 
} 

void remove_element(int *array, int index, int array_length) {
   int i;
   for(i = index; i < array_length-1; i++) {
        //printf("%d ", array[i]);
        array[i] = array[i + 1];
        //printf("%d\n", array[i]);
   }
}


void main() { 
    int n , i;
	int *array;
    printf("Digite o tamanho do array");
    scanf("%d",&n);
	array = (int*) malloc(sizeof(int)*n);
	
    printf("Digite os elementos do vetor no max %d ", n);
	for(i=0; i<n; i++){
		scanf("%d ", &array[i]);
	}
    printArray(array, n);




    int arr[] = {12, 11, 13, 5, 6, 7}; 
    int arr_size = sizeof(arr)/sizeof(arr[0]); 
    //int i;
    //printf("\nArray is: \n"); 
    //printArray(arr, arr_size); 
    printArray(arr, arr_size); 
    mergeSort(arr, 0, arr_size - 1); 
    printArray(arr, arr_size); 
    for(i=0; i<arr_size; i++){
        if(arr[i]=arr[i+1]){
            remove_element(arr, i, arr_size);
            arr_size = sizeof(arr)/sizeof(arr[0]); 
        }
    }
    printArray(arr, arr_size); 

    /*
    printf("\nSorted array is: \n"); 
    printArray(arr, arr_size); 

    printf("\nRemove 0 Array: \n"); 
    remove_element(arr, 0, arr_size);
    arr_size = sizeof(arr)/sizeof(arr[0]); 

    printArray(arr, arr_size); 
    */
} 
