package Jogo;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;
import ClassesBasicas.Mochila;
import ClassesBasicasGenericas.SalaGenerica;
import Jogo.Ferramentas.Celular;
import Jogo.Ferramentas.Chaveiro;
import Jogo.Ferramentas.Chocolate;
import Jogo.Ferramentas.GarrafaAgua;
import Jogo.Ferramentas.GuardaChuva;
import Jogo.Ferramentas.Marreta;
import Jogo.Ferramentas.Pao;
import Jogo.Ferramentas.PedraFilosofal;
import Jogo.Ferramentas.Player;
import Jogo.Ferramentas.PocaoMagica;
import Jogo.Janelas.JanelaJogo;
import Jogo.Salas.Comercio;
import Jogo.Salas.Cozinha;
import Jogo.Salas.Hospital;
import Jogo.Salas.ParadaOnibus;
import Jogo.Salas.Passarela;
import Jogo.Salas.Quarto;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Engine {
	private JanelaJogo janelaPrincipal;
	private SalaGenerica salaInicial;
	private SalaGenerica salaCorrente;
	private SalaGenerica quarto;
	private SalaGenerica cozinha;
	private SalaGenerica paradaDeOnibus;
	private SalaGenerica comercio;
	private SalaGenerica passarela;
	private SalaGenerica hospital;
	private Mochila mochila;
	private Player player;

	public Engine(JanelaJogo janelaPrincipal) {
		this.janelaPrincipal = janelaPrincipal;
		criaSalas();
		mochila = new Mochila();
		player = new Player();
		mochila.guardar(player);
		salaInicial.entra(mochila); // Bota a mochila na sala
		salaCorrente = salaInicial;
	}

	public void load() throws IOException {
		File arquivoLe = new File("arquivo.txt");
		Scanner scanner = new Scanner(arquivoLe);

		// Primeira Linha = Tempo restante
		int tempo = Integer.parseInt(scanner.nextLine());
		player.setTime(tempo);
		janelaPrincipal.setTempo((tempo / 100) + 0.5f);

		// Segunda Linha = Itens da mochila
		String texto = scanner.nextLine();
		String linhaLimpa = texto.replaceAll("[\\,.:;()\\[\\]_?“”]", "");
		String[] itensLinha = linhaLimpa.split(" ");
		
		for (String s : itensLinha) {
			
			if (s.equals("Marreta")) {
				System.out.println("Marreta");
				mochila.guardar(new Marreta());
			} else if (s.equals("Pao")) {
				System.out.println("Pao");
				mochila.guardar(new Pao());
			} else if (s.equals("Celular")) {
				System.out.println("Celular");
				mochila.guardar(new Celular());
			} else if (s.equals("GuardaChuva")) {
				System.out.println("GuardaChuva");
				mochila.guardar(new GuardaChuva());
			} else if (s.equals("GarrafaAgua")) {
				System.out.println("GarrafaAgua");
				mochila.guardar(new GarrafaAgua());
			} else if (s.equals("Chocolate")) {
				System.out.println("Chocolate");
				mochila.guardar(new Chocolate());
			} else if (s.equals("Chaveiro")) {
				System.out.println("Chaveiro");
				mochila.guardar(new Chaveiro());
			} else if (s.equals("PedraFilosofal")) {
				System.out.println("PedraFilosofal");
				mochila.guardar(new PedraFilosofal());
			} else if (s.equals("PocaoMagica")) {
				System.out.println("PocaoMagica");
				mochila.guardar(new PocaoMagica());
			}
		}
		janelaPrincipal.setTextMochila(mochila.inventario());
		
		// Terceira Linha = Sala corrente
		String sala = scanner.nextLine();
		if (sala.equals("Quarto")) {
			Quarto quarto = new Quarto();
			quarto.getPortas().put(cozinha.getNome(), cozinha);
			salaCorrente = quarto;
		} else if (sala.equals("Cozinha")) {
			Cozinha cozinha = new Cozinha();
			cozinha.getPortas().put(paradaDeOnibus.getNome(), paradaDeOnibus);
			salaCorrente = cozinha;
		} else if (sala.equals("ParadaOnibus")) {
			ParadaOnibus paradaOnibus = new ParadaOnibus();
			paradaDeOnibus.getPortas().put(cozinha.getNome(), cozinha);
			paradaDeOnibus.getPortas().put(comercio.getNome(), comercio);
			salaCorrente = paradaOnibus;
		} else if (sala.equals("Comercio")) {
			Comercio comercio = new Comercio();
			comercio.getPortas().put(passarela.getNome(), passarela);
			salaCorrente = comercio;
		} else if (sala.equals("PassarelaPucrs")) {
			Passarela passarela = new Passarela();
			passarela.getPortas().put(comercio.getNome(), comercio);
			passarela.getPortas().put(hospital.getNome(), hospital);
			salaCorrente = passarela;
		} else if (sala.equals("Hospital")) {
			Hospital hospital = new Hospital();
			hospital.getPortas().put(passarela.getNome(), passarela);
			salaCorrente = hospital;
		}
		salaCorrente.entra(mochila);
		janelaPrincipal.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));

		// Quarta Linha = Se fez a Acao
		String acao = scanner.nextLine();
		if (acao.equals("1")) {
			salaCorrente.getObject().setAcaoOk(true);
		} else {
			salaCorrente.getObject().setAcaoOk(false);
		}

		scanner.close();
		
		janelaPrincipal.clearDescricao();
		janelaPrincipal.setDescricao("\n" + salaCorrente.textoDescricao() + "\n");
	}

	public void save() throws IOException {
		File arquivoEscreve = new File("arquivo.txt");
		arquivoEscreve.createNewFile();
		FileWriter fileW = new FileWriter(arquivoEscreve);
		BufferedWriter buffW = new BufferedWriter(fileW);

		// Primeira Linha = Tempo restante
		buffW.write(Integer.toString(player.getTime()));

		buffW.newLine();

		// Segunda Linha = Itens da mochila
		buffW.write(mochila.inventario().toString());

		buffW.newLine();

		// Terceira Linha = Sala corrente
		buffW.write(salaCorrente.getNome());

		buffW.newLine();

		// Quarta Linha = Fez Acao
		int i;
		if (salaCorrente.getObject().isAcaoOk()) {
			i = 1;
		} else {
			i = 0;
		}
		buffW.write(Integer.toString(i));

		buffW.close();
		fileW.close();
	}

	private void criaSalas() {
		quarto = new Quarto();
		cozinha = new Cozinha();
		paradaDeOnibus = new ParadaOnibus();
		comercio = new Comercio();
		passarela = new Passarela();
		hospital = new Hospital();

		// Adiciona a porta na sala
		quarto.getPortas().put(cozinha.getNome(), cozinha);

		cozinha.getPortas().put(paradaDeOnibus.getNome(), paradaDeOnibus);
		paradaDeOnibus.getPortas().put(cozinha.getNome(), cozinha);

		paradaDeOnibus.getPortas().put(comercio.getNome(), comercio);

		comercio.getPortas().put(passarela.getNome(), passarela);
		passarela.getPortas().put(comercio.getNome(), comercio);

		passarela.getPortas().put(hospital.getNome(), hospital);
		hospital.getPortas().put(passarela.getNome(), passarela);

		// Atribui a sala inicial
		salaInicial = quarto;
	}

	// Retorna a Lista de Strings com as Portas da Sala
	public List<String> getPortas() {
		return salaCorrente.portasDisponiveis();
	}

	// Retorna a Lista de String com as Ferramentas da sala
	public List<String> getFerramentas() {
		return salaCorrente.ferramentasDisponiveis();
	}

	// Retorna uma Lista de String com as Ferramentas da Mochila
	public List<String> getMochila() {
		return mochila.inventario();
	}

	public void joga(String acao) {
		String[] comandos = acao.split(" ");
		switch (comandos[0]) {
		case "Pega":
			// Se a sala tem a Ferramenta
			if (salaCorrente.pega(comandos[1])) {
				player.decPegaFerramenta();
				janelaPrincipal.setDescricao(comandos[1] + " colocado na mochila!\n");
			}
			// Atualiza o que tem na mochila
			janelaPrincipal.setTextMochila(mochila.inventario());
			break;
		case "Usa":
			try {
				// Se a sala usa o tipo de ferramenta
				if (salaCorrente.usa(comandos[1])) {
					player.decUsaFerramentaCorreta();
					mochila.removeFerramenta(comandos[1]);
					janelaPrincipal.setTextMochila(mochila.inventario());
					janelaPrincipal.clearDescricao();
					janelaPrincipal.setDescricao("\n" + salaCorrente.textoDescricao() + "\n");
				}
				// Se a sala nao usa o tipo de ferramenta
				else {
					player.decUsaFerramentaErrada();
					janelaPrincipal.setDescricao("Nao eh possivel usar " + comandos[1] + " nesta sala.\n");
				}
			} catch (FimDeJogoException e) {
				vitoria();
			}
			break;
		case "Vai":
			// Se pode trocar de sala
			if (salaCorrente.getObject().isAcaoOk() || !salaCorrente.isObjectRequired()) {
				SalaGenerica novaSala = (SalaGenerica) salaCorrente.sai(comandos[1]);
				player.decMudaSalaCorreta();
				novaSala.entra(mochila);
				salaCorrente = novaSala;
				janelaPrincipal.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
				janelaPrincipal.clearDescricao();
				janelaPrincipal.setDescricao("\n" + salaCorrente.textoDescricao() + "\n");
			}
			// Se nao pode trocar de sala
			else {
				player.decMudaSalaErrada();
				janelaPrincipal.setDescricao(salaCorrente.getTextAction() + "\n");
			}
			break;
		case "start":
			janelaPrincipal.setDescricao("\n" + salaCorrente.textoDescricao() + "\n");
			janelaPrincipal.setImagem(Integer.parseInt(salaCorrente.getRepVisual()));
			break;
		default:
			janelaPrincipal.setDescricao("Comando desconhecido: " + comandos[0] + "\n");
			break;
		}

		janelaPrincipal.setTempo(((float) player.getTime() / 100) + 0.05f);

		if (player.isDead()) {
			gameOver();
			return;
		}
	}

	private void vitoria() {
		janelaPrincipal.close();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Fim de jogo! ");
		alert.setHeaderText("Parabens !!!");
		alert.setContentText("Voce conseguiu se livrar do tempo!\nFIM DE JOGO");
		alert.showAndWait();
	}

	private void gameOver() {
		janelaPrincipal.close();
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Over!!!");
		alert.setHeaderText("Voce Perdeu!!!");
		alert.setContentText("Voce nao conseguiu tente novamente.");
		alert.showAndWait();
	}
}
