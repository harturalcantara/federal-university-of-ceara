#include <stdio.h>
#include <stdlib.h>

int quantidadeCaractere(char *vetor, int n){
    int i=0, cont=0;
    while(vetor[i]!='\0'){
        i++;
    }
    return i;
}

int main()
{
    int resultado;    
    char nome[50];

    printf("\nDigite seu nome:");
    scanf("%s",nome);    
    resultado = quantidadeCaractere(nome,50);
    printf("\nTanto de caracteres %d\n", resultado);
    return 0;
}
