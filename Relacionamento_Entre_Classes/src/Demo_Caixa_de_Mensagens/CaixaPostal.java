package Demo_Caixa_de_Mensagens;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CaixaPostal {
	private int MAX = 10;
	private static final String fName = "CaixaPostal.txt";
    private MsgEmail[] msgs;
    private int pos;
    
    public CaixaPostal(){
    	msgs = new MsgEmail[MAX];
    	pos = 0;
    }
    
    
    public void carregaMsgs(){
        String currDir = Paths.get("").toAbsolutePath().toString();
        String nameComplete = currDir+"\\"+fName;
        Path path2 = Paths.get(nameComplete);
        try (Scanner sc = new Scanner(Files.newBufferedReader(path2, Charset.defaultCharset()))){ 
           sc.useDelimiter("[;\n]"); // separadores: ; e nova linha
           String strRem, strDest;
           String assunto, texto;
           while (sc.hasNext()){ 
               strRem = sc.next();
               strDest = sc.next();
               assunto = sc.next();
               texto = sc.next();
               EndEmail remetente = new EndEmail(strRem);
               EndEmail destinatario = new EndEmail(strDest);
               MsgEmail msg = new MsgEmail(remetente,destinatario,assunto,texto);
               acrescenta(msg);
           }
        }catch (IOException x){ 
            System.err.format("Erro de E/S: %s%n", x); 
        } 
    }
    
    public void acrescenta(MsgEmail m){
    	msgs[pos] = m;
    	pos++;
    }
    
    public MsgEmail getMsg(int i){
    	return(msgs[i]);
    }
    
    public void remove(int n){
    	for(int i=n;i<pos-1;i++){
    		msgs[i] = msgs[i+1];
    	}
    	pos--;
    }
    
    public int qtdadeMsgs(){
    	return(pos);
    }
    
    public int qtdadeMsgsDest(EndEmail dest){
    	int cont = 0;
    	for(int i=0; i<pos; i++){
    		if (msgs[i].getDestinatario().equals(dest)){
    			cont++;
    		}
    	}
    	return(cont);
    }
}
