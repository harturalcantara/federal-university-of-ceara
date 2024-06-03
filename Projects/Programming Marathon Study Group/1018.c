#include <stdio.h>
#include <stdlib.h>

int main(){
    int x;
    int c100=0, c50=0,c20=0,c10=0,c5=0,c2=0,c1=0;
    scanf("%d",&x);
    printf("%d\n",x);
    if(0 < x < 1000000){
        while (x>=100){
            if(x>=100){
                c100++;
                x = x-100;
            }
        }
        while (x>=50){
            if(x>=50){
                c50++;
                x=x-50;
            }
        }
        while (x>=20){
            if(x>=20){
                c20++;
                x=x-20;
            }
        }
        while (x>=10){
            if(x>=10){
                c10++;
                x=x-10;
            }
        }
        while (x>=5){
            if(x>=5){
                c5++;
                x=x-5;
            }
        }
         while (x>=2){
            if(x>=2){
                c2++;
                x=x-2;
            }
        }
         while (x>=1){
            if(x>=1){
                c1++;
                x=x-1;
            }
        }
    }
    printf("%d nota(s) de R$ 100,00\n",c100);
    printf("%d nota(s) de R$ 50,00\n",c50);
    printf("%d nota(s) de R$ 20,00\n",c20);
    printf("%d nota(s) de R$ 10,00\n",c10);
    printf("%d nota(s) de R$ 5,00\n",c5);
    printf("%d nota(s) de R$ 2,00\n",c2);
    printf("%d nota(s) de R$ 1,00\n",c1);
    return 0;
}
