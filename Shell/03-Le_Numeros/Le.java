// Le N valores inteiros pertencentes ao intervalo [1;100] e imprime a media

import java.util.Scanner;
public class Le{
	public static void main (String args[]){
		int n = 10;
		//if (args.length == 1){
		//   n = Integer.parseInt(args[0]);
		//}
       		
		Scanner in = new Scanner(System.in);
		int acum = 0;
		for(int i = 0; i < n; i++)
		{
			acum += in.nextInt();
		}

		Double media = acum/(double)n;
		System.out.println("A media e: "+ media);
	}
}