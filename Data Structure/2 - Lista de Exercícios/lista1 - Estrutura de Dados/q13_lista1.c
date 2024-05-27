#include <stdio.h>
#include <stdlib.h>


int funcaocomprimos(int n, int m){
    int i,maior;
    if(n>m){
        maior = n;
    }else
        maior = m;
    for(i=2;i<maior;i++){
        if(n%i==0 && m%i==0){
            return 0;
        }
    }
    return 1;
}


int main(){
    int a,b;
    printf("Digite numero A:\n");
    scanf("%d",&a);
    printf("Digite numero B:\n");
    scanf("%d",&b);

    if(funcaocomprimos(a,b)==0){
        printf("Nao sao comprimos\n");
    }else
        printf("Sao comprimos!!\n");

    return 0;
}
