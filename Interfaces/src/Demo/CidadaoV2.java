package Demo;

public class CidadaoV2 implements Pessoa {
	public static int IDADE = 0;
	public static int ALTURA = 1;
	public static int PESO = 2;
    private String nome;
    private int dados[];
    
	public CidadaoV2(String nome, int idade, int altura, int peso) {
		super();
		dados = new int[3];
		this.nome = nome;
		this.dados[IDADE] = idade;
		this.dados[ALTURA] = altura;
		this.dados[PESO] = peso;
	}

	@Override
	public String getNome() {
		return nome;
	}

	@Override
	public int getIdade() {
		return dados[IDADE];
	}

	@Override
	public int getPeso() {
		return dados[PESO];
	}

	@Override
	public int getAltura() {
		return dados[ALTURA];
	}

	@Override
	public double getIMC() {
		return (double)dados[PESO]/(dados[ALTURA]*dados[ALTURA]);
	}
}
