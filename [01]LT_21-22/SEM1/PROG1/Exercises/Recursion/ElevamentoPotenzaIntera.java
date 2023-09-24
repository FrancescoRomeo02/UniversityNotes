import java.util.Scanner;

class ElevamentoPotenzaIntera {

  public static int elevamento(int b, int e) {
    if (e==0)
      return(1);
    else
      return(b*elevamento(b,e-1));
    /*
    int risultato;
    if (e==0)
      risultato=1;
    else
      risultato=b*elevamento(b,e-1);
    return risultato;
    */
  }

  public static void main(String[] args) {
    int base=0, espo=0, risu=0;
    Scanner tastiera = new Scanner(System.in);
    System.out.println("Inserisci base ed esponente: ");
    base = tastiera.nextInt();
    espo = tastiera.nextInt();
    risu = elevamento(base,espo);
    System.out.println("risultato: "+risu);
  }
}