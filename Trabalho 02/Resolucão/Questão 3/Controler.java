package main;

public class Controler {

	private ICalcular calcular;
	private String operador;
	private double operando1;
	private double operando2;

	public Controler(String valores) {
		String[] valoresVector = valores.split(":");
		operador = valoresVector[0].strip();
		operando1 = Double.parseDouble(valoresVector[1].strip());
		operando2 = Double.parseDouble(valoresVector[2].strip());
	}
	
	public double resolver() {
		switch (operador) {
		case "+":
			calcular = new Soma();
			break;
		case "-":
			calcular = new Subtracao();
			break;
		case "*":
			calcular = new Multiplicacao();
			break;
		case "/":
			calcular = new Divicao();
			break;
		default:
			return 0;
		}
		return calcular.resolver(operando1, operando2);
	}
}