all: sort.x

main.o: main.c
	gcc -c main.c
sort.o: sort.c
	gcc -c sort.c
sort.x: main.o sort.o
	gcc -o sort.x main.o sort.o

clean:
	rm -f *.o *.x