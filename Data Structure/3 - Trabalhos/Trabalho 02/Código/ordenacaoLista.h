
/*--------------------Estrutura da Lita--------------------*/
typedef struct lista Lista;


int testaLista(Lista* *l);

void listaAleatorio(Lista* *v, int len);

/*--------------------Funções auxiliares--------------------*/

Lista* criaListaNull();

Lista* adicionarLista(Lista* l, int x);

Lista* inicioLista(Lista* l);


void inserirNovaLista(Lista* *head_ref, int inteiro);



Lista* busca(Lista *l, int v);

Lista* retira(Lista* l, int v);




void imprimir(Lista* l);

void swap ( int* a, int* b );


void swapLista(Lista* *l);

void libera_lista(Lista* l);

/*--------------------Algoritimo de Ordenação Versões Interativas--------------------*/

void bubbleSortListaInt(Lista* *l, int tamanho);

void InsertionSortIntLista(Lista* *l, int tamanho);

void selectionSortListaInt(Lista* *l, int tam);




/*--------------------Algoritimo de Ordenação Versões Recursivas--------------------*/


void bubbleSortListaRec(Lista* *l, int tamanho);//INCOMPLETO


Lista* selectionSortListaRec(Lista *l, int tam);










/*--------------------Versões Elegantes de Ordenação Duplamente Encadeada,não implementado pela dupla apenas comentários por cima--------------------*/

/*InsertionSort - Versão Elegante*/

void sortedInsert(Lista* *head_ref, Lista* newNode);

void insertionSortLista(Lista* *head_ref);


/*Quick Sort - Versão Elegante*/

Lista* lastNode(Lista *root);

void quickSortListaEnd(Lista *head);

void QuickSortLista(Lista* l, Lista *h);

Lista* partition(Lista *l, Lista *h);


void quickSortCall(Lista* *l, int tam);


//----------------

void swapListaMaximo(Lista* *l);

void bubbleListaRec(Lista* *l, int t);

void finalLista(Lista* *l);