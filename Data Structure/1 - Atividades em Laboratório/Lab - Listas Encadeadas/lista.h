

//ESTRUTURA
typedef struct lista Lista;

void imprimeUmElemento(Lista* l);

Lista* inserir(Lista *l, int x);

Lista* insereOrdenado(Lista* l, int x);

Lista* cria();

void libera(Lista* l);

Lista* retira(Lista *l,i nt x);

int vazia(Lista*l); 

Lista* busca(Lista *l, int v);

void imprime(Lista *l);
