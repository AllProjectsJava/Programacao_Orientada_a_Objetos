package Exercicio_3;

public class ItemVenda {
    private Produto produto;
    private int qtdade;
    private double valorVenda;

    public ItemVenda(Produto umProduto,int umaQtdade){
        produto = umProduto;
        qtdade = umaQtdade;
        valorVenda = produto.getPrecoUnitario() * qtdade;
    }

    public Produto getProduto() {
        return produto;
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public int getQtdade() {
        return qtdade;
    }

    public String toString(){
        return("Cod: "+getProduto().getCodigo()+
          	   " Descricao: "+getProduto().getDescricao()+
               " Custo unitario R$ "+getProduto().getPrecoUnitario()+
               " Quantidade: "+getQtdade()+
               " Custo R$ "+getValorVenda());
    }
}
