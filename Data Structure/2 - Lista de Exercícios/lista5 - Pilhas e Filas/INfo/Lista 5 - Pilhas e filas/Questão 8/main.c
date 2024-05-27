#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"

int main(){

	Pilha *p = pilha_cria();
    Pilha *f = pilha_cria();
    Pilha *c = pilha_cria();

    pilha_push(p,3);
    pilha_push(p,3);
    pilha_push(p,3);
    pilha_push(p,5);

    imprime(p);

    printf("\n\n");

    c = copia_pilha(p);

    printf("Copia da pilha\n");
    imprime(c);

	return 0;
}
