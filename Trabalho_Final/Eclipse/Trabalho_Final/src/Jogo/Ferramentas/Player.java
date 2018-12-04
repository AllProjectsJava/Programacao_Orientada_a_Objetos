package Jogo.Ferramentas;

import ClassesBasicas.Ferramenta;

public class Player extends Ferramenta {
	private int time;

	public Player() {
		super("Player");
		time = 53;
	}

	public void decPegaFerramenta() {
		time -= 5;
	}

	public void decUsaFerramentaCorreta() {
		time -= 10;
	}

	public void decUsaFerramentaErrada() {
		time -= 20;
	}

	public void decMudaSalaCorreta() {
		time -= 2;
	}

	public void decMudaSalaErrada() {
		time -= 4;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

	public void decTime(int time) {
		this.time -= time;
	}

	public boolean isDead() {
		return (getTime() <= 0);
	}
}
