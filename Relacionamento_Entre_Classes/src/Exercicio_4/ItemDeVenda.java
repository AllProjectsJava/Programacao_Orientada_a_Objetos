package Exercicio_4;

public class ItemDeVenda {
    private Produto prod;
    private int qtdade;
    private double valorVenda;

	public ItemDeVenda(Produto prod, int qtdade, double valorVenda) {
		this.prod = prod;
		this.qtdade = qtdade;
		this.valorVenda = valorVenda;
	}

	public Produto getProd() {
		return prod;
	}

	public int getQtdade() {
		return qtdade;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	@Override
	public String toString() {
		return prod.toString() + ", qtdade:" + qtdade + ", valorVenda:" + valorVenda;
	}

}
