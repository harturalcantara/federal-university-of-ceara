#include <stdio.h>
#include <stdlib.h>

int main()
{
    double x;
    int m1=0, m050=0,m025=0,m010=0,m005=0,m001=0;
    scanf("%lf",&x);
    if(0 <= x <= 10000000.00){
        int c100=0, c50=0,c20=0,c10=0,c5=0,c2=0;
            while (x>=100){
                if(x>=100){
                    c100++;
                    x = x-100.00;
                }
            }
            while (x>=50){
                if(x>=50){
                    c50++;
                    x=x-50.00;
                }
            }
            while (x>=20){
                if(x>=20){
                    c20++;
                    x=x-20.00;
                }
            }
            while (x>=10){
                if(x>=10){
                    c10++;
                    x=x-10.00;
                }
            }
            while (x>=5){
                if(x>=5){
                    c5++;
                    x=x-5.00;
                }
            }
            while (x>=2){
                if(x>=2){
                    c2++;
                    x=x-2.00;
                }
            }

            while(x >= 1.00){
                    m1++;
                    x=x-1.00;
            }
            ///50 CENTAVOS
            x =x *100;
            while(x>=50){
                m050++;
                x=x-50;
            }
            while (x>=25){
                m025++;
                x=x-25;
            }
            while (x>=10){
                m010++;
                x=x-10;
            }
            while (x>=5){
                m005++;
                x=x-5;
            }
            m001 = x;

            printf("NOTAS:\n");
            printf("%d nota(s) de R$ 100.00\n",c100);
            printf("%d nota(s) de R$ 50.00\n",c50);
            printf("%d nota(s) de R$ 20.00\n",c20);
            printf("%d nota(s) de R$ 10.00\n",c10);
            printf("%d nota(s) de R$ 5.00\n",c5);
            printf("%d nota(s) de R$ 2.00\n",c2);
            printf("MOEDAS:\n");
            printf("%d moeda(s) de R$ 1.00\n",m1);
            printf("%d moeda(s) de R$ 0.50\n",m050);
            printf("%d moeda(s) de R$ 0.25\n",m025);
            printf("%d moeda(s) de R$ 0.10\n",m010);
            printf("%d moeda(s) de R$ 0.05\n",m005);
            printf("%d moeda(s) de R$ 0.01\n",m001);
        }

    return 0;
}
