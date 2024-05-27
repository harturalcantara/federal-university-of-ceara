#include <stdio.h>
#include <stdlib.h>
#include "lista.h"

///Estrutura - FUNCIONANDO
struct lista{
   int v;
   struct lista *prox;
};

///Criar -FUNCIONANDO
Lista* cria(){
   return NULL;
}

//INSERIR LISTA NO CONJUNTO DE LISTAS - FUNCIONANDO
Lista* inserir(Lista *l, int x){
   Lista *novo;// = l;
   novo = (Lista*)malloc(sizeof(Lista)*1);
   novo->v = x;
   novo->prox = l;
   return novo;
}


//FUNCAO IMPRIMIR A LISTA - FUNCIONANDO
void imprime(Lista *l){
   Lista *aux = l;
   while(aux!=NULL){
      printf("%d\n",aux->v);
      aux = aux->prox;
   }
}

//IMPRIME UM ELEMENTO - FUNCIONANDO
void imprimeUmElemento(Lista* l){
   if(l!=NULL){
      printf("%d\n", l->v);
   }
   else{
      printf("Lista Vazia\n");
   }   
}

//IMPRIME ORDENADAMENTE - FUNCIONANDO
Lista* insereOrdenado(Lista* l, int x){
   Lista *anterior = NULL;
   Lista *atual = l;
   Lista *novo;

   while((atual!=NULL) && (atual->v < x)){
      anterior = atual;
      atual = atual->prox;

   }
   
   if(anterior==NULL){

      return inserir(l,x);

   }else{
   		novo = (Lista*)malloc(sizeof(Lista));
   		novo->v = x;
   		anterior->prox = novo;
   		novo->prox = atual;
   		return l;
   }
}


//LIBERA LISTA - FUNCIONANDO
void libera(Lista* l){
    Lista* aux=l;
    while(l!=NULL){
      aux = l;
      l = l->prox;
      free(aux);
    }
}


///FUNCAO RETIRA
Lista* retira(Lista *l, int x){
   Lista *anterior = NULL;
   Lista *atual = l;

   while((atual != NULL) && (atual->v != x)){
      anterior = atual;
      atual = atual->prox;
   }
   if(atual == NULL){
      return l;
   }
   else if(anterior == NULL){//SE O ANTERIOR FOR IGUAL A NULL, LIBERA O ATUAL QUE ESTA O VALOR, SE ESTA NO INICIO; 
      l = l->prox;
      free(atual);
      return l;
   }
   else{//
      anterior->prox = atual->prox;
      free (atual);
      return l;
   }
}



//VERIFICA SE A LISTA ESTA VAZIA OU NAO - FUNCIONANDO
int vazia(Lista*l){
   if(l==NULL){
      return 1;
   }
   else
      return 0;
}

//FUCAO BUSCAR
Lista* busca(Lista *l, int x){
   Lista* aux = l;

   while(aux!=NULL){
      if(aux->v == x){
         return aux;
      }
      aux = aux->prox;
   }

}












