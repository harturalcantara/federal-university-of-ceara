all:exe

listaRecursiva.o: listaRecursiva.c
	gcc -c listaRecursiva.c -g
mainR.o: mainR.c
	gcc -c mainR.c -g
exe: listaRecursiva.o mainR.o
	gcc -o exe.x mainR.o listaRecursiva.o -g
clean:
	rm -f *.o *.x


