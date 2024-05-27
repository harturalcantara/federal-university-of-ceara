#include <stdio.h>
#include <stdlib.h>

int main()
{
    float n1,n2,n3,p1,p2,p3;
    float exame;
    float media;
    scanf("%f %f %f %f %f %f",&n1,&p1,&n2,&p2,&n3,&p3);
    media = ((n1*p1)+(n2*p2)+(n3*p3))/(p1+p2+p3);

    printf("Media: %.1f\n", media);

    return 0;
}
