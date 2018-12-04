package Exercicio_3;

public class Geometria {
	public static double getVolumeEsfera(double raio) {
		return (4 * Math.PI * Math.pow(raio, 3)) / 3;
	}
	
	public static double getSuperficieEsfera(double raio) {
		return 4 * Math.PI * Math.pow(raio, 2);
	}
	
	public static double getVolumeCilindro(double raio, double altura) {
		return Math.PI * Math.pow(raio, 2) * altura;
	}
	
	public static double getVolumeCone(double raio, double altura) {
		return (Math.PI * Math.pow(raio, 2) * altura) / 3;
	}
}
