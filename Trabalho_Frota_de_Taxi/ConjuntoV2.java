// Este conjunto é capaz de armazenar nros inteiros entre 0 e "n-1"
// Não armazena nros negativos
public class ConjuntoV2 implements Conjunto{
    private int base[];
    private int capacidade;
    private int nElementos;
        
    public ConjuntoV2(int cap){
        capacidade = cap;
        base = new int[capacidade];
        for(int i=0; i<capacidade; i++){
            base[i] = -1;
        }
        nElementos = 0;
    }

    // Métodos auxiliares privados
    private ConjuntoV2 alocaNovo(Conjunto outro){
        ConjuntoV2 novo;
        // Aloca novo vetor base
        if (getTamMaximo() > outro.getTamMaximo()){
            novo = new ConjuntoV2(getTamMaximo());
        }else{
            novo = new ConjuntoV2(outro.getTamMaximo());
        }   
        return(novo);         
    }
    
    // Operacoes entre elemento e conjunto
    public boolean pertence(int n){
        if (base[n] == n) return(true);
        else return(false);
    }
    
    public boolean insere(int n){
        // Se for valor invalido, retorna false
        if (n < 0 || n >= capacidade){
            return(false);
        }        
        // Se o valor não esta no conjunto, insere
        if (base[n] == -1){
            base[n] = n;
            nElementos++;
        }
        return(true);
    }
    
    public boolean remove(int n){
        // Se for valor invalido, retorna false
        if (n < 0 || n >= capacidade){
            return(false);
        }
        // Se o valor está no conjunto, remove
        if (base[n] != -1){
            base[n] = -1;
            nElementos--;
        }
        return(true);
    }
    
    // Operacoes entre conjuntos
    public Conjunto uniao(Conjunto outro){
        ConjuntoV2 novo = alocaNovo(outro);
        // Insere todos os elementos do conjunto corrente no conjunto novo
        for(int i=0;i<capacidade;i++){
            if (base[i] != -1){
                novo.insere(base[i]);
            }
        }
        // Insere todos os elementos do outro conjunto no conjunto novo
        int array[] = outro.toArray();
        for(int i=0;i<array.length;i++){
            novo.insere(array[i]);
        }
        // Retorna o conjunto novo
        return(novo);
    }
    
    public Conjunto interseccao(Conjunto outro){
        ConjuntoV2 novo = alocaNovo(outro);
        // Insere todos os elementos do conjunto corrente, que estão em ambos, no conjunto novo
        for(int i=0;i<capacidade;i++){
            if (base[i] != -1 && outro.pertence(this.base[i])){
              novo.insere(this.base[i]);
            }
        }
        // Insere todos os elementos do conjunto corrente, que estão em ambos, no conjunto novo
        int array[] = outro.toArray();
        for(int i=0;i<array.length;i++){
            if (this.pertence(array[i])){
              novo.insere(array[i]);
            }
        }
        return(novo);
    }
    
    public Conjunto diferenca(Conjunto outro){
        ConjuntoV2 novo = alocaNovo(outro);
        // Insere todos os elementos do conjunto corrente, que estão em ambos, no conjunto novo
        for(int i=0;i<capacidade;i++){
            if (base[i] != -1 && !outro.pertence(this.base[i])){
              novo.insere(this.base[i]);
            }
        }
        return(novo);    
    }
    
    // Métodos auxiliares publicos
    public int getTamMaximo(){
        return(capacidade);
    }
    
    public int getTamanho(){
        return(nElementos);
    }    public int[] toArray(){
        int copia[] = new int[nElementos];
        for(int b=0,c=0;b<capacidade;b++){
            if (base[b] != -1){
                copia[c] = base[b];
                c++;
            }
        }
        return(copia);
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        if (nElementos == 0){
            return null;
        }
        for(int i=0;i<capacidade;i++){
            if (base[i] != -1){
                sb.append(base[i]).append(", ");
            }
        }
        return(sb.toString());
    }
}

