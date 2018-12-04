package Teste;

public class Pessoa implements Comparable<Pessoa> {
	private String nome;
	private int idade;

	public Pessoa(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	@Override
	public int compareTo(Pessoa outra) {
		return this.getNome().compareTo(outra.getNome());
		/*
		 * if (this.getIdade() > outra.getIdade()) return 1; else if (this.getIdade() ==
		 * outra.getIdade()) return 0; else return -1;
		 */
		// return this.getIdade() - outra.getIdade();
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}

	@Override
	public String toString() {
		return "\nNome: " + nome + "Idade: " + idade;
	}
}
