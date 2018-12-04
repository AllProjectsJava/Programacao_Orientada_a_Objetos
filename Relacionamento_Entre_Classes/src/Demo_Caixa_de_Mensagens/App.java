package Demo_Caixa_de_Mensagens;

public class App {

	public static void main(String[] args) {
        CaixaPostal cp = new CaixaPostal();
        cp.carregaMsgs();
        
        EndEmail rem = new EndEmail("Donald","hotmail.com");
    	EndEmail dest = new EndEmail("luizinho","outlook.com");
    	MsgEmail m = new MsgEmail(rem,dest,"Loteria","Parece que não ganhamos de novo ...");
    	
    	cp.acrescenta(m);
    	
    	//cp.remove(2);
    	
    	int nm = cp.qtdadeMsgsDest(dest);
    	System.out.println("Quantidade de mensagens para: "+dest.toString()+":"+nm);
	}

}
