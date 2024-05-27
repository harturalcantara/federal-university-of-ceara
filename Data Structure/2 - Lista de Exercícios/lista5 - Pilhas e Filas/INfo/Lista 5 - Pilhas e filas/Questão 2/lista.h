

typedef struct fila Fila;

typedef struct lista Lista;


Lista* lst_cria();

Lista* lst_insere(Lista* l,int i);


Fila* fila_cria();

void fila_insere(Fila* f, int v);

int fila_retira(Fila* f);

void fila_imprime(Fila* f);

Fila* fila_lista(Lista* p);

void fila_cir_imprime(Fila* f);

void fila_insere_cir(Fila* f, int v);

void fila_tamanho(Fila* f);
