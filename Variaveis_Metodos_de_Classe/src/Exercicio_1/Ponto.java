package Exercicio_1;

public class Ponto {
	private int x;
	private int y;

	public Ponto() {
		this.x = 0;
		this.y = 0;
	}

	public Ponto(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Ponto(Ponto p) {
		this.x = p.getX();
		this.y = p.getY();
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	@Override
	public String toString() {
		return "Ponto [x=" + x + ", y=" + y + "]";
	}
}
