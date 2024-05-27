#include <stdio.h>
#include <stdlib.h>
#include "ordenacaoLista.h"


/*Estrutura da lista duplamente encadeada*/
struct lista{
	int valor;  
    struct lista *proximo;
    struct lista *anterior;
};

/*-------------------------Implementação das Funções Auxiliares--------------------*/

Lista* criaListaNull(){
    return NULL;
}



void swap ( int* a, int* b ){
   int t = *a;      *a = *b;       *b = t;   
}


void libera_lista(Lista* l){
    if(l != NULL){
        Lista* no;
        while((l) != NULL){
            no = l;
            l =  l->proximo;
            free(no);
        }
        free(l);
    }
}



void listaAleatorio(Lista* *v, int len){

	Lista* aux = *v;
    
    int i;
    for(i=0; i<len; i++){
    	//printf("%d\n",rand()%100);
    	inserirNovaLista(&aux, rand()%100);

    }
    *v = aux;
}


int testaLista(Lista* *l){

	Lista* aux= *l;

	while(aux!=NULL && aux->proximo != NULL){
		
		if(aux->valor > aux->proximo->valor)
			return 0;

		aux= aux->proximo;
	}
	return 1;
}


void inserirNovaLista(Lista* *head_ref, int inteiro){

	Lista* nova_Lista = (Lista*) malloc(sizeof(Lista*));


	nova_Lista->valor = inteiro;

	nova_Lista->proximo = (*head_ref);
	nova_Lista->anterior = NULL;

	if ((*head_ref) != NULL){
		(*head_ref)->anterior = nova_Lista;
	}

	(*head_ref) = nova_Lista;

}




Lista* adicionarLista(Lista* l, int x){	

	Lista* novo = (Lista*)malloc(sizeof(Lista)*1);

	novo->valor = x;
	novo->anterior = NULL;
	novo->proximo = l;

	if(l!=NULL){
		l->anterior = novo;
	}

	return novo;
}


void imprimir(Lista* l){
    Lista* aux = l;
    //printf("\tLista de valores:\n");
    while(aux != NULL){
        printf("[%d]\n", aux->valor);
        aux = aux->proximo;
    }
    printf("\n");

}









/*---------------------------------------------------------------------------------------------------------*/
/*-------------------------Implementação dos Algoritimos de Ordenação Interativos.-------------------------*/
/*-----------------------------------------------------------------------------------.---------------------*/

void bubbleSortListaInt(Lista* *l, int tamanho){ /*BubbleSortInterativoLista - Okay*/
	Lista *auxP;/*Nosso auxiliar Principal*/
	Lista *auxRestante;/*Nosso auxiliar que pega o restante da Lista*/
	Lista *auxN;/*Assiliar que pega NULL;*/
	//Lista *p = l;
	int verificador;/*Variavel auxiliar.*/
	int k;/*Variavel para pecorrer For.*/

	for(k=0; k<tamanho;k++){/*Percorro o tamanho da lista*/
		
		auxP = *l;
		auxRestante = auxP->proximo;

		verificador=0;

		while(auxRestante != NULL){

			verificador++;
			//printf("Estou comparando: %d > %d \n",auxP->valor,auxRestante->valor);
			if((auxP->valor) > (auxRestante->valor)){

				auxN = auxP->anterior;
				auxRestante->anterior->proximo = auxRestante->proximo;

				if(auxRestante->proximo != NULL){
					auxRestante->proximo->anterior = auxRestante->anterior;
				}

				auxRestante->anterior = auxN;
				auxRestante->proximo = auxP;
				auxP->anterior = auxRestante;

				if(auxN != NULL){
					auxN->proximo = auxRestante;
				}
				
				if(verificador==1){
					*l = auxRestante;
				}
			}
			else{
				auxP = auxP->proximo;
			}
			//imprimir(auxP);
			auxRestante = auxP->proximo;
		}
		
	}
	//return l;
}

