#include <stdio.h>
#include <stdlib.h>



void imp(char *st){
    if(st[0]=='\0'){
        return;
    }
    else{
        imp(&st[1]);
        printf("%c",st[0]);
    }
}


int main()
{
    char nome[50];
    printf("Digite um nome:");
    scanf("%s",&nome);
    imp(&nome);

    return 0;
}
