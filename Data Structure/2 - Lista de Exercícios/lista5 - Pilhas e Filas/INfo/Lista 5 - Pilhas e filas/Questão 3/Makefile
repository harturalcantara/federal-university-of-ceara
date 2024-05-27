all: listaFila.x

listaFila.o: listaFila.c
	gcc -c listaFila.c
main.o: main.c
	gcc -c main.c
listaFila.x: main.o listaFila.o
	gcc -o listaFila.x main.o listaFila.o
run: listaFila.x
	./listaFila.x
clean:
	rm -f *.o *.x