void InsertionSortIntLista(Lista* *l, int tamanho){/*InsertionSortInterativoLista - Okay*/
	Lista *Trivial = *l;
	Lista *aux1 = Trivial->proximo;
	Lista *aux2;
	Lista *aux3;
	Lista *p;
	int x,i;

	while(aux1!=NULL){

		x = aux1->valor;
		aux2 = aux1->anterior;

		while(aux2!=NULL){
			if(aux2->valor > x){
				/*
				aux3 = aux2->anterior;
				aux1->anterior->proximo = aux1->proximo;

				if(aux1->proximo != NULL){
					aux1->proximo->anterior = aux1->anterior;
				}

				aux1->anterior = aux3;
				aux1->proximo =  aux2;
				aux2->anterior = aux1;

				if(aux3!=NULL){
					aux3->proximo = aux1;
				}
				*/
				swapLista(&aux1);//mais eficiente
			}

			p = aux2;
			*l = p;
			aux2 = aux2->anterior;
		}

		//imprimir(p);
		aux1 = aux1->proximo;

	}
}


void selectionSortListaInt(Lista* *l, int tam){
	

	Lista* Trivial = *l;

	Lista *aux1;
	Lista *aux2;

	Lista* minimo;
	int troca=0;

	/*Variaveis para o meu While - Fazendo Swap*/
	Lista* mod1;
	Lista* mod2;
	Lista *aux3;

	Lista* begin;


	Lista* primeiro;
	int primeiroMenor =0;

	if(Trivial->anterior == NULL && Trivial->proximo == NULL){
		return;
		//return Trivial;
	}
	else{

		for(aux1=Trivial; aux1!=NULL; aux1=aux1->proximo){

			minimo = aux1;
			
			for (aux2 = aux1->proximo; aux2!=NULL; aux2 = aux2->proximo){
				
				if(aux2->valor < minimo->valor){
					minimo = aux2;
				}

			}
			//printf("[Selection] - Meu menor valor é: %d \n\n", minimo->valor);
			if(minimo->anterior == NULL){
				primeiro = minimo;
				primeiroMenor = 1;
			}
			else
			while( (minimo->anterior != NULL) && (minimo->valor) < (minimo->anterior->valor) ){
				

				troca++;//Isso é pra pegar o primeiro minimo

				//printf("\t[While] - Antes de alterar\n");
				//imprimir(Trivial);

				// mod1 = minimo;
				// mod2 = minimo->anterior;
				
				

				// aux3 = mod2->anterior;
				// mod1->anterior->proximo = mod1->proximo;

				// if(mod1->proximo != NULL){
				//  	mod1->proximo->anterior = mod1->anterior;
				// }

				// mod1->anterior = aux3;
				// mod1->proximo =  mod2;
				// mod2->anterior = mod1;

				// if(aux3!=NULL){
				//  	aux3->proximo = mod1;
				// }
				swapLista(&minimo);

				aux1 = minimo;


				//printf("\t[While] - Depois que alterei\n");
				//imprimir(Trivial);

				//printf("[Aux1] Meu menor valor é: %d \n\n", aux1->valor);
				
				if(troca == 1){
					begin = minimo;
				}

				//l=minimo;
			
			}

			//aux1=minimo;//teste

		}

		if(primeiroMenor == 1){
			Trivial = primeiro;
			begin = Trivial;
			*l = primeiro;
			//printf("\t[Funcao 1] - Processo:\n");
			//imprimir(Trivial);

		}
		

		*l = begin;
		//printf("\t[Funcao 2 ] - Processo:\n");
		//imprimir(begin);
	}

}


