package Demo_Conta_Bancaria;

public class Conta {
	protected double saldo;
	private String nomeCorrentista;
	private int numeroDaConta;

	public Conta(String nomeCorrentista, int numeroDaConta, double saldo) {
		this.nomeCorrentista = nomeCorrentista;
		this.numeroDaConta = numeroDaConta;
		this.saldo = saldo;
	}
	
	public int getNumeroDaConta() {
		return numeroDaConta;
	}

	public String getNomeCorrentista() {
		return nomeCorrentista;
	}

	public double getSaldo() {
		return saldo;
	}

	public boolean deposito(double valor){
		if (valor <= 0){
			return false;
		}
		saldo = saldo + valor;
		return true;
	}

	public boolean retirada(double valor){
		if (valor > saldo) return false;
		saldo = saldo - valor;
		return true;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(this.getClass().getSimpleName()).append("\n");
		sb.append("Numero da Conta: ").append(getNumeroDaConta()).append("\n");
		sb.append("Nome do Correntista: ").append(getNomeCorrentista()).append("\n");
		sb.append("Saldo: R$ ").append(getSaldo()).append("\n");
		return (sb.toString());
	}
}



