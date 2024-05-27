#include <stdio.h>
#include <stdlib.h>
int result = 0;

int Russa(int n, int m){
    if(n==0){
        return result;
    }
    else{
        if(n%2!=0){
            result = result+m;
        }
        return Russa(n/2,m*2);
    }
}

int main()
{
   int n;
   int m;
   int x;
   scanf("%d",&n);
   scanf("%d",&m);

   x = Russa(n,m);
    printf("%d\n",x);
    return 0;
}
