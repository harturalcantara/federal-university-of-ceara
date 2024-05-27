#include <stdio.h>
#include <stdlib.h>
#include "fila2.h"

int main(){


	Fila2* l = f2_cria();
	
	/*
	f2_insere_ini(l, 1);
	f2_insere_ini(l, 2);
	f2_insere_ini(l, 3);
	f2_insere_ini(l, 4);
	f2_insere_ini(l, 5);
	*/
	f2_insere_fim(l, 1);
	f2_insere_fim(l, 2);
	f2_insere_fim(l, 3);
	f2_insere_fim(l, 4);
	
	//f2_insere_fim(l, 5);

	// int i;
	// float valor;
	// for(i=0; i < f2_quantidade(l);i++){
	// 	valor = f2_retira_ini(l);
	// 	printf("%f\n",valor);
	// 	f2_insere_fim(l,valor);
	// }

}