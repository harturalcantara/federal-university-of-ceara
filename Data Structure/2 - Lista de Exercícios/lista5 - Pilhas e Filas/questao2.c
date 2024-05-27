#include <stdio.h>
#include <stdlib.h>
//#include "fila2.h"

#define MAX 50


/*Filas Duplas - Versão Vetores*/

struct fila2{
	int n;
	int ini;
	float v[MAX];
};



/*----------------------------------------------------------*/
/*Funções auxiliares*/
Fila2* f2_cria(){
	
	Fila2* f = (Fila2*)malloc(sizeof(Fila2*));
	
	f->ini = 0;
	f->n = 0;
	
	return f;
}

int f2_quantidade(Fila2* f2){

	return f2->n;
	
}


int f2_vazia(Fila2* f2){
	return f2->n == 0;
}


void f2_libera(Fila2 *f2){
	 free(f2);
}
/*----------------------------------------------------------*/

void f2_insere_ini(Fila2* f, float v){
	int p;
	if(f2_quantidade(f)==MAX){
		printf("Fila cheia!\n");
	}
	
	
	p = (f->ini+MAX-1) % MAX;

	f->v[p] = v;
	f->n++;
}



void f2_insere_fim(Fila2* f, float v){
	if(f2_quantidade(f)==MAX){
		printf("Fila cheia!\n");
		exit(1);
	}

	int p = f->ini + f->n % MAX;
	f->v[p] = v;
	f->n++;
}





float f2_retira_ini(Fila2* f2){

	if(f2_vazia(f2)){
		printf("Fila Vazia!\n");
		exit(1);
	}

	float x = f2->v[f2->ini];
	
	f2->ini = (f2->ini+1)% MAX;

	f2->n--;

	return x;

}

float f2_retira_fim(Fila2* f2){
	if(f2_vazia(f2)){
		printf("Fila Vazia!\n");
		exit(1);
	}

	int p = (f2->ini + f2->n-1) % MAX;
	
	int x = f2->v[p];

	f2->n--;

	return x;
}


void fila_imprime(Fila2* f){

	int i;
	for(i=0;i<f2_quantidade(f);i++){
		printf("%f\n",q->info);
	}

}