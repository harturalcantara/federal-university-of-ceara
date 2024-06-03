#include <stdio.h>
#include <stdlib.h>

int main()
{
    int a,b,c,i,j;

    int vet[3],vetor3[3], k=0;
    for(j=0;j<3;j++){
            scanf("%d",&vet[j]);
    }

    for(i=0;i<3;i++){
        for(j=1;j<3;j++){
            if(vet[i]<=vet[j]){
               vetor3[k] = vet[i];
                k++;
            }
        }
    }
    printf("\n");
     for(j=0;j<3;j++){
        printf("%d\n",vetor3[j]);
    }

//    scanf("%d",&a);
//    scanf("%d",&b);
//    scanf("%d",&c);
//    int maior=0, menor = 9999;
//    if(a > b ){
//        maior = a;
//        menor = b;
//    }else
//        maior = a;
//        menor = b
//    if(a > c){
//        maior = a;
//        menor = c;
//    }else
//        maior = c;
//
//    if(b > c){
//        maior = b;
//
//    }else
//        maior = c;
//    printf("%d",menor);
//    printf("%d",aux);
//    printf("%d",maior);
    return 0;
}
