package Exercicio_1_Hierarquia_Veiculos;

public class Veiculo {
    private String chassi;
    private String placa;
    private double consumo;
	
    public Veiculo(String chassi, String placa, double consumo) {
		this.chassi = chassi;
		this.placa = placa;
		this.consumo = consumo;
	}

	public String getChassi() {
		return chassi;
	}

	public String getPlaca() {
		return placa;
	}

	public double getConsumo() {
		return consumo;
	}

	public double combustivelNecessario(int distancia) {
	    return distancia/consumo;
	}
	
	@Override
	public String toString() {
		return "Veiculo [chassi=" + chassi + ", placa=" + placa + ", consumo=" + consumo + "]";
	}
}
