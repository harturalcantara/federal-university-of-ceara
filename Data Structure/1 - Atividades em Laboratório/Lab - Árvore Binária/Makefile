all: exe

arvoreBusca.o: arvoreBusca.c
	gcc -c arvoreBusca.c

main.o: main.c
	gcc -c main.c

exe: arvoreBusca.o main.o
	gcc -o exe main.o arvoreBusca.o

clean:
	rm -f *.o *.x 
