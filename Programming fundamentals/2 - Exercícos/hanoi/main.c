#include <stdio.h>
#include <stdlib.h>

void hanoi(int x, int origem, int destino, int temp)
{
    if (x == 1)
        printf("%d -> %d\n", origem, destino);
    else{
        hanoi(x-1, origem, temp, destino);
        printf("%d -> %d\n", origem, destino);
        hanoi(x-1, temp, destino, origem);
    }
}

int main()
{
    int x;
    printf("Bem-vindo à Torre de Hanoi\n\n");
    printf("Digite com quantos pinos gostaria de resolver a torre: ");
    scanf("%d", &x);
    printf("\nRespota: \n\n");
    hanoi(x, 1, 3, 2);
    return 0;
}
