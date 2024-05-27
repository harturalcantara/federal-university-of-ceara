#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "indice.h"
#include "lista.h"

/*struct paginas{
    int pg;
    struct paginas *proxPagina;
};*/



Paginas* criaPaginasNull(){
    return NULL;
}

Paginas* inserirPaginaOrdenado(Paginas* novaPG, int pg){	
	Paginas *aux1 = novaPG;

	/*PROCESSO VERIFICA SE A PAGINA JA EXISTE*/
	while(aux1 != NULL){	
		if(aux1->pg == pg)
		{
			return novaPG;
		}
		aux1 = aux1->proxPagina;
	}

	/*INSERE ORDENADO NORMALMENTE*/
	Paginas *novo;
	Paginas *ant = NULL;
	Paginas *aux = novaPG;

	while(aux != NULL && aux->pg < pg)
	{
		ant = aux;
		aux = aux->proxPagina;
	}


	novo = (Paginas*)malloc(sizeof(Paginas));
	novo->pg = pg;

	if(ant == NULL)
	{
		novo->proxPagina = novaPG;
		novaPG = novo; 
	}
	else
	{
		novo->proxPagina = ant->proxPagina;
		ant->proxPagina = novo;
	}

	return novaPG;
}