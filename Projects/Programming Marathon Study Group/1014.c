//#include <stdio.h>
//#include <stdlib.h>
//
//int main()
//{
//    int x,l;
//    scanf("%d %d",&x,&l);
//    printf("%.3f km/l\n", (float) x/l);
//    return 0;
//}
#include <stdio.h>

int main() {


    int x;
    float y,total;
    scanf("%d",&x);
    scanf("%f",&y);
    total=x/y;
    printf("%.3f km/l\n", total);

    return 0;
}
