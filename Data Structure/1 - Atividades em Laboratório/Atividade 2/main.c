#include <stdio.h>
#include <stdlib.h>

int* apareceu(int *v1, int n){
    int *vetor;
    vetor = (int*) malloc(sizeof(int)*10);
    int i, j;
    for(j=0;j<10;j++){
        vetor[j]=0;
    }
    for(i=0;i<n;i++){
        if(v1[i] == 0){
            vetor[0]++;
        }
        if(v1[i] == 1){
            vetor[1]++;
        }
        if(v1[i] == 2){
            vetor[2]++;
        }
        if(v1[i] == 3){
            vetor[3]++;
        }
        if(v1[i] == 4){
            vetor[4]++;
        }
        if(v1[i] == 5){
            vetor[5]++;
        }
        if(v1[i] == 6){
            vetor[6]++;
        }
        if(v1[i] == 7){
            vetor[7]++;
        }
        if(v1[i] == 8){
            vetor[8]++;
        }
        if(v1[i] == 9){
            vetor[9]++;
        }
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
