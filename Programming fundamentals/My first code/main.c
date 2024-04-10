#include <stdio.h>
#include <stdlib.h>

int main()
{
    int OP, x, y;
    OP = -1;
    while (OP!=0)
    {
        printf("\t \t \t \t  MENU \n \n");
        printf ("1 - Somar 2 numeros int \n");
        printf ("2 - Multi 2 numeros int \n");
        printf ("3 - Divid 2 numeros int \n");
        printf ("0 - Sair da janela \n \n");
        printf ("Escolha sua opção -_-: ");
        scanf ("%d", &OP);

        if (OP == 1)
        {
            printf("digite 2 int: ");
            scanf("%d",&x);
            scanf("%d",&y);
            printf("A soma e: %d\n", x+y);
        }

            else if (OP==2)
            {

                printf("receber 2 numeros \n\n");
                scanf("%d",&x);
                scanf("%d",&y);
                printf("a mult e: %d\n", x*y);
             }

                     else if(OP ==3)
                        {
                        printf ("Recebe 2 numeros \n\n ");
                        scanf ("%d",&x);
                        scanf ("%d",&y);
                            if(y ==0)
                            { printf("Impossivel '-'");

                            }
                            else {
                                printf("A divid e: %d\n", x/y);
                        }
                        }

                    else if(OP!= 0)
                    {

                    printf("\n Opção inválida \n\n");
                    }



        }


return 0;
    }
