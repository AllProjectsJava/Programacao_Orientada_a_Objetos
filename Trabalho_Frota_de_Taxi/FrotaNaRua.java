import java.util.*;

public class FrotaNaRua{
    private final int MAXTAXIS = 300;
    private Conjunto frotaNaRua;
    
    public FrotaNaRua(){
        frotaNaRua = new ConjuntoV2(MAXTAXIS);
    }
    
    public void carregaFrota(){
        // A probabilidade de um motorista sair em um dia é 70%
        // Sorteia um valor entre 0 e 2
        // Se sair 0 ou 1 o motorista veio (insere no conjunto)
        Random r = new Random();
        for(int i=0;i<MAXTAXIS;i++){
            int aux = r.nextInt(3);
            if (aux != 2){
                frotaNaRua.insere(i);
            }
        }         
    }
    
    public boolean prefixoValido(int p){
        if (p<0 || p>=MAXTAXIS){
            return(false);
        }else{
            return(true);
        }
    }
    
    public void menu(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Sistema de controle de frota de taxis");
        while(true){
            System.out.println("Digite o prefixo do taxi: (-1 encerra)");
            int prefixo = sc.nextInt();
            if (prefixo == -1){
                break;
            }
            if (!prefixoValido(prefixo)){
                System.out.println("Prefixo invalido");
            }else{
                if (frotaNaRua.pertence(prefixo)){
                    System.out.println("O taxi "+prefixo+" está trabalhando");
                }else{
                    System.out.println("O taxi "+prefixo+"  não está trabalhando");
                }
            }
        }
        System.out.println("Encerrando sistema!");
    }
}

