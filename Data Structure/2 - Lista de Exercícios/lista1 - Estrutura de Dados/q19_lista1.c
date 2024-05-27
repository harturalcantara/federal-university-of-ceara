#include <stdio.h>
#include <stdlib.h>

int main()
{
    int matriz[3][3];
    int i,j;
    int k =0;
    printf("DIGITE OS VALORES DA MATRIZ:\n");
    for(i=0;i<3;i++){
        for(j=0;j<3;j++){
            printf("Na matriz [%d][%d]:",i,j);
            scanf("%d",&matriz[i][j]);
        }
    }
    ///IMPRIMINDO A MATRIZ RECEBIDA APENAS;
    for(i=0;i<3;i++){
        for(j=0;j<3;j++){
            printf("[%d] ",matriz[i][j]);
        }
        printf("\n");
    }

    ///Declarando a primeira linha como a K;
    for(i=0;i<3;i++){
        k = k + matriz[0][i];
    }

    int aux;
    int linhaDireita =0;
///LinhaDireita;
    for(i=0;i<3;i++){
        aux=0;
        for(j=0;j<3;j++){
            aux = aux + matriz[i][j];
        }
        if(aux == k){
            printf("Progresso Linha a DIREITA\n");
            linhaDireita++;
        }
    }
    printf("\t\tLinhaDireita = [%d]\n",linhaDireita);

///LinhaEsquerda;
    int linhaEsquerda = 0;
    for(i=0;i<3;i++){
        aux=0;
        for(j=2;j>=0;j--){
            aux = aux + matriz[i][j];
        }
        if(aux == k){
            printf("Progresso na Linha a Esquerda\n");
            linhaEsquerda++;
        }
    }
    printf("\t\tLinhaEsquerda [%d]\n",linhaEsquerda);

///TODAS AS COLUNAS;
    int baixo=0;
    if(linhaEsquerda>0){
        for(j=0;j<3;j++){
            aux=0;
            for(i=0;i<3;i++){
                aux = aux + matriz[i][j];
            }
            if(aux == k){
                printf("MEU AUX = K -> Progresso [%d] Coluna para Baixo\n",j); //3x;
                baixo++;
            }
        }
    }
    printf("\t\tColunasBaixo = [%d]\n", baixo);

///DIAGONAL A DIREITA;
    int diagonalDireita=0;
    if(baixo>0){
        aux=0;
        for(i=0;i<3;i++){
            aux = aux + matriz[i][i];
            printf("AUX = %d && K = %d\n",aux,k);
            if(aux == k){
                diagonalDireita++;
            }
        }
        printf("\t\tDiagonalDireita: [%d]\n",diagonalDireita);
    }
///DIAGONAL A ESQUERDA;
    int diagonalEsquerda=0;
    if(diagonalDireita>0){
        aux=0;
        for(i=2;i>=0;i--){
            aux = aux + matriz[i][i];
            printf("AUX = %d && K = %d\n",aux,k);
            if(aux == k){
                diagonalEsquerda++;
            }
        }
        printf("\t\tDiagonalEsquerda: [%d]\n",diagonalEsquerda);
    }

    if(linhaDireita==0||linhaEsquerda==0||baixo==0||diagonalDireita==0){
        printf("N e quadrado magico");
    }else{
        printf("E Quadrado magico");
    }
    return 0;
}
