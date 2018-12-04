package Exercicio_5;

public class ItemDeVenda {
	private Produto produto;
	private int quantidade;
	private double valorVenda;

	public ItemDeVenda(Produto produto, int quantidade, double valorVenda) {
		this.produto = produto;
		this.quantidade = quantidade;
		this.valorVenda = valorVenda;
	}

	public Produto getProd() {
		return produto;
	}

	public int getQtdade() {
		return quantidade;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public String toString() {
		return (produto.getCodigo() + ":" + produto.getDescricao() + ":" + produto.getPrecoUnitario() + ":"
				+ getQtdade() + ":" + getValorVenda());
	}
}
