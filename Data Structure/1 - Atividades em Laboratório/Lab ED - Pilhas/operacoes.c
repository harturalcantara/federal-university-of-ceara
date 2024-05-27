#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "pilha.h"

#define n 60


void imprime(Pilha* p){


	char k;
	Pilha* aux = p_cria();

	while(!p_vazia(p)){
		k = p_pop(p);
		printf("%c\n", k);
		p_push(aux,k);

	}
	while(!p_vazia(aux)){
		k = p_pop(aux);
		p_push(p,k);
		
	}

}


void imprimeReversa(Pilha* p){

	char k[n];
	int i=0;
	Pilha* aux = p_cria();

	while(!p_vazia(p)){
		k[i] = p_pop(p);
		p_push(aux,k[i]);
		i++;
	}
	i--;
	while(i!=-1){
		//printf("Meu i: %d\n",i );
		printf("%d\n",k[i]);
		i--;
	}
	i=0;
	while(!p_vazia(aux)){
		k[i] = p_pop(aux);
		//printf("%d\n", k);
		p_push(p,k[i]);
		i++;
	}

}



void elimina(Pilha* p, char valor){


	char k;
	Pilha* aux = p_cria();

	while(!p_vazia(p)){
		k = p_pop(p);
		if(k != valor){
			p_push(aux,k);
		}
	}

	while(!p_vazia(aux)){
		k = p_pop(aux);
		p_push(p,k);
	}

}


void minusculoMaiusculo(Pilha* p, Pilha* aux1, Pilha* aux2){
	char k;
	Pilha* aux = p_cria();

	while(!p_vazia(p)){
		k = p_pop(p);
		if(k > 64 && k < 91){//MAIUSCULO
			p_push(aux1,k);
		}
		else{//MINUSCULO
			p_push(aux2,k);
		}
		p_push(aux,k);
	}

	while(!p_vazia(aux)){
		k = p_pop(aux);
		p_push(p,k);
	}
}


void palindroma(Pilha* p){
	char k[n];
	char keverso[n];

	int i=0;
	Pilha* aux = p_cria();

	while(!p_vazia(p)){
		k[i] = p_pop(p);
		p_push(aux,k[i]);
		i++;
	}

	i--;
	int t=0;
	while(i!=-1){
		keverso[t] = k[i];
		i--;
		t++;
	}
	i=0;
	
	int h;
	int veri =0;
	for(h=0;h<t;h++){
		if(keverso[h] != k[h]){
			printf("Não é palindromo!\n");
			veri = 1;
			break;
		}
	}
	if(veri == 0){
		printf("É palindromo!\n");
	}
	

	while(!p_vazia(aux)){
		k[i] = p_pop(aux);
		//printf("%d\n", k);
		p_push(p,k[i]);
		i++;
		
	}
}