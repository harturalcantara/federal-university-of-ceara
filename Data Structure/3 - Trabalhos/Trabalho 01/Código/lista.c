#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "lista.h"

#include "indice.h"

/*
struct paginas{
    int pg;
    struct paginas *proxPagina;
};
*/

//typedef struct paginas Paginas;

struct nomes{
    char nome[100];
    struct nomes *proxNome;
    Paginas *paginasDoLivro;

};


Nomes* criaNomesNull(){
    return NULL;
}

Nomes* inserirNomeNaLista(Nomes* l, char *texto, int pg){	

	Nomes *aux = l;
	Paginas *novaPagina = criaPaginasNull();

	while(aux != NULL){	
		if(strcmp(aux->nome, texto)==0){
			aux->paginasDoLivro = inserirPaginaOrdenado(aux->paginasDoLivro, pg);
			return l;
		}
		aux = aux->proxNome;
	}

	Nomes *novo;
	novo = (Nomes*)malloc(sizeof(Nomes));
	novo->paginasDoLivro = inserirPaginaOrdenado(novaPagina, pg);
	
	strcpy(novo->nome,texto);

	novo->proxNome = l;

	return novo;
}

Nomes* inserirStringSeparada(Nomes *l, char *nome, int pg){
	
	char *nomeSeparado = malloc(sizeof(char)*100);

	nomeSeparado = strtok(nome, " ");

	while(nomeSeparado != NULL){
		l = inserirNomeNaLista(l, nomeSeparado, pg);
		nomeSeparado = strtok(NULL, " ");
	}

	return l;
}






void imprimirNomeTodosIndices(Nomes *l, char *nome){
	Nomes *auxNome = l;
	Paginas *auxPagina;
	int cont=0;
	while(auxNome != NULL){	
		if(strcmp(nome, auxNome->nome)==0){	
			printf("\nAparece nas paginas o nome: \"%s\" =  ", nome);

			auxPagina = auxNome->paginasDoLivro;			
			while(auxPagina!= NULL){
				printf("[%d] ", auxPagina->pg);
				auxPagina= auxPagina->proxPagina;
			}
			printf("\n\n");
			cont++;
			break;
		}
		auxNome = auxNome->proxNome;
	}
	if(cont==0){
		printf("\tO nome recebido nao existe em nosso Livro de Nomes!!\n\n");
	}
}



void imprimirTodosNomesTodosIndices(Nomes* l){
	Nomes *aux = l;
	Paginas *aux1;
	while(aux != NULL){	
		printf("Aparece nas paginas o nome: \"%s\" = ", aux->nome);
		aux1 = aux->paginasDoLivro;

		while(aux1 != NULL)
		{ 
			printf("[%d] ",aux1->pg);
			aux1 = aux1->proxPagina;
		}
		printf("\n");
		aux = aux->proxNome;
	}
}


/*Verificando o tipo de busca a ser realizado, simples ou composta.*/
void verificarTipoDeBusca(Nomes *l,char *nome){

	int i, cont=0;
	for(i=0; i<strlen(nome)+1; i++)//CONTA A QUANTIDADE DE PALAVRAS
	{	

		if(nome[i] == ' ')
		{
			cont++;
		}
		else if(nome[i] == '\0')
		{
			cont++;
		}
	}

	if(cont > 1)// O NOME COMPOSTO
	{
		buscaStringSeparadas(nome, cont, l);
	}
	else//O NOME SIMPLES
	{
		imprimirNomeTodosIndices(l, nome);
	}
}

/*Verifico se na minha Matriz de char, se todos os nomes dentro da Matriz estão na ListaNomes*/
void buscaStringSeparadas(char *texto, int cont, Nomes *l){
	
	int i=0,j;
	//cont - total de palavras
	//texto - nome recebido

	//DECLARANDO MATRIX DE CHAR
	char **palavras = (char**)malloc(cont * sizeof(char*));
	for(j=0;j<cont;j++)
	{
		palavras[j] = (char*)malloc(100 * sizeof(char));	
	}


	/*Separo o meu nome e armazeno na Matriz*/
	palavras[i] = strtok(texto, " ");//strtok retorna o ponteiro para a palavra que vem antes do espaco;
	while(palavras[i] != NULL)
	{	
		i++;
		palavras[i] = strtok(NULL, " ");
	}

	/*Verifico se os nomes existem na minha Lista de Nomes*/
	j=0;
	Nomes *aux = l;
	for (i = 0; i < cont; i++)
	{	
		while(aux != NULL)
		{
			if(strcmp(palavras[i],aux->nome) == 0)
			{
				j++;
			}
			aux = aux->proxNome;
		}
		aux = l;
	}
	/*Se sim, chamo minha funcao buscarStringComposto*/
	if(j==cont)
	{
		buscaStringComposta(palavras, l, cont);
	}
	//Se nao, o nome nao existe
	else
	{

		printf("O nome buscado nao existe no livro! por favor digite uma nome validade\n");
		return;
	}

}

void buscaStringComposta(char **palavras, Nomes *l, int cont){
	
	int i,j,tamanhoVetor=-1, verificador = 0;
	Nomes *aux = l;
	Paginas *aux2;
	
	int v[100];

	/*Processo para achar o unico(primeiro) nome que tem lá, q seja igual da matriz*/
	while(aux != NULL){
		if(strcmp(palavras[0],aux->nome) == 0)
		{	

			aux2 = aux->paginasDoLivro;
			while(aux2 != NULL)
			{
				tamanhoVetor++;
				v[tamanhoVetor] = aux2->pg;
				aux2 = aux2->proxPagina;
			}

		}
		aux = aux->proxNome;
	}


	/*   */
    aux = l;

	for(i=1;i<cont;i++){ // Percorrer todos os nomes da minha matriz, de 1 porque o 0 já foi
		while(aux != NULL){ //Percorro a lista de Nomes para encontrar os nomes restantes		
			if(strcmp(palavras[i],aux->nome) == 0){	

				for (j = 0; j <tamanhoVetor+1; j++){// Aqui eu percorro o meu vetor auxiliar(paginas) do primeiro nome. 		
					
					aux2 = aux->paginasDoLivro;//Aux2 Pagina do livro para percorrer daquele livro


					while(aux2 != NULL){// percorro as paginas do meu segundo nome encontrado em diante
						if(v[j] == aux2->pg){// verifico quais paginas do meu vetor sao iguais a paginas do meu segundo nome 
							verificador++;
						}

							aux2 = aux2->proxPagina;
					}

					if(verificador==0){
						v[j] = -1;
					}

					verificador=0;
				}
			}
			aux = aux->proxNome;
		}
	}

	printf("\nO nome ");
	for (i = 0; i < cont; i++){
		printf("%s ", palavras[i]);
	}

	printf("Aparece na(s) pagina(s): ");
	for(i=0;i<tamanhoVetor+1;i++)
	{	
		if(v[i] != -1)
		printf("%d,", v[i]);
	}
	printf("\n");

}


