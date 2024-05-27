#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int conta_letra(char *str, char c){
    int i, j,cont=0;
    char r;
    for(i=0;i<50;i++){
        if(str[i] == c){
            cont++;
        }
    }
    return cont;
}

int main()
{
    char nome[50];
    char a;
    int result;

    fgets(nome,50,stdin);
    scanf("%c",&a);

    result = conta_letra(nome, a);

    printf("Numero de letras: %d\n", result);
    return 0;
}
