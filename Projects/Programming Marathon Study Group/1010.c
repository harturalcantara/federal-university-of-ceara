#include <stdio.h>
#include <stdlib.h>

int main(){
    int cod, cod2, Npecas, Npecas2;
    float Upecas,Upecas2, x;
    scanf("%d %d %f \n",&cod, &Npecas, &Upecas);
    scanf("%d %d %f \n",&cod2, &Npecas2, &Upecas2);

    x = (Npecas * Upecas) + (Npecas2 * Upecas2);
    printf("VALOR A PAGAR: R$ %.2f\n", x);
    return 0;
}
