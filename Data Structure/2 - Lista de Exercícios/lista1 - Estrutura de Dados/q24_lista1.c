#include <stdio.h>
#include <stdlib.h>

int palindroma(char *nome1){
    int i, j=0;
    int tam1,tam2,cont=0;
    tam1 = tamanho(nome1);
    char reverso[tam1];

    for(i=tam1-1;i>=0;i--){
        reverso[j]=nome1[i];
        j++;
    }
    reverso[j]='\0';
    printf("INVERSO = [%s]\n",reverso);
    for(i=0;i<tam1;i++){
        if(nome1[i]!=reverso[i]){
            return 1;
        }
    }
    return 0;

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
    int x;
    printf("Digite o 1 nome:");
    gets(nome1);
    fflush(stdin);
    int f;
    f = palindroma(nome1);
    if(f==0){
        printf("DEU BOM");
    }else
        printf("DEU RUIM");
    return 0;
}



