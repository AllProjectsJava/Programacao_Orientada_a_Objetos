package Ex_3_FuncionariosSemRepeticao;

import java.util.*;

public class App{
    public static List<Funcionario> listaSemRepeticao(List<Funcionario> lst){
        //Set<Funcionario> set = new HashSet<Funcionario>();
        Set<Funcionario> set = new TreeSet<Funcionario>();
        set.addAll(lst);
        return(new ArrayList<Funcionario>(set));
    }
    
    public static void impLst(List<Funcionario> lst){
        System.out.println("Total de elementos: "+lst.size());
        for(Funcionario f:lst){
            System.out.println(f);
        }
    }
    
    public static void main(String args[]){
        final int MAX = 20;
        Random r = new Random();
        List<Funcionario> lst = new ArrayList<>(MAX);
        
        for(int i=0;i<(MAX-(MAX/4));i++){
            String nome = "Nome"+r.nextInt(1000)+" Sobrenome"+r.nextInt(1000);
            int matricula = r.nextInt(5000);
            lst.add(new Funcionario(nome,matricula));
        }
        
        for(int i=0;i<(MAX/4);i++){
            int indice = r.nextInt(MAX-(MAX/4));
            lst.add(lst.get(indice));
        }
        
        System.out.println("Lista original:");
        impLst(lst);
        
        List<Funcionario> semDup = listaSemRepeticao(lst);
        
        System.out.println("Lista sem repeticao:");
        impLst(semDup);
    }  
}
        
