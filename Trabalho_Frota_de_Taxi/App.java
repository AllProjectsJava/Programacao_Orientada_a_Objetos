import java.util.*;

public class App{
    public static void main(String args[]){
    /*
        FrotaNaRua taxis = new FrotaNaRua();
        taxis.carregaFrota();
        taxis.menu();*/
        
        Conjunto c1 = new ConjuntoV1();
        Conjunto c2 = new ConjuntoV2(100);
        
        c1.insere(10);
        c1.insere(20);
        c1.insere(30);
        c1.insere(40);
        c1.insere(60);
        
        c2.insere(20);
        c2.insere(30);
        c2.insere(40);
        c2.insere(50);
        
        System.out.println(c1.uniao(c2));
        System.out.println(c2.uniao(c1));
        
        Conjunto c3 = c2.interseccao(c1);
        System.out.println(c3 instanceof Conjunto);
        System.out.println(c3 instanceof ConjuntoV1);
        System.out.println(c3 instanceof ConjuntoV2);
    }
}
