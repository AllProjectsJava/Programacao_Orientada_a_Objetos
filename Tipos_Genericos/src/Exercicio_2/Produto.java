package Exercicio_2;

public class Produto <T, P>{
	private T codigo;
	private P descricao;
	private double preco;
	
	public Produto(T codigo, P descricao, double preco) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.preco = preco;
	}

	public T getCodigo() {
		return codigo;
	}

	public void setCodigo(T codigo) {
		this.codigo = codigo;
	}

	public P getDescricao() {
		return descricao;
	}

	public void setDescricao(P descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Produto [codigo=" + codigo + ", descricao=" + descricao + ", preco=" + preco + "]";
	}
}
