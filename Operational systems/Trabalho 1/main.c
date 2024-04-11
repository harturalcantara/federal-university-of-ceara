///EQUIPE
///HARTUR ALCANTARA.
///ALIMPIO BRITO.
#include <stdio.h>
#include <stdlib.h>
int main(){
    FILE *arquivo = fopen("criadopormim.txt","r");//LEIO O ARQUIVO QUE CRIEI NA PASTA DO COD BLOCKS
    FILE *arquivoNew = fopen("crianovoarquivo","w");//ABRO UM NOVO AQUIVO NO MODO DE ESCRITA, ELE DESTROI O Q TEM LA E ABRE UM NOOVO EM FOLHA
    int i;
    while((i = fgetc(arquivo)) != EOF){//ENQUANTO ELE N CHEGA NO FIM DO ARQUIVO ELE FAZ:
        putchar(i);//IMPRIMI O Q TEM NO ARQUIVO
        fputc(i,arquivoNew);//ELE PASSA 1 CARACTERE, E MOVE PARA O PROXIMO CARACTERE.
    }
    return 0;
}
