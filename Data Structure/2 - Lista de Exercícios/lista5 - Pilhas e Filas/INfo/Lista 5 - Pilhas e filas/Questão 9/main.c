#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"

int main(){


	Pilha *p = pilha_cria();
    int x;

    printf("Digite o numero que voce deseja conveter:");
    scanf("%i",&x);
    printf("\n");
	pilha_push(p,x);

	imprime(p);



	return 0;
}
