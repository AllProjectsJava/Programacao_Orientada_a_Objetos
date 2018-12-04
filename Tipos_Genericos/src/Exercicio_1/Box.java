package Exercicio_1;

public class Box <T> {
	private T caixa;
	
	public Box() {
		caixa = null;
	}
	
	public void guardar(T elemento) {
		caixa = elemento;
	}
	
	public void retirar() {
		caixa = null;
	}

	@Override
	public String toString() {
		return "Box [caixa=" + caixa + "]";
	}
}
