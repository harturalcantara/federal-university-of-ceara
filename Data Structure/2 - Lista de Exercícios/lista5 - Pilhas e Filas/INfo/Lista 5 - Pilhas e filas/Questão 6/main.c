#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"

int main(){

	Pilha *p = pilha_cria();

    fator(p,3960);

    imprime(p);

    libera(p);

	return 0;
}
