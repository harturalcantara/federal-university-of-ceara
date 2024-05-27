#include <stdio.h>
#include <stdlib.h>

int fatorial(int n){
    if(n==0){
        return 1;
    }
    else{
        return n*fatorial(n-1);
    }

}

int superfatorial(int n){
    if(n==0){
        return 1;
    }
    else{
        return superfatorial(n-1)*fatorial(n);
    }

}

int main() {
    int n;
    scanf("%d",&n);
    int x;
    x= superfatorial(n);
    printf("%d",x);
    return 0;
}