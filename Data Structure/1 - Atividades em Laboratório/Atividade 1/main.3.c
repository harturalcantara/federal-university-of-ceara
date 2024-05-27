#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    scanf("%d",&n);
    int tam[n];

    int i,j,cont=0;
    for(i=0;i<n;i++){
        printf("\n");
        cont = 1;
        for(j=0;j<=i;j++){
            printf("%d ", cont);
            cont++;
        }
    }
    return 0;
}
