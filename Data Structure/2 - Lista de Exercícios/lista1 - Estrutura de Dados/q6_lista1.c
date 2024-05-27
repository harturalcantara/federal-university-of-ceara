#include <stdio.h>
#include <stdlib.h>

void *minusculo(char *str){
    int i, j;
    for(i=0;i<10;i++){
        for(j=65;j<=90;j++){
            if(str[i] == j){
                str[i] = str[i] + 32;
            }
        }
    }
    printf("FUNCAO: %s", str);
}

int main()
{
    char nome[10];
    
    printf("DIGITE SEU NOME EM LETRA MAIUSCULA: ");
    fgets(nome, 10, stdin);
    minusculo(nome);
    return 0;
}
