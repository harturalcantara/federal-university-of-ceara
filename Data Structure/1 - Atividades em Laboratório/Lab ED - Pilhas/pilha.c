#include <stdio.h>
#include <stdlib.h>
#include "pilha.h"

#define n 60


struct pilha{
	int topo;
	char v[n];
};


char getTopo(Pilha *p){
	return p->v[p->topo-1];
} 

Pilha* p_cria(){
	Pilha *p = (Pilha*)malloc(sizeof(Pilha));
	p->topo = 0;
	return p;
}

void p_push(Pilha *p, int v){	
	if(p->topo == n){
		printf("Erro! Pilha está cheia!\n");
		exit(1);
	}
	
	p->v[p->topo] = v;
	p->topo++;
}

char p_pop(Pilha *p){	
	
	if(p_vazia(p)){
		printf("Erro! Pilha está vazia!");
		exit(1);
	}

	char aux = p->v[p->topo-1];
	p->topo--;
	return aux;

}

int p_vazia(Pilha *p){

	return p->topo==0;
}

void p_libera(Pilha *p){
	free(p);
}