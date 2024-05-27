#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"

int main(){

	Pilha *p = pilha_cria();
    Pilha *c = pilha_cria();
    int t,i,j,y,u;

    printf("Quantos numeros deseja empilhar na Pilha 1?(Obs.: No maximo 50 | CAPACIDADE TOTAL 80):");
    scanf("%i",&t);

    if(t > 50){

        printf("Excedeu o maximo de numeros!!");
        exit(1);

    }else{

    for(i = 0; i < t;i++){

        scanf("%i",&j);
        pilha_push(p,j);            //Aqui estou passnado os valores para pilha_push comum

    }

}

    printf("Quantos numeros deseja empilhar na Pilha 2?(Obs.: No maximo 50 |CAPACIDADE TOTAL %i):",(80 - t));
    scanf("%i",&y);

    if(y > (80 - t)){

        printf("Excedeu o maximo de numeros!!");
        exit(1);
    }else{

    for(i = 0; i < y;i++){

        scanf("%i",&u);
        pilha_push2(c,p, u);          //Aqui temos uma pilha_push modificada que vai adicionar os valores em uma segunda pilha
                                    //Será adiciondo os valores de acordo com o tamanho da primeira pilha

    }
}
    printf("\n\nPilha 1\n");
    imprime(p);

    printf("\n\n");

    printf("Pilha 2\n");
    imprime(c);

    printf("\nTOTAL DE %i NUMEROS!!\n\n",t+y);

    printf("Desempilha %2.f da Pilha 2\n",pilha_pop(c));
    printf("Desempilha %2.f da Pilha 2\n\n",pilha_pop(c));

    printf("Desempilha %2.f da Pilha 1\n",pilha_pop(p));
    printf("Desempilha %2.f da Pilha 1\n\n",pilha_pop(p));


	return 0;
}
