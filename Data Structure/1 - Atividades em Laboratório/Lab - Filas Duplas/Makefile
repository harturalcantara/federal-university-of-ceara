all:exe_vet exe_lista

fila2.o: fila2.c
	gcc -c fila2.c

fila2Lista.o: fila2Lista.c
	gcc -c fila2Lista.c

mainf2.o: mainf2.c
	gcc -c mainf2.c

exe_vet: fila2.o mainf2.o
	gcc -o exe1 mainf2.o fila2.o

exe_lista: fila2Lista.o mainf2.o
	gcc -o exe2 mainf2.o fila2Lista.o

clean:
	rm -f *.o *.x 
