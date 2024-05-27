#include<stdio.h>
#include<stdlib.h>

void crescente(int n){
    if(n==0){
        printf("[0] ");
    }else{
        crescente(n-1);
        printf("[%d] ",n);
    }
}

int main()
{
    int x;
    scanf("%d",&x);
    crescente(x);
}
