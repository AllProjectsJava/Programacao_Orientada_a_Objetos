package Exercicio_1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Janela1 extends Application {
	private Stage primaryStage;
	private Scene cenaLogin;
	private TextField tfUserName;
	private PasswordField pwBox;

	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;

		GridPane root = new GridPane();
		// root.setAlignment(Pos.CENTER);
		root.setPadding(new Insets(25, 25, 25, 25));
		root.setHgap(10);
		root.setVgap(10);
		root.setGridLinesVisible(true);

		// Scene scene = new Scene(root,500,350);
		cenaLogin = new Scene(root);

		Text scenetitle = new Text("Welcome");
		scenetitle.setId("welcome-text");
		scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
		root.add(scenetitle, 0, 0);

		Label lbUserName = new Label("Username:");
		tfUserName = new TextField();
		root.add(lbUserName, 0, 1);
		root.add(tfUserName, 1, 1);
		Label lbPass = new Label("Password:");
		pwBox = new PasswordField();
		root.add(lbPass, 0, 2);
		root.add(pwBox, 1, 2);

		Button btOk = new Button("Ok");
		// btOk.setOnAction(e->analisaLogin(e));
		Button btCancel = new Button("Cancela");
		btCancel.setOnAction(e -> primaryStage.close());
		HBox hbBtn = new HBox(10);
		hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
		hbBtn.getChildren().add(btOk);
		hbBtn.getChildren().add(btCancel);
		root.add(hbBtn, 1, 4);

		primaryStage.setTitle("Hello World!");
		primaryStage.setScene(cenaLogin);
		primaryStage.setResizable(false);
		primaryStage.show();
	}

	private void segundaJanela() {
		Janela2 janela2 = new Janela2(primaryStage);
	}

	public static void main(String[] args) {
		launch(args);
	}
}
