#include <stdio.h>
#include <stdlib.h>

int main()
{
    double A, B, C, media;

    scanf("%lf",&A);
    scanf("%lf",&B);
    scanf("%lf",&C);
    media = ((A * 2.0)+(B * 3.0)+(C * 5.0))/ (10.0);

    printf("MEDIA = %.1lf\n", media);
    return 0;
}
