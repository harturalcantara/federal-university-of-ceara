#include<stdio.h>
#include<stdlib.h>
#include"PilhaLista.h"
#define N 20

struct pilha{

	int n;
	float vet[N];
	int num;

};


Pilha* pilha_cria(){

	Pilha* p = (Pilha*)malloc(sizeof(Pilha));

	p->n = 0;


	return p;
}


void pilha_push(Pilha* p, int v){

    p->num = v;

	if(p->n == N){

	printf("Pilha cheia");
	exit(1);
	}
    while(p->num >= 0 && p->num >= 1){

	p->vet[p->n] = converte(p,p->num);
	p->n++;

    }
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

    printf("Representacao em binario!\n");
    for(i = 0; i < p->n;i++){

        printf("%2.f",p->vet[i]);

    }

}

float converte(Pilha* p,int num){

    int total;
    float resto;

    if(p->num >= 1 && p->num >= 0){

      resto  = p->num%2;

      p->num = num / 2;

    }

        return resto;
}


