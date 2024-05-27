#include <stdio.h>
#include <stdlib.h>
#include <limits.h>
#include "lista3.h"

///Estrutura - OK
struct lista{
   int valor;
   struct lista *proximo;
};

///Criar - OK
Lista* cria(){
   return NULL;
}

//LIBERA LISTA - OK
void libera(Lista* l){
    Lista* aux=l;
    while(l!=NULL){
      aux = l;
      l = l->proximo;
      free(aux);
    }
}
			///QUESTAO - 1 RECURSIVA
Lista* menorRecursivo(Lista *l,Lista *men){
	if(l==NULL)
		return men.
	else if(l->valor<menor->valor)
		return menor(l->prox,l);
	else
		return menor(l->prox,men);
}


//INSERIR NA LISTA - OK
Lista* inserir(Lista *l, int x){
	Lista *novo = l;
	novo = (Lista*)malloc(sizeof (Lista)*1);
	novo->valor = x;
	novo->proximo = l;
	return novo;
}
//IMPRIME O QUE TEM DENTRO DA LISTA - OK
void imprimir(Lista *l){
	Lista *aux = l;
	while(aux!=NULL){
		printf("%d\n",aux->valor);
		aux = aux->proximo;
	}
}
//IMPRIMIR UM ELEMENTO - OK;
void imprimirUmElemento(Lista *l){
	if(l!=NULL){
		printf("%d\n", l->valor);
	}
	else{
		printf("A lista tem valor vazio!\n");
	}

}

//ENCONTRAR NAS CELULAS O VALOR CONTEUDO MINIMO;
int encontrarMinimo(Lista *l){
	Lista* aux = l;
	int menor = aux->valor;

	while(aux!=NULL){
		if(aux->valor < menor){
			menor = aux->valor;
		}
		aux = aux->proximo;
	}

	return menor;
}
//ENCONTRA CONTEUDO MAXIMO
int encontrarMaximo(Lista *l){
	Lista* aux = l;
	int maior = aux->valor;

	while(aux!=NULL){
		if(aux->valor > maior){
			maior = aux->valor;
		}
		aux = aux->proximo;
	}
	return maior;
}
//VAI RETIRAR QUEM TEM O MAIOR VALOR;
Lista* retiraMaximo(Lista *l){
   int maiorEncontrado = encontrarMaximo(l);

   Lista *anterior = NULL;
   Lista *atual = l;
   while((atual != NULL) && (atual->valor != maiorEncontrado)){
      anterior = atual;
      atual = atual->proximo;
   }
   if(atual == NULL){
      return l;
   }
   else if(anterior == NULL){//SE O ANTERIOR FOR IGUAL A NULL, LIBERA O ATUAL QUE ESTA O VALOR, SE ESTA NO INICIO; 
      l = l->proximo;
      free(atual);
      return l;
   }
   else{//
      anterior->proximo = atual->proximo;
      free (atual);
      return l;
   }
}

//FUNCAO QUE VAI CONTAR O NUMERO DE CELULAS
int contaCelulas(Lista *l){
	Lista *aux = l;
	int cont=0;
	while(aux!=NULL){
		if(aux->valor!=0){
			cont++;
		}
		aux = aux->proximo;
	}
	return cont;
}

//FUNCAO QUE VAI CONCATENAR
Lista* concatenarListas(Lista *l, Lista *k){
	Lista *aux = l;
	while(aux->proximo!=NULL){
		aux = aux->proximo;
	}
	aux->proximo = k;
	return l;
}


//REMOVE A K-ESIMA;
Lista* remover(Lista *l, int x){
   Lista *anterior = NULL;
   Lista *atual = l;

   while((atual != NULL) && (atual->valor != x)){
      anterior = atual;
      atual = atual->proximo;
   }
   if(atual == NULL){
      return l;
   }
   else if(anterior == NULL){//SE O ANTERIOR FOR IGUAL A NULL, LIBERA O ATUAL QUE ESTA O VALOR, SE ESTA NO INICIO; 
      l = l->proximo;
      free(atual);
      return l;
   }
   else{//
      anterior->proximo = atual->proximo;
      free (atual);
      return l;
   }
}

//FUNCAO REMOVER TODOS OS X;
Lista* removerTodosX(Lista* l, int x){

}

//CONTA QTS
int contarX(Lista* l, int x){
	Lista* aux = l;
	int cont=0;
	while(aux!=NULL){
		if(aux->valor == x){
			cont++;
		}
		aux = aux->proximo;
	}
	return cont;
}

//FUNCAO AUXILIAR
int verificaPrimo(int x){
	int i;
	int cont=0;
	for(i=2;i<x;i++){
		if(x%i==0){
			cont++;
		}
	}
	if(cont == 0){
		return 1;
	}
	else{
		return 0;
	}
}
//FUNCAO QUE CONTA OS NUMEROS DE PRIMOS NA LISTA
int contaPrimos(Lista *l){
	Lista *aux = l;
	int cont=0;
	while(aux!=NULL){
		if(verificaPrimo(aux->valor)==1){
			cont++;
		}
		aux = aux->proximo;
	}
	return cont;
}
//FUNZAO QUE RETORNA A SOMA DOS NUMEROS PRIMOS;
int somaPrimos(Lista *l){
	Lista *aux = l;
	int cont=0;
	int soma = 0;
	while(aux!=NULL){
		if(verificaPrimo(aux->valor)==1){
			soma = soma + aux->valor;
		}
		aux = aux->proximo;
	}
	return soma;
}

