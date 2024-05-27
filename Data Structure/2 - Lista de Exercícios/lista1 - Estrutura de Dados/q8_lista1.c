#include <stdio.h>
#include <stdlib.h>

int lastprimo(int n)
{
    int i, cont = 0;
    for (i = 2; i < n; i++)
    {
        if (n % i == 0)
        {
            cont++;
        }
    }
    if (cont == 0)
    {
        return n;
    }
    else
        return 0;
}

int main()
{
    int n;
    scanf("%d", &n);
    int i, x;
    int cont = 0;
    for (i = 2; i <= n; i++)
    {
        if (lastprimo(i) != 0)
        {
            x = lastprimo(i);
        }
    }
    printf("X = %d\n", x);
    int y;
    while (1)
    {

        if (lastprimo(n) != 0)
        {
            y = lastprimo(n);
            printf("Y = %d\n", y);
            break;
        }
        n++;
    }

    return 0;
}
