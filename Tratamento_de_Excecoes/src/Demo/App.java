package Demo;

public class App {
	public static void main(String[] args) {
		//Scanner scanner = new Scanner(System.in);
		Pessoa p1 = null;
		Pessoa p2 = null;

		try {
			p1 = new Pessoa("Ze", 30);
			p2 = new Pessoa("Banana", 45);
		} catch (NomeInvalidoException e) {
			System.out.println(e.getMessage());
			return;
		} catch (IdadeInvalidaException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getIdade());
			return;
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
			return;
		} catch (InterruptedException e) {
			System.out.println(e.getMessage());
			return;
		}

		System.out.println(p1);
		System.out.println(p2);

		/*
		 * boolean valido = false; while(!valido) { valido = true;
		 * System.out.println("Digite um valor: "); int val = s.nextInt(); try { int
		 * resp = x.fatorial(val)*2; System.out.println("Resp="+resp);
		 * }catch(IllegalArgumentException e) {
		 * System.out.println("O valor era invalido para o calculo");
		 * System.out.println("Tente novamente"); valido = false; }
		 * 
		 * }
		 */
		/*
		 * try { double resp = x.umCalculo(10, 20); System.out.println(resp);
		 * }catch(ArithmeticException e) {
		 * System.out.println("O calculo nao e possivel"); }
		 */
		System.out.println("Fim");

	}
}
