#include <stdio.h>
#include <stdlib.h>
#include "arvoreBusca.h"

struct arv{
	int v;
	struct arv* esq;
	struct arv* dir;
};

int vazia(Arv* a){

	return a==NULL;

}


Arv* inserir(Arv* a, int x){
	if(a==NULL){
		Arv* novo = (Arv*)malloc(sizeof(Arv));
		novo->v = x;
		novo->dir = NULL;
		novo->esq = NULL;
		return novo;
	}
	else{
		if (x<=a->v){
			a->esq = inserir(a->esq, x);
		}
		else
			a->dir = inserir(a->dir, x);
	}
	return a;
}

Arv* busca(Arv* a, int x){
	if(a==NULL){
		return NULL;
	}
	if(x > a->v){
		return busca((a->dir),x); 
	}
	else if(x < a->v){
		return busca(a->esq,x);
	}
	else{
		return a;
	}
}

Arv* retira(Arv* a, int x){
	if(a==NULL){
		return NULL;
	}
	else if(x > a->v)
		a->dir = retira(a->dir, x);
	else if(x < a->v)
		a->esq = retira(a->esq, x);
	else{
		if(a->esq == NULL && a->dir == NULL){
			free(a);
			return NULL;
		}
		else if(a->dir==NULL){
			Arv* T = a->esq;
			free(a);
			return T;
		}
		else if(a->esq==NULL){
			Arv* T = a->dir;
			free(a);
			return T;
		}
		else{
			Arv* T = a->esq;
			while(T->dir != NULL){
				T = T->dir; 
			}
			a->v = T->v;
			T->v = x;
			a->esq = retira(a->esq, x);
		}
	}
	return a;
}

void imprime(Arv* a){/*Em Ordem*/

	if(!vazia(a)){

		imprime(a->esq);
		printf("%d\n",a->v);
		imprime(a->dir);

	}
}


/*Lab da aula!*/
int igual(Arv* a, Arv* b){
	if ( a==NULL &&  b==NULL ){
		return 1;
	}
	else if(a->info != b->info){
		return 0;
	}
	else{
		
		igual(a->dir, b->dir);
		igual(a->esq, b->esq);

	}
}

int folhas(Arv* a){
	if(a == NULL)
		return 0;
	if(a->esq == NULL)
		return 1;
	else
		return folhas(a->esq) + folhas(a->dir);
	
}