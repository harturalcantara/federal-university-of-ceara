typedef struct fila Fila;

typedef struct lista Lista;




Fila* fila_cria();

void fila_insere(Fila* f, int v);

void fila_retira(Fila* f);

int fila_vazia(Fila* f);

void fila_libera(Fila* f);

void fila_imprime(Fila* f);

Fila* fila_busca(Fila* f);

Lista* lst_retira(Lista *l, int v);
