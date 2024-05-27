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


int compra_pilhas(Pilha* p,Pilha* c){

    Pilha* b = pilha_cria();
    float aux1;
    float aux2;
    int i = 0;
    float r;
    if(p->n != c->n){

        printf("As pilhas diferentes!!\n");
         exit(1);
    }else{

        while(i < p->n){

            aux1 = pilha_pop(p);
            aux2 = pilha_pop(c);

            if(aux1 == aux2){

                pilha_push(b,aux1);
                pilha_push(b,aux2);
            }

            i++;
        }

    }

    if(p->n + c->n == b->n){

        return 1;

    }else{

        return 0;
    }

}







