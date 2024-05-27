#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <fcntl.h>
#include <netdb.h>
#include <netinet/in.h>
#include <string.h>
#include <sys/socket.h>
#include <sys/types.h>
#define MAX 80
#define PORT 8080
#define SA struct sockaddr
void func(int sockfd){
  char buff[MAX];
  int n;
  for(;;){
    bzero(buff,MAX);

    read(sockfd,buff,sizeof(buff));
    printf("Cliente : %s ",buff);
    
    bzero(buff,MAX);
    n = 0;

    while((buff[n++] = getchar()) != '\n')
      ;

    write(sockfd,buff,sizeof(buff));

    if(strncmp("exit",buff,4) == 0){
      printf("Exit ....\n");
      break;
    }
  }
}
int main(){
  int sockfd;
  int connfd;
  int len;
  struct sockaddr_in servaddr;
  struct sockaddr_in cliente;
  sockfd = socket(AF_INET,SOCK_STREAM,0);
  if(sockfd == -1){
    printf("falha na criacao do socket\n");
    exit(0);
  }
  else
    printf("Socket criado com sucesso\n" );
  bzero(&servaddr,sizeof(servaddr));
  servaddr.sin_family = AF_INET;
  servaddr.sin_addr.s_addr = htonl(INADDR_ANY);
  servaddr.sin_port = htons(PORT);

  if((bind(sockfd,(SA*)&servaddr,sizeof(servaddr))) != 0){
    printf("falha no bind ... \n");
    exit(0);
  }
  else
    printf(":) ...\n");

  if((listen(sockfd,5)) != 0){
    printf("falha ...\n");
    exit(0);

  }
  else
    printf("sucesso ...\n");
  len = sizeof(cliente);

  connfd = accept(sockfd,(SA*)&cliente,&len);
  if(connfd < 0 ){
    printf("falha na conexao com servidor\n");
    exit(0);
  }
  else
    printf("servido  aceitou a conexao\n");

  func(connfd);

  close(sockfd);
}
