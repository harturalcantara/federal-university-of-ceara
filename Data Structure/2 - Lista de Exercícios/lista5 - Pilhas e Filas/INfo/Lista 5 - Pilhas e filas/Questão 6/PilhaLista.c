#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"
#define N 50

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


void pilha_push(Pilha* p,float v){

    if(p->n == N){

        printf("Pilha cheia!!");
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


void libera(Pilha* p){

    p->n = 0;

}

void imprime(Pilha* p){

    int i;

    for(i = p->n - 1; i >= 0;i--){

        printf(" * %2.f",p->vet[i]);
    }

}

void fator(Pilha* p, int n){

    int i = 2;

    while(n > 1){

      if(n % i == 0){      //SE "i" FOR DIVISOR DE "n" IREMOS ARMAZENAR "i" NA PILHA

        n = n/i;
        pilha_push(p,i);

      }else{
                        ////SE "i" NAO FOR DIVISOR DE "n" INCREMENTAMOS "i"
        i++;

      }

    }

}









