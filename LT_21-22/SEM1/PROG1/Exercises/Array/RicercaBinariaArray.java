import java.util.Scanner;

class RicercaBinariaArray {

  public static int ricercaBinaria(int[] a, int obiettivo, int primo, int ultimo) {
    int risultato;
    if (primo > ultimo) risultato=-1;
    else {
      int med=(primo+ultimo)/2;
      if (obiettivo==a[med])
        risultato=med;
      else if (obiettivo < a[med])
        risultato=ricercaBinaria(a,obiettivo,primo,med-1);
      else // obiettivo > a[med]
        risultato=ricercaBinaria(a, obiettivo, med+1, ultimo);
    }
    return risultato;
  }


  public static int trova(int[] a, int obiettivo) {
    return ricercaBinaria(a, obiettivo, 0, a.length-1);
  }

  public static void main(String[] args) {
    int [] unArray = {1, 3, 4, 6, 11, 23, 43, 51};
    int obiettivo = 43; // numero da cercare
    int risultato = trova(unArray, obiettivo);
    System.out.println(risultato);
  }
}