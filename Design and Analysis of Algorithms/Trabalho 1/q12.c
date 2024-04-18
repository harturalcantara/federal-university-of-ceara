#include <stdlib.h> 
#include <stdio.h> 


int merge_count(int A[], int B[], int p,int q,int r);
int sort_count(int A[], int B[], int i,int j);


int main() {
    int arr[] = { 12, 3, 1, 1, 3, 4, 2, 2, 9, 6, 2, 1, 2 };
    int length = sizeof(arr)/sizeof(int);

    int result = find_majority_element(arr, length);

    if (result == -1) {
        printf("None");
    } 
    
    else {
        printf("Majoritary: %d\n", result);
    }
    return 0;
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