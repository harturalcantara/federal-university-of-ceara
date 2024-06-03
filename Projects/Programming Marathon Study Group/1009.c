#include <stdio.h>
#include <stdlib.h>

int main()
{
    char nome[10];
    double salarioF, vendas, total;
    scanf("%s",nome);
    scanf("%lf",&salarioF);
    scanf("%lf",&vendas);

    total = salarioF + (vendas* 0.15);
    printf("TOTAL = R$ %.2f\n",total);
    return 0;
}
