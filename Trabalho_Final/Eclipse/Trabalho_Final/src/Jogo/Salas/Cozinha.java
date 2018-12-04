package Jogo.Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import ClassesBasicasGenericas.SalaGenerica;
import Jogo.Ferramentas.Chocolate;
import Jogo.Ferramentas.GarrafaAgua;
import Jogo.Ferramentas.GuardaChuva;
import Jogo.Ferramentas.Pao;
import Jogo.Ferramentas.Torrada;
import Jogo.Objetos.Torradeira;

public class Cozinha extends SalaGenerica{
	private Torradeira torradeira;
	private String textTorrada;

	public Cozinha() {
		super("Cozinha", "1");
		super.objectRequired = true;
		torradeira = new Torradeira();
		this.getObjetos().put("Torradeira", torradeira);
		GuardaChuva guardaChuva = new GuardaChuva();
		GarrafaAgua garrafaDeAgua = new GarrafaAgua();
		Chocolate chocolate = new Chocolate();
		this.getFerramentas().put(guardaChuva.getDescricao(), guardaChuva);
		this.getFerramentas().put(garrafaDeAgua.getDescricao(), garrafaDeAgua);
		this.getFerramentas().put(chocolate.getDescricao(), chocolate);
		textTorrada ="";
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append(".\n");
		descricao.append("Voce deve usar o pao e guargar a torrada na mochila para mais tarde comer!").append("\n");
		descricao.append("Depois que voce guardou a torrada, ficou com fome, entao voce resolve comer a torrada e percebe que ganha tempo!").append("\n").append("\n");
		descricao.append("Status da torradeira: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramentas da cozinha: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("A porta da passagem para a: ").append(this.portasDisponiveis().toString()).append("\n");
		descricao.append(textTorrada);
		return descricao.toString();
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) {// Verifica se tem a ferramenta na mochila
			return false;
		}
		if (f instanceof Pao) {// Verifica Se é a ferramenta correta
			((Torradeira)(this.getObjetos().get("Torradeira"))).setAcaoOk(true);
			Torrada torrada = new Torrada();
			this.getFerramentas().put(torrada.getDescricao(), torrada);
			return true;
		}
		if(f instanceof Torrada) {
			this.aumentaTempo(20);
			textTorrada = "Voce comeu a torrada e ganhou tempo!\n";
			return true;
		}
		return false;
	}

	@Override
	public Objeto getObject() {
		return torradeira;
	}

	@Override
	public String getTextAction() {
		return this.objetosDisponiveis().toString();
	}
}
