package Demo_Conta_Bancaria;

public class ContaComLimite extends Conta {
    private double txJuros;
    private double limite;
    private double jurosDevidos;
    
	public ContaComLimite(String nomeCorrentista, int numeroDaConta, double saldo, double txJuros,double limite) {
		super(nomeCorrentista, numeroDaConta, saldo);
        this.txJuros = txJuros;
        this.limite = limite;
        deposito(limite);
	}

	public double getJuros(){
		return jurosDevidos;
	}
	
	public boolean quitaJuros(){
		if (getSaldo()-limite > jurosDevidos){
			super.retirada(jurosDevidos);
			jurosDevidos = 0;
			return true;
		}
		return false;
	}
	/*
	@Override
	public boolean deposito(double valor) {
		return super.deposito(valor);
	}
	*/

	@Override
	public boolean retirada(double valor) {
        if (valor > getSaldo()){
        	return false;
        }
        if (valor > getSaldo()-limite){
        	double emp = Math.abs(getSaldo()-limite-valor);
        	double juros = emp*txJuros;
        	jurosDevidos += juros;
        }
		return super.retirada(valor);
	}
}
