public class programma {
    /**
     * metodi
     */
    public static int[] creaArray() {
        int[] array = new int[100];

        return array;
    }

    public static boolean aggiungiElemento(int[] array, int numeroElementi, int elemento) {
        boolean info = true;
        if (!(numeroElementi == 100)) {

            for (int i : array) {

                if (elemento == i)
                    info = false;

                if (info)
                    array[numeroElementi] = elemento;
            }

        } else
            info = false;

        return info;
    }

    public static boolean rimuoviElemento(int[] array, int numeroElementi, int elemento) {
        boolean info = true;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == elemento) {
                array[i] = 0;
                for (int j = i; j < (array.length - i); j++) {
                    array[j] = array[j + 1];
                }
            } else
                info = false;
        }

        return info;
    }

    /**
     * main
     */
    public static void main(String[] args) {
        int[] array = creaArray();
        aggiungiElemento(array, 0, 1);
        aggiungiElemento(array, 1, 2);
        aggiungiElemento(array, 2, 3);
        for (int i : array) {
            System.out.println(i);
        }
        rimuoviElemento(array, 2, 2);
        System.out.println("array modificato");
        for (int i : array) {
            System.out.println(i);
        }
    }
}