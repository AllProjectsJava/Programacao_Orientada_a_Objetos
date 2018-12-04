package Exercicio_1;

public class App {
	public static void main(String[] args) throws InterruptedException {
		ContaCorrente c = null;
		try {
			c = new ContaCorrente(55);
		} catch (SaldoInicialInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			c.deposito(10);
		} catch(SaldoDepositoInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		try {
			c.retirada(100);
		} catch(SaldoSaqueInvalidoException e) {
			System.out.println(e.getMessage());
		}
		
		

	}
}
