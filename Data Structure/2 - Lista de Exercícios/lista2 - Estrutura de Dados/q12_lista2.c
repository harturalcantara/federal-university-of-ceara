#include <stdio.h>
#include <stdlib.h>
int cont=1;

int elevafat(int n, int m){
    int k=1;
    int i;
    k=n*n;
    for(i=2;i<m;i++){
        k = k*n;
    }
    return k;
}

int hiperfatorial(int n){
    if(n==0){
        return cont;
    }
    else{
        cont = cont*elevafat(n,n);
        return hiperfatorial(n-1);
    }
}

int main()
{
    int n;
    scanf("%d",&n);
    printf("%d\n", hiperfatorial(n));
    return 0;
}
