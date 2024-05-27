#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"
#include "operacoes.h"

#define n 60

#define for(a,b) for(a = 0; a < b; a++)

int main(){

	Pilha *p;
	int j;
	p = p_cria();


	char string[10];
	printf("Digite um nome de 60 caracteres!\n");
	scanf("%s",string);
	//string = '\0';

	int i=0;
	while(string[i]!='\0'){
		p_push(p,string[i]);
		i++;
	}	

	//p_push(p,j);


	//printf("%d\n", getTopo(p));

	/*
	imprime(p);
	printf("\n");

	imprimeReversa(p);
	printf("\n");

	elimina(p,3);
	imprime(p);
	*/

	Pilha* aux1 = p_cria();
	Pilha* aux2 = p_cria();
	/*
	imprime(p);
	minusculoMaiusculo(p,aux1,aux2);
	printf("Letra maiusculas:\n");
	imprime(aux1);
	printf("Letra minusculas:\n");
	imprime(aux2);
	printf("Pilha:\n");
		imprime(p);
	*/
	palindroma(p);

	/*
	while(!p_vazia(p))
	{
		printf("%d \t",p_pop(p));
	}
	p_libera(p);
	*/
	return 0;

}