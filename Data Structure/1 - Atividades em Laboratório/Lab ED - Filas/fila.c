
#include <stdio.h>
#include <stdlib.h>
#include "fila.h"


#define MAX 50

struct fila{
	int ini;
	int fim;
	float v[MAX];
};




Fila* f_cria(){

	Fila* f = (Fila*)malloc(sizeof(Fila));

	f->ini = -1;
	f->fim=0;
	
	return f;

}


void f_inserir(Fila* f, float v){

	if(f_quantidade(f) == MAX){
		
		printf("Fila cheia!\n");
		exit(1);

	}

	f->v[f->fim] = v;
	f->fim = (f->fim+1)%MAX;
	
	if(f->ini==-1){
		f->ini++;
	}
	
}

float f_retirar(Fila* f){

	if(f_vazia(f)){

		printf("Fila vazia!\n");
		exit(1);

	}

	float x = f-> v[f->ini];

	f->ini = (f->ini+1)%MAX;

	if(f->ini==f->fim){

		f->ini=-1;
		f->fim =0;

	}

	return x;
}

void f_libera(Fila* f){
	free(f);
}

int f_vazia(Fila *f){
	return f->ini==-1;
}

int f_quantidade(Fila* f){
	
	int qtd = (MAX - ((f->fim) - (f->ini))%MAX);
	return qtd;

}

