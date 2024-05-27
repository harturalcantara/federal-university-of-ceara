

	/*Questão 24*/	//ALGORITIMOS DE ORDENACAO


void bubbleSort(int n, int *v){
	int i, j, aux,k;
	k=n-1;
	for(i=0;i<n;i++){
		for(j=0;j<k; j++){
			if(v[j] < v[j+1]){
				aux = v[j];
				v[j] = v[j+1];
				v[j+1] = aux;
			}
		}
		k--;
	}
}

void insertionSort(int n, int *v){
	int i, j, x;
	for(j=1;j<n;j++){
		x = v[j];
		for(i=j-1; i>=0 && x > v[i]; i--){
			v[i+1] = v[i];
		}
		v[i+1] = x;
	}
}
	
void selectionSort(int n, int *v){
	int i, j, min, x;
	for(i=0;i<n-1;i++){
		min = i;
		for(j=i+1;j<n; j++){
			if(v[j] > v[min])
				min = j;
		}
		x = v[i];
		v[i] = v[min];
		v[min] = x;
	}
}



/*Funcao auxiliar para o MergeSort*/
void intercala1(int p, int q, int r, int *v) {
	int i, j, k,*w;
	w = (int*)malloc((r-p)* sizeof(int));
	i = p; j = q;
	k = 0;
	while (i < q && j < r) {
		if (v[i] <= v[j]){
			w[k++] = v[i++];
		}
		else{
			w[k++] = v[j++];
		}  	
	}
	while (i < q){
		w[k++] = v[i++];
	}  
	while (j < r)  w[k++] = v[j++];
	for (i = p; i < r; ++i)  v[i] = w[i-p];
	free (w);
}

/*Funcao MergeSortRecursivo*/
void mergesort (int p, int r, int*v){
	if (p < r-1) {
		int q = (p + r)/2;
		mergesort (p, q, v);
		mergesort (q, r, v);	
		intercala1(p, q, r, v);
	}
}




	/*FIM ---- Questão 24*/

	/*SELECTION SORT CRESCENTE RECURSIVO*/
	void selectionSortRec(int n, int *v){
		int i,j, min,x;
		if(n>1){
			//selectionSortRec(n-1,v);
			for(i=0; i<n-1; i++){
				min = i;
				for(j=i+1; j < n; j++){
					if(v[j] < v[min]){
						min=j;
					}
				}
				x = v[i];
				v[i]=v[min];
				v[min]=x;
			}
		}
	}

	/*SELECTION SORT DECRESCENTE*/

void selectionSort(int n, int *v){

	int i,j, min,x;
	for(i=0; i<n-1; i++){
		min = i;
		for(j=i+1; j < n; j++){
			if(v[j] < v[min]){
				min=j;
			}
		}
		x = v[i];
		v[i]=v[min];
		v[min]=x;
	}


}