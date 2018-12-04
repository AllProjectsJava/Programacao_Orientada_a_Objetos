package Exercicio_4;

public class Registradora {
    private final int MAX = 100;
    private double totDia;
    private CupomFiscal[] cupons;
    private int nVendas;
    private CupomFiscal vendaAtual;

    public Registradora(){
        totDia = 0.0;
        nVendas = 0;
        cupons = new CupomFiscal[MAX];
        vendaAtual = new CupomFiscal();
    }

    public double getTotalVendido(){
        return(totDia);
    }

    public double registraItem(Produto prod,int qtdade){
        double valorVenda = prod.getPrecoUnitario() * qtdade;
        ItemDeVenda it = new ItemDeVenda(prod,qtdade,valorVenda);
        vendaAtual.informaItem(it);
        return it.getValorVenda();
    }

    public CupomFiscal encerraVenda(){
      	vendaAtual.fechaCupom();
        cupons[nVendas] = vendaAtual;
        nVendas++;
        totDia = totDia + vendaAtual.getValorPago();
        vendaAtual = new CupomFiscal();
        return cupons[nVendas-1];
    }

    public String relVendas(){
        String rel = "";
        for(int i=0;i<nVendas;i++){
            rel = rel + cupons[i].toString() + "\n";
        }
        return rel;
    }
}
