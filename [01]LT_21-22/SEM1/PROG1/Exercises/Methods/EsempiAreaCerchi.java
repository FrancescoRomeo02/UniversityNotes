public class EsempiAreaCerchi
{
  public static void stampaAreaCerchioRaggio2() {
    System.out.println(3.1415*2*2);
  }

  public static double areaCerchioRaggio2() {
    return 3.1415*2*2;
  }

  public static double areaCerchiov2(double raggio) {
    double area;
    area = 3.1415*raggio*raggio;
    return area;
  }

  public static void provaVarLocali(int p1) {
    p1 = p1+1;
    System.out.println("p1 (dentro nel metodo): "+p1);
  }

  public static void main(String[] args) {
      // invocazione metodo void
      System.out.print("Area del cerchio di raggio 2: ");
      stampaAreaCerchioRaggio2();

      // invocazione metodo che restituisce double
      // invocazione ovunque si possa usare un double
      double area=areaCerchioRaggio2();
      System.out.println("Area del cerchio di raggio 2: "+area);
      System.out.println("Area del cerchio di raggio 2: "+areaCerchioRaggio2());

      // invocazione metodo che restituisce double e accetta in input il raggio
      double raggio=2.0;
      //int raggio=2; (esempio cast automatico)
      System.out.println("Area del cerchio di raggio 2: "+areaCerchiov2(raggio));
      // non si deve per forza chiamare come nell'intestazione del metodo...
      double coso=2.0;
      System.out.println("Area del cerchio di raggio 2: "+areaCerchiov2(coso));
      // ... infatti può anche non chiamarsi ed essere una costante
      System.out.println("Area del cerchio di raggio 2: "+areaCerchiov2(2));


      // prova variabili locali con lo stesso nome
      int p1=1;
      System.out.println("p1 (prima del metodo): "+p1);
      provaVarLocali(p1);
      System.out.println("p1 (dopo del metodo): "+p1);
      
  }
}
