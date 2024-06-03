#include <stdio.h>
#include <stdlib.h>

int main()
{
    int num, horas;
    float sala;
    scanf("%d",&num);
    scanf("%d",&horas);
    scanf("%f",&sala);

    sala = sala * horas;
    printf("NUMBER = %d\n",num);
    printf("SALARY = U$ %.2f\n",sala);
    return 0;
}
