
typedef struct pilha Pilha;


Pilha* pilha_cria();

void pilha_push(Pilha* p, float v);

float pilha_pop(Pilha* p);

int compra_pilhas(Pilha* p,Pilha* c);
