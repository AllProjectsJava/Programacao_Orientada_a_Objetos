package Jogo.Objetos;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import Jogo.Ferramentas.GuardaChuva;

public class CaixaComercio extends Objeto{

	public CaixaComercio() {
		super("Aguardando itens!", "Item trocados!");
		
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
