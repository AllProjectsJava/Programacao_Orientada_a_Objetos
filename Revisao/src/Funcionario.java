public class Funcionario implements Comparable<Funcionario>{
    private String nome;
    private int codigo;
    private double salarioBase;
    
    public Funcionario(String umNome,int umCodigo,double umSalBase){
        nome = umNome;
        codigo = umCodigo;
        salarioBase = umSalBase;
    }
        
    public String getNome(){
        return(nome);
    }
    
    public int getCodigo(){
        return(codigo);
    }
    
    public double getSalarioBase(){
        return(salarioBase);
    }
    
    public void setSalarioBase(double umSal){
        salarioBase = umSal;
    }
    
    /*
    public double getSalario(){
        double inss = getSalarioBase() * 0.1;
        double ir = 0;
        if (getSalarioBase() >= 2000){
            ir = getSalarioBase() * 0.12;
        }
        return(getSalarioBase() - inss - ir);
    }
    */
    public double getSalario(CalculaSalario cs){
    	return cs.calcula(this);
    }

	@Override
	public String toString() {
		return "Funcionario [nome=" + nome + ", codigo=" + codigo + ", salarioBase=" + salarioBase + "]";
	}
	
	@Override
	public int compareTo(Funcionario f) {
		return this.getCodigo() - f.getCodigo();
		//return this.getNome().compareTo(f.getNome());
	}
}
