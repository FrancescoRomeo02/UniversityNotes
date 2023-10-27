/**
 * programma
 */
public class programma {

    public static boolean checkEspr(String s) {
        boolean stato = true, iterazione = true;
        char[] caratteriAccettati = { 'A', 'B', 'C', 'D', 'E', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        char[] simboliAccettati = { '+', '-' };

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            iterazione = true;
            if ((i + 1) % 2 == 0) {
                if (c != simboliAccettati[0] && c != simboliAccettati[1]) {
                    stato = false;
                }
            } else {
                for (int j = 0; j < caratteriAccettati.length; j++) {
                    if (c == caratteriAccettati[j]) {
                        iterazione = false;
                    }
                    if (iterazione && j == caratteriAccettati.length - 1) {
                        stato = false;
                    }
                }
            }

        }
        System.out.println("primo controllo concluso con esito: " + stato);
        return stato;
    }

    public static boolean checkValori(String s) {
        boolean stato = true, iterazione = true;
        char[] caratteriAccettati = { 'A', 'B', 'C', 'D', 'E' };
        char[] numeriAccettati = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9' };
        char separatore = ':';

        for (int i = 0; i < s.length(); i = i + 3) {
            iterazione = true;
            char c1 = s.charAt(i);
            char c2 = s.charAt(i + 1);
            char c3 = s.charAt(i + 2);

            if (!(c2 == separatore)) {
                stato = false;
            }

            for (int j = 0; j < caratteriAccettati.length; j++) {
                if (c1 == caratteriAccettati[j]) {
                    iterazione = false;
                }
                if (iterazione && j == caratteriAccettati.length - 1) {
                    stato = false;
                }
            }

            iterazione = true;

            for (int j = 0; j < numeriAccettati.length; j++) {
                if (c3 == numeriAccettati[j]) {
                    iterazione = false;

                }
                if (iterazione && j == numeriAccettati.length - 1) {
                    stato = false;
                }
            }

        }
        System.out.println("secondo controllo concluso con esito: " + stato);
        return stato;
    }

    public static void estraiValori(String s, int[] i) {
        String valori = s;
        int[] array = i;
        for (int j = 0; j < valori.length(); j += 3) {
            char key = valori.charAt(j);
            int intVal = Integer.parseInt(String.valueOf(valori.charAt(j + 2)));
            switch (key) {
                case 'A':
                    array[0] = intVal;

                    break;
                case 'B':
                    array[1] = intVal;

                    break;
                case 'C':
                    array[2] = intVal;

                    break;
                case 'D':
                    array[3] = intVal;

                    break;
                case 'E':
                    array[4] = intVal;

                    break;
                default:
                    break;
            }
        }
    }

    public static String sostituisci(String s, int[] i) {
        String valori = s;
        int[] array = i;
        for (int j = 0; j < valori.length(); j += 2) {
            char key = valori.charAt(j);
            int val;
            switch (key) {
                case 'A':
                    val = array[0];
                    valori = valori.replace(key, String.valueOf(val).charAt(0));

                    break;
                case 'B':
                    val = array[1];
                    valori = valori.replace(key, String.valueOf(val).charAt(0));

                    break;
                case 'C':
                    val = array[2];
                    valori = valori.replace(key, String.valueOf(val).charAt(0));

                    break;
                case 'D':
                    val = array[3];
                    valori = valori.replace(key, String.valueOf(val).charAt(0));

                    break;
                case 'E':
                    val = array[4];
                    valori = valori.replace(key, String.valueOf(val).charAt(0));

                    break;
                default:
                    break;
            }
        }
        return valori;
    }

    public static int calcola(String s) {
        int risultato = 0, parziale = 0, temp;
        char segno;
        String espressione = s;
        for (int j = 0; j < espressione.length(); j++) {
            // sommo il primo numero
            if (j == 0) {
                parziale = Integer.parseInt(String.valueOf(espressione.charAt(j)));
                risultato += parziale;
            }
            if (!(j % 2 == 0) && j != 0) {
                temp = j;
                segno = espressione.charAt(j);
                parziale = Integer.parseInt(String.valueOf(espressione.charAt(temp + 1)));
                if (segno == '-') {
                    risultato -= parziale;
                } else {
                    risultato += parziale;
                }
            }
        }
        return risultato;
    }

    public static void main(String[] args) {

        String espressione, valori, daCalc;
        int[] tabella = new int[4];

        espressione = args[0];
        valori = args[1];

        if (!checkEspr(espressione))
            System.exit(0);

        if (!checkValori(valori))
            System.exit(0);

        estraiValori(valori, tabella);

        daCalc = sostituisci(espressione, tabella);

        System.out.println(daCalc);

        System.out.println(calcola(daCalc));
    }
}