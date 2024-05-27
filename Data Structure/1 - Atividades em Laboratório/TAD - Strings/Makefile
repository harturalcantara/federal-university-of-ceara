all: exe

strings.o: strings.c
	gcc -c strings.c
main.o: main.c
	gcc -c main.c
exe: main.o strings.o
	gcc -o exe.x main.o strings.o

clean:
	rm -f *.x *.o