void swapLista(Lista* *l){

	Lista* trivial = *l;

	//printf("Qual valor mandei para esse Swap: %d\n",trivial->valor );
	Lista* aux1 = trivial;

	Lista* aux2 = trivial->anterior;
	Lista *aux3;



	aux3 = aux2->anterior;
	aux1->anterior->proximo = aux1->proximo;

	if(aux1->proximo != NULL){
		aux1->proximo->anterior = aux1->anterior;
	}

	aux1->anterior = aux3;
	aux1->proximo =  aux2;
	aux2->anterior = aux1;

	if(aux3!=NULL){
		aux3->proximo = aux1;
	}

	*l = aux1;
	//printf("[SWAP] ----- %d\n",aux1->valor);
}





/*-------------------------------------------------------------------------------------------------------*/
/*-------------------------Implementação dos Algoritimos de Ordenação Recursivos-------------------------*/
/*-------------------------------------------------------------------------------------------------------*/



void swapListaMaximo(Lista* *l){

	Lista* trivial = *l;

	//printf("Qual valor mandei para esse Swap: %d\n",trivial->valor );
	Lista* aux1 = trivial;

	Lista* aux2 = trivial->proximo;
	Lista *aux3;



	aux3 = aux2->proximo;

	aux1->proximo->anterior = aux1->anterior;

	if(aux1->anterior != NULL){
		aux1->anterior->proximo = aux1->proximo;
	}

	aux1->proximo = aux3;
	aux1->anterior =  aux2;
	aux2->proximo = aux1;

	if(aux3!=NULL){
		aux3->anterior = aux1;
	}

	*l = aux1;
	//printf("[SWAP] ----- %d\n",aux1->valor);
}


void finalLista(Lista* *l){
	Lista* aux = *l;
    while (aux!=NULL && aux->anterior!=NULL){
        aux = aux->anterior;
    }
    *l = aux;
}


Lista* inicioLista(Lista* l){
	Lista* root;
    while (root!=NULL && root->anterior!=NULL){
        root = root->anterior;
    }
    return root;
}


void bubbleListaRec(Lista* *l, int t){

	// printf("TAMANHO DA MINHA LISTA %d\n", t);
	Lista* Trivial = *l;

	Lista* aux1;
	Lista* aux2;

	Lista* maximo;

	int primeiroMaior = 0;

	int tam = t;
	int troca=0;

	int contador =0;

	

	if(Trivial->anterior == NULL && Trivial->proximo == NULL){
		return;
	}
	else{

		for(aux1=Trivial; aux1!=NULL; aux1=aux1->proximo){

			maximo = aux1;
			
			for (aux2 = aux1->proximo; aux2!=NULL && contador<tam; aux2 = aux2->proximo){
				
				if(aux2->valor > maximo->valor){
					maximo = aux2;
				}
				contador++;

			}

			
			
			finalLista(&Trivial);
			
			if(testaLista(&Trivial)){

				*l = Trivial;

				return;
			}

			// printf("[Bubble] - Meu maior valor é: %d \n\n", maximo->valor);
			
			while( (maximo->proximo != NULL) && (maximo->valor) > (maximo->proximo->valor) ){
			

				troca=1;//Isso é pra pegar o primeiro maximo

				// printf("\t[While] - Antes de alterar\n");
				//imprimir(Trivial);

				
				swapListaMaximo(&maximo);

				//aux1 = maximo;


				// printf("\t[While] - Depois que alterei\n");
				// finalLista(&Trivial);
				// imprimir(Trivial);

				//printf("[Aux1] Meu menor valor é: %d \n\n", aux1->valor);
				
				//if(troca == 1){
					//begin = minimo;
				//}

					//l=minimo;
			
			}

			if(troca == 1){
				
				// printf("Antes Quem é aux1: %d\n",aux1->valor );
				
				finalLista(&aux1);
				// printf("Dps Quem é aux1: %d\n",aux1->valor );
				// imprimir(aux1);

				bubbleListaRec(&aux1,t-1);
			}

			//exit(1);
			
		}//for
			
	}
	
			
}
/*
void bubbleSortListaRec(Lista* *l, int tamanho){
	
	Lista* Trivial = *l;

	Lista* aux = Trivial;
	Lista* auxProximo = aux->proximo;

	int j;//percorrer tamanho
	int T;//Tamanho da Lista
	int troca=0;


	T = tamanho;;

	Lista* assistente1;
	Lista* assistente2;

	for(j=1; j<=T; j++){

		while(aux != NULL && aux->proximo != NULL){
			if((aux->valor) > aux->proximo->valor){



				Lista* assistente1 = aux->proximo;
				swapLista




				troca=1;
			}
			if(troca == 1){
				bubbleSortListaRec(&aux, T-1);
			}
			

		}
	}
}
*/

