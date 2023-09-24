import java.util.Scanner;

public class ConversioneParole {
  public static void main(String[] args) {
    System.out.println("Inserire un intero:");
    Scanner tastiera = new Scanner(System.in);
    int numero = tastiera.nextInt(); 
    System.out.println("Le cifre in questo numero sono:"); scriviAParole(numero);
    System.out.println();
    System.out.println("Aggiungendo 10 a questo numero, ");
    System.out.println("le cifre nel nuovo numero sono:"); numero = numero + 10;
    scriviAParole(numero);
    System.out.println();
  }

  /**
Precondizione: numero >= 0
Scrive a parole le cifre del numero.
*/
  
  public static void scriviAParole(int numero) {
    if (numero < 10) System.out.print(daCifraAParola(numero) + " ");
    else { //numero ha due o più cifre 
      scriviAParole(numero / 10); //Chiamata ricorsiva
      System.out.print(daCifraAParola(numero % 10) + " "); }
  } 
  // esempio ricorsione infinita
  /*
  public static void scriviAParole(int numero) {
    // Non ancora corretto
    scriviAParole(numero / 10); 
    System.out.print(daCifraAParola(numero % 10) + " ");
  }
  */

// Precondizione: 0 <= cifra <= 9
// Restituisce la parola corrispondente alla cifra passata come parametro. 
  public static String daCifraAParola(int cifra) {
    String risultato = null; 
    switch (cifra) {
      case 0: risultato = "zero"; break; 
      case 1: risultato = "uno"; break; 
      case 2: risultato = "due"; break; 
      case 3: risultato = "tre"; break; 
      case 4: risultato = "quattro"; break; 
      case 5: risultato = "cinque"; break; 
      case 6: risultato = "sei"; break; 
      case 7: risultato = "sette"; break; 
      case 8: risultato = "otto"; break; 
      case 9: risultato = "nove"; break; 
      default:
      System.out.println("Errore grave.");
      System.exit(0); break;
    }
    return risultato; }
}