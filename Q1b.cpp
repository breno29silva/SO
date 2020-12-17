#include <stdio.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>
#include "fibo.h"

void callFork(int inicio, int fim, int meio){   
    int pID = fork();
    if(pID == -1){
      	cout << "Falhar ao criar fork" ; 
      	exit(1);
    }else if(pID == 0){
      	showFib(inicio, meio);
    }else{
	wait(NULL);
	cout << ", ";
	showFib(meio + 1, fim);
	cout << "\n";
    }
}

void start(int inicio, int fim){
    int meio;
    meio = (int) (inicio + fim)/2;

    if(validarDados(inicio, fim)){
        callFork(inicio, fim, meio);
    }else{
        cout << "Entrada inválida";
    }  
}

int main(int argc, char *argv[ ]){ 
    
    start(atoi(argv[1]), atoi(argv[2]));

    return 0; 
}
