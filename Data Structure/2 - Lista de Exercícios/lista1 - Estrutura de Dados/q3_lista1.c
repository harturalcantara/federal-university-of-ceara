#include <stdio.h>
#include <stdlib.h>
#include <math.h>

void calc_esfera(float r, float *area, float *volume){
    *area = 4*(r*r);
    *volume = (4*(pow(r,3)))/3.0;
    printf("%f\n",*area);
    printf("%f\n" ,*volume);
}

int main()
{
    float raio;
    float area, volume;

    printf("Digite o raio:\n");\
    scanf("%f",&raio);
    calc_esfera(raio, &area, &volume);
    printf("%f\n",area);
    printf("%f\n" ,volume);
    return 0;
}
