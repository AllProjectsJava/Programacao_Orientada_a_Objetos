package Exercicio_1;

public class SaldoDepositoInvalidoException extends RuntimeException{
	public SaldoDepositoInvalidoException() {
		super("Saldo de deposito invalido");
	}
}
