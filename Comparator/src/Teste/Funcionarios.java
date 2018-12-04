package Teste;

import java.util.LinkedList;

public class Funcionarios {
	private LinkedList<Pessoa> funcionarios;
	
	public Funcionarios() {
		funcionarios = new LinkedList<>();
	}
	
	public void load() {
		funcionarios.add(new Pessoa("Pedro", 20));
		funcionarios.add(new Pessoa("Ana", 10));
		funcionarios.add(new Pessoa("Maria", 15));
		funcionarios.add(new Pessoa("Raquel", 5));
	}

	@Override
	public String toString() {
		return "" + funcionarios ;
	}
}
