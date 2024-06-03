#include <stdio.h>
#include <stdlib.h>

int main()
{
    double A, B, media;

    scanf("%lf",&A);
    scanf("%lf",&B);

    media = ((A * 3.5)+(B * 7.5))/ (3.5 + 7.5);

    printf("MEDIA = %.5lf\n", media);
    return 0;
}
