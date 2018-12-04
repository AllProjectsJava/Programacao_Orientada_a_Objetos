public class ConjuntoV1 implements Conjunto{
    private int base[];
    private int proxLivre;
    private final int capacidade = 100;
    
    public ConjuntoV1(){
        base = new int[capacidade];
        proxLivre = 0;
    }
    
    // Metodos auxiliares privados
    private int posicao(int n){
        for(int i=0;i<proxLivre;i++){
            if (n == base[i]){
                return(i);
            }
        }
        return(-1);
    }
    
    // Operacoes entre elemento e conjunto
    public boolean pertence(int n){
        for(int i=0;i<proxLivre;i++){
            if (n == base[i]){
                return(true);
            }
        }
        return(false);
    }
    
    public boolean insere(int n){
        // Se for valor invalido, retorna
        if (n < 0){
            return(false);
        }
        // Se o valor ja esta no conjunto, retorna
        int pos = posicao(n);
        if (pos >= 0){
            return(true);
        }
        // Insere o valor no conjunto
        base[proxLivre] = n;
        proxLivre++;
        return(true);
    }
    
    public boolean remove(int n){
        int pos = posicao(n);
        if (pos < 0){
            return(false);
        }
        for(int i=pos; i<proxLivre-1; i++){
            base[i] = base[i+1];
        }
        proxLivre--;
        return(true);
    }
    
    // Operacoes entre conjuntos
    public Conjunto uniao(Conjunto outro){
        ConjuntoV1 novo = new ConjuntoV1();
        // Insere todos os elementos do conjunto corrente no conjunto novo
        for(int i=0;i<this.proxLivre;i++){
            novo.insere(this.base[i]);
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
        ConjuntoV1 novo = new ConjuntoV1();
        // Insere todos os elementos do conjunto corrente, que estão em ambos, no conjunto novo
        for(int i=0;i<this.proxLivre;i++){
            if (outro.pertence(this.base[i])){
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
        ConjuntoV1 novo = new ConjuntoV1();
        // Insere todos os elementos do conjunto corrente que estão em ambos no conjunto novo
        for(int i=0;i<this.proxLivre;i++){
            if (!outro.pertence(this.base[i])){
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
        return(proxLivre);
    }
    
    public int[] toArray(){
        int copia[] = new int[proxLivre];
        for(int i=0;i<proxLivre;i++){
            copia[i] = base[i];
        }
        return(copia);
    }
    
    public String toString(){
        StringBuffer sb = new StringBuffer();
        if (proxLivre <= 0){
            return null;
        }
        for(int i=0;i<proxLivre-1;i++){
            sb.append(base[i]).append(", ");
        }
        sb.append(base[proxLivre-1]);
        return(sb.toString());
    }
}

