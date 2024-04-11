#include <stdio.h>
#include <stdlib.h>
//BICLIOTECAS ADICIONAIS
#include <pthread.h>
#include <semaphore.h>
//DEFINIDO VALORES VERDADE E FALSE
#define TRUE 1
#define FALSE 0

char tamanho[1024];
pthread_mutex_t lock= PTHREAD_MUTEX_INITIALIZER;
    //MINHA TRAVA
int string_read=FALSE;

pthread_cond_t cond;

	//SALVANDO NO ARQUIVO STRING RECEBIDA
void salvaNoArquivo(char *string){
                    FILE *arquivo;
                        char vetorArquivo[] = "Trabalho.txt";
                        arquivo = fopen(vetorArquivo, "w");
                        //VERIFICACAO
                        if(arquivo == NULL)
                             printf("DEU RUIM DEMAIS, NAO CONSIGO ABRIR O ARQUIVO!\n");
                        //SE OCORREU TUDO BEM, FAZ:
                        else{
                            //SALVANDO MSG NO AQUIVO
                            fprintf(arquivo, "STRING RECEBIDA PELO PROCESSO FILHO: [%s]\n", string);
                        }
                    fclose(arquivo);
}

    //FUNCAO RECEBE DO USUARIO
void *leitor(){
        while(1){
            while(string_read);
                pthread_mutex_lock(&lock);
                    printf("[Thread Pai] - Digite sua mensagem:");
                    scanf("%s",tamanho);
                    string_read=TRUE;
                pthread_mutex_unlock(&lock);

                pthread_cond_signal(&cond);
                /*
                desbloqueia pelo menos um dos segmentos que estão bloqueados 
                na variável de condição especificada cond (se algum tópico estiver bloqueado em cond ).
                */
                break;
            
        }
}
    //FUNCAO IMPRIME O QUE USUARIO DIGITOU e Salva no Arquivo
void *escreve(){
        while(1){
            pthread_mutex_lock(&lock);
            while(!string_read)
            pthread_cond_wait(&cond,&lock);

            printf("[Thread Filho] - A String recebida mandada pelo pai e: [%s]\n",tamanho);
            salvaNoArquivo(tamanho);
            string_read=FALSE;
            pthread_mutex_unlock(&lock);

            break;
            
        }
}

int main(){
        pthread_t threadLer,threadEscreve;

        pthread_create(&threadLer,NULL,leitor,NULL);
        pthread_create(&threadEscreve,NULL, escreve,NULL);

        pthread_join( threadLer, NULL);
        pthread_join( threadEscreve,NULL);

        printf("[MAIN] - A String recebida mandada pelo pai e: [%s]\n",tamanho);
        /*
         pthread_join() uma thread pode esperar pela terminação duma thread específica.
        */
        return 0;
}