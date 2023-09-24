class ArrayMultiDim {
  public static void main(String[] args) {
    System.out.println("Hello world!");

    int[][] tabella=new int[3][3];
    int count=1;
    for(int riga=0; riga<3; riga++){
      for(int colonna=0; colonna<3; colonna++){
        tabella[riga][colonna]=count;
        count++;
      }
    }

    for(int riga=0; riga<3; riga++){
      for(int colonna=0; colonna<3; colonna++){
        System.out.print(tabella[riga][colonna]+",");
      }
      System.out.println();
    }

  }
}