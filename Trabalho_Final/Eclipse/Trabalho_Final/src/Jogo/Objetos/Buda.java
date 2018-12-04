package Jogo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;

public class Buda extends Objeto {

	public Buda() {
		super("Aguardando a Pedra Filosofal", "Troca feita! pocao magica disponivel!");
	}

	@Override
	public boolean usar(Ferramenta f) {

		return false;
	}
}
