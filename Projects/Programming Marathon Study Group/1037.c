#include <stdio.h>
#include <stdlib.h>

int main()
{
    double x;
    scanf("%lf",&x);

    if( x >=0 && x <= 25.0)
        printf("Intervalo [0,25]");

    else if(25.000000 < x && x <= 50.0000000)
        printf("Intervalo (25,50]");

    else if(50.000000 < x && x <= 75.000000)
        printf("Intervalo (50,75]");

    else if(75.000000 < x && x <= 100.000000)
        printf("Intervalo (75,100]");

    else if(100.000000 < x && x < 0)
        printf("Fora de intervalo\n");
    return 0;
}
