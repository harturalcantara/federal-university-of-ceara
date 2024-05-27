#include <stdio.h>
#include <stdlib.h>
int restante = 1;

int fatorial(int n){
    if(n==0){
        return 1;
    }
    if(n==1){
        return 1;
    }
    else{
        return n*fatorial(n-1);
    }
}

int quaFat(int n){

    if(n==0){
        return restante;
    }
    else{
        return((fatorial(n*2))/fatorial(n));
    }
}

int main()
{
    int n;
    scanf("%d",&n);
    printf("%d \n",quaFat(n));
    return 0;
}
