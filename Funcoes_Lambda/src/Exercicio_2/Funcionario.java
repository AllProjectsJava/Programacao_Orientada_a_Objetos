package Exercicio_2;

import java.util.LinkedList;

public class Funcionario {
	private int matricula;
	private String nome;
	private double salarioBase;
	private int nroDependentes;
	private boolean insalubridade;
	private LinkedList<Double> lstAumentos;

	public Funcionario(int matricula, String nome, double salarioBase, int nroDependentes, boolean insalubridade) {
		this.matricula = matricula;
		this.nome = nome;
		this.salarioBase = salarioBase;
		this.nroDependentes = nroDependentes;
		this.insalubridade = insalubridade;
		this.lstAumentos = new LinkedList<>();
	}

	public int getMatricula() {
		return matricula;
	}

	public String getNome() {
		return nome;
	}

	public double getSalarioBase() {
		return salarioBase;
	}

	public int getNroDependentes() {
		return nroDependentes;
	}

	public boolean getInsalubridade() {
		return insalubridade;
	}

	public void aumentaSalBase(double taxa){
		addAumento(taxa);
		salarioBase *= taxa;
	}
	
	public void addAumento(double taxa) {
		lstAumentos.add(taxa);
	}
	
	private double inss() {
		if (getSalarioBase() <= 5000.0){
		return (getSalarioBase() * 0.045);
		}else{
			return 5000.0 * 0.045;
		}
	}

	private double irpf() {
		if (getSalarioBase() <= 2000) {
			return 0.0;
		} else if (getSalarioBase() <= 5000) {
			return ((getSalarioBase() - 2000) * 0.12);
		} else {
			double p1 = 3000 * 0.12;
			double p2 = (getSalarioBase() - 5000) * 0.275;
			return (p1 + p2);
		}
	}

	public double getSalarioBruto() {
		double adicInsalubridade = 0.0;
		double adicDep = 0.0;

		if (getInsalubridade()) {
			adicInsalubridade = getSalarioBase() * 0.1;
		}

		adicDep = getNroDependentes() * (getSalarioBase() * 0.01);

		return (getSalarioBase() + adicInsalubridade + adicDep);
	}

	public double getSalarioLiquido() {
		return (getSalarioBruto() - inss() - irpf());
	}
	
	public boolean isAumento(double taxa) {
		double quantidade = lstAumentos
							.stream()
							.filter(v -> v.doubleValue() == taxa)
							.count();
		
		return quantidade != 0;
	}

	@Override
	public String toString() {
		return "matricula=" + matricula + ", nome=" + nome + ", salarioBase=" + salarioBase
				+ ", nroDependentes=" + nroDependentes + ", insalubridade=" + insalubridade;
	}
}
