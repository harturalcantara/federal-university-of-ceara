#include <stdlib.h>
#include <stdio.h>

int fat(int x){
    if(x==1){
        return 1;
    }
    else
        return fat(x-1)*x;

}

int main(){
    int x;
    printf("Digite um numero e veja o seu fatorial:");
    scanf("%d",&x);
    printf("%d",fat(x));

    return 0;
}
