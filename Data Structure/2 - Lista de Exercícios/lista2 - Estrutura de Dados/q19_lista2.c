#include <stdio.h>
#include <stdlib.h>
int x=0;
int somar(int n){
    if(n==0){
        return x;
    }
    else{
        x= x+n%10;
        return somar(n/10);
    }
}
int main(){
    int n;
    scanf("%d",&n);
    int a;
    a = somar(n);
    printf("%d\n",a);
    return 0;
}
