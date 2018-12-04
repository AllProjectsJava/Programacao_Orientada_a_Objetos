public class App{
	public static void main(String args[]){
		if(args.length < 3 || args.length > 3 || args[2].length() != 9){
			System.out.println("Erro nos dados!");
			System.exit(1);
		}
		else{
			String nome = args[0];
			int idade = Integer.parseInt(args[1]);
			int telefone = Integer.parseInt(args[2]);
			
			System.out.println("Nome: " + nome);
			System.out.println("Idade: " + idade);
			System.out.println("Telefone: " + telefone);
		}
	}
}