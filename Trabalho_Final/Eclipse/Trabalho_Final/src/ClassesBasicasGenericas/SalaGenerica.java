package ClassesBasicasGenericas;

import ClassesBasicas.Objeto;
import ClassesBasicas.Sala;
import Jogo.Ferramentas.Player;

public abstract class SalaGenerica extends Sala {
	protected boolean objectRequired;

	public SalaGenerica(String nome, String repVis) {
		super(nome, repVis);
	}

	@Override
	public abstract String textoDescricao();

	@Override
	public abstract boolean usa(String ferramenta);

	public boolean isObjectRequired() {
		return objectRequired;
	}

	public abstract Objeto getObject();

	public abstract String getTextAction();

	@Override
	public boolean pega(String nomeFerramenta) {
		boolean resp = super.pega(nomeFerramenta);
		this.getFerramentas().remove(nomeFerramenta);
		return resp;
	}

	public int getTempo() {
		Player f =  (Player) this.getMochila().usar("Player");
		return f.getTime();
	}

	public void aumentaTempo(int tempo) {
		Player f = (Player) this.getMochila().usar("Player");
		f.setTime(f.getTime() + tempo);
	}

	public void decrementaTempo(int tempo) {
		Player f = (Player) this.getMochila().usar("Player");
		f.decTime(tempo);
	}

}
