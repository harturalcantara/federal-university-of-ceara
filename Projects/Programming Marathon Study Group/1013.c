#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c, abc,maior;
    scanf("%d %d %d",&a,&b,&c);
    abc =(a+b+abs(a-b))/2;
    maior=(abc+c+abs(abc-c))/2;

    printf("%d eh o maior\n",maior);
    return 0;
}
