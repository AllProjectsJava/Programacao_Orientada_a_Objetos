package Jogo.Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import ClassesBasicasGenericas.SalaGenerica;
import Jogo.Ferramentas.PedraFilosofal;
import Jogo.Ferramentas.PocaoMagica;
import Jogo.Objetos.Buda;

public class Passarela extends SalaGenerica {
	private Buda buda;

	public Passarela() {
		super("Passarela", "4");
		super.objectRequired = false;
		buda = new Buda();
		this.getObjetos().put("Buda", buda);
	}

	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append("\n");
		descricao.append("Voce esta atravessando a passarela, quando se depara com um Buda!").append("\n");
		descricao.append("Ele quer trocar a Pedra Filosofal por uma Pocao Magica! não esqueca de pegar a PocaoMagica!").append("\n").append("\n");
		descricao.append("Status da troca: ").append(this.objetosDisponiveis().toString()).append("\n");
		descricao.append("Ferramenta: ").append(this.ferramentasDisponiveis().toString()).append("\n");
		descricao.append("A porta da passagem para a: ").append(this.portasDisponiveis().toString());
		return descricao.toString();
	}
	
	@Override
	public boolean usa(String ferramenta) {
		Ferramenta f = this.getMochila().usar(ferramenta);
		if (f == null) { // Verifica se tem a ferramenta na mochila
			return false;
		}
		if (f instanceof PedraFilosofal) { // Verifica Se é a ferramenta correta
			this.getMochila().removeFerramenta("PedraFilosofal");
			PocaoMagica pocaoMagica = new PocaoMagica();
			this.getFerramentas().put(pocaoMagica.getDescricao(), pocaoMagica);
			((Buda) (this.getObjetos().get("Buda"))).setAcaoOk(true);
			return true;
		}
		return false;
	}

	@Override
	public Objeto getObject() {
		return buda;
	}

	@Override
	public String getTextAction() {
		return this.objetosDisponiveis().toString();
	}
}
