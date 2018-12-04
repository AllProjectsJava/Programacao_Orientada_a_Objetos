package Jogo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import Jogo.Ferramentas.Marreta;

public class PortaQuarto extends Objeto{

	public PortaQuarto() {
		super("A porta esta trancada e voce nao tem a chave!", "Voce conseguiu abrir a porta!");
	}

	@Override
	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof Marreta) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}
}
