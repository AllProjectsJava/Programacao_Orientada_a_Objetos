public class FaltandoOtimiz{
    public int faltando(int vet[]) {
        // Soma dos valores de 0 a n = (n(n+1))/2
        int soma = (vet.length * (vet.length+1) ) / 2;
        
        // Calcula a soma dos números no vetor
        int acum = 0;
        for (int i=0; i<vet.length; i++)
            acum += vet[i];
            
        // A diferença é o número que está faltando
        return soma - acum;
    }

    public static void main(String args[]){
        int vet[] = {6,4,1,2,3,0};
        
        Faltando f = new Faltando();
        int nro = f.faltando(vet);
        System.out.println("Faltando: "+nro);
    }
}