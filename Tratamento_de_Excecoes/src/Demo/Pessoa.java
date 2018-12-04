package Demo;

import java.util.Scanner;

public class Pessoa {
	private String nome;
	private int idade;
	
	public Pessoa(String nome, int idade) throws InterruptedException{
		if (nome == null || nome.length() == 0) {
			throw new NomeInvalidoException();
		}
        if (idade < 0) {
        	throw new IdadeInvalidaException(idade);
        }
		this.nome = nome;
		this.idade = idade;
		Thread.sleep(1000);
	}
	
	@Override
	public String toString() {
		return "Pessoa [nome=" + nome + ", idade=" + idade + "]";
	}



	public double umCalculo(int a,int b) {
    	return a/b;
    }
    
    public int fatorial(int n) {
    	if (n < 0) {
    		//return -1;
    		throw new IllegalArgumentException("Fatoria de negativo");
    	}
    	int resp = 1;
    	while(n>1) {
    		resp = resp * n;
    		n--;
    	}
    	return resp;
    }
}
