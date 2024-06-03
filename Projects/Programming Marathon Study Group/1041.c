#include <stdio.h>
#include <stdlib.h>


int main()
{
    float x,y;
    scanf("%f",&x);
    scanf("%f",&y);
    if(x ==0 && y == 0){
        printf("Origem\n");
    }
    if (x == 0 && y!=0){
        printf("Eixo Y\n");
    }
    if (y == 0 && x!=0){
        printf("Eixo X\n");
    }

    if (y > 0 && x > 0){
        printf("Q1\n");
    }
    if (y < 0 && x < 0)
         printf("Q3\n");

    if (y > 0 && x < 0){
        printf("Q2\n");
    }
    if (y < 0 && x > 0)
         printf("Q4\n");
    return 0;
}
