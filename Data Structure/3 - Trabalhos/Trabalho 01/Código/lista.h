

//typedef struct paginas Paginas;

typedef struct nomes Nomes;


Nomes* criaNomesNull();

Nomes* inserirNomeNaLista(Nomes* l, char *texto, int pg);

Nomes* inserirStringSeparada(Nomes *l, char *nome, int pg);



/*Funções Imprimir*/

void imprimirNomeTodosIndices(Nomes *l, char *nome);

void imprimirTodosNomesTodosIndices(Nomes* l);



/*Funcoes de busca*/

void verificarTipoDeBusca(Nomes *l,char *nome);

void buscaStringSeparadas(char *texto, int cont, Nomes *l);

void buscaStringComposta(char **palavras, Nomes *l, int cont);