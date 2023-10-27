public class temp {
    public static void main(String[] args) {
        int[] a = new int[5];
        int[] b = { 1, 1, 1, 1, 1, 1, 1, 1 };
        int j = 0;
        for (int i = 0; i < a.length; i++) {
            if (i % 2 == 0) {
                a[i] = i;
            }
        }

        System.out.print("a: ");
        for (int i : a) {
            System.out.print(i);
        }

        System.out.println();
        System.out.print("b: ");
        for (int i : b) {
            System.out.print(i);

        }

        b = a;

        a[0] = 15;
        System.out.println();
        System.out.print("a: ");
        for (int i : a) {
            System.out.print(i);

        }

        System.out.println();
        System.out.print("b: ");
        for (int i : b) {
            System.out.print(i);

        }

    }
}
