package Demo;

/*
// Exemplo de classe abstrata pura
public abstract class Pessoa {
    public abstract String getNome();
    public abstract int getIdade();
    public abstract int getPeso();
    public abstract int getAltura();
    public abstract double getIMC();
}
*/
public interface Pessoa {
    String getNome();
    int getIdade();
    int getPeso();
    int getAltura();
    double getIMC();
}
