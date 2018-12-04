package Exercicio_4;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CatalogoProdutos{
    public static int MAXPRODS = 100;
    private Produto produtos[];
    private int contProd;
    private String fName;

    public CatalogoProdutos(String fname){
    	fName = fname;
        carregaProdutos();
    }

    public Produto getProduto(int codigo){
        for(int i=0; i<contProd; i++){
            if (produtos[i].getCodigo() == codigo){
                return(produtos[i]);
            }
        }
        return(null);
    }

    private void carregaProdutos(){
    	produtos = new Produto[MAXPRODS];
        contProd = 0;

        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+fName;
        System.out.println(nameComplete);
        Path path2 = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){
           sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
           int codigo;
           String descricao;
           double preco;
           while (sc.hasNext()){
               codigo = Integer.parseInt(sc.next());
               descricao = sc.next();
               preco = Double.parseDouble(sc.next());
               Produto p = new Produto(codigo,descricao,preco);
               produtos[contProd] = p;
               contProd++;
           }
        }catch (IOException x){
            System.err.format("Erro de E/S: %s%n", x);
        }
    }
}
