#include <stdio.h>
#include <stdlib.h>
#include "fila.h"


#define MAX 50




struct lista{

	float info;
	struct lista* prox;

};

struct fila{

	Lista* ini;
	Lista* fim;

};



Fila* f_cria(){

	Fila* f = (Fila*)malloc(sizeof(Fila));

	f->ini = NULL;
	f->fim = NULL;

	return f;

}

void f_inserir(Fila* f, float v){

	Lista* nova = (Lista*)malloc(sizeof(Lista));
	
	nova->info = v;
	nova->prox = NULL;

	if(f_vazia(f)){

		f->fim = nova;
		f->ini = nova;

	}
	else{

		f->fim->prox = nova;
		f->fim = nova;
	}

}

float f_retirar(Fila* f){

	float x;
	
	Lista* T;
	
	if(f_vazia(f)){
		printf("Fila vazia!\n");
		exit(1);
	}

	x = f->ini->info;

	T = f->ini;

	free(T);

	if(f->ini==NULL){

		f->fim=NULL;
		
	}
	return x;
}	

int f_vazia(Fila* f){
	return f->ini ==NULL;
}

void f_libera(Fila* f){
	Lista* aux = f->ini;
	while(aux!=NULL){
		Lista* T = aux;
		aux = aux->prox;
		free(T);
	}
	free(f);
}

int f_quantidade(Fila* f){
	int cont=0;
	Lista* aux = f->ini;
	while(aux!=NULL){
		cont++;
		aux=aux->prox;
	}
	return cont;
}

void imprimeFila(Fila *f){
	int i;
	float valor;
	for(i = 0; i < f_quantidade(f); i++){
		valor = f_retirar(f);
		printf("%1.f\n", valor);
		f_inserir(f, valor);
	}
}