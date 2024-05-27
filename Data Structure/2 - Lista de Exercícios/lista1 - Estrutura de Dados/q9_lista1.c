#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    int i,j, cont;

    printf("Digite um numero:");
    scanf("%d",&n);
    
    for(i=0;i<=n;i++){
        cont = 1;
        for(j=1;j<=i;j++){
            printf("%d ",cont);
            cont++;
        }
        printf("\n");
    }
    return 0;
}
