#include <stdio.h>
#include <stdlib.h>
 
int main (){
	int x,y,aux;
	int mdc, dividendo, divisor;
	 
	printf("Digite o numero X: "); 
	scanf("%d", &x);
	printf("Digite numero Y: "); 
	scanf("%d", &y);

	dividendo = x;
 	divisor = y;
 
	while (aux!=0){
		 aux = dividendo % divisor;
		 dividendo = divisor;
		 divisor = aux;
	}
 
	mdc = dividendo;
 	//Use o exemplo de 1320 e 35!!
	printf ("De acordo com Sir Euclides o mdc(%d, %d) = %d\n", x, y, mdc);
	return 0;
}