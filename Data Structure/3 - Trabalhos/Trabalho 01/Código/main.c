#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"
#include "indice.h"


int main(){
	

	/*Criação da ListaNomes*/
	Nomes* ListaNomes = criaNomesNull();

	/*ENTRADA DO CODIGO*/

	int n , i, indicePg;

	char *nome;
	nome = (char*)malloc(sizeof(char)*100);

	printf("Digite o numero de entradas de nomes:");
	scanf("%d",&n);

	for(i=0;i<n;i++){
		
		printf("[ENTRADA] - Digite um nome [%d]:\n",i);
		setbuf(stdin, NULL);
		scanf("%[^\n]s", nome);	

		printf("[ENTRADA] - Digite o Numero da Pagina [%d]:\n",i);
		scanf("%d",&indicePg);

		ListaNomes = inserirStringSeparada(ListaNomes, nome, indicePg);

	}

	/*SAIDA DO CODIGO*/
	int c;
	char *nomeBuscado;
	nomeBuscado = (char*)malloc(sizeof(char)*100);

	printf("\t\t[EXIBICAO] - Esses sao todos os nomes inseridos - [EXIBICAO]\n");
	imprimirTodosNomesTodosIndices(ListaNomes);

	printf("[CONSULTA] - Digite o numero de consultas:\n");
	scanf("%d",&c);
	printf("\n");
	for(i=0;i<c;i++){
		printf("[CONSULTA] - [%d] - Digite um  nome:\n",i);
		setbuf(stdin, NULL);
		scanf("%[^\n]s", nomeBuscado);
		verificarTipoDeBusca(ListaNomes,nomeBuscado);
	}
	

}