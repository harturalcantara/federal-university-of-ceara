#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int conta_vogais(char *str){
    int i, j,cont=0;
    char vogais[5]={'a','e','i','o','u'};
    for(i=0;i<50;i++){
        for(j=0;j<5;j++)
            if(str[i]== vogais[j]){
                cont++;
            }
    }
    return cont;
}

int main(){
    char nome[50];
    scanf("%s",&nome);
    int result;
    result = conta_vogais(nome);

    printf("Tem %d vogais",result);

    return 0;
}
