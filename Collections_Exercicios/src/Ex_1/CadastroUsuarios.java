package Ex_1;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.StringTokenizer;

public class CadastroUsuarios {
    private List<Usuario> users;
    
	private static void inicializa(List<Usuario> lst,String fName)throws IOException{
        File file = new File(fName);
        Scanner s = new Scanner(file);
    	String line = s.nextLine();
        while(s.hasNextLine()){
        	line = s.nextLine();
        	StringTokenizer st = new StringTokenizer(line,",");
        	int id = Integer.parseInt(st.nextToken());
        	String nome = st.nextToken();
        	String sobrenome = st.nextToken();
        	String email = st.nextToken();
        	String sexo = st.nextToken();
        	String ip = st.nextToken();
            Usuario u = new Usuario(id,nome,sobrenome,email,sexo,ip);
            lst.add(u);
        }
    }
    
    public CadastroUsuarios()throws IOException{
    	//users = new ArrayList<>(1000);
    	users = new LinkedList<>();
    	inicializa(users,"pessoas");
    }

    // Letra a
    public ListIterator<Usuario> getIterator(){
    	return users.listIterator();
    }
    
    // Letra b
    public int removePorIp(int nro){
    	int cont = 0;
    	ListIterator<Usuario>it = users.listIterator();
        while(it.hasNext()){
        	Usuario u = it.next();
        	StringTokenizer st = new StringTokenizer(u.getIp(),".");
            int nroInic = Integer.parseInt(st.nextToken());
            if (nro == nroInic){
            	cont++;
            	it.remove();
            }
        }
        return cont;
    }
    
    // Letra c
    public void insere(String nome,String sobrenome,Usuario novo){
    	ListIterator<Usuario>it = users.listIterator();
        while(it.hasNext()){
        	Usuario u = it.next();
        	if (u.getNome().equals(nome)&&
        		u.getSobrenome().equals(sobrenome)){
        		it.add(novo);
        	}
        }
    }
    
    // Letra d (supondo que Usuario implements Comparable
    public void ordena(){
    	Collections.sort(users);
    }

    @Override
    public String toString(){
    	return users.toString();
    }
}
