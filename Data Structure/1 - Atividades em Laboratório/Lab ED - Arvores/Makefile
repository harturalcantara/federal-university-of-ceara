all: exe

arvore.o: arvore.c
	gcc -c arvore.c

main.o: main.c
	gcc -c main.c

exe: arvore.o main.o
	gcc -o exe main.o arvore.o

clean:
	rm -f *.o *.x 
