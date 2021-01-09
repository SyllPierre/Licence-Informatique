all : trirapide  main 

trirapide : trirapide.o 
	gcc trirapide.o -o trirapide -g

trirapide.o : trirapide.c 
	gcc -c trirapide.c -g

main : main.o nobel.o
	gcc nobel.o main.o -o main -g

exercice28 : exercice28.o
	gcc -o exercice28 exercice28.o

nobel.o : nobel.c struct.h
	gcc -c nobel.c -g

main.o : main.c struct.h const.h
	gcc -c main.c


 
exercice28.o : exercice28.c
	gcc -c exercice28.c

clean : 
	rm *.o
	rm trirapide
	
