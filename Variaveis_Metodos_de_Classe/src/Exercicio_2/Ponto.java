package Exercicio_2;

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
	
	public double distancia(Ponto p) {
		int difx = x - p.getX();
		int dify = y - p.getY();
		double resp = Math.sqrt((difx * difx) + (dify * dify));
		return resp;
	}

	public static double distancia(Ponto p1, Ponto p2) {
		int difx = p1.getX() - p2.getX();
		int dify = p1.getY() - p2.getY();
		double resp = Math.sqrt((difx * difx) + (dify * dify));
		return resp;
	}

	@Override
	public String toString() {
		return "Ponto [x=" + x + ", y=" + y + "]";
	}
}
