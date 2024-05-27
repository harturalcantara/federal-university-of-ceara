
//#include "lista.h"

struct paginas{
    int pg;
    struct paginas *proxPagina;
};

typedef struct paginas Paginas;

Paginas* criaPaginasNull();

Paginas* inserirPaginaOrdenado(Paginas* novaPG, int pg);