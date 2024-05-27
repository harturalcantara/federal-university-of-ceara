
typedef struct pilha Pilha;



Pilha* pilha_cria();

void pilha_push(Pilha* p, int v);

Pilha* pilha_pop(Pilha* p,int tam);

float converte(Pilha* p,int num);
