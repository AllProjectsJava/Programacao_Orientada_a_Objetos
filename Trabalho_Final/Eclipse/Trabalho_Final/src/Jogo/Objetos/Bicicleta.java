package Jogo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import Jogo.Ferramentas.GuardaChuva;

public class Bicicleta extends Objeto{

	public Bicicleta() {
		super("A bicicleta esta disponivel!", "Voce pegou a bicicleta!");
	}

	@Override
	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof GuardaChuva) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}

}
