#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"
#define N 50

struct pilha{

	int n;
	float vet[N];
    int tam;
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


void pilha_push(Pilha* p,float v){


	if(p->n == N){

	printf("Pilha cheia");
	exit(1);
	}

	p->vet[p->n] = v;
	p->n++;
	p->tam = p->n;

}


void pilha_push2(Pilha* c, Pilha* p,float v){


	/*if(c->n == N){

	printf("Pilha cheia");

	}*/
    if(p->tam < 80){
	c->vet[c->n] = v;
	c->n++;
    p->tam++;

    }else{

        printf("\nAtingiu o máximo");

    }

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


void libera(Pilha* p){

    p->n = 0;

}

void imprime(Pilha* p){

    int i;

    for(i = p->n - 1; i >= 0;i--){

        printf("%2.f\n",p->vet[i]);
    }

}










