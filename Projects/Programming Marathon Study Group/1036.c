#include <stdio.h>
#include <stdlib.h>
#include <math.h>
int main()
{
    double a, b, c;
    scanf("%lf",&a);
    scanf("%lf",&b);
    scanf("%lf",&c);

    double delta;
    double x1, x2;

    delta = pow(b,2)-(4*a*c);

    if(delta > 0){
       x1 = (-(b) + sqrt(delta))/(2.0*a);
       x2 = (-(b) - sqrt(delta))/(2.0*a);

       printf("R1 = %.5f\n", x1);
       printf("R2 = %.5f\n", x2);
    }
    if(delta < 0){
        printf("Impossivel calcular\n");
    }
     if(delta == 0){
        printf("Impossivel calcular\n");
    }
    return 0;
}
