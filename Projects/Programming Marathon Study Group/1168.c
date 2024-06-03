#include <stdio.h>
#include <stdlib.h>
#include <string.h>
int main()
{
    char numero[10000];
    int test = 0;
    int i,j, tam, cont;

    scanf("%d",&test);
    if (1 >= test <= 1000){
        for(i=0;i<test;i++){
            scanf("%s",&numero);
            tam = strlen(numero);
            cont = 0;
            for(j=0;j<tam;j++){
                if(numero[j] == '1'){
                    cont = cont + 2;
                }
                if(numero[j] == '2'){
                    cont = cont + 5;
                }
                if(numero[j] == '3'){
                    cont = cont + 5;
                }
                if(numero[j] == '4'){
                    cont = cont + 4;
                }
                if(numero[j] == '5'){
                    cont = cont + 5;
                }
                if(numero[j] == '6'){
                    cont = cont + 6;
                }
                if(numero[j] == '7'){
                    cont = cont + 3;
                }
                if(numero[j] == '8'){
                    cont = cont + 7;
                }
                if(numero[j] == '9'){
                    cont = cont + 6;
                }
                if(numero[j] == '0'){
                    cont = cont + 6;
                }
            }
            printf("%d leds\n", cont);
        }//NUMERO DE TESTE
    }//IF DE CONDICAO;
    return 0;
}
