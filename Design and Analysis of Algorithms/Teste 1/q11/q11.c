#include<stdlib.h> 
#include<stdio.h> 

#define double f = -INFINITY;




int find_majority_element(int arr[], int length);

int count(float *A, int inicio, int fim, float x)
{
    int i, cont = 0;
    for(i = inicio; i <= fim; i++)
    {
        if(A[i] == x) cont++;
    }
    return cont;
}


int question_11(float *A, int inicio, int fim) {

    if (inicio > fim) return 0;
    else if (inicio == fim) return A[inicio];
    else
    {
        int meio = (inicio + fim) / 2;

        float x = question_11(A, inicio, meio);
        float y = question_11(A, meio + 1, fim);

        if (x == y) return x;

        if (x > 0)
        {
            if (count(A, inicio, fim, x) > (fim - inicio + 1) / 2) return x;
        }
        if (y > 0)
        {
            if (count(A, inicio, fim, y) > (fim - inicio + 1) / 2) return y;
        }
        return 0;
    }
}

int main() {
    int *arr;
    arr = (int*) malloc(sizeof(int)*13);
    arr = { 12, 3, 1, 1, 3, 4, 2, 2, 9, 6, 2, 1, 2 };
    int
    
    int length = sizeof(arr)/sizeof(int);

    //int result = find_majority_element(arr, length);
    int result2;
    result2 = question_11(arr, 1, length);
    printf("Majoritary: %d\n", result2);
    
    //if (result == -1) {
      //  printf("None");
    //} 

    //else {
      //  printf("Majoritary: %d\n", result);
    //}
    return 0;
}

int find_majority_element(int arr[], int length) {

    if (length == 2) {
        if (arr[0] == arr[1]) {
            return arr[0];
        } 
        else {
            return -1;
        }
    } 
    else if (length == 1) {
        return arr[0];
    }

    int *leftHalf = arr;
    int *rightHalf = arr + length/2;

    int element1 = find_majority_element(leftHalf, length/2);
    //int element2 = find_majority_element(rightHalf, length/2);
    int element2 = find_majority_element(rightHalf, length - length/2);

    if (element1 == -1 && element2 >= 0) {
        return element2;
    } 
    else if (element2 == -1 && element1 >= 0) {
        return element1;   
    }

    if (element1 == element2) {
        return element1;
    } 
    else {
        return -1;
    }

}