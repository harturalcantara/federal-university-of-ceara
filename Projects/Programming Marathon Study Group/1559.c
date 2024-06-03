#include <stdio.h>
#include <stdlib.h>



int cima(int matriz[][4]){

int i;
    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            if(matriz[0][j] == 0){

            }
        }
    }


}

int main()
{
    int jogo[4][4];

    int i,j, teste;
    scanf("%d",&teste);
    int cima, baixo, esquerda, direita;
    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            jogo[i][j] = 0;
        }
    }
    for(i=0;i<4;i++){
        for(j=0;j<4;j++){
            scanf("%d",&jogo[i][j]);
        }
    }

    cima(jogo)


    return 0;
}
