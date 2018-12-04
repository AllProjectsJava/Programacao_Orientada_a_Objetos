package Demo;

public class IdadeInvalidaException extends RuntimeException {
	private int idade;
	
	public IdadeInvalidaException(int idade) {
		super("Idade invalida");
		this.idade = idade;
	}
	
	public int getIdade() {
		return idade;
	}

}
