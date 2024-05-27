#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "listaRecursiva.h"


///Estrutura - OK
struct lista{
   int valor;
   struct lista *proximo;
};


Lista* cria(){
   return NULL;
}

void libera(Lista* l){
    Lista* aux=l;
    while(l!=NULL){
      aux = l;
      l = l->proximo;
      free(aux);
    }
}

  //QUESTAO 1;
Lista* menorRecursivo(Lista *l,Lista *men){
  if(l==NULL)
    return men.
  else if(l->valor<menor->valor)
    return menor(l->prox,l);
  else
    return menor(l->prox,men);
}


Lista* remover(Lista *l,int x){
  if(l==NULL){
    return NULL;
  }
  if(l->valor == x){
    Lista* aux = l;
    l = l->proximo;
    free(aux);
    l = remove(l,x);
    return l;
  }
  else{
    l->proximo = remove(l->proximo,x);
    return l;
  }
}


Lista* remove(Lista* l, Lista* l2){
    if(l!=NULL){
        return l1;
    }
    else if(l->valor == l2->valor){
      Lista* aux=l;
      l=l->proximo;
      free(aux);
      l1->proximo=remove(l1,l2);

    }
    else{
      l1->proximo = remove(l1->proximo,l2->proximo);
    }
    return l;
}

//VERIFICANDO DUAS LISTAS IGUAIS
Lista* igual(Lista* l1,Lista* l2){
  if igual(l1=NULL && l2==NULL){
    return 1;
  }
  else if(l1==NULL || l2 == NULL){
    return 0;
  }
  else{
    return 0;
  }

}

Lista* inverte(Lista* l, Lista* aux){
  if(l==NULL){
    return aux;
  }
  else{
    Lista* atual = l;
    l=l->proximo;
    atual->proximo=aux;
    aux=atual;
    return inverte(l,aux);

  }
}

Lista* inserir(Lista *l, int x){
  Lista *novo = l;
  novo = (Lista*)malloc(sizeof (Lista)*1);
  novo->valor = x;
  novo->proximo = l;
  return novo;
}

void imprimir(Lista *l){
  Lista *aux = l;
  while(aux!=NULL){
    printf("%d\n",aux->valor);
    aux = aux->proximo;
  }
}