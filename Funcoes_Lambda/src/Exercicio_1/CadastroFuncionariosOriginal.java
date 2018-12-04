package Exercicio_1;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class CadastroFuncionariosOriginal {
	private List<Funcionario> lstf;

	public CadastroFuncionariosOriginal() {
		lstf = new LinkedList<>();

		Random r = new Random();

		for (int i = 0; i < 40; i++) {
			int matricula = r.nextInt(1000) + 100;
			String nome = "Fulano" + i;
			boolean insalubridade = r.nextBoolean();
			int nroDep = r.nextInt(3) + 1;
			double salBase = (r.nextDouble() * 15000) + 500;
			Funcionario f = new Funcionario(matricula, nome, salBase, nroDep, insalubridade);
			lstf.add(f);
		}
	}

	public List<Funcionario> getFuncionarios() {
		return lstf;
	}

	@Override
	public String toString() {
		return "CadastroFuncionarios [lstf=" + lstf + "]";
	}
}
