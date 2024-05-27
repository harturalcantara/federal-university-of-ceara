#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

void buscar(int *menor, int *vetor, int x){

    if(x==0){
        return;
    }
    else if(*menor>vetor[0]){
        *menor=vetor[0];
    }
    else{
        buscar(menor, &vetor[1],x-1);
    }
}



int main()
{
    int vetor[5];
    int i, x, n;
    n=5;
    for(i=0;i<n;i++){
        scanf("%d",&vetor[i]);
    }
    x=INT_MAX;
    buscar(&x, vetor, n);
    printf("O MENOR = %d\n",x);

    return 0;
}
