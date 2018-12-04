package Ex_2_UsuariosWeb;
import java.io.IOException;
import java.util.Iterator;

public class App {

	public static void main(String[] args) {
		try {
			CadastroUsuarios cd = new CadastroUsuarios();
			int qtdadeRemovidos = cd.removePorIp(200);
			System.out.println("Removidos: "+qtdadeRemovidos);

			cd.ordena();

			/*
			Iterator<Usuario> it = cd.getIterator();
			while(it.hasNext()) {
				System.out.println(it.next());
			}
			*/
			/*
			for(Usuario u:cd) {
				System.out.println(u);
			}
			*/
			
		} catch (IOException e) {
			System.out.println("Arquivo de dados não encontrado!!");
			System.exit(0);
		}

	}

}
