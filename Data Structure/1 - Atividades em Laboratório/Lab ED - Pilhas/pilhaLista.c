#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

#define n 60

struct lista
{	
	float v;
	struct lista *prox;
}; typedef struct lista Lista;


struct pilha{
	Lista *topo;
};

Pilha* p_cria(){

	Pilha *p = (Pilha*)malloc(sizeof(Pilha));

	p->topo = NULL;
	
	return p;
}

void p_push(Pilha *p, float v){

	Lista *l = (Lista*)malloc(sizeof(Lista));

	l->v = v;

	l->prox = p->topo;

	p->topo = l;

}

float p_pop(Pilha *p){

	if(p_vazia(p)){

		printf("Erro! Pilha está vazia!");
		exit(1);

	}

	float aux = p->topo->v;

	Lista *l = p->topo;

	p->topo = p->topo->prox;

	free(l);

	return aux;

}

int p_vazia(Pilha *p){

	return p->topo==NULL;

}

void p_libera(Pilha *p){

	Lista *l;

	while(p->topo != NULL){

		l = p->topo;
		p->topo = p->topo->prox;
		free(l);

	}

	free(p);

}