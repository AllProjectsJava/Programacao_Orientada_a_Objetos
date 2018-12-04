package Ex_7_PalavrasDiferentes;

import java.io.*;
import java.nio.file.*;
import java.nio.charset.*;
import java.util.*;

public class Palavras{
    public static void main(String args[]){
        Set<String> palDif = new HashSet<>();
        //Set<String> palDif = new TreeSet<>();
        Path p = Paths.get("texto.txt");
        System.out.println("Nome do arquivo: "+p.toString()); 
        System.out.println("Lendo os dados:");
        try(BufferedReader rd = Files.newBufferedReader(p,Charset.defaultCharset())){
            String linha = null;
            while((linha = rd.readLine()) != null){
                StringTokenizer st = new StringTokenizer(linha);
                while(st.hasMoreTokens()){
                    String palavra = st.nextToken();
                    palDif.add(palavra);
                    System.out.print(palavra+" ");
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        System.out.println("");
        System.out.println("Palavras diferentes:");
        System.out.println("--------------------");
        for(String pal:palDif){
            System.out.print(pal+" ");
        }
        System.out.println("");
    }
    /*
    public static void main(String args[]){
        Set<String> palTexto = new HashSet<>();
        Set<String> palRepetidas = new HashSet<>();
        Path p = Paths.get("texto.txt");
        System.out.println("Nome do arquivo: "+p.toString()); 
        System.out.println("Lendo os dados:");
        try(BufferedReader rd = Files.newBufferedReader(p,Charset.defaultCharset())){
            String linha = null;
            while((linha = rd.readLine()) != null){
                StringTokenizer st = new StringTokenizer(linha);
                while(st.hasMoreTokens()){
                    String palavra = st.nextToken();
                    if (palTexto.contains(palavra)) {
                    	palRepetidas.add(palavra);
                    }else {
                        palTexto.add(palavra);
                    }
                }
            }
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        Set<String> palNaoRepetidas = new HashSet<>(palTexto);
        palNaoRepetidas.removeAll(palRepetidas);
        System.out.println("Palavras do texto: "+palTexto);
        System.out.println("Palavras repetidas:"+palRepetidas);
        System.out.println("Palavras não repetidas:"+palNaoRepetidas);
    }
    */
}
