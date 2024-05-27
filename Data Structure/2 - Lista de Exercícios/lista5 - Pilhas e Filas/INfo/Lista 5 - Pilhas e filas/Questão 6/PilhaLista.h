
typedef struct pilha Pilha;



Pilha* pilha_cria();

void pilha_push(Pilha* p,float v);

void pilha_push2(Pilha* c, Pilha* p,float v);

float pilha_pop(Pilha* p);

void libera(Pilha* p);

void imprime(Pilha* p);

void fator(Pilha* p, int n);