//RETORNA UMA NOVA LISTA DE SOMENTE NUMEROS PRIMOS;
Lista* listaPrimos(Lista *l){
	Lista* aux = l;
	Lista* novaLista = cria();
	while(aux!=NULL){
		if(verificaPrimo(aux->valor)==1){
			printf("AQUI\n");
			novaLista = inserir(novaLista, aux->valor);
			//novaLista = novaLista->proximo;
		}
		aux = aux->proximo;
	}
	return novaLista;
}

//FUNCAO QUE VAI SOMAR DUAS OS VALOR DE DUAS LISTA E COLOCAR NA NOVA LISTA;
Lista* somaDuasLista(Lista *x, Lista*y){
    Lista* aux1 = x;
    Lista* aux2 = y;

    Lista* somaDasDuas = cria();
    
    int soma = 0;
    while(aux1 != NULL){
        soma = aux1->valor + aux2->valor;
        somaDasDuas = inserir(somaDasDuas,soma);
        soma = 0;
        aux1 = aux1->proximo;
        aux2 = aux2->proximo;
    }
    return somaDasDuas;
}
//VERIFICA SE AS LISTA TEM O MSM TAMANHO E SE SAO IGUAIS;
void conteudoIguais(Lista* X, Lista* Y){
    
    if(contaCelulas(X)==contaCelulas(Y)){
        Lista* aux1 = X;
        Lista* aux2 = Y;

        while(aux1 != NULL){
            if(aux1->valor != aux2->valor){
                printf("OS VALORES NAO SAO IGUAIS!\n");
                return;
            }
            aux1 = aux1->proximo;
            aux2 = aux2->proximo;
        }
        printf("OS VALORES SAO IGUAIS!\n");
    }
    else{
        printf("OS TAMANHO DAS LISTAS SAO DIFERENTES!\n");
    }
}


void conteudoIguaisSemOrdem(Lista* X, Lista* Y){
    if(contaCelulas(X)==contaCelulas(Y)){
        Lista* aux1;
        Lista* aux2;
        int cont = 0;
        for(aux1=X; aux1!=NULL; aux1=aux1->proximo){        
            for(aux2=Y; aux2!=NULL; aux2 = aux2->proximo){
                if(aux1->valor == aux2->valor){
                    cont++;
                }
            }
            if(cont == 1){
                cont = 0;
            }
            else{
                printf("\nNAO TEM O MESMOS ELEMENTOS!\n");
                return;
            }
        }
        printf("\nPOSSUEM OS MESMOS ELEMENTOS!\n");
    }
    else{
        printf("\nNAO SAO DO MESMO TAMANHO!\n");
    }
}

Lista* removeAuxRecursivo(Lista* l1, Lista* l2){

}

//QUESTAO7
void removeRepetidosRecursivo(Lista* X){

}



//QUESTAO7
void removeRepetidos(Lista* X){
        Lista* aux1 = X;
        Lista* aux2;
        Lista* ant;

        while(aux1->proximo != NULL){
          aux2 = aux1->proximo;
          ant = aux1;
          while(aux2!=NULL){
            if(aux1->valor == aux2->valor){
                    ant->proximo = removeElementoX(aux2,aux2->valor);
                    break;
                }
            ant = aux2;
            aux2 = aux2->proximo;
          }
          aux1 = aux1->proximo;
        }
}



//VERIFICA NA LISTA OS ELEMETOS QUE SAO NULOS E REMOVE ELES
Lista* removerDaListaOsNulosQ17(Lista* l){
	Lista* aux = l;
    while(aux != NULL){
        if(aux->valor == 0){
            l = remover(l, 0);
            aux = l;
        }
        aux = aux->proximo;
    }
    return l;
}

//REMOVE O ELEMENTO X,(ERRO) - RESOLVIDO...
Lista* removeElementoX(Lista* l, int x){
	Lista* aux = l;
    while(aux != NULL){
        if(aux->valor == x){
            l = remover(l, x);
            if(l!=NULL)
              aux = l;
        }
        aux = aux->proximo;
    }
    return l;
}

Lista* uniaoQ16a(Lista *l, Lista *k){
  Lista *aux = l;
  while(aux->proximo!=NULL){
    aux = aux->proximo;
  }
  aux->proximo = k;
  return l;
}

Lista* subtraiDuasLista(Lista *x, Lista*y){
    Lista* aux1 = x;
    Lista* aux2 = y;

    Lista* somaDasDuas = cria();
    
    int result = 0;
    while(aux1 != NULL){
        result = aux1->valor - aux2->valor;
        somaDasDuas = inserir(somaDasDuas,result);
        result = 0;
        aux1 = aux1->proximo;
        aux2 = aux2->proximo;
    }
    return somaDasDuas;
}

