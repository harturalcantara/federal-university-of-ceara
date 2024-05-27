#include <stdio.h>
#include <stdlib.h>

void inverteordem(int *vet, int n)
{
    int aux;
    if (n == 1 || n == 0)
        return;
    else
    {
        aux = vet[0];
        vet[0] = vet[n - 1];
        //printf("----Vet[0]:%d\n",vet[0]);
        vet[n - 1] = aux;

        inverteordem(&vet[1], n - 2);
    }
}

int main()
{
    int d;
    printf("Digite o tamanho do vetor:");
    scanf("%d", &d);

    int *vet;
    vet = (int *)malloc(sizeof(int) * d);

    int i;
    printf("\nDigite valores do vetor:");
    for (i = 0; i < d; i++)
    {
        scanf("%d", &vet[i]);
    }

    inverteordem(vet, d);

    for (i = 0; i < d; i++)
    {
        printf("Inversao: [%d] ", vet[i]);
    }
    free(vet);
}
