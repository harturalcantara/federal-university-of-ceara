#include <stdio.h>
#include <stdlib.h>


float somarecursiva(float *vetor, int tam, float soma) {
   printf("Auxiliar print = VETOR: %f\n", vetor[tam]);
   if (tam >= 0) {
    soma = soma + vetor[tam];
    printf("----Soma = %f -- Vetor posicao tam: %f\n", soma,vetor[tam]);
    return somarecursiva(vetor, tam-1, soma);
   }
   else{
    return soma;
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
    r = somarecursiva(num, 4, 0);

    printf("Soma: %.3f\n",r);
    return 0;
}

