#include<stdio.h>
#include<stdlib.h>
#include "lista.h"

struct lista{

    int info;
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


Fila* fila_cria(){

    Fila* f = (Fila*)malloc(sizeof(Fila));
    f->ini = f->fim = NULL;


    return f;
}

void fila_insere(Fila* f, int v){

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

Fila* fila_lista(Lista* p){

    Fila* f = fila_cria();

    f->ini = p;
    f->fim->prox = p;

    for(p = f->ini;p != NULL;p = p->prox){

    if(p->prox == NULL){



    f->fim->prox = p;

    }

}


    return f;
}


void fila_cir_imprime(Fila* f){

    Lista* c = f->ini;
    Lista* aux = f->ini;

    if(c)do{

    printf("%i\n",c->info);
    c = c->prox;

    }while(c != aux);


}

int fila_retira(Fila* f){

    Lista* t;
    int v;
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

        printf("%i\n",q->info);

    }

}

void fila_insere_cir(Fila* f, int v){

    Lista* n = (Lista*)malloc(sizeof(Lista));
    n->info = v;
    n->prox = f->ini;

    if(f->fim != NULL){

        f->fim->prox = n;

    }else{

        f->ini = n;
    }

    f->fim = n;
}

void fila_tamanho(Fila* f){

    int tam = 0;
    Lista* c = f->ini;
    Lista* aux = f->ini;

    if(f != NULL){
        if(c)do{

        tam++;
        c = c->prox;

        }while(c != aux);

    }else{

        printf("Nao ha elementos na fila!!\n");

    }

    if(tam > 0){

        printf("Tamanho atual da fila:%i\n",tam);

    }
}



int fila_retira_cir(Fila* f){

    Lista* t;
    int v;
    if(f == NULL){

        printf("Fila vazia\n");
        exit(1);
    }

    t = f->ini;
    v = t->info;
    f->ini = t->prox;

    if(f->ini == NULL){

        f->fim = f->ini;

    }

        free(t);

        return v;
}
