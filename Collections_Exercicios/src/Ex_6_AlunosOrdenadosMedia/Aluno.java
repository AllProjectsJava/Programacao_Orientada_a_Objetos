package Ex_6_AlunosOrdenadosMedia;

public class Aluno implements Comparable<Aluno>{
	private int matricula;
	private String nome;
	private double n1;
	private double n2;
	private double n3;
	
	public Aluno(int matricula, String nome, double n1, double n2, double n3) {
		super();
		this.matricula = matricula;
		this.nome = nome;
		this.n1 = n1;
		this.n2 = n2;
		this.n3 = n3;
	}

	public int getMatricula() {
		return matricula;
	}


	public void setMatricula(int matricula) {
		this.matricula = matricula;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public double getN1() {
		return n1;
	}


	public void setN1(double n1) {
		this.n1 = n1;
	}


	public double getN2() {
		return n2;
	}


	public void setN2(double n2) {
		this.n2 = n2;
	}


	public double getN3() {
		return n3;
	}


	public void setN3(double n3) {
		this.n3 = n3;
	}
	
	public double getMedia(){
		return (n1+n2+n3)/3.0;
	}

	@Override
	public int compareTo(Aluno other){
		/*
		if (getMedia() > other.getMedia()){return 1;}
		else if (getMedia() < other.getMedia()){return -1;}
		else{return 0;}
		*/
		return (int)(this.getMedia() - other.getMedia()); 
	}

	@Override
	public String toString() {
		return "Aluno [matricula=" + matricula + ", nome=" + nome + " media= "+getMedia()+"]";
	}
}
 