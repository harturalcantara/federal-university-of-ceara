
typedef struct pilha Pilha;


Pilha* pilha_cria();

void pilha_push(Pilha* p, float v);

float pilha_pop(Pilha* p);

Pilha* copia_pilha(Pilha* p);

void imprime(Pilha* p);
