package Ex_1;

import java.io.IOException;

public class App {

	public static void main(String[] args) {
		try {
			CadastroUsuarios cd = new CadastroUsuarios();
			int qtdadeRemovidos = cd.removePorIp(200);
			System.out.println("Removidos: "+qtdadeRemovidos);
		} catch (IOException e) {
			System.out.println("Arquivo de dados não encontrado!!");
			System.exit(0);
		}

	}

}
