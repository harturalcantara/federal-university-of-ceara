#include <stdio.h>
#include <stdlib.h>

int main()
{
    double R, volume;
    scanf("%lf",&R);
    volume = (4.0/3.0) * 3.14159 * (R*R*R);
    printf("VOLUME = %.3lf\n",volume);
    return 0;
}
