#include <stdio.h>

int main(){
    int x,hor,min,seg;
    scanf("%d",&x);

    hor=x/3600;
    min=x%3600/60;
    seg=x%60;
    printf("%d:\t%d:\t%d\n",hor,min,seg);
    return 0;
}
