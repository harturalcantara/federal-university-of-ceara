#include <stdio.h>
#include <stdlib.h>
#include <math.h>


int raizes(float a, float b, float c, float*x1, float*x2){
    float delta;
    if(delta > 0){
        delta = pow(b,2) - 4*a*c;
        printf("DELTA %f\n",delta);
        *x1 = (-(b)+sqrt(delta))/(2.0*a);
        *x2 = (-(b)-sqrt(delta))/(2.0*a);
    }
    if(delta == 0){
        delta = pow(b,2) - 4*a*c;
        printf("DELTA %f\n",delta);
        *x1 = (-(b)+sqrt(delta))/(2.0*a);
    }
    if(delta < 0){
        printf("Nao existem raizes\n")
    }
}

int main()
{
    float a, b, c, x1, x2;
    printf("Valor de A\n");
    scanf("%f",&a);
    printf("Valor de B\n");
    scanf("%f",&b);
    printf("Valor de C\n");
    scanf("%f",&c);

    raizes(a,b,c,&x1,&x2);

    printf("Valor de X1 = %2.f\n",x1);
    printf("Valor de X2 = %2.f\n",x2);

    return 0;
}
