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

Pilha* copia_pilha(Pilha* p){

    int cont = 0;
    int cont2 = 0;

    Pilha* y = pilha_cria();
    Pilha* c = pilha_cria();


    while(cont <=  p->n + 2){

    pilha_push(y,pilha_pop(p));

    cont++;

    }


    while(cont2 <= y->n + 2){

    pilha_push(c,pilha_pop(y));

    cont2++;

    }


    return c;
}

void imprime(Pilha* p){

    int i = 0;

    for(i = p->n - 1; i>=0;i--){

        printf("%f\n",p->vet[i]);

    }

}







