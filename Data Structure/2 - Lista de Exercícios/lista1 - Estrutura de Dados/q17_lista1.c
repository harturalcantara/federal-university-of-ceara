#include <stdio.h>
#include <stdlib.h>

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

    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            printf("Digite os numeros da matris [%d][%d]",i,j);
            scanf("%d",&mat[i][j]);
        }
    }
    printf("Sua Matriz:\n");
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            printf("[%d]", mat[i][j]);
        }
        printf("\n");
    }
    printf("\n");
    printf("Sua Matriz Transporta:\n");
    for(i=0;i<n;i++){
        for(j=0;j<m;j++){
            printf("[%d]", mat[j][i]);
        }
        printf("\n");
    }
    return 0;
}
