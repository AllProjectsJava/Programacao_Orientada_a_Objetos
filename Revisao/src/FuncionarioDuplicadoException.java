
public class FuncionarioDuplicadoException extends RuntimeException{
    private Funcionario funcionario;
    
    public FuncionarioDuplicadoException(Funcionario funcionario) {
    	super(funcionario.getNome()+" tem codigo duplicado !!");
    	this.funcionario = funcionario;
    }
    
    public Funcionario getFuncionario() {
    	return funcionario;
    }
}
