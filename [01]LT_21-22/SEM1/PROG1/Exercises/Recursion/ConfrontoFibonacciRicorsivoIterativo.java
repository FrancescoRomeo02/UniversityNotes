class ConfrontoFibonacciRicorsivoIterativo {

  static int n1=0, n2=1, n3=0;

  static void printFibonacciR(int count){
    if(count>0) {
      n3 = n1 + n2;
      n1 = n2;
      n2 = n3;
      System.out.print(" "+n3);
      printFibonacciR(count-1);
    }
  }

  public static void main(String[] args) {
    int count=10; // # di elementi della sequenza
    long startTime = System.nanoTime();
    System.out.print(n1+" "+n2); // stampato i primi 2 numeri
    printFibonacciR(count-2); // ne restano count-2
    long endTime = System.nanoTime();
    long timeElapsed=endTime-startTime;
    System.out.println();
    System.out.println("Exec time in nanosec (ricors): "+timeElapsed);
    System.out.println("Exec time in sec (ricors): "+(1e-9*(float)timeElapsed));

    n1=0; n2=1; n3=0;
    startTime = System.nanoTime();
    System.out.print(n1+" "+n2); // stampato i primi 2 numeri
    for(int n=3; n<=count; n++){
      n3 = n1+n2;
      n1 = n2;
      n2 = n3;
      System.out.print(" "+n3);
    }
    endTime = System.nanoTime();
    timeElapsed=endTime-startTime;
    System.out.println();
    System.out.println("Exec time in nanosec (iter): "+timeElapsed);
    System.out.println("Exec time in sec (iter): "+(1e-9*(float)timeElapsed));
  }
}