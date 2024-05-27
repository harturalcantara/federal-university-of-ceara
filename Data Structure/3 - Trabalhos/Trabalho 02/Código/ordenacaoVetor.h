





/*Algoritimos de Ordenação Recursivos:*/


void bubbleSortRec(int n, int *v);

void insertionSortRec(int n, int *v);

void selectionSortRec(int n, int i, int *v);

void mergeSortRec(int p, int r, int *v);

void quickSortRec(int p, int r, int *v);

void heapSortRec(int n, int *v);





/*Algoritimos de Ordenação Interativos*/

void bubbleSortInt(int n, int *v);

void insertionSortInt(int n, int *v);

void selectionSortInt(int n, int *v);

void mergeSortInt(int n, int *v);

void quickSortInt(int v[], int p, int r);

void heapSortInt(int n, int *a);

/*Função auxiliar*/

void imprimirVetor(int n, int *v);

void mergeCallRec(int tam, int *v);

void quickCallRec(int tam, int *v);

void quickCallInt(int tam, int *v);

void selectionCallRec(int n, int *v);

/*Outra tipos de implementações*/

void bubbleSortSeg(int *v, int n);

void selectionSortSeg(int* v, int n);

void insertionSortSeg(int* v, int n);


void criaHeapSeg(int *vet, int i, int f );

void heapSortSeg(int* v, int n);

void bubbleSort(int n, int *v);

void bubbleSortRecSeg(int *v, int n);