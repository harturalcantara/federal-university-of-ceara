
typedef struct pilha Pilha;

typedef struct fila Fila;


Pilha* pilha_cria();

void pilha_push(Pilha* p, float v);

float pilha_pop(Pilha* p);


Fila* fila_cria();

void fila_insere (Fila* f, float i);

float fila_retira (Fila* f);

void fila_imprime(Fila *l);
