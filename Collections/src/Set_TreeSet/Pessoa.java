package Set_TreeSet;

public class Pessoa implements Comparable<Pessoa>{
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) {
		super();
		this.nome = nome;
		this.idade = idade;
	}

	public String getNome() {
		return nome;
	}

	public int getIdade() {
		return idade;
	}
	
	@Override
	public int compareTo(Pessoa outra){
	    //return this.getNome().compareTo(outra.getNome()); // Compara por nome
		//if (this.getIdade() > outra.getIdade()) return 1; // Compara por idade
		//else if (this.getIdade() == outra.getIdade()) return 0;
		//else return -1;
		return this.getIdade() - outra.getIdade();
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}
}
