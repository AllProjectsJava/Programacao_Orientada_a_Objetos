package Demo_Conta_Bancaria;

public class ContaRemunerada extends Conta {
    private double percentRemuneracao;
    
	public ContaRemunerada(String nomeCorrentista, int numeroDaConta, double saldo, double pr) {
		super(nomeCorrentista, numeroDaConta, saldo);
		percentRemuneracao = pr;
	}

	public void definePercentRemuneracao(double pr){
		percentRemuneracao = pr;
	}
	
	@Override
	public boolean deposito(double valor) {
		double valorDep = valor * percentRemuneracao;
		return super.deposito(valorDep);
	}
	
	/*
	@Override
	public boolean retirada(double valor) {
		return super.retirada(valor);
	}
	*/
}
