#include <stdio.h>
#include <stdlib.h>

int main()
{
    int i=1, n;
    scanf("%d",&n);

    if(n>0){
        while(i<=n){
            if((i)*(i+1)*(i+2)==n){
                printf("E triangular");
                break;
            }
            if(i=n){
                printf("Nao e triangular");
            }
            i++;
        }
    }
    return 0;
}
