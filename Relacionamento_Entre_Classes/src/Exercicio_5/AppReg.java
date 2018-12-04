package Exercicio_5;

import java.util.Scanner;

public class AppReg {
	public static void main(String args[]) {
		Registradora registradora = new Registradora();
		CatalogoProdutos catalogoProdutos = new CatalogoProdutos();
		EstoqueProdutos estoqueProdutos = new EstoqueProdutos();

		Scanner scanner = new Scanner(System.in);
		
		while (true) {
			System.out.println("1 para efetuar nova compra:");
			System.out.println("2 para consultar pelo codigo:");
			System.out.println("3 para produto mais vendido ate o momento:");
			System.out.println("4 oara quantidade média de itens distintos por cupom fiscal");
			System.out.println("5 para para fechar o programa");
			int op = scanner.nextInt();

			if (op == 1) {
				while (true) {
					System.out.println("0 encerra a venda, -1 encerra o dia");
					System.out.println("Entre o codigo do produto:");
					int codigo = scanner.nextInt();
					if (codigo == 0) {
						CupomFiscal cupomFiscal = registradora.encerraVenda();
						System.out.println(cupomFiscal.toString());
						System.out.println("Nova venda:");
					} else if (codigo == -1) {
						break;
					} else {
						Produto sendoVendido = catalogoProdutos.getProduto(codigo);
						if (sendoVendido == null) {
							System.out.println("Produto nao encontrado!!");
							continue;
						}
						System.out.println("Entre a quantidade: ");
						int quantidade = scanner.nextInt();
						registradora.informaVenda(sendoVendido, quantidade);
						estoqueProdutos.vendaProduto(sendoVendido.getCodigo(), quantidade);
					}
				}
				System.out.println("Itens vendidos:");
				System.out.println(registradora.relVendas());
				System.out.println("Total do dia: R$ " + registradora.getTotalDia());
			} else if (op == 2) {
				System.out.println("Digite o codigo do produto:");
				int cod = scanner.nextInt();
				System.out.println(catalogoProdutos.getProduto(cod).getPrecoUnitario());
				
			} else if (op == 3) {
				System.out.println();
			} else if (op == 4) {
				
			}  
			else if (op == 5) {
				break;
			}
		}
		scanner.close();
	}
}