#include <stdio.h>
#include <stdlib.h>

int main()
{

    int x, ano=0, mes=0, dia=0;
    scanf("%d",&x);

    while(x >= 365){
        ano++;
        x = x-365;
    }
    while(x >= 30){
        mes++;
        x = x-30;
    }
    while(x > 0){
        dia++;
        x = x-1;
    }
    printf("%d ano(s)\n",ano);
    printf("%d mes(es)\n",mes);
    printf("%d dia(s)\n",dia);
    return 0;
}
