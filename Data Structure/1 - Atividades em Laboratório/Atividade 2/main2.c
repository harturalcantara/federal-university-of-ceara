#include <stdio.h>
#include <stdlib.h>


int* apareceu(int *v1, int n){
    int *vetor;
    vetor = (int*) malloc(sizeof(int)*10);
    int i, j;
    for(j=0;j<10;j++){
        vetor[j]=0;
    }
    for(i=0;i<10;i++){
        vetor[v1[i]]++;
    }
    return vetor;


}




int main()
{
    int n, i;
    printf("Tamanho do vetor:");
    scanf("%d",&n);
    printf("\n");

    int *vet, *vetR;
    vet = (int*) malloc(sizeof(int)*n);
    vetR = (int*) malloc(sizeof(int)*10);

    for(i=0;i<n;i++){
        scanf("%d",&vet[i]);
    }

    vetR = apareceu(vet, n);

    for(i=0;i<10;i++){
        printf("Elemento %d = %d\n", i, vetR[i]);
    }
    free(vet);
    free(vetR);
    return 0;
}
