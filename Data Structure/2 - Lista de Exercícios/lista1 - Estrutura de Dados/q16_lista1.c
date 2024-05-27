#include <stdio.h>
#include <stdlib.h>


int eprimo(int n){

    int i,j,k=0, cont=0;

        for(j=2;j<n;j++){
            if(n%j == 0){
                return 0;
            }
        }
        return 1;
}

int soma_primos(int *vetor, int n){
    int i;
    int acumulador=0;
    for(i=0;i<=n;i++){
        if(eprimo(vetor[i])==1){
            acumulador += vetor[i];
        }
    }
    printf("Acumulador = %d",acumulador);
}


int main()
{
    int d;
    int *n;
    printf("Digite tamanho do vetor \"n\":\n");
    scanf("%d",&d);
    n = (int*)malloc(sizeof(int)*d);

    int i;
    for(i=0;i<d;i++){
        printf("Digite um numero: \n");
        scanf("%d",&n[i]);
    }
    soma_primos(n,d);
    return 0;
}
