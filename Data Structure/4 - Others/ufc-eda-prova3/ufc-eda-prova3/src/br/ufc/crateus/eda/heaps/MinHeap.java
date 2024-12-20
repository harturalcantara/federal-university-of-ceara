package br.ufc.crateus.eda.heaps;

public class MinHeap {

	private int[] Heap;
	private int size;
	private int maxsize;
	private static final int FRONT = 1;

	public MinHeap(int maxsize) {
		this.maxsize = maxsize;
		this.size = 0;
		Heap = new int[this.maxsize + 1];
		Heap[0] = Integer.MIN_VALUE;
	}

	public void insert(int element) {
		Heap[++size] = element;
		int current = size;
		while (Heap[current] < Heap[parent(current)]) {
			swap(current, parent(current));
			current = parent(current);
		}
	}
	
	private void swap(int fpos, int spos) {
		int tmp;
		tmp = Heap[fpos];
		Heap[fpos] = Heap[spos];
		Heap[spos] = tmp;
	}
	
	private void minHeapify(int pos) {
		if (!isLeaf(pos)) {
			if (Heap[pos] > Heap[leftChild(pos)] || Heap[pos] > Heap[rightChild(pos)]) {
				if (Heap[leftChild(pos)] < Heap[rightChild(pos)]) {
					swap(pos, leftChild(pos));
					minHeapify(leftChild(pos));
				} 
				else {
					swap(pos, rightChild(pos));
					minHeapify(rightChild(pos));
				}
			}
		}
	}
	
	public void minHeap() {
		for (int pos = (size / 2); pos >= 1; pos--) {
			minHeapify(pos);
		}
	}

	public int remove() {
		int popped = Heap[FRONT];
		Heap[FRONT] = Heap[size--];
		minHeapify(FRONT);
		return popped;
	}
	
	private int parent(int pos) {
		return pos / 2;
	}

	private int leftChild(int pos) {
		return (2 * pos);
	}

	private int rightChild(int pos) {
		return (2 * pos) + 1;
	}

	private boolean isLeaf(int pos) {
		if (pos >= (size / 2) && pos <= size) {
			return true;
		}
		return false;
	}

	public void print() {
		for (int i = 1; i <= size / 2; i++) {
			System.out.print(
					" PARENT : " + Heap[i] + " LEFT CHILD : " + Heap[2 * i] + " RIGHT CHILD :" + Heap[2 * i + 1]);
			System.out.println();
		}
	}


	public static void main(String... arg) {
		MinHeap minHeap = new MinHeap(15);

		minHeap.insert(5);
		minHeap.insert(3);
		minHeap.insert(17);
		minHeap.insert(10);
		minHeap.insert(84);
		minHeap.insert(19);
		minHeap.insert(6);
		minHeap.insert(22);
		minHeap.insert(9);
		
		minHeap.minHeap();

		minHeap.print();
		System.out.println("The Min val is " + minHeap.remove());

	}

}
/*Uma pilha binária é uma árvore binária com as seguintes propriedades. 
1) É uma árvore completa (todos os níveis estão completamente preenchidos,
   exceto possivelmente o último nível e o último nível tem todas as chaves o 
   mais esquerdo possível). Esta propriedade do heap binário torna-os adequados 
   para serem armazenados em um array.

2) Uma pilha binária é Min Heap ou Max Heap. Em uma pilha binária mínima,
   a chave na raiz deve ser mínima entre todas as chaves presentes na pilha binária.
   A mesma propriedade deve ser recursivamente verdadeira para todos os nós na Árvore binária. Max Binary Heap é semelhante ao MinHeap.
*/