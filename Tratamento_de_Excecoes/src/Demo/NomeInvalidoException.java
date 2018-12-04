package Demo;

public class NomeInvalidoException extends RuntimeException {
    public NomeInvalidoException() {
    	super("Nome nulo ou vazio");
    }
}
