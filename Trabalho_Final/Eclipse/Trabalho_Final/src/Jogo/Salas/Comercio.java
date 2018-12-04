package Jogo.Salas;

import ClassesBasicas.Ferramenta;
import ClassesBasicas.Objeto;
import ClassesBasicasGenericas.SalaGenerica;
import Jogo.Ferramentas.Celular;
import Jogo.Ferramentas.Chaveiro;
import Jogo.Ferramentas.Chocolate;
import Jogo.Ferramentas.PedraFilosofal;
import Jogo.Objetos.CaixaComercio;

public class Comercio extends SalaGenerica {
	private CaixaComercio caixaComercio;
	private boolean celular;
	private boolean chocolate;
	private boolean chaveiro;

	public Comercio() {
		super("Comercio", "3");
		super.objectRequired = false;
		caixaComercio = new CaixaComercio();
		this.getObjetos().put("CaixaComercio", caixaComercio);
		celular = false;
		chocolate = false;
		chaveiro = false;
	}
	
	@Override
	public String textoDescricao() {
		StringBuilder descricao = new StringBuilder();
		descricao.append("Voce esta na ").append(this.getNome()).append("\n");
		descricao.append("Voce deve se desfazer do Celular, do Chocolate e do Chaveiro.").append("\n");
		descricao.append("Em troca vai receber a Pedra Filosofal, voce deve guardar a Pedra Filosofal!").append("\n").append("\n");
		descricao.append("Status da Caixa de Cambio: ").append(this.objetosDisponiveis().toString()).append("\n");
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
		if(f instanceof Celular) {
			celular = true;
			this.getMochila().removeFerramenta("Celular");
			ganhaPedra();
			return true;
		}
		if(f instanceof Chocolate) {
			chocolate = true;
			this.getMochila().removeFerramenta("Chocolate");
			ganhaPedra();
			return true;
		}
		if(f instanceof Chaveiro) {
			chaveiro = true;
			this.getMochila().removeFerramenta("Chaveiro");
			ganhaPedra();
			return true;
		}
		return false;
	}
	
	private void ganhaPedra() {
		if ((celular == true && chocolate == true) && chaveiro == true) {
			PedraFilosofal pedraFilosofal = new PedraFilosofal();
			this.getFerramentas().put(pedraFilosofal.getDescricao(), pedraFilosofal);
			((CaixaComercio) (this.getObjetos().get("CaixaComercio"))).setAcaoOk(true);
		}
	}

	@Override
	public Objeto getObject() {
		return caixaComercio;
	}

	@Override
	public String getTextAction() {
		return this.objetosDisponiveis().toString();
	}
}
