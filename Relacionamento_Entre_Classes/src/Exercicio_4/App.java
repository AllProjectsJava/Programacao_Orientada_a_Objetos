package Exercicio_4;

import java.util.Scanner;

public class App {

	public static void main(String[] args) {
		if (args.length != 1) {
			System.out.println("Sintaxe: App <arquivo do catalogo de produtos");
			System.exit(0);
		}

		CatalogoProdutos catalogo = new CatalogoProdutos(args[0]);
		Registradora reg = new Registradora();
		Scanner input = new Scanner(System.in);

		while (true) {
			System.out.println("Entre o código do produto");
			System.out.println("-1 para encerrar o dia, 0 para encerrar a venda");
			System.out.print("-->");
			int codigo = input.nextInt();
			if (codigo == -1) {
				break;
			} else if (codigo == 0){
                CupomFiscal cf = reg.encerraVenda();
                System.out.println(cf.toString());
                System.out.println("Nova venda:");
			}else{
				Produto prod = catalogo.getProduto(codigo);
				if (prod == null) {
					System.out.println("Produto não cadastrado!!");
				} else {
					System.out.println("Entre a quantidade vendida:");
					int qtdade = input.nextInt();
					double custoItem = reg.registraItem(prod, qtdade);
					//System.out.println("Total a pagar:" + custoItem);
				}
			}
		}
		System.out.println("Encerrando o caixa !!");
		System.out.println(reg.relVendas());
		System.out.println("Total vendido no dia:" + reg.getTotalVendido());
		input.close();
	}

}
