import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
 * Nomes: Douglas Bernardes, Henrique Ramires e Matheus Zanon 
*/

public class App {

	public static Map<String, Entrada> palavrasEmTreeMap(String nomeArqIgnorar, String nomeArqTexto) throws IOException {
		HashSet<String> stopWords = leituraHashSet(nomeArqIgnorar);  // throws erro ao ler o arquivo texto 
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
								Set<Integer> linhas = new TreeSet<Integer>(); // Lista que guarda as linhas em q a word aparece
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

	public static HashSet<String> leituraHashSet(String nomeArqTexto) throws IOException {
		HashSet<String> texoEmHashSet = new HashSet<String>(); // throws erro ao ler o arquivo de stopwords
		Scanner entrada = null;
		File file = new File(nomeArqTexto);
		entrada = new Scanner(file);
		while (entrada.hasNext()) {// System.out.println(entrada.nextLine());
			String palavra = entrada.next();
			String palavraLimpa = palavra.replaceAll("[\\,.:;()\\[\\]_?“” ]", "").toLowerCase();
			texoEmHashSet.add(palavraLimpa);
		}
		entrada.close();
		return texoEmHashSet;
	} 

	public static Entry<String, Entrada> achaPalavraMaisFrequente(Map<String, Entrada> palavras) throws NoSuchElementException  {
		Entry<String, Entrada> word = palavras.entrySet().iterator().next();
		for (Entry<String, Entrada> entrada : palavras.entrySet()) {
			if (word.getValue().getContador() < entrada.getValue().getContador()) {
				word = entrada;
			}
		}
		return word;
	}

	public static void escrever(String nomeArqTexto, String palavraMaisFrequencia, Map<String, Entrada> palavras) throws IOException {
		Scanner entrada = null; // throws erro ao escrever
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
			buffW.write(key + " " + value);
			buffW.newLine();
		}
		buffW.close();
		entrada.close();
	} 

	public static void main(String ar[]) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("CERTIFIQUE QUE OS ARQUIVOS TEXTO ESTÃO NA MESMA PASTA DO PROGRAMA");
		System.out.println("Exemplo :   PerfumesAndTheirPreparation.txt    ");
		System.out.println("Insira o nome do arquivo texto:");
		String nomeArqTexto = scanner.nextLine();
		Map<String, Entrada> palavras = null;
		try {
			palavras = palavrasEmTreeMap("stopwords.txt", nomeArqTexto);
		} catch (IOException e1) {   
			System.out.println("Erro na leitura do arquivo texto, verifique se os nomes estão corretamente digitados");
			System.exit(2);
		}
		Entry<String, Entrada> word = null;
		String palavraMaisFrequente = null;
		try {
			word = achaPalavraMaisFrequente(palavras);
			palavraMaisFrequente = "Palavra mais frequente: " + word.getKey();
		} catch (NoSuchElementException e1) {
			System.out.println("O mapa de palavras não foi concluido");
			System.exit(4);
		}
		try {
			escrever(nomeArqTexto, palavraMaisFrequente, palavras);
			System.out.println("Arquivo escrito com sucesso, verifique na pasta do programa o texto gerado \"TextoFinal\"");
			System.out.println("O programa irá fechar em 4 segundos");
			System.exit(4);
		} catch (IOException e) {
			System.out.println("Erro na escrita do arquivo texto de saida, verifique se os nomes estão corretamente digitados");
			System.exit(4);
		}
		scanner.close();
	}
}
