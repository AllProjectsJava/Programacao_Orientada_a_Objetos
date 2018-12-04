package Ex_3_FuncionariosSemRepeticao;

public class Funcionario implements Comparable<Funcionario>{
    private String nome;
    private int matricula;
    
    public Funcionario(String n,int m){
        nome = n;
        matricula = m;
    }
    
    public String getNome(){
        return(nome);
    }
    
    public int getMatricula(){
        return(matricula);
    }
    
    public String toString(){
        return("Matricula: "+getMatricula()+", nome: "+getNome());
    }
    
    @Override
    public int compareTo(Funcionario outro){
        return(this.getMatricula() - outro.getMatricula());
        //return(this.getNome().compareTo(outro.getNome()));
    }
}
