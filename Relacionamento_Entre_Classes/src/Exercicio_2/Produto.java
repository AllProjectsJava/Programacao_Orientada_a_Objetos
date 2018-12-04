package Exercicio_2;

public class Produto{
    private int codigo;
    private String descricao;
    private double preco;
    
    public Produto(int umCod,String umaDescr,double umPreco){
        codigo = umCod;
        descricao = umaDescr;
        preco = umPreco;
    }
    
    public int getCodigo(){
        return(codigo);
    }
    
    public String getDescricao(){
        return(descricao);
    }
    
    public double getPrecoUnitario(){
        return(preco);
    }
    
    public String toString(){
        return(getCodigo()+": "+getDescricao()+", R$ "+getPrecoUnitario());
    }
}

