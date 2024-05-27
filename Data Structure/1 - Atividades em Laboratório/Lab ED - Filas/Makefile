all:exe_vet exe_lista

fila.o: fila.c
	gcc -c fila.c

filalista.o: filalista.c
	gcc -c filalista.c

main.o: main.c
	gcc -c main.c

exe_vet: fila.o main.o
	gcc -o exe1 main.o fila.o

exe_lista: filalista.o main.o
	gcc -o exe2 main.o filalista.o

clean:
	rm -f *.o *.x 
