#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int conta_char(char *nome, char c){

int vezes=0, i=0;

    while(nome[i]!='\0'){
        if(nome[i]==c){
            vezes++;
        }
        i++;
    }
    return vezes;
}


int main()
{
    char nome[50];
    char x;
    int result;
    fgets(nome,50,stdin);
    scanf("%c",&x);


    result = conta_char(&nome, x);

    printf("PARECEU %d\n",result);






    return 0;
}
