package Demo_Conta_Bancaria;

public class App {
    public static void main(String args[]){	
    	ContaComLimite c1 = new  ContaComLimite("Huguinho",1200,5000,0.05,10000);
    	ContaRemunerada c2 = new ContaRemunerada("Zezinho",1300,7000,1.01);
    	ContaComLimite c3 = new ContaComLimite("Luisinho",1400,3000,0.05,5000);

    	c1.retirada(7000);
    	c1.retirada(2000);
    	System.out.println("Saldo:"+c1.getSaldo()+", Juros:"+c1.getJuros());
    	
    	c2.deposito(7000);
    	c2.retirada(2000);
    	System.out.println("Saldo:"+c2.getSaldo());

    	c3.retirada(1000);
    	c3.deposito(5000);
    	System.out.println("Saldo:"+c3.getSaldo()+", Juros:"+c3.getJuros());
    }
}
