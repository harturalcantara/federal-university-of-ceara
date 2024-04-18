#include <stdlib.h> 
#include <stdio.h> 


int merge_count(int A[], int B[], int p,int q,int r);
int sort_count(int A[], int B[], int i,int j);


int main() {
    int arr1[] = { 12, 3, 1, 1, 3, 4, 2, 2, 9, 6, 2, 1, 2 };
    
    int length1 = sizeof(arr1)/sizeof(int);
    int length2 = sizeof(arr2)/sizeof(int);

    int c = sort_count(arr1, );

    //int result = find_majority_element(arr, length);

    //if (result == -1) {
      //  printf("None");
    //} 
    
   // else {
      //  printf("Majoritary: %d\n", result);
    //}
    return 0;
}

void merge(int vetor[], int comeco, int meio, int fim) {
    int com1 = comeco, com2 = meio+1, comAux = 0, tam = fim-comeco+1;
    int *vetAux;
    vetAux = (int*)malloc(tam * sizeof(int));

    while(com1 <= meio && com2 <= fim){
        if(vetor[com1] < vetor[com2]) {
            vetAux[comAux] = vetor[com1];
            com1++;
        } else {
            vetAux[comAux] = vetor[com2];
            com2++;
        }
        comAux++;
    }

    while(com1 <= meio){  //Caso ainda haja elementos na primeira metade
        vetAux[comAux] = vetor[com1];
        comAux++;
        com1++;
    }

    while(com2 <= fim) {   //Caso ainda haja elementos na segunda metade
        vetAux[comAux] = vetor[com2];
        comAux++;
        com2++;
    }

    for(comAux = comeco; comAux <= fim; comAux++){    //Move os elementos de volta para o vetor original
        vetor[comAux] = vetAux[comAux-comeco];
    }
    
    free(vetAux);
}

void mergeSort(int vetor[], int comeco, int fim){
    if (comeco < fim) {
        int meio = (fim+comeco)/2;

        mergeSort(vetor, comeco, meio);
        mergeSort(vetor, meio+1, fim);
        merge(vetor, comeco, meio, fim);
    }
}





int merge_count(int A[], int B[], int p,int q,int r){
    int i,j,k;
  
    int c;
  
    for(i=p; i<=q; i++)
        B[i] = A[i];
   
    for(j=q+1; j<=r; j++)
        B[r+q+1-j] = A[j];
   
    i = p;
    j = r;
    c = 0; 
  
    for(k=p; k<=r; k++){
        if(B[i] <= B[j]){
            A[k] = B[i];
            i = i+1;
        }
        else{
            A[k] = B[j];
            j = j-1;
            c = c + (q-i+1);
        }
    }
    return c;
}
 
 
 
int sort_count(int A[], int B[], int i,int j){
    int q;
    if(i >=j ) 
        return 0;
    else{
        q = (i+j)/2;
        return sort_count(A, B, i, q) +
        sort_count(A, B, q+1, j)+
        merge_count(A, B, i, q, j);  
    }   
  
}