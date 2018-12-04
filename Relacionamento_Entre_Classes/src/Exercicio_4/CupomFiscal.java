package Exercicio_4;

public class CupomFiscal {
	private static final int MAX = 50;
    private ItemDeVenda[] itens;
    private int nItens;
    private double valorPago;

    public CupomFiscal(){
    	itens = new ItemDeVenda[MAX];
    	nItens = 0;
    	valorPago = 0.0;
    }

    public void informaItem(ItemDeVenda iv){
    	itens[nItens] = iv;
    	nItens++;
    }

	public int getnItens() {
		return nItens;
	}

	public double getValorPago() {
		return valorPago;
	}

	public void fechaCupom(){
		valorPago = 0.0;
		for(int i=0;i<nItens;i++){
			valorPago = valorPago + itens[i].getValorVenda();
		}
	}

	public String toString(){
		String rel = "Cupom fiscal:\n";
		for(int i=0;i<nItens;i++){
			rel = rel + itens[i].toString()+"\n";
		}
		rel = rel + "Total a pagar: R$ "+getValorPago();
		rel = rel + "----------";
		return(rel);
	}
}
