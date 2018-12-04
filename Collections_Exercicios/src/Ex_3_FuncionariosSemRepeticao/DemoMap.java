package Ex_3_FuncionariosSemRepeticao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DemoMap {

	public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Ze",1212);
        Funcionario f2 = new Funcionario("Ze Luis",1313);
        Funcionario f3 = new Funcionario("Ze Roberto",1515);
        
        Map<Integer,Funcionario> cad = new HashMap<>();
        cad.put(f1.getMatricula(), f1);
        cad.put(f2.getMatricula(), f2);
        cad.put(f3.getMatricula(), f3);

        System.out.println("Digite a matricula do funcionario");
        Scanner s = new Scanner(System.in);
        int matr = s.nextInt();

        Funcionario f = cad.get(matr);
        if (f != null) System.out.println("Nome: "+f.getNome());
        else System.out.println("Matricula não encontrada");
        
        for(Integer m:cad.keySet()){
        	
        	
        }
        
        /*
        List<Funcionario> lst = new ArrayList<>();
        
        lst.add(f1);
        lst.add(f2);
        lst.add(f3);
        
        System.out.println("Digite a matricula do funcionario");
        Scanner s = new Scanner(System.in);
        int matr = s.nextInt();
  
        boolean achou = false;
        for(int i=0;i<lst.size();i++){
        	if (matr == lst.get(i).getMatricula()){
        		System.out.println("Nome: "+lst.get(i).getNome());
        		achou = true;
        		break;
        	}
        }
        if (!achou){
        	System.out.println("Matricula não encontrada");
        }
        */
	}

}
