#include<stdio.h>
#include<stdlib.h>


void numerospares(int n){
    if(n==0){
        printf("[%d]",0);
    }else{
        if(n%2==0){
            printf("[%d] ",n);
        }
        numerospares(n-1);
    }

}

int main(){
    int x;
    scanf("%d",&x);

    numerospares(x);
}

