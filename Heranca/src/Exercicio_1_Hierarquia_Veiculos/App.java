package Exercicio_1_Hierarquia_Veiculos;

public class App {

	public static void impVeiculo(Veiculo v) {
		System.out.println("Placa: "+v.getPlaca());
		System.out.println("Comb necessario para 1000Km:"+v.combustivelNecessario(1000));
		System.out.println("----");
	}
	
	public static void main(String[] args) {
	    VeiculoPasseio vp = new VeiculoPasseio("Q1234E","IJX2375",10,5);
		VeiculoCarga vc = new VeiculoCarga("CH786R4","AAA0000",6,5.0);
		
		impVeiculo(vp);
		impVeiculo(vc);
	}

}
