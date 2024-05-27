#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"
#define N 20


struct pilha{
	
	int n;
	float vet[N];

};

struct fila{

	int n;
	int ini;
	float vet[N];


};



Pilha* pilha_cria(){

	Pilha* p = (Pilha*)malloc(sizeof(Pilha));

	p->n = 0;


	return p;
}


void pilha_push(Pilha* p, float v){

	if(p->n == N){

	printf("Pilha cheia");
	exit(1);
	}

	p->vet[p->n] = v;
	p->n++;
}


float pilha_pop(Pilha* p){
        
	float v;	

	if(p == NULL){
	printf("Pilha vazia");
	exit(1);
	}	

	v = p->vet[p->n - 1];


	p->n--;

	return v;



}


Fila* fila_cria(){

	Fila* f = (Fila*)malloc(sizeof(Fila));
	f->n = 0;
	f->ini = 0;

	return f;
}




void fila_insere (Fila* f, float i){


	int fim;

	if(f->n == N){

	printf("Fila cheia");
	exit(1);
	}

	fim = (f->ini + f->n) % N;

	f->vet[fim] = i;
	f->n++;

}

float fila_retira (Fila* f){

	float v;

	if(f == NULL){
	
	printf("Fila vazia");
	exit(1);
	}

	v = f->vet[f->ini];
	f->ini = (f->ini + 1) % N;

	return v;
}

void fila_imprime(Fila *f){

	
	int p;

	for(p = f->ini; p < f->n;p++){


	printf("%f\n",f->vet[p]);


	}


}











