package Exercicio_2;

public class App {
	public static void main(String[] args) {
		CadastroFuncionarios cf = new CadastroFuncionarios();

		System.out.println("Lista de todos os funcionarios:");
		cf.getFuncionarios().forEach(System.out::println);
		
		System.out.println("======================================");
		
		System.out.println("Lista dos funcionários que recebem insalubridade e tem dependentes ordenados pela quantidade de dependentes:");
		cf.getInsalubridadeOrdenadoDependentes().forEach((Funcionario f) -> System.out.println("Nome: "+f.getNome() +" Nurero dependentes: "+f.getNroDependentes()));
		
		System.out.println("======================================");
		
		System.out.println("Quantidade de funcionários que tem dependentes:");
		System.out.println(cf.getQuantidadeFuncionarioComDependente());
		
		System.out.println("======================================");
		
		System.out.println("Somatório dos salários bruto de todos os funcionários:");
		System.out.println(cf.getSomatorioSalariosBrutos());
		
		System.out.println("======================================");
		
		System.out.println("Lista dos funcionários que tem dependentes e tiveram seu salário alterado em 10%:");
		Funcionario  f = cf.getFuncionario("Fulano 2");
		f.addAumento(10);
		cf.getFuncionariosDependentesSalAuterados().forEach(System.out::println);
	}
}
