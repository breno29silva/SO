package main;

public class Subtracao implements ICalcular {
	@Override
	public double resolver(double valor1, double valor2) {
		return valor1 - valor2;
	}
}
