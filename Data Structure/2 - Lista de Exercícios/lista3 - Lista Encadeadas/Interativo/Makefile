all:exe

lista3.o: lista3.c
	gcc -c lista3.c -g
main3.o: main3.c
	gcc -c main3.c -g
exe: lista3.o main3.o
	gcc -o exe.x main3.o lista3.o -g
clean:
	rm -f *.o *.x


