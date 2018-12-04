package Exercicio_1_Hierarquia_Veiculos;

public class VeiculoPasseio extends Veiculo{
	private int capacidadePassageiros;

	public VeiculoPasseio(String chassi, String placa, double consumo,int capacidadePassageiros) {
		super(chassi, placa, consumo);
		this.capacidadePassageiros = capacidadePassageiros;
	}

	public int getCapacidadePassageiros() {
		return capacidadePassageiros;
	}
	
	@Override
	public double combustivelNecessario(int distancia) {
		double qtdadeComb = super.combustivelNecessario(distancia);
		if (capacidadePassageiros > 2) {
			double taxa = (capacidadePassageiros-2)*1.2;
			qtdadeComb *= taxa;
		}
		return qtdadeComb;
	}
}
