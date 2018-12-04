package Jogo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import Jogo.Ferramentas.PocaoMagica;

public class MaquinaTiraTempo extends Objeto{

	public MaquinaTiraTempo() {
		super("Aguardando Pocao Magica!", "Tempo removido com sucesso!");
	}

	@Override
	public boolean usar(Ferramenta ferramenta) {
		if (ferramenta instanceof PocaoMagica) {
			this.setAcaoOk(true);
			return true;
		}
		return false;
	}
}
