package Exercicio_3;

import java.util.Scanner;

/*
 * Para uso acadêmico
 */

/**
 * Esta redução atua como uma registradora simples
 * Solicita o c�digo do produto e a quantidade vendida e informa o total a pagar
 * No final do dia informa o total vendido
 *
 * @author Bernardo
 */
public class App {
    public static void main(String args[]){
        CatalogoProdutos catProd = new CatalogoProdutos();
        Registradora registradora = new Registradora(catProd);
        Scanner input = new Scanner(System.in);

        while(true){
            System.out.println("Entre o codigo do produto");
            System.out.println("Codigo -1, encerra dia");
            System.out.print("-->");
            int codigo = input.nextInt();
            if (codigo == -1){
                break;
            }else{
              System.out.println("Digite a quantidade");
              int qtdade = input.nextInt();
              double custoItem = registradora.registraVenda(codigo,qtdade);
              if (custoItem == -1.0){
                System.out.println("Produto inexistente!!");
              }else{
                System.out.println("Total a pagar:"+custoItem);
              }
            }
        }
        System.out.println("Encerrando o caixa !!");
        System.out.println(registradora.relVendasDoDia());
        input.close();
    }
}
