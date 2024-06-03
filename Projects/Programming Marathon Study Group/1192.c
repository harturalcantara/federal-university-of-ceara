#include <stdio.h>
#include <stdlib.h>

int main()
{
    int x,y;
    char c;
    int test;

    scanf("%d",&test);
    int i, result;
    for(i=0;i<test;i++){
        scanf("%d",&x);
        scanf("%c",&c);
        scanf("%d",&y);
        result = 0;
        if(c >= 'A' && c <= 'Z' && x!=y){
            result= y-x;
        }
        else if(c >= 'a' && c <= 'z' && x!=y){
            result= x + y;
        }
        if(x == y){
            result = x*y;
        }
        printf("%d\n", result);
    }

    return 0;
}
