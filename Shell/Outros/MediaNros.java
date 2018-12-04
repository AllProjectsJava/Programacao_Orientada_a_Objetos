import java.util.Scanner;

classe pública MediaNros {
  public static void main (String args []) {
    int qtdade = Integer.parseInt (args [0]);

    Scanner s = novo scanner (System.in);
    int acum = 0;
    para (int i = 0; i <qtdade; i ++) {
      int nro = s.nextInt ();
      acum = acum + nro;
    }
    mídia dupla = acum / qtdade;
    System.out.println (mídia);
  }
}