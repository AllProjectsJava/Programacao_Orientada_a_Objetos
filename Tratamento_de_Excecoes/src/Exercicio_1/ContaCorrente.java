package Exercicio_1;

public class ContaCorrente {
	private double saldo;
    
    public ContaCorrente(double saldoInicial) throws InterruptedException{
    	if (saldoInicial < 0) {
			throw new SaldoInicialInvalidoException();
		}
    	saldo = saldoInicial;
    }

    public void deposito(double valor) throws InterruptedException{
    	if(valor <= 0) {
    		throw new SaldoDepositoInvalidoException();
    	}
        saldo += valor;
    }

    public void retirada(double valor) throws InterruptedException{
    	if(valor > saldo) {
    		throw new SaldoSaqueInvalidoException();
    	}
        saldo -= valor;
    }

    public double getSaldo(){ 
        return(saldo);   
    }

}
