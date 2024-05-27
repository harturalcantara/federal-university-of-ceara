all: run

PilhaLista.o: PilhaLista.c
	gcc -c PilhaLista.c
main.o: main.c
	gcc -c main.c
PilhaLista.x: main.o PilhaLista.o
	gcc -o PilhaLista.x main.o PilhaLista.o
run: PilhaLista.x
	./PilhaLista.x
clean:
	rm -f *.o *.x
