CC=gcc -g
SRC_DIR=src
BLD_DIR=build

all : $(BLD_DIR)/main $(BLD_DIR)/mainCBL

$(BLD_DIR)/main.o : $(SRC_DIR)/main.c $(SRC_DIR)/atf.h
	$(CC) -c $< -o $@

$(BLD_DIR)/mainCBL.o : $(SRC_DIR)/mainCBL.c $(SRC_DIR)/cbl.h
	$(CC) -c $< -o $@

$(BLD_DIR)/atf.o : $(SRC_DIR)/atf.c  $(SRC_DIR)/atf.h
	$(CC) -c $< -o $@

$(BLD_DIR)/cbl.o : $(SRC_DIR)/cbl.c  $(SRC_DIR)/cbl.h
	$(CC) -c $< -o $@

$(BLD_DIR)/amb.o : $(SRC_DIR)/amb.c  $(SRC_DIR)/amb.h
	$(CC) -c $< -o $@

$(BLD_DIR)/main : $(BLD_DIR)/main.o $(BLD_DIR)/atf.o
	$(CC) $^ -o $@

$(BLD_DIR)/mainCBL : $(BLD_DIR)/mainCBL.o $(BLD_DIR)/cbl.o
	$(CC) $^ -o $@

clean : 
	rm $(BLD_DIR)/*.o
	rm $(BLD_DIR)/main
