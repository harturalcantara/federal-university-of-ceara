#include <stdio.h>
#include <stdlib.h>

int main()
{
    int cod;
    int qts;
    float total = 0;
    scanf("%d",&cod);
    scanf("%d",&qts);
    if(cod == 1){
        total = qts*4.00;
    }
    if(cod == 2){
        total = qts*4.50;
    }
    if(cod == 3){
        total = qts*5.00;
    }
    if(cod == 4){
        total = qts*2.00;
    }
    if(cod == 5){
        total = qts*1.50;
    }
    printf("Total: R$ %.2f\n", total);
    return 0;
}
