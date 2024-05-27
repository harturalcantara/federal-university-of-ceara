#include<stdio.h>
#include<stdlib.h>


void decrescente(int n){
    if(n==0){
        printf("[%d]",n);
    }else{
        printf("[%d] ",n);
        decrescente(n-1);
    }

}

int main(){
    int x;
    scanf("%d",&x);

    decrescente(x);
}
