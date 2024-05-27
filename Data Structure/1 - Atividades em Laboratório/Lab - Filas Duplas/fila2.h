




/*Versão Vetores*/
typedef struct fila2 Fila2;

Fila2* f2_cria();

int f2_vazia(Fila2* f2);

void f2_libera(Fila2* f2);

int f2_quantidade(Fila2* f2);

void f2_insere_ini(Fila2* f, float v);

void f2_insere_fim(Fila2* f, float v);

/*Para as Filas Duplas Versão Lista*/ /*E para Fila Normal*/
float f2_retira_ini(Fila2* f2);

float f2_retira_fim(Fila2* f2);



