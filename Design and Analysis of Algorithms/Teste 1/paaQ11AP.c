#include<stdlib.h> 
#include<stdio.h> 

int count(int *A, int inicio, int fim, float x) {
    int i, cont = 0;
    for(i = inicio-1; i < fim; i++){
        if(A[i] == x) cont++;
    }
    return cont;
}

int marjo(int *A, int inicio, int fim) {

    if (inicio > fim) 
        return 0;
    else if (inicio == fim) 
        return A[inicio-1];
    else {
        int meio = (inicio + fim) / 2;
        //printf("meio - %d", meio);

        float x = marjo(A, inicio, meio);
        float y = marjo(A, meio + 1, fim);

        if (x == y) 
            return x;
        if (x > 0){
            if (count(A, inicio, fim, x) > (fim - inicio + 1) / 2) 
                return x;
        }
        if (y > 0) {
            if (count(A, inicio, fim, y) > (fim - inicio + 1) / 2) 
                return y;
        }
        return -1; //caso nao possua um elemento marjoritario.
    }
}

/* CASOS DE TESTES
// 1 -- RETORNO 1
// 7 -- RETORNO 7
//  
*/

void main() {
    int n , i;
	int *arr;
    printf("Digite o tamanho do array:\n");
    scanf("%d",&n);
    arr = (int*) malloc(sizeof(int)*n);
	
    printf("Array max element %d: \n", n);
	for(i=0; i<n; i++)
		scanf("%d", &arr[i]);

    //int length = sizeof(arr)/sizeof(int);
    //printf("%d",length);
    //int result2 = marjo(arr, 0, n-1);
    int result2 = marjo(arr, 1, n);
    printf("Majoritary: %d\n", result2);
    
}

