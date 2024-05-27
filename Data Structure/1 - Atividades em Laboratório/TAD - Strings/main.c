#include <stdio.h>
#include "strings.h"

int main(){
	char c1[10];
	char c2[10];

	scanf("%s", c1);
	fflush(stdin);	
	scanf("%s", c2);

	printf("%d\n", mstrlen(c1));
	printf("%s\n",mstrcat(c1,c2));
	return 0;

}
