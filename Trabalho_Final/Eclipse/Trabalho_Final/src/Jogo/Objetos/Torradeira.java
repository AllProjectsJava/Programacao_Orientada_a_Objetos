package Jogo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import Jogo.Ferramentas.Pao;

public class Torradeira extends Objeto{
	
	public Torradeira() {
		super("Aguardando fazer a torrada!", "Torrada feita!");
	}

	@Override
	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof Pao) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}

}
