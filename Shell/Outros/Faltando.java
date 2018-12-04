class Faltando{
	public static void main(String args[]){
        int vet[] = {6,4,5,2,3,0};
        
        Faltando f = new Faltando();
        int nro = f.faltando(vet);
        System.out.println("Faltando: "+nro);
    }

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
    
    
}                   