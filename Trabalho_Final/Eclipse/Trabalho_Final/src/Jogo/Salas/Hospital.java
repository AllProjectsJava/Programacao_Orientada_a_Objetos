package Jogo.Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import ClassesBasicasGenericas.SalaGenerica;
import Jogo.FimDeJogoException;
import Jogo.Ferramentas.PocaoMagica;
import Jogo.Objetos.MaquinaTiraTempo;

public class Hospital extends SalaGenerica{
	private MaquinaTiraTempo maquinaTiraTempo;
	
	public Hospital() {
		super("Hospital", "5");
		super.objectRequired = true;
		maquinaTiraTempo = new MaquinaTiraTempo();
		this.getObjetos().put("MaquinaTiraTempo", maquinaTiraTempo);
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append(".\n");
		descricao.append("Tem uma maquina que remove o relogio do seu braco ao seu lado.").append("\n");
		descricao.append("E preciso colocar a Pocao Magica na maquina.").append("\n").append("\n");
		descricao.append("Status da Maquina: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramenta: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("A porta da passagem para a: ").append(this.portasDisponiveis().toString()).append("\n");
		return descricao.toString();
	}
	
	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) { // Verifica se tem a ferramenta na mochila
			return false;
		}
		if (f instanceof PocaoMagica) { // Verifica Se é a ferramenta correta
			this.getMochila().removeFerramenta("PocaoMagica");
			((MaquinaTiraTempo) (this.getObjetos().get("MaquinaTiraTempo"))).setAcaoOk(true);
			throw new FimDeJogoException();
		}
		return false;
	}

	@Override
	public Objeto getObject() {
		return maquinaTiraTempo;
	}

	@Override
	public String getTextAction() {
		return this.objetosDisponiveis().toString();
	}
}
