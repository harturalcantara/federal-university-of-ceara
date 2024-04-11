#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include <unistd.h>

//#define TRUE 1
//#define FALSE 0

int cont_homem = 0;                    //armazena quantidade de homens no banheiro
int cont_mulher = 0;                    //armazena quantidade de mulheres no banheiro    
int max = 0;                        //indica que o banheiro esta vazio
int statusPessoa = 0; /*Estado em que o banheiro se encontra, 0 para homens, 1 para mulheres.*/
int banheiroDesocupado = 0;/*0 se sim está ocupado, 1 para se não*/

void homem_quer_entrar(){
    //while(1){

            if(banheiroDesocupado == 0){
            	statusPessoa = 0;
            	banheiroDesocupado = 1;
        	}

            if(cont_homem < 2 && statusPessoa == 0 && banheiroDesocupado == 1){
                cont_homem++;
            	printf("[Homem] - Homem entrou no banheiro\n");
                //printf("Quantos homens tem no banheiro: %d\n",cont_homem);
                //banheiro = FALSE;
                sleep(1);
            }
            
            //sleep(1);
        //}

        sleep(1);

        //while(com_homem < 3 && banheiro == FALSE){
            if(cont_homem > 0 && statusPessoa == 0){
                printf("\t\tQuantos homens tem no banheiro: %d\n", cont_homem);
                cont_homem--;
                printf("[Homem] - Homem saiu do banheiro\n");
                printf("\t\tQuantos homens tem no banheiro: %d\n", cont_homem);

                if(cont_homem == 0 && banheiroDesocupado == 1){
                    banheiroDesocupado = 0;
                    printf("[BANHEIRO VAZIO]\n");
                }
                //sleep(1);
            }
            //sleep(1);
        //}
        sleep(1);
        
    //}
}



void mulher_quer_entrar(){

	if(banheiroDesocupado==0){
    	statusPessoa = 1;
    	banheiroDesocupado = 2;
	}

    //while(cont_mulher < 2 && statusPessoa == 1){
        if(cont_mulher < 2 && banheiroDesocupado == 2 && cont_homem == 0){
            cont_mulher++;
            printf("---[Mulher] - Mulher entrou no banheiro\n");
            //sleep(1);
        }
        sleep(2);      
    //}
    //sleep(1);

    //while(com_mulher < 2 && banheiroDesocupado == 2){
        if(cont_mulher > 0 && banheiroDesocupado == 2){
            cont_mulher = cont_mulher - 1;
            printf("---[Mulher]- Mulher saiu do banheiro\n");
            if(cont_mulher == 0 && cont_homem == 0 && banheiroDesocupado == 2){
                banheiroDesocupado = 0;
                printf("---[BANHEIRO VAZIO]\n");
            }

        }
        sleep(3);
    //}
    //sleep(1);
}

int main(){


    pthread_t homemEntra,homemSai;
    pthread_t mulherEntra,mulherSai;
    srand(time(NULL));
    
    while(1){
        int x = rand()%100 + 1;
        //printf("%d\n",x);
        if(x > 50){

            pthread_create(&homemEntra,NULL,(void *) &homem_quer_entrar, NULL);
            //pthread_join (homemEntra, NULL);
            //pthread_join (homemSai, NULL);
        }
        else{
            pthread_create(&mulherEntra,NULL,(void *) &mulher_quer_entrar, NULL);
            //pthread_join (mulherEntra, NULL);
            //pthread_join (mulherSai, NULL);
        }
        //pthread_join (homemEntra, NULL);
        //pthread_join (homemSai, NULL);
        //pthread_join (mulherEntra, NULL);
        //pthread_join (mulherSai, NULL);
    }


}