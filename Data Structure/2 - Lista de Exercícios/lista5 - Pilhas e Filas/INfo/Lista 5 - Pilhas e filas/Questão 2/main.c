#include<stdio.h>
#include "lista.c"

int main(){

    Fila* t = fila_cria();
	Fila* p = fila_cria();
    Lista* c = lst_cria();

    fila_insere_cir(t,4); // NA INSERÇÃO POR SI JÁ UTILIZA UMA LISTA LINEAR
    fila_insere_cir(t,6);
    fila_insere_cir(t,8);

    fila_cir_imprime(t);// IMPRIME A FILA CIRCULAR

    printf("\n\n");

    fila_tamanho(t);

   // fila_retira(t);//FALTOU O RETIRA

    //printf("\n\n");

    //fila_cir_imprime(t);

	return 0;
}
