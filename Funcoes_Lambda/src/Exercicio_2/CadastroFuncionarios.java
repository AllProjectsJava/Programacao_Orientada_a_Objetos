package Exercicio_2;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CadastroFuncionarios {
	private List<Funcionario> lstf;

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
	
	// A - A lista de todos os funcionários
	public List<Funcionario> getFuncionarios() {
		return lstf;
	}

	// B - A lista dos funcionários que recebem insalubridade e tem dependentes ordenados pela quantidade de dependentes.
	public List<Funcionario> getInsalubridadeOrdenadoDependentes(){
		List<Funcionario> aux = lstf
				.stream()
				.filter((Funcionario f) -> f.getInsalubridade())
				.filter((Funcionario f) -> f.getNroDependentes() > 0)
				.collect(Collectors.toList());
		
			Collections.sort(aux, (Funcionario f1, Funcionario f2) -> f1.getNroDependentes() - f2.getNroDependentes());
									
		return aux;
	}
	
	// C - A quantidade de funcionários que tem dependentes
	public long getQuantidadeFuncionarioComDependente() {
		return lstf
				.stream()
				.filter((Funcionario f) -> f.getNroDependentes() > 0)
				.count();
	}
	
	// D - O somatório dos salários bruto de todos os funcionários.
	public double getSomatorioSalariosBrutos() {
		return lstf
				.stream()
				.mapToDouble((Funcionario f) -> f.getSalarioBruto())
				.sum();
	}
	
	// E - A lista dos funcionários que tem dependentes e tiveram seu salário alterado em 10%.
	public List<Funcionario> getFuncionariosDependentesSalAuterados(){
		return lstf
				.stream()
				//.filter((Funcionario f) -> f.getNroDependentes() > 0)
				.filter((Funcionario f) -> f.isAumento(10))
				.collect(Collectors.toList());
	}
	
	public Funcionario getFuncionario(String nome) {
		List<Funcionario> aux =
				lstf
				.stream()
				.filter((Funcionario f) -> f.getNome().equals(nome))
				.collect(Collectors.toList());
		
		return aux.get(0);
	}

	@Override
	public String toString() {
		return "CadastroFuncionarios\n" + lstf;
	}
}
