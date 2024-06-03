
//QUESTAO MARATONA
#include <stdio.h>
#include <iostream>
#include <algorithm>
int dados[10001];

using namespace std;

int cmp(int a, int b){
	return a>b;
}

int main(){
	int n;
	int num;
	int i;
	scanf("%d",&n);
	scanf("%d",&num);
	for(i=0;i<n;i++){
		scanf("%d",&dados[i]);
	}
	sort(dados, dados+n, cmp);
	i=num;
	while(dados[num-1]==dados[i] && i!=n){
		num++;
		i++;
	}
	printf("%d\n",num);
	return 0;
}