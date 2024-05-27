#include <stdio.h>
#include <stdlib.h>

int main()
{
    int n;
    printf("Digite um numero:");
    scanf("%d",&n);
    
    int i,j, cont;

    for(i=0;i<n;i++){
            printf("\n");
        for(j=0;j<n;j++){
            if(i==j){
                printf("+");
            }
            else
                printf("* ");
        }

    }
    return 0;
}
