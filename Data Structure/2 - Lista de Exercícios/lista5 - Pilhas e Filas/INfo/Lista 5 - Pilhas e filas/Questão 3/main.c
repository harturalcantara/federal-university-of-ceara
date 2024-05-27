#include <stdio.h>
#include <stdlib.h>
#include "listaFila.h"

int main(){

	Fila* f;
	f = fila_cria();

	fila_insere(f, 1);
	fila_insere(f, 2);
	fila_insere(f,-6);
	fila_insere(f, 4);

	f  = fila_busca(f);

	fila_imprime(f);

	fila_libera(f);
	return 0;
}
