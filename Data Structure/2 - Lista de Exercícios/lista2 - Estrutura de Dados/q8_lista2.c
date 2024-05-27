#include<stdio.h>
#include<stdlib.h>


void primosdecrescente(int n){
    int cont=0;
    if(n==0){
        printf("[%d]",0);
    }
    else{
        int i;
        for(i=2;i<n;i++){
            if(n%i==0){
                cont++;
            }
        }
        if(cont==0){
                printf("[%d] ",n);
            }
            primosdecrescente(n-1);
        }
}

int main(){
    int x;
    scanf("%d",&x);

    primosdecrescente(x);
}

