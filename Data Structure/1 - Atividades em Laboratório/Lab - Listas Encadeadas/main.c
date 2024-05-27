#include "lista.h"
#include <stdio.h>
#include <stdlib.h>

int main(){
   //Crio uma lista
   Lista *r;

   r = cria();

   r = inserir(r,5);
   r = inserir(r,6);
   r = inserir(r,7);
   r = inserir(r,8);
   //IMPRIME ESTADO ATUAL
   printf("NUMEROS ATUAIS\n");
   imprime(r);

   //printf("FUNCAO IMPRIME UM ELEMENTO\n");
   //IMPRIME UM ELEMENTO
   //imprimeUmElemento(r);


   //VERIFICANDO SE ESTA VAZIA
   printf("Nao esta vazia = 0 e 1 se esta == %d\n",vazia(r));


   //printf("Foi retirado:\n");
   //r = retira(r,8);
   //imprime(r);
   
   //INSERE ORDEANADO
   //r = insereOrdenado(r,1);
   //r = insereOrdenado(r,2);
   //r = insereOrdenado(r,4);
   //printf("ATUAL ORDENADO\n");
   //imprime(r);
   //printf("ESTADO ATUAL INSERIDO ORDENADAMENTE:\n");
   //r = insereOrdenado(r,3);
   imprime(r);

   printf("FOI RETIRADO::\n");

   r = retira(r,8);
   imprime(r);

   Lista* aux;
   aux = busca(r,5);
   printf("BUSCOU:\n");
   imprime(aux);

   ////TESTANDO FUNCAO LIBERA
   //libera(r);

   /*RECURSIVO
      void imprime(lista* l){
         if(l==NULLL){
            return
         }
         else{
            printf("Elemento:%d",l->v);
         }
      }
   */

   /*
      lista* buscar(lsita *l,int x){
         if(l==null)
            return insere(l,x);
         if(l->x<x){
            null
         }
         else{
            buscar(lista l->prox, x);
         }
      }
      /////FEITAAAAAA
      lista* insereordenado(lsita *l,int x){
         if(l==null)
            return insere(l,x);
         else if(l->v < x){
            l->prox= insereordenado(l->prox,x)
         }
         else{
            l=insere(l,x);
         }
         return l;
      }  
   */
    /*
      if(l==null){
         return null;
      }
      else
      if(l->v<x)
    
    
   */

}
