#include<stdio.h>
#include<stdlib.h>
#include "lista.h"

struct lista{

    float info;
    Lista* prox;

};

struct fila{

    Lista* ini;
    Lista* fim;

};

Lista* lst_cria(){


    return NULL;
}

Lista* lst_insere(Lista* l,int i){

    Lista* novo = (Lista*)malloc(sizeof(Lista));

    novo->info = i;
    novo->prox = l;

    return novo;
}

Lista* lst_retira(Lista *l, int v){
	Lista *ant = NULL;
	Lista *p = l;

	while(p!= NULL && p->info !=v){
		ant = p;
		p = p->prox;
	}
	if(p==NULL) return;
	if (ant == NULL) l = p->prox;
	else ant->prox = p->prox;
	free(p);
	return l;
}


Fila* fila_cria(){

    Fila* f = (Fila*)malloc(sizeof(Fila));
    f->ini = f->fim = NULL;


    return f;
}

void fila_insere(Fila* f, float v){

    Lista* n = (Lista*)malloc(sizeof(Lista));
    n->info = v;
    n->prox = NULL;

    if(f->fim != NULL){

        f->fim->prox = n;

    }else{

        f->ini = n;
    }

    f->fim = n;
}

void fila_lista(Lista* p,Fila* f){

    Lista *n =(Lista*)malloc(sizeof(Lista));

    n->info = p->info;
    n->prox = NULL;

    if(f->fim != NULL){

        f->fim->prox = n;
    }else{

        f->ini = n;
    }

    f->fim = n;

}



float fila_retira(Fila* f){

    Lista* t;
    float v;
    if(fila_vazia(f)){

        printf("Fila vazia\n");
        exit(1);
    }

    t = f->ini;
    v = t->info;
    f->ini = t->prox;
    if(f->ini == NULL){

        f->fim = NULL;

    }

        free(t);

        return v;
}

int fila_vazia(Fila* f){



    return(f->ini == NULL);
}

void fila_imprime(Fila* f){

    Lista* q;
    for(q = f->ini;q != NULL; q = q->prox){

        printf("%2.f\n",q->info);

    }

}


void retira_neg(Fila* f){

    Fila* aux;
    Lista* c;
    float i;

    c = f->ini;

    while(c != NULL){


        if(c->info < 0){

        //c = lst_retira(c->ini,c->info);

        }

        c = c->prox;

    }

}


Fila* fila_busca_neg(Fila* f){


	Lista* l;

	for(l = f->ini; l != NULL;l = l->prox){

		if(l->info < 0){

		l = lst_retira(f->ini,l->info);

	}


      }

	return f;
}
