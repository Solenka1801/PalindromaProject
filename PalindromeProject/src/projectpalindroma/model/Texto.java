package projectpalindroma.model;

public class Texto {

    public static int posSalto = -1;

    public static String[] inicializarRecorrido(String[] arrOriginal, int index, String palabra, String[] arrActualizado) {
        if (index > arrOriginal.length - 1) {

            return arrActualizado;
        } else if (arrOriginal[index].length() == 1) {

            arrActualizado[index] = arrOriginal[index];

            return inicializarRecorrido(arrOriginal, index + 1, palabra, arrActualizado);

        } else if (arrOriginal[index].length() == 0) {
            arrActualizado[index] = arrOriginal[index];

            return inicializarRecorrido(arrOriginal, index + 1, palabra, arrActualizado);

        } else {
            String cadena = CaracteresEspeciales.tratamientoTildes(arrOriginal[index], 0, 0);

            if (arrOriginal[index].contains("\n")) {
                cadena = posicionSaltoLinea(cadena, 0);
            }

            palabra = Palabra.esPalindroma(cadena, 0, 0, ' ');

            String modificarPalabra = CaracteresEspeciales.retornarTildes(palabra, 0, 0);
            if (posSalto != -1) {
                arrActualizado[index] = "\n" + modificarPalabra;
                posSalto = -1;
            } else {

                arrActualizado[index] = modificarPalabra;
            }
            return inicializarRecorrido(arrOriginal, index + 1, palabra, arrActualizado);
        }
    }

    private static String posicionSaltoLinea(String cadena, int i) {
        if (i > cadena.length() - 1) {
            cadena = cadena.replace("\n", "");
            return cadena;
        } else if (cadena.charAt(i) == '\n') {
            posSalto = i;
        }
        return posicionSaltoLinea(cadena, i + 1);

    }
}
