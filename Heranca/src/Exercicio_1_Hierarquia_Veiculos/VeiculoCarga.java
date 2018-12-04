package Exercicio_1_Hierarquia_Veiculos;

public class VeiculoCarga extends Veiculo {
  private double capacidadeCarga;

  public VeiculoCarga(String chassi, String placa, double consumo, double capacidadeCarga){
    super(chassi,placa,consumo);
    this.capacidadeCarga = capacidadeCarga;
  }

  public double getCapacidadeCarga(){
    return capacidadeCarga;
  }

  @Override
  public double combustivelNecessario(int distancia){
    double qtdadeComb = super.combustivelNecessario(distancia);
    if(capacidadeCarga > 3){
      double taxa = (capacidadeCarga-3)*1.05;
      qtdadeComb *= taxa;
    }
    return qtdadeComb;
  }
  public String toString(){
    return (super.toString()+" ,CapacidadeDeCarga = "+ capacidadeCarga);
  }
}
