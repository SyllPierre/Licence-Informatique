OPTION=-ansi -pedantic -Wall
CC=gcc -g

.PHONY: clean decompression.test

decompression: decompression.c amb.o amb.h
	gcc $(OPTION) -o decompression amb.o decompression.c

decompression.test: decompression
	./decompression < decompression.input > madecompression.output 

amb.o : amb.c  amb.h
	$(CC) -c $< -o $@

clean:
	- rm decompression 
