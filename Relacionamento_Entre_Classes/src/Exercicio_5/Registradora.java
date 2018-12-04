package Exercicio_5;

class Registradora {
	private final int MAX = 100;
	private double totDia;
	private CupomFiscal[] cupomFiscal;
	private int nVendas;
	private CupomFiscal vendaAtual;

	public Registradora() {
		totDia = 0.0;
		nVendas = 0;
		cupomFiscal = new CupomFiscal[MAX];
		vendaAtual = new CupomFiscal();
	}

	public double getTotalDia() {
		return (totDia);
	}

	public void informaVenda(Produto produto, int quantidade) {
		vendaAtual.informaItem(new ItemDeVenda(produto, quantidade, produto.getPrecoUnitario() * quantidade));
	}

	public CupomFiscal encerraVenda() {
		vendaAtual.fechaCupom();
		cupomFiscal[nVendas] = vendaAtual;
		nVendas++;
		totDia += vendaAtual.getValorPago();
		vendaAtual = new CupomFiscal();
		return cupomFiscal[nVendas - 1];
	}

	public String relVendas() {
		String rel = "";
		for (int i = 0; i < nVendas; i++) {
			rel = rel + cupomFiscal[i].toString() + "\n";
		}
		return rel;
	}
	
}