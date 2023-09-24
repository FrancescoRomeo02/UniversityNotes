import java.util.Scanner;

class MediaArray {
  public static void main(String[] args) {
    // valori di default
    /*int[] vettore = new int[5];
    for(int i=0; i<=4; i++)
      System.out.println(vettore[i]);

    double[] vettoreD = new double[5];
    for(int i=0; i<=4; i++)
      System.out.println(vettoreD[i]);

    char[] vettoreC = new char[5];
    for(int i=0; i<=4; i++)
      System.out.println(vettoreC[i]);

    String[] vettoreS = new String[5];
    for(int i=0; i<=4; i++)
      System.out.println(vettoreS[i]);
    */

    Scanner tastiera = new Scanner(System.in);
    System.out.println("Quanti esami hai superato?");
    int numeroEsami = tastiera.nextInt();
    int[] votoEsame;

    // esempio con "spreco" della posizione 0
    /*
    votoEsame = new int[numeroEsami+1]; // allocato a run-time
    for(int i=1; i<=numeroEsami; i++) {
      System.out.println("Inserisci il voto del "+i+"° esame: ");
      votoEsame[i]=tastiera.nextInt();
    }
    */

    // esempio senza "spreco" della posizione 0
    votoEsame = new int[numeroEsami]; // allocato a run-time
    for(int i=0; i<numeroEsami; i++) {
      System.out.println("Inserisci il voto del "+(i+1)+"° esame: ");
      votoEsame[i]=tastiera.nextInt();
    }

    int somma=0;
    for(int i=0; i<numeroEsami; i++)
      somma+=votoEsame[i];
    double media=(double)somma/numeroEsami;
    System.out.println("La tua media è: "+media);

    somma=0;
    for(int i=0; i<votoEsame.length; i++)
      somma+=votoEsame[i];
    media=(double)somma/votoEsame.length;
    System.out.println("La tua media è: "+media);

  }
}