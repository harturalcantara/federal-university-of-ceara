#include <stdio.h>
#include <stdlib.h>

int mult(int k , int n){
    if(n ==0){
        return 1;
    }else
        return k * mult(k,n-1);
}
int main(){
    int k,n;
    scanf("%d",&k);
    scanf("%d",&n);
    int r = mult(k,n);
    printf("Resultado: %d",r);
}
