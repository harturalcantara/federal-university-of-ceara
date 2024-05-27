#include <stdio.h>
#include <stdlib.h>
#include "arvore.h"


struct arv{
	char info;
	struct arv* dir;
	struct arv* esq;
};



Arv* cria_vazia(){
	return NULL;
}

Arv* cria(char c, Arv* esquerda, Arv* direita){

	Arv* a = (Arv*)malloc(sizeof(Arv));

	a->info = c;
	a->dir = direita;
	a->esq = esquerda;

	return a;
}



int vazia(Arv* a){

	return a==NULL;

}



int pertence(Arv* a, char c){
	
	if(!vazia(a)){
		return 0;
	}
	else{
		if(a->info == c){
			return 1;
		}
		else{
			return pertence(a->esq, c) || pertence(a->dir,c);
		}
	}

}


Arv* libera(Arv* a){

	if(!vazia(a)){

		libera(a->esq);
		libera(a->dir);
		free(a);

	}

	return NULL;

}




/*Pré-Ordem - Trata a raiz, chama para esquerda, chama para direita*/
/*Em ordem: - Chama para esquerda, trata raiz, chama para direita  */
/*Pós Ordem: Chama para esquerda, chama para direita, trata a raiz*/

void imprime(Arv* a){/*Pré-Ordem*/

	if(!vazia(a)){

		printf("%c\n",a->info);
		imprime(a->esq);
		imprime(a->dir);

	}

}

void imprime_Ordem(Arv* a){/*Em Ordem*/

	if(!vazia(a)){

		imprime(a->esq);
		printf("%c\n",a->info);
		imprime(a->dir);

	}

}
void imprime_Pos_Ordem(Arv* a){/*Pós-Ordem*/

	if(!vazia(a)){

		imprime(a->esq);
		imprime(a->dir);
		printf("%c\n",a->info);

	}

}
