package Exercicio_3;

public class App {
	public static void main(String[] args) {
		double volumeEsfera = Geometria.getVolumeEsfera(2);
		System.out.println("Volume da esfera: " + volumeEsfera);
		
		double superficiEsfera = Geometria.getSuperficieEsfera(2);
		System.out.println("Superficie da esfera: " + superficiEsfera);
		
		double volumeCilindro = Geometria.getVolumeCilindro(2, 5); 
		System.out.println("Volume do Cilindro: " + volumeCilindro);
		
		double volumeCone = Geometria.getVolumeCone(4, 7);
		System.out.println("Volume do Cone: " + volumeCone);
	}
}
