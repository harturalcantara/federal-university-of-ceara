#include <stdio.h>
#include <stdlib.h>
#include <string.h>


int* permutacaolinha(int** mat, int m, int n,int l, int c){
    int i,j;
//    mat = (int*)malloc(sizeof(int)*m);
//    for(i=0;i<n;i++){
//        mat[i]=(int*)malloc(sizeof(int)*m);
//    }
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            printf("Digite numero da matriz [%d][%d]:",i,j);
            scanf("%d",&mat[i][j]);
        }
        printf("\n");
    }
    printf("Matriz recebida:\n");
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            printf("[%d] ",mat[i][j]);
        }
        printf("\n");
    }

    int k=0;
    for(i=0;i<m;i++){
            mat[l][i] = mat[i][c];
            k++;
    }

    printf("Matriz nova:\n");
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            printf("[%d] ",mat[i][j]);
        }
        printf("\n");
    }



}


int main()
{
    int **mat;
    int m,n,i,j;
    printf("Digite o tamanho da Matriz:");
    scanf("%d",&m);
    scanf("%d",&n);
    mat = (int*)malloc(sizeof(int)*m);
    for(i=0;i<n;i++){
        mat[i]=(int*)malloc(sizeof(int)*m);
    }

    int l,c;
    printf("Digite a linha que virá coluna:");
    scanf("%d",&l);
    printf("\nDigite a coluna que virá linha:");
    scanf("%d",&c);

    permutacaolinha(mat,m,n,l,c);
    return 0;
}
