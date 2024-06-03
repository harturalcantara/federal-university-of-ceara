#include <stdio.h>
#include <stdlib.h>
int main()
{
    double raio, area;
    double r = 3.14159;

    scanf("%lf",&raio);
    area = r * raio*raio;

    printf("A=%.4lf\n", area);
    return 0;
}
