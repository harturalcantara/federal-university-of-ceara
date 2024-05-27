#include <stdio.h>
#include <stdlib.h>




int buscar(int *vet, int n){
    if(vet[0]==n){
        return 1;
    }
    if(vet[0]==n){
        return 0;
    }
    else{
        return buscar(&vet[1],n);
    }


}
int main()
{
    int n;
    printf("\nTamanho do vetor:");
    scanf("%d",&n);

    int *vetor;
    vetor = (int*)malloc(sizeof(int)*n);
    int i;
    printf("\nDigite numeros para o vetor:");
    for(i=0;i<n;i++){
        scanf("%d",&vetor[i]);
    }
    int k;
    printf("\nDigite numero para achar: ");
    scanf("%d",&k);
    printf("\nResultado 1 se achou, 0 se nao: %d", buscar(vetor,k));

    return 0;
}
