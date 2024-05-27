#include <stdio.h>
#include <stdlib.h>
#include "fila.h"

typedef struct fila Fila;
typedef struct lista Lista;

struct lista{
	int info;
	Lista* prox;
};

struct fila{
	Lista* inicio;
	Lista* fim;
};

Fila* fila_cria(){
	Fila* f = (Fila*)malloc(sizeof(Fila));
	f->inicio = NULL;
	f->fim = NULL;
	return f;
}

void fila_insere(Fila* f, int v){
	Lista* l = (Lista*)malloc(sizeof(Lista));
	l->info = v;
	l->prox = NULL;
	if(f->fim != NULL){
		f->fim->prox = l;
		f->fim = l;
	}else{
		f->inicio = l;
		f->fim = l;
	}
}

void fila_retira(Fila* f){
	Lista* l;
	int aux;
	if(fila_vazia(f)){
		printf("Fila vazia!");
		exit(1);
	}
	l = f->inicio;
	aux = l->info;
	f->inicio = l->prox;
	if(f->inicio == NULL){
		f->fim = NULL;
	}
	free(l);
//	return aux;
}

int fila_vazia(Fila* f){
	return f->inicio == NULL;
}

void fila_libera(Fila* f){
	Lista* p = f->inicio;
	while(p != NULL){
		Lista* aux = p->prox;
		free(p);
		p = aux;
	}
	free(f);
}

void fila_imprime(Fila* f){
	Lista* p;
	for(p = f->inicio; p != NULL; p = p->prox){
		printf("%d\n", p->info);
	}
}

Fila* fila_busca(Fila* f){


	Lista* l;

	for(l = f->inicio; l != NULL;l = l->prox){

		if(l->info < 0){

		l = lst_retira(f->inicio,l->info);

	}


}

	return f;
}


Lista* lst_retira(Lista *l, int v){
	Lista *ant = NULL;
	Lista *p = l;

	while(p!= NULL && p->info >= 0){
		ant = p;
		p = p->prox;
	}
	if(p == NULL) return p;
	if (ant == NULL) l = p->prox;
	else ant->prox = p->prox;
	free(p);

	return l;
}
