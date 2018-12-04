package Exercicio_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CadastroFuncionarios {
	private LinkedList<Funcionario> lstf;

	public CadastroFuncionarios() {
		lstf = new LinkedList<>();

		Random r = new Random();

		for (int i = 0; i < 5; i++) {
			int matricula = r.nextInt(1000) + 100;
			String nome = "Fulano " + i;
			boolean insalubridade = r.nextBoolean();
			int nroDep = r.nextInt(4);
			double salBase = (r.nextDouble() * 15000) + 500;
			Funcionario f = new Funcionario(matricula, nome, salBase, nroDep, insalubridade);
			lstf.add(f);
		}
	}

	// A - Tipo Function (função unária de T em R)
	// Retornar uma lista com todos os funcionários que recebem insalubridade e tem dependentes.
	public List<Funcionario> getInsalubresComDependentes() {
		return lstf.stream()
				.filter((Funcionario u) -> u.getInsalubridade())
				.filter((Funcionario u) -> u.getNroDependentes() > 0)
				.collect(Collectors.toList());
	}

	// B -
	// Retornar a quantidade de funcionários que tem dependentes.
	public long getQuantidadeFuncionarioComDependente() {
		return lstf
				.stream()
				.filter((Funcionario u) -> u.getNroDependentes() > 0)
				.count();
	}

	// C -
	// Retornar o somatório do valor do salário bruto de todos os funcionários.
	public double getSomatorioSalariosBrutos() {
		return lstf
				.stream()
				.mapToDouble((Funcionario u) -> u.getSalarioBruto())
				.sum();
	}

	// D -
	// Aplicar uma taxa de aumento (ex: 1.2 para 20%) em todos os funcionários que recebem insalubridade.
	public void aumentaSalarioBaseDosInsalubres(double taxa) {
		lstf
		.stream()
		.filter((Funcionario f) -> f.getInsalubridade())
		.forEach((Funcionario f) -> f.aumentaSalBase(taxa));
	}
	
	// E -
	// Aplicar uma taxa de aumento em todos os funcionários que tem dependentes
	// e 
	// retornar uma lista com os funcionários que tiveram os salários modificados.
	public List<Funcionario> aumentaSalarioBaseDosQueTemDependentes(double taxa) {
		List<Funcionario> aux = lstf
				.stream()
				.filter((Funcionario f) -> f.getNroDependentes() > 0)
				.collect(Collectors.toList());

		aux.forEach((Funcionario f) -> f.aumentaSalBase(taxa));

		return aux;
	}

	public List<Funcionario> getFuncionarios() {
		return lstf;
	}
	
	public List<Funcionario> getFuncionariosInsalubres(){
		return lstf
				.stream()
				.filter((Funcionario f) -> f.getInsalubridade())
				.collect(Collectors.toList());
	}

	@Override
	public String toString() {
		return "CadastroFuncionarios\n" + lstf;
	}
}
