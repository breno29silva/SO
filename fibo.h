#include <iostream>
#include <math.h>
using namespace std;

int fib(int n){
    return round(1/sqrt(5) * pow((1 + sqrt(5)) / 2, n) - 
    1/sqrt(5) * pow((1 - sqrt(5)) / 2, n)); 
}

bool validarDados(int inicio, int fim){
    return inicio >= 0 && fim > inicio;
}

void showFib(int inicio, int fim){
    if(inicio == 0) inicio += 1;
    cout << fib(inicio - 1);
    for(int n = inicio; n < fim; n++){
        cout << ", " << fib(n);
    }
}

void calcular(int inicio, int fim){
    if(validarDados(inicio, fim)){
        showFib(inicio, fim);
    }else{
        cout << "Entrada inválida";
    }
}