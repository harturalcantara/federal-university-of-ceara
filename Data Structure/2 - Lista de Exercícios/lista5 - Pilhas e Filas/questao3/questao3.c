#include <stdio.h>
#include <stdlib.h>
//#include "fila.h"


#define MAX 50




struct lista{

	float info;
	struct lista* prox;

};


typedef struct lista Lista;

struct fila{

	Lista* ini;
	Lista* fim;

};

typedef struct fila Fila;



Fila* f_cria(){

	Fila* f = (Fila*)malloc(sizeof(Fila));

	f->ini = NULL;
	f->fim = NULL;

	return f;

}

int f_vazia(Fila* f){
	return f->ini ==NULL;
}


void f_inserir(Fila* f, float v){

	Lista* nova = (Lista*)malloc(sizeof(Lista));
	
	nova->info = v;
	nova->prox = NULL;

	if(f_vazia(f)){

		f->fim = nova;
		f->ini = nova;

	}
	else{

		f->fim->prox = nova;
		f->fim = nova;
	}

}

Fila* f_retirar(Fila* f){

	
	Lista* T;
	
	if(f_vazia(f)){
		printf("Fila vazia!\n");
		exit(1);
	}
	int veri=0;

	Lista* aux = f->ini;

	if(aux->info < 0){
		T = aux;
		aux = aux->prox;
		free(T);
	}
	f->ini = aux;
	// for (aux = f->ini; aux!=NULL; aux = aux->prox){
	// 	if(aux->info < 0){
	// 		T = aux;
	// 		aux = aux->prox;
	// 		free(T); 	
	// 	}
	// }

	while(aux != NULL){
		veri=0;
		//printf("Estou comparando: %.2f < 0\n",aux->info);
		if(aux->prox->info < 0){
			T = aux->prox;
			aux->prox = aux->prox->prox;
			printf("MOrri!\n");
			free(T);
			printf("Morri msm!\n");
			veri=1;
			aux = aux->prox;
		}
		if(veri == 0 && aux!=NULL){
			aux = aux->prox;
		}
	}


	return f;
}	


void f_libera(Fila* f){
	Lista* aux = f->ini;
	while(aux!=NULL){
		Lista* T = aux;
		aux = aux->prox;
		free(T);
	}
	free(f);
}

int f_quantidade(Fila* f){
	int cont=0;
	Lista* aux = f->ini;
	while(aux!=NULL){
		cont++;
		aux=aux->prox;
	}
	return cont;
}

void imprimeFila(Fila *f){
	int i;
	float valor;
	Lista* aux;
	for(aux = f->ini; aux != NULL ; aux = aux->prox){
		printf("%f\n", aux->info );
	}
}



int main(){

	Fila* filinha = f_cria();

	f_inserir(filinha, -1);
	f_inserir(filinha, 2);
	
	f_inserir(filinha, 5);
	f_inserir(filinha, -1);
	f_inserir(filinha, 7);
	// /f_inserir(filinha, -1);
	printf("Minha fila normal!\n");
	imprimeFila(filinha);

	filinha = f_retirar(filinha);
	printf("Sem negativos!\n");
	imprimeFila(filinha);
}