public class App{
	public static void main(String args[]){
		int quantidade = args.length;
		
		System.out.println("Este programa recebeu " + quantidade + " de parametros." );
		
		System.out.println("Os parametros recebidos sao os que seguem:");
		
		for(int i=0; i<quantidade; i++){
			System.out.println(args[i]);
		}
	}
}