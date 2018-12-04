package Jogo.Janelas;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class JanelaMenu extends Application {
	private boolean isGridVisible = false;
	private Stage primaryStage;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

		GridPane gp = new GridPane();
		gp.setAlignment(Pos.CENTER);
		gp.setHgap(10);
		gp.setVgap(10);
		gp.setPadding(new Insets(20, 20, 20, 20));
		gp.setGridLinesVisible(isGridVisible);

		// Primeira linha
		ImageView imgView = new ImageView();
		imgView.setImage(new Image("file:Mapa.jpg"));
		imgView.setFitWidth(750);
		imgView.setPreserveRatio(true);
		imgView.setSmooth(true);
		imgView.setCache(true);
		
		HBox boxImage = new HBox(50);
		boxImage.setAlignment(Pos.CENTER);
		boxImage.getChildren().add(imgView);
		gp.add(boxImage, 0, 0);

		// Segunda Linha
		Button buttonLoad = new Button("Load");
		buttonLoad.setOnAction(e -> carrega());
		// Botao Novo Jogo
		Button buttonNewGame = new Button("New Game");
		buttonNewGame.setOnAction(e -> novo());
		// Botao Fechar
		Button buttonFechar = new Button("Fechar");
		buttonFechar.setOnAction(e -> primaryStage.close());

		HBox box = new HBox(50);
		box.setAlignment(Pos.CENTER);
		box.getChildren().add(buttonLoad);
		box.getChildren().add(buttonNewGame);
		box.getChildren().add(buttonFechar);
		gp.add(box, 0, 1);

		Scene cenaMenu = new Scene(gp, 750, 550);
		primaryStage.setTitle("O Preço do Amanha");
		primaryStage.getIcons().add(new Image("file:Ampulheta.jpg"));
		primaryStage.setScene(cenaMenu);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void carrega() {
		JanelaJogo janelaJogo = new JanelaJogo(primaryStage);
		janelaJogo.load();
	}

	private void novo() {
		new JanelaJogo(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
