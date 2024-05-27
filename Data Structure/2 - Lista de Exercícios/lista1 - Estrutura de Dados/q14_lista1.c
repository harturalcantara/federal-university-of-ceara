#include <stdio.h>
#include <stdlib.h>


int funcaocomprimos(int n, int m){
    int i,maior;
    if(n>m){
        maior = n;
    }else
        maior = m;
    for(i=2;i<=maior;i++){
        if(n%i==0 && m%i==0){
            return 0;
        }
    }
    return 1;
}


int main(){
    int a,b;
//    printf("Digite numero A:\n");
//    scanf("%d",&a);
//    printf("Digite numero B:\n");
//    scanf("%d",&b);
//
//    if(funcaocomprimos(a,b)==0){
//        printf("Nao sao comprimos\n");
//    }else
//        printf("Sao comprimos!!\n");

    int **mat;
    int matriz[9][9];
    int i,j;
    for(i=0;i<9;i++){
        for(j=0;j<9;j++){
            matriz[i][j]=0;
            matriz[i][0]=i;
            matriz[0][i]=i;
        }
    }
    for(i=1;i<9;i++){
        for(j=1;j<9;j++){
            if(funcaocomprimos(matriz[i][0],matriz[0][j])==1)
                matriz[i][j]=1;
            else
               matriz[i][j]=0;
        }
    }

     for(i=0;i<9;i++){
        for(j=0;j<9;j++){
            printf("%d ",matriz[i][j]);
        }
        printf("\n");
    }


    return 0;
}
