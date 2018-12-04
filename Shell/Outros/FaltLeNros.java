import java.util.*;

class FaltLeNros{
    public boolean procuraValor(int vet[],int n){        
        for(int i=0; i<vet.length; i++){
            if (n == vet[i]){
                return(true);
            }
        }
        return(false);
    }
       
    public int faltando(int vet[]){
        int num;
        for (num=0; num<=vet.length; num++) {
            boolean achou = procuraValor(vet,num);
            if (!achou){
                return(num);
            }
        }
        return -1;
    }
    
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);

        System.out.println("Quantos valores?");
        int max = sc.nextInt();
        
        System.out.print("Max: "+max+"Valores:\n");
        
        int vet[]= new int[max];
                
        System.out.println("Digite valores de 0 ate "+max+", faltando 1");
        for(int i=0; i<max-1; i++){
            vet[i] = sc.nextInt();
            System.out.print(vet[i]+" ");
        }
        
        Faltando f = new Faltando();
        int nro = f.faltando(vet);
        System.out.println("Faltando: "+nro);
    }
}                   