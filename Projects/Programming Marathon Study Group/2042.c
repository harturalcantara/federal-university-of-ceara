#include <stdio.h>
#include <stdlib.h>

int main()
{
    char palavra[50];
    int i,j;
    fgets(palavra, 50, stdin);
    int cont =0;
    char vet[5]={'a','e','i','o','u'};


    char vogal[8];
    for(i=0;i<50;i++){
        for(j=50;j>=0;j--){
            if(palavra[i] == vet[i]){
                if(palavra[j] == vet[i]){
                    cont++;
                }
            }
        }
    }
    int veri=0;
    for(i=0;i<50;i++){
        if(palavra[i] == vet[i]){
                veri++;
        }
    }

    if(cont == veri)
        printf("S");
    else
        printf("N");

    return 0;


}

