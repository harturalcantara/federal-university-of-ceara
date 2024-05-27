#include <stdio.h>
#include <stdlib.h>


/*Filas Duplas - Versão Lista Encadeada*/
struct lista2{

	float info;
	struct lista2* anterior;
	struct lista2* proximo;

};
typedef struct lista2 Lista2;

struct fila2{

	Lista2* inicio;
	Lista2* fim;

};
typedef struct fila2 Fila2;

/*-----------------------------------------------------------------------------------------------*/
/*-----------------------------------Funções auxiliares------------------------------------------*/
/*-----------------------------------------------------------------------------------------------*/

Fila2* f2_cria(){

	Fila2* f = (Fila2*)malloc( sizeof(Fila2) );

	f->inicio = NULL;

	f->fim = NULL;

	return f;

}

int f2_vazia(Fila2* f2){

	return f2->inicio==NULL;

}

void f2_libera(Fila2* f2){

	free(f2);

}






/*-----------------------------------------------------------------------------------------------*/


/*Função auxiliar que  insere no inicio.*/ //OK
Lista2* insere2_inicio(Lista2* inicio, float v){

	Lista2* p = (Lista2*) malloc(sizeof(Lista2));

	p->info = v;

	p->proximo = inicio;

	p->anterior = NULL;

	if(inicio != NULL){
		inicio->anterior = p;
	}

	return p;
}

/*Função auxiliar que  insere no fim.*/ //OK
Lista2* insere2_fim(Lista2* fim, float v){
	
	Lista2* p = (Lista2*) malloc(sizeof(Lista2));

	p->info = v;

	p->proximo = NULL;

	p->anterior = fim;
	
	if(fim!=NULL){

		fim->proximo = p;

	}
	
	return p;
}


/*Função auxiliar que retira do inicio.*/ //OK
Lista2* retira2_ini(Lista2* inicio){
	
	Lista2* p = inicio->proximo;
	
	if(p!= NULL){
		p->anterior = NULL;
	}
	
	free(inicio);
	
	return p;
}

/*Função auxiliar que  retira do fim.*/ //OK
Lista2* retira2_fim(Lista2* fim){
	
	Lista2* p = fim->anterior;

	if(p!=NULL){
		p->anterior = NULL;
	}

	free(fim);

	return p;
}



/*-------------------------------------------------------------------*/
/*-------Funções de Inserir e Retirar!--------------------------*/
/*--------------------------------------------------------------*/

void f2_insere_ini(Fila2* f, float v){

	f->inicio = insere2_inicio(f->inicio , v);

	if(f->fim == NULL){
		f->fim = f->inicio;
	}

}

void f2_insere_fim(Fila2* f, float v){
	
	f->fim = insere2_fim(f->inicio,v);

	if(f->inicio==NULL){

		f->inicio = f->fim;

	}

}

float f2_retira_ini(Fila2* f2){
	
	float valor;
	
	if(f2_vazia(f2)){

		printf("Fila vazia.\n");
		exit(1);

	}
	
	valor = f2->inicio->info;
	
	f2->inicio = retira2_ini(f2->inicio);

	if(f2->inicio == NULL){

		f2->fim = NULL;

	}

	return valor;

}

float f2_retira_fim(Fila2* f2){
	
	float valor;

	if(f2_vazia(f2)){

		printf("Fila vazia.\n");
		exit(1);

	}

	valor = f2->fim->info;

	f2->fim = retira2_fim(f2->fim);
	
	if(f2->fim == NULL){

		f2->inicio = NULL;

	}

	return valor;
}

int f2_quantidade(Fila2* f){
	int cont=0;
	Fila2* aux = f;
	while(aux->inicio!=NULL){
		cont++;
		aux->inicio = aux->inicio->proximo;
	}
	return cont;
}


void fila_imprime(Fila2* f){
	Fila2* aux = f2_cria();
	aux = f;
	int i;
	while(aux->inicio != NULL){
		printf("%2.f\n",aux->inicio->info);
		
		aux->inicio = aux->inicio->proximo;
	}
}

int main(){
 
	Fila2* teste = f2_cria();

	f2_insere_ini(teste, 1);
	f2_insere_ini(teste, 2);
	
	//printf("%d\n", f2_quantidade(teste) );
	// insere2_inicio(teste, 2);
	// insere2_inicio(teste, 3);
	// insere2_inicio(teste, 4);

	fila_imprime(teste);
	fila_imprime(teste);


}