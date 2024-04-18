#include <stdio.h>
#include <stdlib.h>
#include <limits.h>

typedef struct {
  int cliente_num;
  int duracao_num;
} SERVIDOR;

int extrair_menor(SERVIDOR *arr, int n){
    int i, k, index;
    double menor = INT_MAX;
    for (i=0; i<n; i++){
      if(arr[i].duracao_num < menor){
        menor = arr[i].duracao_num;
        index = i;
      }
    }
    return index; //retornando o indice do cliente com menor duracao
}

void ler_dados(SERVIDOR *arr, int n) {
    int i;
    for (i=0; i<n; i++){
        printf("Cliente: ");
        scanf("%d",&(arr)[i].cliente_num);    
        printf("Duracao: ");
        scanf("%d",&(arr)[i].duracao_num);    
        getchar();
    }    
}

void mostrar_dados(SERVIDOR *arr, int n){
    int i;
    for (i=0; i<n; i++){
        printf ("Numero do cliente: %d \n", arr[i].cliente_num);
        printf ("Seu tempo de duracao: %d \n", arr[i].duracao_num);
    }
}

int main(){
  
  int i, x=2;
  printf("Digite quantidade clientes:\n");
  scanf("%d",&x);

  SERVIDOR arr[x];

  printf("Lendo dados dos clientes:\n");
  ler_dados(arr, x);
  printf("\n");
  mostrar_dados(arr, x);
  printf("\n");
  
  double tempo=0;
  double inicia_serv[x];

  for(i=x-1; i >= 0; i--){
    int cli_menor_dur = extrair_menor(arr, x);
    inicia_serv[i] =  arr[cli_menor_dur].cliente_num;
    tempo = tempo + arr[cli_menor_dur].duracao_num;
    arr[cli_menor_dur].duracao_num = INT_MAX;
  }

  printf("Ordem dos usuarios para serem atendidos:\n");
  double somar=0;
  for( i=x-1; i >= 0; i--)
    printf("%2.f\n", inicia_serv[i]);

}

/**PROPRIEDADE GULOSA
 * 
 *  Escolha Gulosa
 * Como queremos minimizar o tempo para que os clientes possam ser atendidos, ou seja o tempo de espera
 * então pegue o cliente com a menor duração possivel e o sirva primeiro, dessa forma o primeiro a 
 * ser atendido tera um tempo de espera 0, e como ele tinha a menor duracao, essa escolha foi a menor
 * tempo de espera para o proximo cliente. 
 * 
 *  Prova
 * Suponha que ao inves de pegar o menor tempo de duracao voce pega o maior, se vc pega o de maior tempo 
 * duracao vc obtem um custo 0 para o primeiro cliente, mas o proximo usuario tem que esperar o tempo pa-
 * ra que o usuario na frente dele possa ser servido, mas como ele é o maior tempo de duraele vai demorar
 * mais dos que todos os outros, o que e absurdo! Pois vc quer diminuir o tempo de espera.
 * 
*/