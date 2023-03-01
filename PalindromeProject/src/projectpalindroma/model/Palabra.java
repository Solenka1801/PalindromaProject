package projectpalindroma.model;

import java.util.Arrays;

public class Palabra {

   

    public static String esPalindroma(String palabra, int i, int imparCantidad, char letraImpar) {
        String[] agruparLetras = new String[palabra.length()];
        contarRepeticionLetras(palabra, i, agruparLetras, 0);
        
        imparCantidad = numeroDeImpares(imparCantidad, agruparLetras, 0);
        letraImpar = determinarletraImpar(letraImpar, agruparLetras, 0);

        if (imparCantidad > 1 || imparCantidad == 1 && palabra.length() % 2 == 0) {
            return "" + palabra;
        }
        String primerMitad = "";
        String ultimaMitad = "";
        return organizarPalabra(primerMitad, ultimaMitad, 0, agruparLetras, imparCantidad, letraImpar);

    }

    public static void contarRepeticionLetras(String palabra, int i, String[] agruparLetras, int posArray) {
        if (i > palabra.length() - 1) {
        } else if (estaAlmacenada(palabra.charAt(i), agruparLetras, 0, 0)) {
            contarRepeticionLetras(palabra, i + 1, agruparLetras, posArray);
        } else {
            String charToString = String.valueOf(palabra.charAt(i));
            agruparLetras[posArray] = charToString;
            contarRepeticionLetras(palabra, i + 1, agruparLetras, posArray + 1);
        }
    }

    private static boolean estaAlmacenada(char letra, String[] agruparLetras, int pos, int verifica) {
        if (pos > agruparLetras.length - 1 && verifica == 0) {
            return false;
        } else if (pos > agruparLetras.length - 1 && verifica == 1) {
            return true;
        } else if (agruparLetras[pos] != null && letra == agruparLetras[pos].charAt(0)) {
            String charToString = String.valueOf(letra);
            agruparLetras[pos] += charToString;
            return estaAlmacenada(letra, agruparLetras, pos + 1, 1);
        } else {
            return estaAlmacenada(letra, agruparLetras, pos + 1, verifica);
        }
    }

    private static int numeroDeImpares(int imparCantidad, String[] agruparLetras, int i) {
        if (i > agruparLetras.length - 1) {
            return imparCantidad;
        } else if (agruparLetras[i] != null && agruparLetras[i].length() % 2 != 0) {
            imparCantidad++;
            return numeroDeImpares(imparCantidad, agruparLetras, i + 1);
        } else {
            return numeroDeImpares(imparCantidad, agruparLetras, i + 1);
        }

    }

    private static char determinarletraImpar(char letraImpar, String[] agruparLetras, int i) {
        if (i > agruparLetras.length - 1) {
            return letraImpar;
        } else if (agruparLetras[i] != null && agruparLetras[i].length() % 2 != 0) {
            letraImpar = agruparLetras[i].charAt(0);
            return determinarletraImpar(letraImpar, agruparLetras, i + 1);
        } else {
            return determinarletraImpar(letraImpar, agruparLetras, i + 1);

        }
    }

    public static String organizarPalabra(String primerMitad, String ultimaMitad, int i, String[] agruparLetras, int imparCantidad, char letraImpar) {
        if (agruparLetras[i] == null || (agruparLetras.length ) == 1) {
            return (imparCantidad == 1)  ? (primerMitad + letraImpar + ultimaMitad)   : (primerMitad + ultimaMitad);
        } else {
          System.out.println("pre:"+Arrays.toString(agruparLetras));

            String mitadLetrasAlmacenadas = "";
            mitadLetrasAlmacenadas = determinarLetras(agruparLetras, i, 0, "");
            primerMitad = primerMitad + mitadLetrasAlmacenadas;
            ultimaMitad = mitadLetrasAlmacenadas + ultimaMitad;
            return organizarPalabra(primerMitad, ultimaMitad, i + 1, agruparLetras, imparCantidad, letraImpar);
        }

    }

    private static String determinarLetras(String[] agruparLetras, int i, int posLetras, String mitadLetras) {
        if (posLetras < agruparLetras[i].length() / 2) {
            mitadLetras += String.valueOf(agruparLetras[i].charAt(0));
            return determinarLetras(agruparLetras, i, posLetras + 1, mitadLetras);
        } else {
            return mitadLetras;
        }
    }
}
