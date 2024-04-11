#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <time.h>
#include <unistd.h>
#define TRUE 1
#define FALSE 0

int estadoMulher = FALSE;
int estadoHomem = FALSE;

         
int com_homem = 0;
int com_mulher = 0;
int banheiro = FALSE; /*O estado em que o banheiro se encontra, FALSE para homens, TRUE para mulheres*/
int banheiroDesocupado = 0;/*[0 se sim, 1 para se nao ele ta ocupado]*/



void homem_quer_entrar(){
    //printf("Estou aqui PARADO :c %d \n", vazio);
    if(banheiroDesocupado==0){
    	banheiro = FALSE;
    	banheiroDesocupado = 1;
	}
	//printf("SEM INCREMENTO - qts homens %d\n",com_homem );
    while(com_homem < 3 && banheiro == FALSE && banheiroDesocupado == 1 && com_mulher == 0){
        	com_homem = com_homem + 1;
        	//printf(" COM INCREMENTO - Qts homens: %d \n", com_homem);
        	printf("[Entrou Homem %d] - Homem entrou no banheiro\n", com_homem);
        	banheiro = FALSE;
            sleep(1);
            return;
    }
    sleep(2);
}

void homem_sai(){
	printf("Na funcao SAI - Qts homens: %d \n", com_homem);
    while(com_homem < 3 && banheiro == FALSE){
        if(com_homem > 0 && banheiro == FALSE && banheiroDesocupado){
        		com_homem = com_homem - 1;
        		//printf("Na funcao SAI - Qts homens: %d \n", com_homem);
        		printf("[Saiu Homem %d] - Homem saiu do banheiro\n", com_homem);
        		sleep(1);

        		 if(com_homem == 0 && banheiro == FALSE){//SE MEU BANHEIRO ESTIVER VAZIO ELE VAI PERGUNTAR QUE VAI ENTRAR AGORA
		        	banheiro = TRUE;
		        	banheiroDesocupado = 0;
		            //verifica = 0;
		            printf("[BANHEIRO VAZIO] - Banheiro se encontra vazio\n");
		            return;
    			}
    		sleep(1);
        	return;
        }
       
        sleep(1);
    }
}




void mulher_quer_entrar(){
	if(banheiroDesocupado == 0){
    	banheiro = TRUE;
    	banheiroDesocupado = 2;
	}
	
    while(com_mulher < 2 && banheiro == TRUE && banheiroDesocupado == 2){
        if(com_mulher < 5){
            com_mulher = com_mulher + 1;
            printf("---[Mulher Entrou %d] - Mulher entrou no banheiro\n", com_mulher);
            //printf("Quantos homens tem no banheiro: %d\n", vazio);
            //banheiro = TRUE;
            
            //sleep(1);
        }
        sleep(1);
        return; 
    }
    //sleep(2);
}

void mulher_sai(){

	

    //while(com_mulher < 2 && banheiro == TRUE && banheiroDesocupado == 2){
        if(com_mulher > 0 && banheiro == TRUE && banheiroDesocupado == 2){
            com_mulher = com_mulher - 1;
            printf("---[Mulher Saiu]- Mulher saiu do banheiro\n");
            sleep(1);
            if(com_mulher == 0 && banheiroDesocupado == 2){
	            banheiroDesocupado = 0;
	            printf("---[BANHEIRO VAZIO]\n");
	            sleep(1);
	            return;
   			}
            return;
        }

        if(com_mulher == 0 && banheiro == TRUE && banheiroDesocupado == 2){
            banheiroDesocupado = 0;
            printf("---[BANHEIRO VAZIO]\n");
            sleep(1);
            return;
        }
    //}
}









int main(){

    pthread_t homemEntra,homemSai;
    pthread_t mulherEntra,mulherSai;
    srand(time(NULL));
    
    while(1){
    	int x = rand()%100 + 1;
    	printf("%d\n",x);
    	if(x > 50){

	        pthread_create(&homemEntra,NULL,(void *) &homem_quer_entrar, NULL);
	        pthread_create(&homemSai,NULL,(void *) &homem_sai,NULL);
	        pthread_join (homemEntra, NULL);
	        pthread_join (homemSai, NULL);
    	}
    	else{
	        pthread_create(&mulherEntra,NULL,(void *) &mulher_quer_entrar, NULL);
	        pthread_create(&mulherSai,NULL, (void *) &mulher_sai, NULL);
	        pthread_join (mulherEntra, NULL);
	        pthread_join (mulherSai, NULL);
    	}
        //pthread_join (homemEntra, NULL);
        //pthread_join (homemSai, NULL);
        //pthread_join (mulherEntra, NULL);
        //pthread_join (mulherSai, NULL);
    }


}