#include <stdio.h>
#include <stdlib.h>

int main()
{
    int A, B, C, D;
    int diferenca;
    scanf("%d",&A);
    scanf("%d",&B);
    scanf("%d",&C);
    scanf("%d",&D);

    diferenca = ((A*B)-(C*D));
    printf("DIFERENCA = %d\n",diferenca);
    return 0;
}
