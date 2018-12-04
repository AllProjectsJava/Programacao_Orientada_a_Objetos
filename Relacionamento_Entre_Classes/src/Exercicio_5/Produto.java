package Exercicio_5;

public class Produto {
	private int codigo;
	private String descricao;
	private double preco;

	public Produto(int codigo, String descricao, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public int getCodigo() {
		return this.codigo;
	}

	public String getDescricao() {
		return this.descricao;
	}

	public double getPrecoUnitario() {
		return this.preco;
	}

	public String toString() {
		return this.getCodigo() + " : " + this.getDescricao() + ", R$ " + this.getPrecoUnitario();
	}
}
