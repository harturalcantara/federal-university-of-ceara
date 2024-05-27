#include <stdio.h>
#include <stdlib.h>
int carac(char c,char *s, int cont){
    if(s[0] == '\0')
        return 0;
    if(s[0] == c){
        cont++;
        return (1+carac(c,++s,cont));
    }
    return carac(c,++s,cont);
}


int main()
{
    char nome[30],c;
    int t;

    printf("\nDigite um nome:  ");
    fflush(stdin);
    scanf("%s",&nome);
    printf("\nCaractere:  ");
    fflush(stdin);
    scanf("%c",&c);

    t = carac(c, nome, 0);

    printf("\n%d vezes", t);

}
