#include <stdio.h>
#include <stdlib.h>

void mudar(int A[], int x, int n)
{
    int i;
    for (i=0; i<n; i++)
    {
        A[i] = x;
    }
}

int main()
{
    int i, A[3] = {0,0,0};
    int *p = &A;

    mudar(A, 5, 3);

    printf("A: ");

    for(i=0; i < 3; i++)
    {
        printf("%d ", A[i]);
    }

    A[2] = -3;

    printf("\n*(A+2) = %d\n", *(A+2));
    printf("A[2] = %d\n", A[2]);

    p[1] = 2;
    printf("\nA[1] = %d\n", A[1]);
    printf("p[1] = %d\n", p[1]);
    printf("*(p+1) = %d\n", *(p+1));

    return 0;
}
