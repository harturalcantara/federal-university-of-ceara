
#include<stdio.h> 
#include <stdlib.h>
#include <limits.h>

void print_r(int S[], int value){
    if(value == 0) return;
    print_r(S, value-S[value]);
    printf("%d \n",S[value]);
}

int minCoins(int coins[], int tam, int value, int k){
    int table[value +1], S[value+1];
    table[0] = 0;
    S[0] = 0;
    
    int i,j;
    
    for(i=1; i<=value;i++)
        table[i] = INT_MAX;
    
    for(i=1; i<=value;i++){
        for(j=0; j<tam; j++){
            if(coins[j]<= i){
                int sub_res = table[i-coins[j]];
                S[i] = coins[j];
                if(sub_res != INT_MAX && sub_res +1 < table[i])
                    table[i]= sub_res + 1;
            }
        }
    }

    if(k >= table[value]){
        printf("Rastreio:\n");
        print_r(S, value);
        return 1;
    } 
    return 0;
}

/*
    A programção dinamica esta nisso
    int sub_res = table[i-coins[j]];

    Veja, que o for sempre percorrerar o vetor de moedas, o que acontece
    se eu pego um valor de coins que caiba para aquela moeda, eu coloco ela no ratreio,
    e iF sub_res+1 < table[i], o que acontece table[i] vai acabar recebendo aquela quantidade
    para troca aquela moeda, porem quando eu continuo o 2º for, o se existir algum valor em  coins 
    que table[i-coins[j]]; ou seja, subtraindo coins[i] com a moeda 'i' der 0, significa que 
    sub_res = 0, e futuramente  
                            table[i] = sub_res + 1; +1 pois foi a moeda usada para ser trocada, e no 
                            final de tudo acaba pegando o numero minimo para trocar aquele valor de ca-
                            da uma das moedas 'i' até n.
*/
 
void main() {
    int n; // tamanho array.
    printf("Digite o total de moedas: \n");
    scanf("%d",&n);
    
    int arr[n];
    int k, valor, i;
    printf("Digite valor para ser trocado:\n");
    scanf("%d",&valor);
    printf("Digite o maximo de moedas devem ser usadas: \n");
    scanf("%d",&k);
    printf("Recebendo as moedas:\n");
    for( i=0 ; i<n; i++){
        scanf("%d",&arr[i]);
        printf("\n");
    }

    printf("Numero minimo de moedas:\n"); //RESULTADO
    if( minCoins(arr, n, valor, k) == 1){    
        printf("Verdade!.\n");
    }
    else{
        printf("Falso!.\n");
    }
} 