

//MINHA ESTRUTURA; - OK
typedef struct lista Lista;

//CRIAR O VALAR NULL; - OK
Lista* cria();

//INSERE NA LISTA - OK
Lista* inserir(Lista *l, int x);

//IMPRIME TODOS OS VALORES DA LISTA - OK
void imprimir(Lista *l);

//IMPRIME UM ELEMENTO;
void imprimirUmElemento(Lista *l);

//ENCONTRE UMA CELULA DE CONTEUDO MINIMO;
int encontrarMinimo(Lista *l);

//ENCONTRE UMA CELULA DE CONTEUDO MAXIMO;
int encontrarMaximo(Lista *l);

//RETIRA A CELULA QUE	O VALOR MAXIMO ENCONTRADO;
Lista* retiraMaximo(Lista *l);

//CONTA O NUMERO DE CELULAS DE UMA LSITA ENCADEADA;
int contaCelulas(Lista *l);

//LISTAS CONCATENANDO
Lista* concatenarListas(Lista *l, Lista *k);

//REMOVE A K-ESIMA CELULA;
Lista* remover(Lista *l, int x);//RETIRA

//REMOVE TODOS OS QUE TIVEREM X;
Lista* removerTodosX(Lista* l, int x);

//CONTA O NUMERO DE VEZES QUE X APARECE NA LISTA
int contarX(Lista* l, int x);

//VE SE O NUMERO E PRIMO - OK
int verificaPrimo(int x);

//CONTA OS PRIMOS - OK
int contaPrimos(Lista *l);

//SOMA OS PRIMOS - OK
int somaPrimos(Lista *l);

//QUESTAO 19 - LISTA DE PRIMOS;
Lista* listaPrimos(Lista *l);

//FUNCAO LIBERAR A LISTA;
void libera(Lista* l);

//SOMA DUAS LISTAS
Lista* somaDuasLista(Lista *x, Lista*y);

//VENDO SE O CONTEUDO SAO IGUAIS E TAMANHO
void conteudoIguaisSemOrdem(Lista* X, Lista* Y);

//FUNCAO QUE VE O SE TAMANHO E IGUAL E SE TEM OS MSM VALORES
void conteudoIguais(Lista* X, Lista* Y);

//FUNCAO QUE VAI REMOVER DAS LISTA OS NULOS
Lista* removerDaListaOsNulosQ17(Lista* l);

//REMOVE TODOS QUE TEM X;
Lista* removeElementoX(Lista* l, int x);

//CONCATENA -_-
Lista* uniaoQ16a(Lista *l, Lista *k);
//Q16c
Lista* subtraiDuasLista(Lista *x, Lista*y);

//QUESTAO 7;
void removeRepetidos(Lista* X);


	///RECURSIVIDADE
Lista* menorRecursivo(Lista *l,Lista *men);