Lista* busca(Lista *l, int v){
	Lista *p;

	for(p=l;p!=NULL; p=p->proximo){
		if(p->valor == v){
			return p;
		}
	}
	return NULL;
}

Lista* retira(Lista* l, int v){
	Lista* p = busca(l,v);

	if(p==NULL)
		return l;

	if(l==p){
		l=l->proximo;
	}
	else
		p->anterior->proximo = p->proximo;

	if(p->proximo != NULL){
		p->proximo->anterior = p->anterior;
	}
	free(p);
}








Lista* selectionSortListaRec(Lista *l, int tam){
	
	Lista *aux1;
	Lista *aux2;

	Lista* minimo;
	int troca=0;	
	/*Variaveis para o meu While - Fazendo Swap*/
	Lista* mod1;
	Lista* mod2;
	Lista *aux3;

	Lista* begin;


	Lista* primeiro;
	int primeiroMenor =0;

	int i, j,k;

	if(l->anterior == NULL && l->proximo == NULL){
			return l;
	}

	if(tam > 1 ){
		//for(k=0;k<tam;k++){


			for(aux1=l; aux1!=NULL; aux1=aux1->proximo){

				minimo = aux1;
					
				for (aux2 = aux1->proximo; aux2!=NULL; aux2 = aux2->proximo){
							
							if(aux2->valor < minimo->valor){
								minimo = aux2;
							}

				}

			}

			printf("[Selection] - Meu menor valor é: %d \n\n", minimo->valor);

			if(minimo->anterior == NULL){

					primeiro = minimo;
					primeiroMenor = 1;

					Lista* salvaMinimo = minimo;
					l = retira(l,minimo->valor);
					return salvaMinimo->proximo = selectionSortListaRec(l,tam-1);
					//return salvaMinimo->proximo = 

			}
			else{
				while( (minimo->anterior != NULL) && (minimo->valor) < (minimo->anterior->valor) ){
					

					troca++;//Isso é pra pegar o primeiro minimo

					printf("\t[While] - Antes de alterar\n");
					imprimir(l);

					swapLista(&minimo);

					aux1 = minimo;


					printf("\t[While] - Depois que alterei\n");
					imprimir(l);

					printf("[Aux1] Meu menor valor é: %d \n\n", aux1->valor);
					
					if(troca == 1){
						begin = minimo;
					}
				}

				l = begin;

				Lista* salvaMinimo = begin;
				l = retira(l,begin->valor);
				return salvaMinimo->proximo = selectionSortListaRec(l,tam-1);
			}
		//}	

	}
	else{
		return l;
	}

}		


/*
void quickSortCall(Lista* *l, int tam){
	Lista* aux = *l;
	quickSortListaEnd(&aux);
	*l = aux;
}
*/









		






//Versão trovando valores
/*
void BubbleSortRecLista(Lista* *l, int tamanho){
	
	Lista* Trivial = *l;
	Lista* aux = Trivial;
	Lista* auxProximo = aux->proximo;

	int i, j, k;

	k = tamanho;//-1;



	Lista* assitente;
	

	if(tamanho>1){
		for(j=0; j<=k; j++){
			while(aux!=NULL && auxProximo != NULL){
				if((aux->valor) > (auxProximo->valor)){
					printf("1 - Imprimir auxiliar:\n");
					imprimir(aux);
					swap(&aux->valor,&auxProximo->valor);	
				}
				aux = aux->proximo;
				auxProximo = auxProximo->proximo;
			}
			printf("Estou aqui!\n");
			imprimir(Trivial);
			//BubbleSortRecLista(&Trivial, tamanho-1);
			
		}
	}
		k--;
}






/*-------------------------Versões Elegantes e Algoritimos de Ordenação-------------------------*/



