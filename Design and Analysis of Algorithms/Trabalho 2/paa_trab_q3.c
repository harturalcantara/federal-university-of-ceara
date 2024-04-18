#include <stdio.h>
#include <stdlib.h>
#include <Math.h>
#include <limits.h>

void print_rec(int S[], int n){
    if(n==0) return;
    if(S[n] == n){
        printf("0");
        return;
    }
    print_rec(S, S[n]);
    printf("%d", S[n]);
}

int main(){
    int n = 3; // tamanho dos hoteis
    int A[n+1]; //kilometragens
    int R[n+1]; //reclamacoes
    int S[n+1]; // rastreio 
    int i, j;

    R[0] = 0;
    S[0] = 0;
    
    printf("Recebendo dados da quilometragem:\n");
    for( i=1 ; i<=n; i++){
        scanf("%d",&A[i]);
        printf("\n");
    }
    
    for( i=1; i <= n ; i++ ){
        R[i] = pow((200 - A[i]), 2); //ir direto.
        S[i] = i;
        for(j=1; j <= i-1; j++){
            int x = R[j] + pow((200 - (A[i] - A[j])),2);
            if(R[i] > x){
                R[i] = x;
                S[i] = j;
            }

        }        
    }

    printf("Reclamacao de R[n]: %d\n", R[n]);
    
    for( i=1 ; i<=n; i++){ // VETOR COM AS RECLAMACOES
        printf("%d", R[i]);
        printf("\n");
    }
    print_rec(S,n); //IMPRIMI O RASTREIO
}