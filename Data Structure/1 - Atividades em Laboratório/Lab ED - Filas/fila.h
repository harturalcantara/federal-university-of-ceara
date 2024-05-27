

typedef struct fila Fila;

typedef struct lista Lista;

Fila* f_cria();

void f_inserir(Fila* f, float v);

float f_retirar(Fila* f);

int f_vazia(Fila* f);

void f_libera(Fila* f);

int f_quantidade(Fila* f);

void imprimeFila(Fila *f);