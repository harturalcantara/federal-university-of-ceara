#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"

int main(){


	Pilha *p = pilha_cria();
    Pilha *c = pilha_cria();

	pilha_push(p,4);
	pilha_push(p,8);
	pilha_push(p,6);
	pilha_push(p,3);

	imprime(p);

	printf("\n\n\n");

    c = pilha_pop(p,2);// Retirando dois elementos

	imprime(c);



	return 0;
}
