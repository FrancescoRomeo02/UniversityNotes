/**
 * app
 */
public class app {
    public static void modificaArray(int[] par, int a) {
        int sum = 0, prod = 1;
        for (int i : par) {
            sum += i;
            prod *= i;
        }
        System.out.println(sum + " " + prod);
        if ((prod - sum) <= a && a >= (prod + sum)) {
            for (int i = 0; i < par.length; i++) {
                if (par[i] > a)
                    par[i] = (prod + sum);
            }
        } else {
            for (int i = 0; i < par.length; i++) {
                if (par[i] < a)
                    par[i] = (prod - sum);
            }
        }
    }

    public static int valutaDifferenzeArray(int[] par1, int[] par2) {
        int stato = 0;
        boolean stop = false;
        if (par1.length != par2.length)
            stato = -1;
        else {
            for (int index = 0; index < par1.length && !stop; index++) {
                if (par1[index] != par2[index]) {
                    stato = 1;
                    stop = true;
                }
            }
        }
        return stato;
    }

    public static void main(String[] args) {
        int[] interi = new int[5];
        int[] copiaInteri = new int[5];
        int j = 0, info;
        int n = Integer.parseInt(args[5]);
        for (int i = 0; i < 5; i++) {
            interi[i] = Integer.parseInt(args[i]);
        }

        for (int i : interi) {
            copiaInteri[j] = i;
            j++;
        }

        modificaArray(interi, n);
        System.out.println("Interi:");
        for (int i : interi) {
            System.out.print(i);
        }

        System.out.println("\nCopia interi:");
        for (int i : copiaInteri) {
            System.out.print(i);
        }
        info = valutaDifferenzeArray(interi, copiaInteri);

        if (info == -1) {
            System.out.println("Errore!");
        } else if (info == 0) {
            System.out.println("\nCopia interi:");
            for (int i : copiaInteri) {
                System.out.print(i);
            }
        } else {
            System.out.println("\ninteri:");
            for (int i : interi) {
                System.out.print(i);
            }
        }

    }
}