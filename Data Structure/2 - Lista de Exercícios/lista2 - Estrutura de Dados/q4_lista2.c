#include <stdio.h>
#include <stdlib.h>

int multRec(int n1, int n2)
{
    if(n2 == 0) return 0;
    return n1 + multRec(n1,n2-1);
}

int main()
{
    int x,y;
    scanf("%d",&x);
    scanf("%d",&y);
    printf("Resultado: %d",multRec(x,y));
}