package Demo;

import java.awt.Color;

public class Caneta<M,T> {
    private M marca;
    private T cor;

    public Caneta(M marca, T cor) {
		super();
		this.marca = marca;
		this.cor = cor;
	}

	public M getMarca() {
		return marca;
	}

	public T getCor() {
		return cor;
	}

	@Override
	public String toString() {
		return "Caneta [marca=" + marca + ", cor=" + cor + "]";
	}
}
