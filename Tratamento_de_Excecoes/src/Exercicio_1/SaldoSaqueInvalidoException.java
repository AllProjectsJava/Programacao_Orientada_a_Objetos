package Exercicio_1;

public class SaldoSaqueInvalidoException extends RuntimeException{
	public SaldoSaqueInvalidoException() {
		super("Saldo de saque invalido");
	}
}
