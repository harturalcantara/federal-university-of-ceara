


typedef struct arv Arv;

Arv* cria_vazia();

Arv* cria(char c, Arv* esq, Arv* dir);

int vazia(Arv* a);

int pertence(Arv* a, char c);

Arv* libera(Arv* a);

void imprime(Arv* a);/*Pre ordem*/

void imprime_Ordem(Arv* a);/*Em ordem*/

void imprime_Pos_Ordem(Arv* a);/*Ordem ordem*/


