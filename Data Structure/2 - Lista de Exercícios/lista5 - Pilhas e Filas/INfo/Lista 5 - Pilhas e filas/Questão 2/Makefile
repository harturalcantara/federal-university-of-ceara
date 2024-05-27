all: run

lista.o: lista.c
	gcc -c lista.c
main.o: main.c
	gcc -c main.c
lista.x: main.o lista.o
	gcc -o lista.x main.o lista.o
run: lista.x
	./lista.x
clean:
	rm -f *.o *.x
