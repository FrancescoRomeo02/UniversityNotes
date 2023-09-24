import java.util.Scanner;
class metodi  {

  public static String saluta(String nome){
    System.out.println("Ciao " + nome + "!");
  }

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    String nome = scanner.next();
    saluta(nome);
  }
}
