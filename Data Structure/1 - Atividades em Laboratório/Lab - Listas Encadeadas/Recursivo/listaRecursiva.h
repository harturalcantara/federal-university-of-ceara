

//MINHA ESTRUTURA; - OK
typedef struct lista Lista;

//CRIAR O VALAR NULL; - OK
Lista* cria();

//INSERE NA LISTA - OK
Lista* inserir(Lista *l, int x);

void libera(Lista* l);

Lista* menorRecursivo(Lista *l,Lista *men);

Lista* remove(Lista* l, Lista* l2);

Lista* remover(Lista *l,int x);

Lista* inverte(Lista* l, Lista* aux);

void imprimir(Lista *l);

Lista* igual(Lista* l1,Lista* l2);

Lista* removeElementoX(Lista* l, int x);

void removeRepetidos(Lista* X);