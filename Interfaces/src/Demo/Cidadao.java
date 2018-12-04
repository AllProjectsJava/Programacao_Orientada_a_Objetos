package Demo;

public class Cidadao implements Pessoa,Comparable {
    private String nome;
    private int idade;
    private int altura; // em cm
    private int peso; // kgs
   
	public Cidadao(String nome, int idade, int altura, int peso) {
		super();
		this.nome = nome;
		this.idade = idade;
		this.altura = altura;
		this.peso = peso;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public int getIdade() {
		return idade;
	}

	@Override
	public int getPeso() {
		return peso;
	}

	@Override
	public int getAltura() {
		return altura;
	}

	@Override
	public double getIMC() {
		return (double)peso/(altura*altura);
	}

	@Override
	public int compareTo(Object o) {
		Cidadao outro = (Cidadao)o;
		/*if (this.altura < outro.altura) return -1;
		else if (this.altura == outro.altura) return 0;
		else return 1;*/
		//return this.altura - outro.altura;
		//return (int)((this.getIMC() - outro.getIMC())*100);
		return this.getNome().compareTo(outro.getNome());
	}
}
