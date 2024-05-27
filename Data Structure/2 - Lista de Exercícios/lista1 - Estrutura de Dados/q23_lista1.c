#include <stdio.h>
#include <stdlib.h>

int iguais(char *nome1, char *nome2){
    int i, j;
    int tam1,tam2,tam3, cont=0;

    tam1 = tamanho(nome1);
    tam2 = tamanho(nome2);
    if(tam1 != tam2){
        return 0;
    }

    for(i=0;i<tam1;i++){
        if(nome1[i] != nome2[i]){
            return 0;
        }
    }
    return 1;
}

int tamanho(char *nome){
    int i=0;
    while(nome[i]!='\0'){
        i++;
    }
    return i;
}

int main()
{
    char nome1[50];
    char nome2[50];
    int x;
    printf("Digite o 1 nome:");
    gets(nome1);
    fflush(stdin);
    printf("\nDigite o 2 nome:");
    gets(nome2);
    fflush(stdin);

    int f;
    f = iguais(nome1,nome2);
    if(f == 1){
        printf("IGUAL\n");
    }else
        printf("N IGUAL\n");
    return 0;
}


