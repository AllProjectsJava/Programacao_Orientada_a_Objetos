package Ex_5_FilaBanco;

import java.util.*;

public class App{
    public static void main(String args[]){
        PriorityQueue<Cliente> pq = new PriorityQueue<>();
        
        pq.add(new Cliente("S11",false,false));        
        pq.add(new Cliente("X34",true,false));
        pq.add(new Cliente("O91",false,false));        
        pq.add(new Cliente("S22",false,true));
        pq.add(new Cliente("S65",false,false));        
        pq.add(new Cliente("X84",true,false));
        
        while(pq.size() > 0){
            Cliente c = pq.remove();
            System.out.println(c);
        }
    }
}

