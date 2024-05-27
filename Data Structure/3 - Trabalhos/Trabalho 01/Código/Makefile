all: exe

indice.o: indice.c
	gcc -c indice.c

lista.o: lista.c
	gcc -c lista.c

main.o: main.c
	gcc -c main.c

exe: main.o lista.o indice.o
	gcc -o exe.x main.o lista.o indice.o

clean:
	rm -f *.x *.o
