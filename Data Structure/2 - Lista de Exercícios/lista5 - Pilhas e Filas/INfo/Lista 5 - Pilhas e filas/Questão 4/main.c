#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.c"

int main(){

	Pilha *p = pilha_cria();
    Pilha *f = pilha_cria();

    pilha_push(p,1);
    pilha_push(p,2);
    pilha_push(p,3);
    pilha_push(p,5);


    pilha_push(f,1);
    pilha_push(f,2);
    pilha_push(f,3);
    pilha_push(f,5);


    if(compra_pilhas(p,f) == 1){

        printf("Sao iguais");

    }else{

        printf("Sao diferentes");

    }


	return 0;
}
