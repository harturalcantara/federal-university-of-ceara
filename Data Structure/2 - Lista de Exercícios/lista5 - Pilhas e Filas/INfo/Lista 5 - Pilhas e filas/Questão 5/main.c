#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"

int main(){

	float u;

	Pilha *p = pilha_cria();

	Fila* f = fila_cria();

	Fila* aux = fila_cria();

	fila_insere (f, 2);
	fila_insere (f, 9);
	fila_insere (f, 7);
	fila_insere (f, 5);

	fila_imprime(f);


	printf("\n\n\n");

	pilha_push(p, fila_retira (f));	
	pilha_push(p, fila_retira (f));
	pilha_push(p, fila_retira (f));
	pilha_push(p, fila_retira (f));

	fila_insere (aux,pilha_pop(p));
	fila_insere (aux,pilha_pop(p));
	fila_insere (aux,pilha_pop(p));
	fila_insere (aux,pilha_pop(p));

	fila_imprime(aux);

	return 0;
}
