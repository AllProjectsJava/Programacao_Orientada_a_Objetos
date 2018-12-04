package Ex_6_AlunosOrdenadosMedia;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class App {
	
    public static Collection<Aluno> alunosOrdenadosPorMedia(Map<Integer,Aluno> alunos){
    	PriorityQueue<Aluno> pq = new PriorityQueue<>();
    	
		for(Integer matr:alunos.keySet()){
			pq.add(alunos.get(matr));
		}
		
		List<Aluno> al = new ArrayList(pq.size());
		while(pq.size()>0){
			al.add(pq.remove());
		}
        return al;
    }
    
	public static void main(String[] args) {
		Map<Integer,Aluno> alunos = new HashMap<>(); 
		
		Aluno a1 = new Aluno(100,"Huguinho",10,10,10);
		Aluno a2 = new Aluno(50,"Zezinho",5,7,9);
		Aluno a3 = new Aluno(150,"Luizinho",7,6,10);
		Aluno a4 = new Aluno(12,"Lala",4,7,3);
		
		alunos.put(a1.getMatricula(), a1);
		alunos.put(a2.getMatricula(), a2);
		alunos.put(a3.getMatricula(), a3);
		alunos.put(a4.getMatricula(), a4);
		
		System.out.println(alunosOrdenadosPorMedia(alunos));		
	}

}
