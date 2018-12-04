package Exercicio_5;

public class CupomFiscal {
	private static final int MAX = 50;
	private ItemDeVenda[] itemDeVenda;
	private int nItens;
	private double valorPago;

	public CupomFiscal() {
		itemDeVenda = new ItemDeVenda[MAX];
		nItens = 0;
		valorPago = 0.0;
	}

	public void informaItem(ItemDeVenda itemDeVenda) {
		this.itemDeVenda[nItens] = itemDeVenda;
		nItens++;
	}

	public int getNItens() {
		return nItens;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void fechaCupom() {
		valorPago = 0.0;
		for (int i = 0; i < nItens; i++) {
			valorPago += itemDeVenda[i].getValorVenda();
		}
	}
	
	public int produtoMaisVendido(){
		int codMaisVendido = 0;
		int quantidade = 0;
		for(int i = 0; i< nItens; i++){
			if(itemDeVenda[i].getQtdade() > quantidade){
				codMaisVendido = itemDeVenda[i].getProd().getCodigo();
			}
		}
		return codMaisVendido;
	}

	public String toString() {
		String rel = "Cupom fiscal:\n";
		for (int i = 0; i < nItens; i++) {
			rel = rel + itemDeVenda[i].toString() + "\n";
		}
		rel = rel + "----------";
		return (rel);
	}
}
