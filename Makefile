# Variables
SRC_DIR=src
BIN_DIR=bin
LIB_DIR=lib
MAIN_CLASS=FeedReaderMain
FILE=

#Buscar todos lo archivos .java dentro de src/
SOURCES=$(shell find $(SRC_DIR) -name "*.java")
CLASSPATH=$(LIB_DIR)/json-20210307.jar

# Detectar separador de classpath según el SO
ifeq ($(OS),Windows_NT)
    SEP=;
else
    SEP=:
endif

# Buscar todos los archivos .java dentro de src/
SOURCES=$(shell find $(SRC_DIR) -name "*.java")

# Target por defecto
all: run

# Compilar el código
compile:
	mkdir -p $(BIN_DIR)
	javac -cp "$(CLASSPATH)" -d $(BIN_DIR) $(SOURCES)

# Ejecutar el programa
ARGS=
run: compile
	java -cp "$(CLASSPATH)$(SEP)$(BIN_DIR)" $(MAIN_CLASS) $(ARGS)

# Ejecutar el programa con argumentos
module:compile
	java -cp "$(CLASSPATH):$(BIN_DIR)" $(FILE)

#Compilar con Heuristica
heuristic: compile
	java -cp "$(CLASSPATH):$(BIN_DIR)" $(MAIN_CLASS) -ne

#Limpiar archivos compilados
clean:
	rm -rf $(BIN_DIR)

.PHONY: all compile run clean

heuristic: compile
	java -cp "$(CLASSPATH)$(SEP)$(BIN_DIR)" $(MAIN_CLASS) -ne
