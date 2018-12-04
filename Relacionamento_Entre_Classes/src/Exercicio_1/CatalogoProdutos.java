package Exercicio_1;

public class CatalogoProdutos{
    public static int MAXPRODS = 10;
    private Produto produtos[];

    public CatalogoProdutos(){
        carregaProdutos();
    }

    public Produto getProduto(int codigo){
        for(int i=0; i<produtos.length; i++){
            if (produtos[i].getCodigo() == codigo){
                return(produtos[i]);
            }
        }
        return(null);
    }

    private void carregaProdutos(){
        produtos = new Produto[MAXPRODS];

        produtos[0] = new Produto(10,"Banana",3.20);
        produtos[1] = new Produto(30,"Maca",5.50);
        produtos[2] = new Produto(20,"Pera",2.20);
        produtos[3] = new Produto(40,"Melao",4.90);
        produtos[4] = new Produto(50,"Melancia",1.80);
        produtos[5] = new Produto(80,"Abacaxi",3.30);
        produtos[6] = new Produto(70,"Laranja",0.45);
        produtos[7] = new Produto(60,"Limao",0.12);
        produtos[8] = new Produto(90,"Morango",8.90);
        produtos[9] = new Produto(100,"Quiwi",6.60);
    }
}
