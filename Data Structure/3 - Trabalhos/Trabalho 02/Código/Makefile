all:ord.x
ordenacaoLista.o: ordenacaoLista.c
	gcc -c ordenacaoLista.c

ordenacaoVetor.o: ordenacaoVetor.c
	gcc -c ordenacaoVetor.c

main.o: main.c
	gcc -c main.c

bench.o: bench.c
	gcc -c bench.c

ord.x: ordenacaoLista.o ordenacaoVetor.o main.o bench.o
	gcc -o ord.x main.o ordenacaoLista.o ordenacaoVetor.o bench.o

clean:
	rm -f *.o *.x 
