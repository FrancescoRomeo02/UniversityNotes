import java.util.Scanner;
public class ContoRovesciaDecollo {
  public static void main(String[] args) {
    int valore = leggiNumero();
    mostraContoAllaRovescia(valore);
  }
  public static int leggiNumero() { 
    System.out.println("Inserire un intero positivo:"); 
    Scanner tastiera = new Scanner(System.in);
    int conteggio = tastiera.nextInt();
    if (conteggio <= 0) {
      System.out.println("Il dato deve essere positivo."); 
      System.out.println("Riprovare.");
      conteggio = leggiNumero(); //ripartenza
    }
    return conteggio; 
  }

  public static void mostraContoAllaRovescia(int conteggio){
    System.out.println("Conto alla rovescia:");
    for (int rimanenti = conteggio; rimanenti >= 0; rimanenti --)
    System.out.print(rimanenti + ", "); 
    System.out.println("Decollo!");
  }
}