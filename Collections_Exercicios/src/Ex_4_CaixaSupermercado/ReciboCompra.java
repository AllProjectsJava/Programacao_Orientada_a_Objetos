package Ex_4_CaixaSupermercado;

import java.util.*;

public class ReciboCompra implements Iterable<Produto>{
    private List<Produto> itens;
    
    public ReciboCompra(){
        itens = new LinkedList<>();
    }
    
    public void add(Produto p){
        itens.add(p);
    }
    
    @Override
    public Iterator<Produto> iterator(){
        return(itens.iterator());
    }
    
    @Override
    public String toString(){
       StringBuilder sb = new StringBuilder();
       double soma = 0;
       for(Produto prod:itens){
           sb.append(prod).append("\n");
           soma += prod.getPreco();
       }
       sb.append("Total: R$ "+soma);
       return(sb.toString());
    }
}
