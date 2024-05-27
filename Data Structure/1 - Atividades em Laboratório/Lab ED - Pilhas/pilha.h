


typedef struct pilha Pilha;

Pilha * p_cria();

void p_push(Pilha *p, int v);

char p_pop(Pilha *p);

int p_vazia(Pilha *p);

void p_libera(Pilha *p);

char getTopo(Pilha *p);
