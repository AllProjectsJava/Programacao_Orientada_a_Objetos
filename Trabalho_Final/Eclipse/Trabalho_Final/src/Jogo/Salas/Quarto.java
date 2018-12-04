package Jogo.Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import ClassesBasicasGenericas.SalaGenerica;
import Jogo.Ferramentas.Celular;
import Jogo.Ferramentas.Marreta;
import Jogo.Ferramentas.Pao;
import Jogo.Objetos.PortaQuarto;

public class Quarto extends SalaGenerica {
	private PortaQuarto portaQuarto;

	public Quarto() {
		super("Quarto", "0");
		super.objectRequired = true;
		portaQuarto = new PortaQuarto();
		this.getObjetos().put("PortaQuarto", portaQuarto);
		Marreta marreta = new Marreta();
		Pao pao = new Pao();
		Celular celular = new Celular();
		this.getFerramentas().put(marreta.getDescricao(), marreta);
		this.getFerramentas().put(pao.getDescricao(), pao);
		this.getFerramentas().put(celular.getDescricao(), celular);
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce acordou no seu ").append(this.getNome()).append(".\n");
		descricao.append("Olhou para seu braço, descobriu que tem um relogio, que marca 30 minutos restantes de vida.").append("\n");
		descricao.append("Dica** Pegue tudo que puder!").append("\n").append("\n");
		descricao.append("Status da porta: ").append(this.objetosDisponiveis().toString()).append(".\n");
		descricao.append("Objetos espalhados no seu quarto: ").append(this.ferramentasDisponiveis().toString()).append(".\n");
		descricao.append("A porta da passagem para a: ").append(this.portasDisponiveis().toString());
		return descricao.toString();
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) { // Verifica se tem a ferramenta na mochila
			return false;
		}
		if (f instanceof Marreta) { // Verifica Se é a ferramenta correta
			((PortaQuarto) (this.getObjetos().get("PortaQuarto"))).setAcaoOk(true);
			return true;
		}
		return false;
	}

	@Override
	public Objeto getObject() {
		return portaQuarto;
	}

	@Override
	public String getTextAction() {
		return this.objetosDisponiveis().toString();
	}
}
