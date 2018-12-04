package Exercicio_1;

import java.util.Scanner;

/*
 * Para uso acadêmico
 */

/**
 * Esta redução atua como uma registradora simples
 * Solicita o código do produto e a quantidade vendida e informa o total a pagar
 * No final do dia informa o total vendido
 *
 * @author Bernardo
 */
public class App {
    public static void main(String args[]){
        CatalogoProdutos catProd = new CatalogoProdutos();
        double totalVendido = 0;
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Entre o codigo do produto");
            System.out.println("Codigo -1, encerra dia");
            System.out.print("-->");
            int codigo = input.nextInt();
            if (codigo == -1){
                break;
            }else{
            	Produto prod = catProd.getProduto(codigo);
                if (prod == null){
                    System.out.println("Produto nao cadastrado!!");
                }else{
                	  double custoUnit = prod.getPrecoUnitario();
                	  System.out.println("Entre a quantidade vendida:");
                    int qtdade = input.nextInt();
                    double custoItem = custoUnit * qtdade;
                    System.out.println("Total a pagar:"+custoItem);
                    totalVendido += custoItem;
                }
            }
        }
        System.out.println("Encerrando o caixa !!");
        System.out.println("Total vendido no dia:"+totalVendido);
        input.close();
    }
}
