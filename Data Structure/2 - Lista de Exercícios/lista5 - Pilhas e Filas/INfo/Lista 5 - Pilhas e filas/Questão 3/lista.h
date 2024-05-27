

typedef struct fila Fila;

typedef struct lista Lista;


Lista* lst_cria();

Lista* lst_insere(Lista* l,int i);


Fila* fila_cria();

void fila_insere(Fila* f, float v);

float fila_retira(Fila* f);

void fila_imprime(Fila* f);

void fila_lista(Lista* p,Fila* f);

void retira_neg(Fila* f);

Fila* fila_busca_neg(Fila* f);

Lista* lst_retira(Lista *l, int v);
