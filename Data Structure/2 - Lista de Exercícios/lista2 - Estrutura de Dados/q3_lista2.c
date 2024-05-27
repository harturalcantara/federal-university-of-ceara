#include<stdio.h>
#include<stdlib.h>


int mdc(int x, int y){
    if(y==0){
        return x;
    }else{
        return mdc(y, x%y);
    }

}



int main(){
    int x,y;
    scanf("%d",&x);
    scanf("%d",&y);

    printf("Maximo divisor comum: %d",mdc(x,y));





}
