import java.util.Scanner;

class RiordinaInteri {

  public static void stampa(int i1, int i2) {
    System.out.println("I due interi riordinati dal più piccolo al più grande sono: "+i1+" "+i2);
  }

  public static void riordina(int i1, int i2) {
    //stampa(i1,i2); // possibile stub
    int v1=Math.min(i1,i2);
    int v2=Math.max(i1,i2);
    stampa(v1,v2);
  }

  public static void main(String[] args) {
    //DriverR.driverStampa();
    //DriverR.driverRiordina();
    Scanner tastiera = new Scanner(System.in);
    System.out.println("Inserisci 2 interi:");
    int i1, i2;
    i1=tastiera.nextInt();
    i2=tastiera.nextInt();
    riordina(i1,i2);
  }
}