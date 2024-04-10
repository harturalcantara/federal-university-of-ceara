#include <stdio.h>
#include <stdlib.h>

int verificarVitoria(char tab[3][3], char letra)
{
    int i, j, resp = 0, cont = 0;

    //para cada linha
    for (i=0; i<3; i++)
    {
        cont = 0;
        for (j=0; j<3; j++)
        {
            if (tab[i][j] == letra)
            {
                cont++;
            }
        }
        if (cont == 3)
        {
            return 1;
        }
    }

    //para cada coluna
    for (j=0; j<3; j++)
    {
        cont = 0;
        for (i=0; i<3; i++)
        {
            if (tab[i][j] == letra)
            {
                cont++;
            }
        }
        if (cont == 3)
        {
            return 1;
        }
    }

    //diagonal principal
    cont = 0;
    for (i=0; i<3; i++)
    {
        if (tab[i][i] == letra)
        {
                cont++;
        }
    }
    if (cont == 3)
    {
            return 1;
    }

    //diagonal secundária
    cont = 0;
    for (i=0; i<3; i++)
    {
        if (tab[i][2-i] == letra)
        {
                cont++;
        }
    }
    if (cont == 3)
    {
            return 1;
    }

    return 0;
}

void desenharTabuleiro(char tab[3][3])
{
    int i, j;
    printf("\n\n*** Tabuleiro ***\n\n");
    for (i=0; i<3; i++)
    {
        for(j=0; j<3; j++)
        {
            printf(" %c ", tab[i][j]);
            if (j!=2)
            {
                printf("|");
            }
        }
        if (i!=2)
        {
            printf("\n-----------\n");
        }
    }

}

int main()
{
    int jogadas, jogador, linha, coluna;
    char letra, tab[3][3] = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
    printf("***Jogo da Velha***\n\n");
    desenharTabuleiro(tab);
    for(jogadas = 1; jogadas<=9; jogadas++)
    {
        jogador = ((jogadas % 2) -2)*-1;
        if (jogador == 1)
        {
            letra = 'O';
        }
        else
        {
            letra = 'X';
        }
        printf("\n\nJogador %d, indique a linha e a coluna que deseja marcar:\n ", jogador);
        printf("Linha (0-2): ");
        scanf("%d", &linha);
        printf("Coluna (0-2): ");
        scanf("%d", &coluna);

        if (tab[linha][coluna] == ' ')
        {
            tab[linha][coluna] = letra;
            if (verificarVitoria(tab, letra) == 1)
            {
                printf("\n\n***Parabéns! Jogador %d venceu!***", jogador);
                return 0;
            }
        }
        else
        {
            printf("\nEsta posicao ja esta preenchida. Escolha outra.\n\n");
            jogadas --;
        }
        desenharTabuleiro(tab);
    }
    printf("\n\nDeu Empate! Boa sorte na proxima!");

    return 0;
}
