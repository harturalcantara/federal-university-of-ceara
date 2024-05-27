all:exe

lista.o: lista.c
	gcc -c lista.c
main.o: main.c
	gcc -c main.c
exe: lista.o main.o
	gcc -o exe.x main.o lista.o
clean:
	rm -f *.o *.x

