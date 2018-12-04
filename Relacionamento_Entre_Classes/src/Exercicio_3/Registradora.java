package Exercicio_3;

public class Registradora{
    private CatalogoProdutos catProd;
    private double totalVendido;
    private ItemVenda vendas[];
    private int qtdadeVendas;

    public Registradora(CatalogoProdutos catProd){
      this.catProd = catProd;
      totalVendido = 0.0;
      vendas = new ItemVenda[1000];
      qtdadeVendas = 0;
    }

    public double registraVenda(int codProd,int qtdade){
      Produto prod = catProd.getProduto(codProd);
      if (prod == null){
        return -1.0;
      }

      ItemVenda iv = new ItemVenda(prod,qtdade);
      vendas[qtdadeVendas] = iv;
      qtdadeVendas++;

      totalVendido = totalVendido + iv.getValorVenda();
      return iv.getValorVenda();
    }

    public double getTotalVendido(){
      return totalVendido;
    }

    public String relVendasDoDia(){
      StringBuffer sb = new StringBuffer("Vendas do dia\n");
      for(int i=0;i<qtdadeVendas;i++){
        sb.append(vendas[i].toString());
        sb.append("\n");
      }
      sb.append("Total vendido: "+totalVendido);
      return sb.toString();
    }
}
