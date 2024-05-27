#include <stdio.h>
#include <stdlib.h>
#include "arvoreBusca.h"

int main(){




	Arv* palmeira = NULL;

	palmeira = inserir(palmeira,2);
	palmeira = inserir(palmeira,5);
	palmeira = inserir(palmeira,4);
	palmeira = inserir(palmeira,1);

	imprime(palmeira);

	palmeira = busca(Arv* a, int x);

	palmeira = retira(palmeira, 5);
	palmeira = retira(palmeira, 1);
	printf("\n");
	imprime(palmeira);


}