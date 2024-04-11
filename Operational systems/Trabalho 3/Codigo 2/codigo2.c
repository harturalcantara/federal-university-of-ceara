#include <stdio.h>
#include <stdlib.h>
//BICLIOTECAS ADICIONAIS
#include <pthread.h>
#include <semaphore.h>
//DEFINIDO VALORES VERDADE E FALSE
#define TRUE 1
#define FALSE 0
//MEU TIPO TRAVA
int estado = FALSE; 
//MINHA MEMORIA COMPARTILHADA ENTRE AS THREADS;
char tamanho[1024];

	///FUNCAO SALVAR NO ARQUIVO
void salvaNoArquivo(char *n){
    FILE *arquivo;
        char vetorArquivo[] = "Trabalho - [S.O].txt";
        arquivo = fopen(vetorArquivo, "w");
        //VERIFICACAO
        if(arquivo == NULL)
             printf("DEU RUIM DEMAIS, NAO CONSIGO ABRIR O ARQUIVO!\n");
        //SE OCORREU TUDO BEM, FAZ:
        else{
            //SALVANDO MSG NO AQUIVO
            fprintf(arquivo, "STRING RECEBIDA PELO PROCESSO FILHO: [%s]\n", n);
        }
    fclose(arquivo);
}

	///TRHEAD PAI VAI RECEBER DO USUARIO;
void *leitor(){
        while(1){
            if(estado==FALSE){
                printf("[Thread Pai] - Digite sua mensagem:");
                scanf("%s",tamanho);
                estado=TRUE;
            }
        }
}
	///TRHEAD FILHO VAI RECEBER DO PAI E SALVAR NA STRING;
void *escreve(){
        while(1){
            if(estado==TRUE){
                printf("[Thread Filho] - A String recebida mandada pelo pai e: [%s]\n",tamanho);
                salvaNoArquivo(tamanho);
                estado=FALSE;
            }
        }
}

int main(){

        pthread_t threadLer,threadEscreve;

        pthread_create(&threadLer,NULL,leitor,NULL);
        pthread_create(&threadEscreve,NULL, escreve,NULL);
        while(1);
        return 0;
}

//gcc threads.c -lpthread