package Exercicio_5;

public class EstoqueProdutos {
	private ProdutoEstoque[] produtoEstoque;
	private static final int TAMANHO = 100;

	public EstoqueProdutos() {
		carregaEstoque();

	}

	public void carregaEstoque() {
		this.produtoEstoque = new ProdutoEstoque[TAMANHO];
		this.produtoEstoque[0] = new ProdutoEstoque(1, 10);
		this.produtoEstoque[1] = new ProdutoEstoque(2, 10);
		this.produtoEstoque[2] = new ProdutoEstoque(3, 10);
		this.produtoEstoque[3] = new ProdutoEstoque(4, 10);
		this.produtoEstoque[4] = new ProdutoEstoque(5, 10);
	}

	public ProdutoEstoque buscaProduto(int codigo) {
		for (int i = 0; i < this.produtoEstoque.length; i++) {
			if (codigo == this.produtoEstoque[i].getCodigo()) {
				return this.produtoEstoque[i];
			}
		}
		return null;
	}
	
	public boolean vendaProduto(int codigo, int quantidade){
		if(buscaProduto(codigo) != null){
			if(buscaProduto(codigo).getQuantidade() >= quantidade){
				buscaProduto(codigo).setQuantidade(buscaProduto(codigo).getQuantidade() - quantidade);
			}
			return true;
		} else {
			return false;
		}		
	}
	
	
}
