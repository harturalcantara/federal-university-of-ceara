#include <stdio.h>
#include <stdlib.h>

int potencia(float x, int y)
{
    int i;
    float aux = 1;
    for (i = 0; i <= y; i++)
    {
        if (i == 0)
        {
        }
        else
        {
            aux = aux * x;
            printf("A base e %f elevado a %d = %f\n", x, y, aux);
        }
    }
}

int main()
{
    float x;
    int y;
    printf("Digite a base: ");
    scanf("%f", &x);
    printf("\nDigite a potencia: ");
    scanf("%d", &y);
    potencia(x, y);
    return 0;
}
