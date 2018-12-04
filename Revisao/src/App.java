import java.util.List;

public class App {

	public static void main(String[] args) {
		CadastroFuncionarios cf = new CadastroFuncionarios();
		
		try {
			cf.add(new Funcionario("Huguinho",1000,5000.0));
			cf.add(new Funcionario("Zezinho",1010,6000.0));
			cf.add(new Funcionario("Luizinho",1020,4000.0));
			cf.add(new Funcionario("Lala",2030,5000.0));
			cf.add(new Funcionario("Lele",2040,6000.0));
			cf.add(new Funcionario("Lili",2050,4000.0));
		}catch(FuncionarioDuplicadoException e) {
			System.out.println(e.getMessage());
			System.out.println(e.getFuncionario());
		}
        /*
		List<String> lst = cf.getMeninasQueGanhamMaisDe4000();
		for(String nome:lst) {
			System.out.println(nome);
		}
		*/
		/*
		List<String> lst = cf.getMeninasQueGanhamMaisDe4000();
        lst.forEach(f->System.out.println(f));
        */
		cf.getMeninasQueGanhamMaisDe4000().forEach(f->System.out.println(f));
		
		System.out.println("Gasto total:"+cf.getGastoTotalComSalarios());
		
		cf.aumentaHomens(1.2);

		System.out.println("Gasto total:"+cf.getGastoTotalComSalarios());

		Funcionario x = new Funcionario("Carlos",1210,6000.0);
		double sal = x.getSalario(new CalculaSalario() {
			public double calcula(Funcionario f) {
				return f.getSalarioBase() * 1.2;				
			}
		});
		
		sal = x.getSalario(f->f.getSalarioBase() * 1.2);
	}

}
