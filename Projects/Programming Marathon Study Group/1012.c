#include <stdio.h>
#include <stdlib.h>

int main()
{
    double A, B, C;
    scanf("%lf",&A);
    scanf("%lf",&B);
    scanf("%lf",&C);
    double areaTriRetan, areaCircRaio, areaTrape, areaQuad, areaRetangulo;

    areaTriRetan = A*C/2.0;
    areaCircRaio = 3.14159*(C*C);
    areaTrape = C*(A+B)/2.0;
    areaQuad = B*B;
    areaRetangulo = A*B;

    printf("TRIANGULO: %.3lf\n", areaTriRetan);
    printf("CIRCULO: %.3lf\n", areaCircRaio);
    printf("TRAPEZIO: %.3lf\n", areaTrape);
    printf("QUADRADO: %.3lf\n", areaQuad);
    printf("RETANGULO: %.3lf\n", areaRetangulo);

    return 0;
}
