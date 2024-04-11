#include <unistd.h>
#include <stdlib.h>
#include <stdio.h>
#include <pthread.h>

int fd[2];//File descriptor for creating a pipe

//This function continously reads fd[0] for any input data byte
//If available, prints

void *reader(){
   while(1){
      char    ch;
      //int     result;
      char  *result;

      result = read (fd[0],&texto,1);
      /*
      if (result != 1) {
        perror("read");
        exit(3);
      }
      */

      printf ("Reader: %d\n", ch);   
      break;
    }
}

//This function continously writes Alphabet into fd[1]
//Waits if no more space is available

void *writer()
{
   int     result;
   char    ch='A';
   char texto[50];
   scanf("%s",texto);

   while(1){
       result = write (fd[1], &texto,1);
       if (result != 1){
           perror ("write");
           exit (2);
       }

       printf ("Writer: %s\n", texto);
       if(ch == 'Z')
         ch = 'A'-1;

       ch++;
       break;
   }
}

int main()
{
   pthread_t tid1,tid2;
   int result;

   result = pipe (fd);
   if (result < 0){
       perror("pipe ");
       exit(1);
   }

   pthread_create(&tid1,NULL,reader,NULL);
   pthread_create(&tid2,NULL,writer,NULL);

   pthread_join(tid1,NULL);
   pthread_join(tid2,NULL);
}