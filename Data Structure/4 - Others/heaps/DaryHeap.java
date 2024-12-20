package br.ufc.crateus.eda.heaps;

import java.util.Arrays;

class DAryHeap {

    private int d;
    private int heapSize;
    private int[] heap;

    public DAryHeap(int capacity, int numChild) {
        heapSize = 0;
        d = numChild;
        heap = new int[capacity + 1];
        Arrays.fill(heap, -1);
    }

    public boolean isEmpty( ) {
        return heapSize == 0;
    }

    /** Check if heap is full **/
    public boolean isFull( ) {
        return heapSize == heap.length;
    }

    public void clear() {
        heapSize = 0;
    }

    /** Function to  get index parent of i **/
    private int parent(int i) {
        return (i - 1)/d;
    }
 

    /** Function to get index of k th child of i **/
    private int kthChild(int i, int k) {
        return d * i + k;
    }

    /** Function to insert element */
    public void insert(int x) {
        if (isFull( ) ) return;
        /** Percolate up **/
        heap[heapSize++] = x;
        heapifyUp(heapSize - 1);
    }

    public int findMin( ) {
        if (isEmpty()) return -1;           
        return heap[0];
    }

    /** Delete element index **/
    public int delete(int ind) {
        if (isEmpty() ) return -1;
        
        int keyItem = heap[ind];
        heap[ind] = heap[heapSize - 1];
        heapSize--;
        heapifyDown(ind);        
        return keyItem;
    }

    /** Function heapifyUp  **/
    private void heapifyUp(int childInd) {
        int tmp = heap[childInd];    
        while (childInd > 0 && tmp < heap[parent(childInd)]) {
            heap[childInd] = heap[ parent(childInd) ];
            childInd = parent(childInd);
        }                   
        heap[childInd] = tmp;
    }

    /** Function heapifyDown **/
    private void heapifyDown(int ind) {
        int child;
        int tmp = heap[ ind ];
        while (kthChild(ind, 1) < heapSize) {
            child = minChild(ind);
            if (heap[child] < tmp)
                heap[ind] = heap[child];
            else
                break;
            ind = child;
        }
        heap[ind] = tmp;
    }

    /** Function to get smallest child **/
    private int minChild(int ind) {
        int bestChild = kthChild(ind, 1);
        int k = 2;
        int pos = kthChild(ind, k);
        while ((k <= d) && (pos < heapSize)) {
            if (heap[pos] < heap[bestChild]) 
                bestChild = pos;
            pos = kthChild(ind, k++);
        }    
        return bestChild;
    }

    /** Function to print heap **/
    public void printHeap()    {
        System.out.print("\nHeap = ");
        for (int i = 0; i < heapSize; i++)
            System.out.print(heap[i] +" ");
        System.out.println();
    }     


}

/* D-�rias s�o uma generaliza��o do heap bin�rio (K = 2) em que cada n� tem K filhos em vez de 2.
 *  Assim como o heap bin�rio, segue duas propriedades:
 * 1) �rvore bin�ria quase completa, com todos os n�veis com n�mero m�ximo de n�s,
 *  exceto o �ltimo, que � preenchido da esquerda para a direita.
 * 2) Como o heap bin�rio, ele pode ser dividido em duas categorias: 
 * (a) heap m�ximo do k-ary (a chave na raiz � maior que todos os descendentes e o mesmo � recursivamente verdadeiro para todos os n�s). 
 * (b) M�nimo k-ary heap (chave na raiz � menor que todos os descendentes e o mesmo � recursivamente verdadeiro para todos os n�s)
 */