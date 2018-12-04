public class Converte{
    public int converte(String bin[]) {
        int dec=0;
        
        for (int i=0; i<bin.length; i++) {
            char digit = bin[i].charAt(0);
            if (digit == '0' || digit == '1'){
                int ival = digit - '0';
                dec = dec + ( ival * (int)Math.pow(2, bin.length-1-i) );
            }else{
                if (digit == ' '){
                    continue;
                }else{
                    return(-1);
                }
            }
        }
        return dec;
    }
    
    public static void main(String args[]){
        Converte conv = new Converte();
        int val = conv.converte(args);
        if (val == -1){
            System.out.println("Sequencia de dígitos inválida !!");
        }else{
            System.out.println("Valor equivalente em decimal: "+val);
        }
    } 
}