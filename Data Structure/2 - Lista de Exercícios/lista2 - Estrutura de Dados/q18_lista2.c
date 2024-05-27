#include <stdio.h>
#include <stdlib.h>


float mediarecursiva(float *vetor, int tam, float soma) {
   printf("VETOR: %f\n", vetor[tam]);
   if (tam >= 0) {
    soma = soma + vetor[tam];
    printf("----Soma = %f -- Vetor posicao tam: %f\n", soma,vetor[tam]);
    return mediarecursiva(vetor, tam-1, soma);
   }
   else{
    return soma/5;
   }

}


int main()
{
    float num[5];
    int i;
    for(i=0;i<5;i++){
        scanf("%f",&num[i]);
    }
    float r;
    r = mediarecursiva(num, 4, 0);

    printf("MEDIA: %.3f\n",r);
    return 0;
}
