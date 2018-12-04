package Exercicio_4;

// Interface funcional que recebe dois inteiros e devolve um inteiro
@FunctionalInterface
public interface ClassFunctionalInterface<T> {
    T operacao(T p1,T p2);
}
