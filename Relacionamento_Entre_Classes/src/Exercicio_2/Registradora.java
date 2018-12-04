package Exercicio_2;

public class Registradora{
    private CatalogoProdutos catProd;
    private double totalVendido;

    public Registradora(CatalogoProdutos catProd){
      this.catProd = catProd;
      totalVendido = 0.0;
    }

    public double registraVenda(int codProd,int qtdade){
      Produto prod = catProd.getProduto(codProd);
      if (prod == null){
        return -1.0;
      }
      double custoDaVenda = prod.getPrecoUnitario() * qtdade;
      totalVendido = totalVendido + custoDaVenda;
      return custoDaVenda;
    }

    public double getTotalVendido(){
      return totalVendido;
    }
}
