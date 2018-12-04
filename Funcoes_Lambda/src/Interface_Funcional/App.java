package Interface_Funcional;

public class App {

	interface Num{
		double getValue();
	}
	
	interface ValorNumerico{
		boolean teste(int n);
	}
	
	interface ValorNumerico2{
		boolean teste(int n, int p);
	}
	
	public static void main(String[] args) {
		// Expressao lambda utilizada como uma constante
		Num n;
		n = () -> 333.11;
		System.out.println(n.getValue());
		
		// Utilização da classe Math  com a etrutura lambda
		Num n2 = () -> Math.random() * 100;
		System.out.println(n2.getValue());
		System.out.println(n2.getValue());

		ValorNumerico isPar = (int i) -> (i % 2) == 0;
		System.out.println(isPar.teste(89));
		System.out.println(isPar.teste(80));
		
		
		//ValorNumerico2 isDiv = (int x, int y) -> (x % y) == 0;
		ValorNumerico2 isDiv = (x, y) -> (x % y) == 0;
		System.out.println(isDiv.teste(10, 2));
		System.out.println(isDiv.teste(10, 3));
		
		ValorNumerico2 expressao1 = (x, y) -> {
			int w = x + y;
			return w > 100;
		};
		System.out.println(expressao1.teste(3, 100));
		
		ValorNumerico expressao2 = i -> (i % 2) == 0;
		System.out.println(expressao2.teste(4));
	}
}
