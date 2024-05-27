/*Questão 01*/
struct pilha{
	int topo;
	char v[n];
};

void p_push(Pilha *p1, Pilha *p2, int v){	
	int soma = p_quantidade(p1)+ p_quantidade(p2);
	if(soma > 80){
		printf("Da erro!\n");
		return;
	}

	if(p1->topo == n){
		printf("Erro! Pilha está cheia!\n");
		exit(1);
	}
	
	p1->v[p1->topo] = v;
	p1->topo++;
}

char p_pop(Pilha *p){

	if(p_vazia(p)){
		printf("Erro! Pilha está vazia!");
		exit(1);
	}

	char aux = p->v[p->topo-1];
	p->topo--;
	return aux;

}

int p_quantidade(Pilha* p){
	int cont=0;

	int i;
	for(i=p->topo-1; i>=0; i--){
		cont++;
	}
	return cont;
}



/*Questão 02*/