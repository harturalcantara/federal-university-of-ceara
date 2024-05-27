#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"
#define N 20

struct pilha{

	int n;
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


Pilha* pilha_pop(Pilha* p,int tam){

    int i;

	if(p == NULL){
	printf("Pilha vazia");
	exit(1);
	}

	for(i = 0; i < tam;i++){

        p->n--;
	}

    return p;
}

void imprime(Pilha* p){

    int i;
    for(i = p->n - 1; i >= 0;i--){


        printf("%2.f\n",p->vet[i]);

    }

}


