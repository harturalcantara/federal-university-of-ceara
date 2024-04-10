#include <stdio.h>
#include <stdlib.h>

int countWords(char *texto)
{
    int c = 0;
    while(*texto != '\0')
    {
        if (*texto != ' ')
        {
            c++;
            while(*texto != ' ' && *texto != '\0')
            {
                texto++;
            }
        }
            while(*texto == ' ')
            {
                texto++;
            }
    }
    return c;
}

void main()
{
    char texto[150];
    printf("Digite um texto e direi quantas palavras ele tem:\n");
    fflush(stdin);
    scanf("%[^\n]s", &texto);
    printf("\nO seu texto tem %d palavras.", countWords(&texto));
}