/*---------------InsertionSort---------------*/

void sortedInsert(Lista* *head_ref, Lista* newNode){
	Lista* current;

	// if list is empty
	if (*head_ref == NULL){
		*head_ref = newNode;
	}

	// if the node is to be inserted at the beginning
	// of the doubly linked list
	else if ((*head_ref)->valor >= newNode->valor) {
		newNode->proximo = *head_ref;
		newNode->proximo->anterior = newNode;
		*head_ref = newNode;
	}

	else {
		current = *head_ref;

		// locate the node after which the new node
		// is to be inserted
		while (current->proximo != NULL && current->proximo->valor < newNode->valor)
			current = current->proximo;

		/*Make the appropriate links */

		newNode->proximo = current->proximo;

		// if the new node is not inserted
		// at the end of the list
		if (current->proximo != NULL)
			newNode->proximo->anterior = newNode;

		current->proximo = newNode;
		newNode->anterior = current;
	}
}

void insertionSortLista(Lista* *head_ref){
	// Initialize 'sorted' - a sorted doubly linked list
	Lista* ordenado = NULL;

	// Traverse the given doubly linked list and
	// insert every node to 'sorted'
	Lista* atual = *head_ref;
	while (atual != NULL) {

		// Store next for next iteration
		Lista* next = atual->proximo;

		// removing all the links so as to create 'current'
		// as a new node for insertion
		atual->anterior = atual->proximo = NULL;

		// insert current in 'sorted' doubly linked list
		sortedInsert(&ordenado, atual);

		// Update current
		atual = next;
	}

	// Update head_ref to point to sorted doubly linked list
	*head_ref = ordenado;
}




/*---------------Quick Sort---------------*/



// A utility function to find last node of linked list
Lista* lastNode(Lista *root){
    while (root && root->proximo)
        root = root->proximo;
    return root;
}
 
/* Considers last element as pivot, places the pivot element at its
   correct position in sorted array, and places all smaller (smaller than
   pivot) to left of pivot and all greater elements to right of pivot */
Lista* partition(Lista *l, Lista *h){
    
    // set pivot as h element
    int x  = h->valor;
 
    // similar to i = l-1 for array implementation
    Lista *i = l->anterior;
 
    // Similar to "for (int j = l; j <= h- 1; j++)"
    for (Lista *j = l; j != h; j = j->proximo){

        if (j->valor <= x){
            // Similar to i++ for array

            if(i==NULL){
            	i=l;
            }
            else{
            	i = i->proximo;
            }

            //i = (i == NULL)? l : i->proximo;
 
            swap(&(i->valor), &(j->valor));
        }
    }

    //i = (i == NULL)? l : i->proximo; // Similar to i++
     if(i==NULL){
    	i=l;
    }
    else{
    	i = i->proximo;
    }

    swap(&(i->valor), &(h->valor));

    return i;
}

 
/* A recursive implementation of quicksort for linked list */
void QuickSortLista(Lista *l, Lista *h){

    if (h != NULL && l != h && l != h->proximo){

        Lista *p = partition(l, h);
        QuickSortLista(l, p->anterior);
        QuickSortLista(p->proximo, h);
    
    }
}
 
// The main function to sort a linked list. It mainly calls _quickSort()
void quickSortListaEnd(Lista *head){

    // Find last node
    Lista *h = lastNode(head);
 
    // Call the recursive QuickSort
    QuickSortLista(head, h);

}

