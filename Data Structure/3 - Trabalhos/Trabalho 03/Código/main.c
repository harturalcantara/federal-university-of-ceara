#include <stdio.h>
#include <stdlib.h>
#include "cartasPilha.h"
#include "pessoasFilaLista.h"



int main(){
	/*Lista que coterao o relatória das cartas que foram doadas e roupas recebidas*/
	RelatorioRoupa* relatorio_roupas = criaRoupa();
	RelatorioCarta* relatorio_cartas = criaCarta();

	/*Criando cartas e roupas*/
	Carta* card1 = cria_Carta();
	Carta* card2 = cria_Carta();
	Carta* card3 = cria_Carta();
	Carta* card4 = cria_Carta();
	Carta* card5 = cria_Carta();


	preencherCarta(&card1, "Black_Dragon" , 2);
	preencherCarta(&card2, "X-Saber_Sousa", 3);
	preencherCarta(&card3, "Red_Dragon" , 6);
	preencherCarta(&card4, "Token", 5);
	preencherCarta(&card5, "Black_Rose" , 1);

	
	Roupa* roupa1 = cria_Roupa();
	Roupa* roupa2 = cria_Roupa();
	Roupa* roupa3 = cria_Roupa();
	Roupa* roupa4 = cria_Roupa();
	Roupa* roupa5 = cria_Roupa();

	preencherRoupa(roupa1, "camiseta", 'P', "azul");
	preencherRoupa(roupa2, "short", 'M', "lilas");
	preencherRoupa(roupa3, "bermuda", 'G', "roxo");
	preencherRoupa(roupa4, "short", 'M', "amarelo");
	preencherRoupa(roupa5, "casaco", 'P', "vermelho");



	/*Criando a pilha de cartas!*/

	Pilha* pilha_cartas = p_cria();
	p_push( pilha_cartas, card1 );
	p_push( pilha_cartas, card2 );
	p_push( pilha_cartas, card3 );
	p_push( pilha_cartas, card4 );
	p_push( pilha_cartas, card1 );
	// p_push( pilha_cartas, card2 );
	// p_push( pilha_cartas, card3 );
	// p_push( pilha_cartas, card4 );
	// p_push( pilha_cartas, card1 );
	// p_push( pilha_cartas, card2 );
	// p_push( pilha_cartas, card3 );
	// p_push( pilha_cartas, card4 );
	//p_push( pilha_cartas, card5 );
	//p_push( pilha_cartas, card4 );
	//p_push( pilha_cartas, card5 );

	/*Fazendo a fila de pessoas, cotendo o nome e as roupa criadas!*/
	Fila* casa_loterica = f_cria();
	inserir_pessoa_fila( casa_loterica, "Manel", roupa1 );
	inserir_pessoa_fila( casa_loterica, "Hartur", roupa2 );
	inserir_pessoa_fila( casa_loterica, "Daniel", roupa1 );
	inserir_pessoa_fila( casa_loterica, "Alimpi", roupa1 );
	inserir_pessoa_fila( casa_loterica, "Cosmo", roupa1 );



	/*Estrutura do Menu!*/
	int op = -1;
	while(op!=0){
		printf("\n");
		printf("1 - Estado da pilha de cartas do Kaiba.\n");
		printf("2 - Estado das pessoas que estao na fila.\n");
		printf("3 - Relizar a troca de roupa por uma carta.\n");
		printf("4 - Relatorio das cartas que foram doadas.\n");
		printf("5 - Relatorio das roupas que foram doadas.\n");
		printf("0 - Sair.\n");

		printf("Escolha uma das opcoes acima!\n");
		scanf("%d",&op);

		if(op == 1){
			printf("\t\t[Pilha] - Atual!\n");
			imprime(pilha_cartas);
		}
		else if(op == 2){		
			printf("\t\t[Fila] - Minha fila de pessoas\n");
			fila_imprime(casa_loterica);
		}
		else if(op == 3){
			troca(casa_loterica, pilha_cartas, &relatorio_roupas, &relatorio_cartas);
		}
		else if(op == 4){
			printf("\t\t[Relatorio Cartas]: \n");
			imprime_Relatorio_Cartas(relatorio_cartas);
		}
		else if(op == 5){
			printf("\t\t[Relatorio Roupas Doadas]:\n");
			imprime_Relario_Roupas(relatorio_roupas);
		}
		else if(op == 0){
			printf("Até mais\n");
			p_libera(pilha_cartas);
			f_libera(casa_loterica);
			l_liberaRoupa(relatorio_roupas);
			l_liberaCarta(relatorio_cartas);
			free( card1);
			free( card2);
			free( card3);
			free( card4);
			free( card5);

			free( roupa1);
			free( roupa2);
			free( roupa3);
			free( roupa4);
			free( roupa5);
			break;
		}
	}

	
}