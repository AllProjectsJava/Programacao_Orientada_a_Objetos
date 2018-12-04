package Jogo.Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import ClassesBasicasGenericas.SalaGenerica;
import Jogo.Ferramentas.Chaveiro;
import Jogo.Ferramentas.GarrafaAgua;
import Jogo.Ferramentas.GuardaChuva;
import Jogo.Objetos.Bicicleta;


public class ParadaOnibus extends SalaGenerica {
	private Bicicleta bicicleta;

	public ParadaOnibus() {
		super("ParadaOnibus", "2");
		super.objectRequired = true;
		bicicleta = new Bicicleta();
		this.getObjetos().put("Bicicleta", bicicleta);
		Chaveiro chaveiro = new Chaveiro();
		this.getFerramentas().put(chaveiro.getDescricao(), chaveiro);
	}
	
	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append(".\n");
		descricao.append("Beba agua! Nao tem combustivel, ande com a bicicleta que esta na parada, cuidado, use o guarda chuva pois esta chovendo.").append("\n").append("\n");
		descricao.append("Status da Bicicleta: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramentas na parada: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("A porta da passagem para a: ").append(this.portasDisponiveis().toString());
		return descricao.toString();
	}

	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) { // Verifica se tem a ferramenta na mochila
			return false;
		}
		if (f instanceof GuardaChuva) { // Verifica Se é a ferramenta correta
			((Bicicleta) (this.getObjetos().get("Bicicleta"))).setAcaoOk(true);
			return true;
		}
		if(f instanceof GarrafaAgua) {
			super.aumentaTempo(90);
			return true;
		}
		return false;
	}

	@Override
	public Objeto getObject() {
		return bicicleta;
	}

	@Override
	public String getTextAction() {
		return this.objetosDisponiveis().toString();
	}
}
