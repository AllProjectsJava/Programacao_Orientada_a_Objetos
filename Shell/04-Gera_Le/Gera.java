import java.util.Scanner;
import java.util.Random;

public class Gera{
	public static void main(String args[]){
		int quantidade = 5000;
	
		Random random = new Random();
		
		for(int i=0; i<quantidade; i++){
			System.out.print(random.nextInt(100) + " ");
		}
	}
}