package Exercicio_10;

public class Aluno {
	private int matricula;
	private String nome;
	private int anoNascimento;

	public Aluno(int umaMtr, String umNom, int umANasc) {
		nome = umNom;
		matricula = umaMtr;
		anoNascimento = umANasc;
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	@Override
	public String toString() {
		return (matricula + ", " + nome + ", " + anoNascimento);
	}

}
