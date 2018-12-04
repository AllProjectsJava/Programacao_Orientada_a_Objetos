package Exercicio_5;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CatalogoProdutos {
	public static final int MAXPRODUTOS = 100;
	private Produto produtos[];
	private int proxLivreProd;

	public CatalogoProdutos() {
		proxLivreProd = 0;
		carregaProdutos();
	}

	public Produto getProduto(int codigo) {
		for (int i = 0; i < produtos.length; i++) {
			if (produtos[i].getCodigo() == codigo) {
				return (produtos[i]);
			}
		}
		return null;
	}

	private void carregaProdutos() {
		produtos = new Produto[MAXPRODUTOS];

		String fName = "produtos.txt";
		String currDir = Paths.get("").toAbsolutePath().toString();
		String nameComplete = currDir + "\\" + fName;
		Path path2 = Paths.get(nameComplete);
		try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))) {
			sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
			int codigo;
			String descricao;
			double preco;
			while (sc.hasNext()) {
				codigo = Integer.parseInt(sc.next());
				descricao = sc.next();
				preco = Double.parseDouble(sc.next());
				Produto p = new Produto(codigo, descricao, preco);
				produtos[proxLivreProd] = p;
				proxLivreProd++;
			}
		} catch (IOException x) {
			System.err.format("Erro no arquivo");
		}
	}
}
