import java.util.Scanner;

public class ContoAllaRovescia{

  public static void main(String[] args) {
    contoAllaRovescia(5);
  }

  public static void contoAllaRovescia(int num) {
  	if (num <=0) {
  		System.out.println();
  	}
    else {
      System.out.print(num);
      contoAllaRovescia(num-1);
    }
  }  

}