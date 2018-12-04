public interface Conjunto{
    // Operacoes entre elemento e conjunto
    boolean pertence(int n);
    boolean insere(int n);
    boolean remove(int n);
    // Operacoes entre conjuntos
    Conjunto uniao(Conjunto outro);
    Conjunto interseccao(Conjunto outro);
    Conjunto diferenca(Conjunto outro);
    // Operacoes auxiliares
    int[] toArray();
    int getTamMaximo();
    int getTamanho();
}

