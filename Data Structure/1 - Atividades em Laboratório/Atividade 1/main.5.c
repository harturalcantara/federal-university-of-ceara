#include <stdio.h>
#include <stdlib.h>

int* Soma(int* v1, int* v2, int n){
    int *v3;
    int i;
    v3 = (int*) malloc(sizeof(int)*n);
    for(i=0;i<n;i++){
        v3[i]= v1[i] + v2[i];
    }
    return v3;
}

int main()
{
    int *v1, *v2, *v3;
    int n, i;
    scanf("%d",&n);

    v1 = (int*) malloc(sizeof(int)*n);
    v2 = (int*) malloc(sizeof(int)*n);

    for(i=0;i<n;i++){
        scanf("%d",&v1[i]);
        scanf("%d",&v2[i]);
    }
    v3 = Soma(v1,v2,n);
    for(i=0;i<n;i++){
        printf("Elemento %d = %d", i, v3[i]);
    }
    free(v1);
    free(v2);
    free(v3);

    return 0;
}
