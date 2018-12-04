package Exercicio_1;

public class App {
	public static void main(String[] args) {
		CadastroFuncionarios cf = new CadastroFuncionarios();
		
		System.out.println("Relacao de funcionarios:");
		cf.getFuncionarios().forEach(System.out::println);
		
		System.out.println("======================================");
		
		System.out.println("Relacao de funcionarios com insalubridade e dependentes:");
		cf
		.getInsalubresComDependentes()
		.forEach(f -> System.out.println(f.getNome() + ", " + f.getNroDependentes() + " dependentes."));
		
		System.out.println("======================================");
		
		System.out.println("Quantidade de funcionarios que tem dependentes:");
		System.out.println(cf.getQuantidadeFuncionarioComDependente());
		
		System.out.println("======================================");
		
		System.out.println("Somatório do valor do salário bruto de todos os funcionários:");
		System.out.println(cf.getSomatorioSalariosBrutos());
		
		System.out.println("======================================");
		
		System.out.println("Taxa de aumento de 20% em todos os funcionários que recebem insalubridade:");
		cf.aumentaSalarioBaseDosInsalubres(1.2);
		cf.getFuncionariosInsalubres().forEach(System.out :: println);
		
		System.out.println("======================================");
		
		System.out.println("Taxa de aumento para todos funcionários com dependentes:");
		cf.aumentaSalarioBaseDosQueTemDependentes(1.0).forEach(System.out::println);
	}
}
