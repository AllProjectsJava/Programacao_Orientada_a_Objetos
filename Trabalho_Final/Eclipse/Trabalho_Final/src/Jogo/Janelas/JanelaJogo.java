package Jogo.Janelas;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import Jogo.Engine;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JanelaJogo {
	private TextArea descricao;
	private TextArea mochila;
	private List<Image> images;
	private ImageView imgView;
	private Engine engine;
	private ChoiceBox<String> choiceBoxComando;
	private ChoiceBox<String> choiceBoxCoisas;
	private ProgressBar progressBarTempo;
	private boolean isGridVisible = false;
	private Stage primaryStage;

	public JanelaJogo(Stage primaryStage) {
		this.primaryStage = primaryStage;
		sceneJogo(primaryStage);
	}

	public void sceneJogo(Stage primaryStage) {
		engine = new Engine(this);

		images = new ArrayList<>();
		images.add(new Image("file:Quarto.jpg"));
		images.add(new Image("file:Cozinha.jpg"));
		images.add(new Image("file:Parada.jpg"));
		images.add(new Image("file:Comercio.jpg"));
		images.add(new Image("file:Passarela.jpg"));
		images.add(new Image("file:Hospital.jpg"));

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(50);
		gp.setVgap(10);
		gp.setPadding(new Insets(20, 20, 20, 20));
		gp.setGridLinesVisible(isGridVisible);

		Scene cenaJogo = new Scene(gp);

		GridPane Linha1 = new GridPane();

		GridPane Quadrante1 = new GridPane();
		Quadrante1.setAlignment(Pos.CENTER);
		Quadrante1.setHgap(50);
		Quadrante1.setVgap(10);
		Quadrante1.setPadding(new Insets(20, 20, 20, 20));
		Quadrante1.setGridLinesVisible(isGridVisible);

		// Coluna 0, Linha 0
		imgView = new ImageView();
		imgView.setImage(images.get(0));
		imgView.setFitWidth(400);
		imgView.setPreserveRatio(true);
		imgView.setSmooth(true);
		imgView.setCache(true);
		Quadrante1.add(imgView, 0, 0);
		Linha1.add(Quadrante1, 0, 0);

		GridPane Quadrante2 = new GridPane();
		Quadrante2.setAlignment(Pos.CENTER);
		Quadrante2.setHgap(50);
		Quadrante2.setVgap(10);
		Quadrante2.setPadding(new Insets(25, 25, 25, 25));
		Quadrante2.setGridLinesVisible(isGridVisible);

		// Linha 0, Coluna 1
		Label labelTempo = new Label("Tempo Restante:");
		progressBarTempo = new ProgressBar();
		HBox box2 = new HBox(10);
		box2.setAlignment(Pos.CENTER);
		box2.getChildren().add(labelTempo);
		box2.getChildren().add(progressBarTempo);
		Quadrante2.add(box2, 0, 0);

		Label labelMochila = new Label("Mochila");
		HBox box1 = new HBox(10);
		box1.setAlignment(Pos.CENTER);
		box1.getChildren().add(labelMochila);
		Quadrante2.add(box1, 0, 1);

		mochila = new TextArea();
		mochila.setMaxSize(200, 200);
		mochila.setEditable(false);
		Quadrante2.add(mochila, 0, 2);
		Quadrante2.setGridLinesVisible(isGridVisible);
		Linha1.add(Quadrante2, 1, 0);

		// Adiciona o GP duvidido como 1 elemento da Coluna 0, Linha 0
		gp.add(Linha1, 0, 0);

		// Linha 2
		descricao = new TextArea();
		descricao.setEditable(false);
		gp.add(descricao, 0, 1);
		gp.setGridLinesVisible(isGridVisible);

		// Linha 3
		// Botao para salvar
		Button buttonSave = new Button("Save");
		buttonSave.setOnAction(e -> {
			try {
				engine.save();
			} catch (IOException e1) {
				descricao.setText("Nao foi possovel gravar!");
				e1.printStackTrace();
			}
		});
		// Label comando
		Label labelComando = new Label("Comando");
		// ChoiceBox Selecao de comandos
		choiceBoxComando = new ChoiceBox<>();
		choiceBoxComando.getItems().add("Pega");
		choiceBoxComando.getItems().add("Usa");
		choiceBoxComando.getItems().add("Vai");
		// Button next opcoes
		Button buttonNext = new Button("Next");
		// ChoiceBox mostra opcoes
		choiceBoxCoisas = new ChoiceBox<>();
		// Acao ao clicar no botao Next
		buttonNext.setOnAction(e -> isNext());
		// Acao ao clicar no botao Ok
		Button btOk = new Button("Ok");
		btOk.setOnAction(e -> isOk());

		HBox box3 = new HBox(10);
		box3.setAlignment(Pos.CENTER);
		box3.getChildren().add(buttonSave);
		box3.getChildren().add(labelComando);
		box3.getChildren().add(choiceBoxComando);
		box3.getChildren().add(buttonNext);
		box3.getChildren().add(choiceBoxCoisas);
		box3.getChildren().add(btOk);

		gp.add(box3, 0, 3);
		gp.setGridLinesVisible(isGridVisible);

		primaryStage.setScene(cenaJogo);

		engine.joga("start");
	}

	public void close() {
		primaryStage.close(); 
	}
	
	public void load() {
		try {
			engine.load();
		} catch (IOException e) {
			descricao.setText("Nao foi possovel ler o Arquivo!");
			e.printStackTrace();
		}
	}

	// Set Texto Mochila
	public void setTextMochila(List<String> list) {
		mochila.setText("");
		for (String f : list) {
			mochila.appendText(f + "\n");
		}
	}

	// Set Texto Descricao
	public void setDescricao(String texto) {
		descricao.appendText(texto);
		descricao.setScrollTop(Double.MAX_VALUE);
	}

	// Limpa Texto Descricao
	public void clearDescricao() {
		descricao.setText("");
	}

	// Limpa o ChoiceBoxCoisas
	private void removeChoiceBoxCoisas() {
		choiceBoxCoisas.getItems().removeAll(choiceBoxCoisas.getItems());
	}

	// Atualiza ChoiceBoxCoisas apos o Next
	private void isNext() {
		removeChoiceBoxCoisas();
		if (choiceBoxComando.getValue() == "Pega") {
			List<String> ferramentaSala = engine.getFerramentas();
			ferramentaSala.stream().forEach(f -> choiceBoxCoisas.getItems().add(f.toString()));
		} else if (choiceBoxComando.getValue() == "Usa") {
			List<String> ferramentaMochila = engine.getMochila();
			ferramentaMochila.stream().forEach(f -> choiceBoxCoisas.getItems().add(f.toString()));
		} else if (choiceBoxComando.getValue() == "Vai") {
			List<String> portas = engine.getPortas();
			portas.stream().forEach(p -> choiceBoxCoisas.getItems().add(p.toString()));
		}
	}

	// Se o botao Ok for pressionado Joga
	private void isOk() {
		engine.joga(choiceBoxComando.getValue() + " " + choiceBoxCoisas.getValue());
		removeChoiceBoxCoisas();
		choiceBoxComando.setValue(null);
	}

	// Altera a imagem
	public void setImagem(int i) {
		imgView.setImage(images.get(i));
	}

	// Altera o tempo na ProgressBar
	public void setTempo(float tempo) {
		progressBarTempo.setProgress(tempo);
	}

}