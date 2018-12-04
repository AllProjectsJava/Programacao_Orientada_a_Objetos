import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Nomes: Douglas Bernardes, Henrique Ramires e Matheus Zanon 
*/

public class App {

	public static Map<String, Entrada> palavrasEmTreeMap(String nomeArqIgnorar, String nomeArqTexto) {
		HashSet<String> stopWords = leituraHashSet(nomeArqIgnorar);
		Map<String, Entrada> palavras = new TreeMap<>();
		Scanner entrada = null;
		int numLinhasAtual = 1;
		try {
			File file = new File(nomeArqTexto);
			entrada = new Scanner(file);
			while (entrada.hasNextLine()) {
				String linhaPalavras = entrada.nextLine().replaceAll("[\\,.:;()\\[\\]_?“”]", "").toLowerCase();
				String[] listaPalavrasDaLinha = linhaPalavras.split(" ");

				if (listaPalavrasDaLinha.length == 1) {
					if (listaPalavrasDaLinha[0].equals("")) {
						numLinhasAtual++;
						continue;
					}
				}

				if (listaPalavrasDaLinha.length > 0) {
					for (String palavraLimpa : listaPalavrasDaLinha) {
						if (palavraLimpa.equals("")) {
							continue;
						}
						if (!stopWords.contains(palavraLimpa)) { // Se não for uma stopWord
							if (!palavras.containsKey(palavraLimpa)) { // Se já não estiver no Map
								Set<Integer> linhas = new TreeSet<Integer>(); // Lista que guarda as linhas em q a
																				// palavra aparece
								linhas.add(numLinhasAtual);
								palavras.put(palavraLimpa, new Entrada(linhas));
							} else { // Se já estiver no Map
								Entrada input = palavras.get(palavraLimpa);
								input.addIndice(numLinhasAtual);
								input.incrementaContador();
							}
						}
					}
				}
				numLinhasAtual++;
			}
		} catch (IOException e) {
			System.out.println("Erro ao ler o arquivo");
		}
		return palavras; // retorna o Map pronto
	}

	public static HashSet<String> leituraHashSet(String nomeArqTexto) {
		HashSet<String> texoEmHashSet = new HashSet<String>();
		Scanner entrada = null;
		try {
			File file = new File(nomeArqTexto);
			entrada = new Scanner(file);
			while (entrada.hasNext()) {// System.out.println(entrada.nextLine());
				String palavra = entrada.next();
				String palavraLimpa = palavra.replaceAll("[\\,.:;()\\[\\]_?“” ]", "").toLowerCase();
				texoEmHashSet.add(palavraLimpa);
			}
		} catch (IOException e) {
			System.out.println("Não foi possivel ler o arquivo");
		} finally {
			entrada.close();
		}
		return texoEmHashSet;
	}

	public static Entry<String, Entrada> achaPalavraMaisFrequente(Map<String, Entrada> palavras) {
		Entry<String, Entrada> word = palavras.entrySet().iterator().next();
		for (Entry<String, Entrada> entrada : palavras.entrySet()) {
			if (word.getValue().getContador() < entrada.getValue().getContador()) {
				word = entrada;
			}
		}
		return word;
	}

	public static void escrever(String nomeArqTexto, String palavraMaisFrequencia, Map<String, Entrada> palavras) {
		Scanner entrada = null;
		try {
			File arquivoLe = new File(nomeArqTexto);
			entrada = new Scanner(arquivoLe);

			File arquivoEscreve = new File("TextoFinal.txt");
			arquivoEscreve.createNewFile();
			FileWriter fileW = new FileWriter(arquivoEscreve);
			BufferedWriter buffW = new BufferedWriter(fileW);

			buffW.write(palavraMaisFrequencia);
			buffW.newLine();
			buffW.newLine();

			int count = 1;
			while (entrada.hasNext()) {
				String linha = entrada.nextLine();
				buffW.write(count + " " + linha);
				buffW.newLine();
				count++;
			}

			buffW.newLine();

			for (String s : palavras.keySet()) {
				String key = s;
				String value = palavras.get(s).toString();
				System.out.println(key + " " + value);
				buffW.write(key + " " + value);
				buffW.newLine();
			}

			buffW.close();
		} catch (IOException io) {
			System.out.println("Erro ao escrever o arquivo.");
		}
	}

	public static void main(String ar[]) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Insira o nome do arquivo texto:");
		String nomeArqTexto = scanner.nextLine();

		Map<String, Entrada> palavras = palavrasEmTreeMap("stopwords.txt", nomeArqTexto);
		Entry<String, Entrada> word = achaPalavraMaisFrequente(palavras);

		String palavraMaisFrequente = "Palavra mais frequente: " + word.getKey();
		escrever(nomeArqTexto, palavraMaisFrequente, palavras);

		// System.out.println("Linhas do arquivo numeradas:\n" + word.getValue());
		// System.out.println("");
		// System.out.println("Indice remissivo:\n" + palavras);
	}
}
