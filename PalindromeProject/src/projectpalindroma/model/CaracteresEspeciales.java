package projectpalindroma.model;

public class CaracteresEspeciales {

    public static String[] ArregloTildes = {"", "", "", "", ""};
    public static char[] tildes = {'á', 'é', 'í', 'ó', 'ú'};
    public static char[] SinTildes = {'a', 'e', 'i', 'o', 'u'};

    private static String reemplazarChar(String palabra, char tilde, int i, char[] letras, char sintilde) {
        if (i > palabra.length() - 1) {
            palabra = modificarTilde(letras, tilde, 0, sintilde, "");
            return palabra;
        } else {
            letras[i] = palabra.charAt(i);
        }
        return reemplazarChar(palabra, tilde, i + 1, letras, sintilde);
    }

    private static String modificarTilde(char[] letras, char tilde, int i, char sintilde, String palabra) {
        if (i > letras.length - 1) {
            palabra = retornarLetras(letras, 0, "");
            return palabra;
        } else if (letras[i] == sintilde) {
            letras[i] = tilde;
            return modificarTilde(letras, tilde, letras.length, sintilde, palabra);
        }
        return modificarTilde(letras, tilde, i + 1, sintilde, palabra);

    }

    private static String retornarLetras(char[] letras, int i, String palabra) {
        if (i > letras.length - 1) {
            return palabra;
        } else {
            palabra += letras[i];
        }
        return retornarLetras(letras, i + 1, palabra);

    }

    public static String retornarTildes(String palabraOrganizada, int posArrays, int posPalabra) {
        if (posPalabra > palabraOrganizada.length() - 1) {
            return palabraOrganizada;
        } else {
            if (posArrays > ArregloTildes.length - 1) {
                return retornarTildes(palabraOrganizada, 0, posPalabra + 1);
            } else {

                if (ArregloTildes[posArrays].equals("") || ArregloTildes[posArrays].equals(" ")) {
                    return retornarTildes(palabraOrganizada, posArrays + 1, posPalabra);
                } else if (palabraOrganizada.charAt(posPalabra) == ArregloTildes[posArrays].charAt(0)) {
                    char[] letras = new char[palabraOrganizada.length()];
                    if (posArrays == 0) {
                        palabraOrganizada = reemplazarChar(palabraOrganizada, 'á', 0, letras, 'a');

                    } else if (posArrays == 1) {
                        palabraOrganizada = reemplazarChar(palabraOrganizada, 'é', 0, letras, 'e');

                    } else if (posArrays == 2) {
                        palabraOrganizada = reemplazarChar(palabraOrganizada, 'í', 0, letras, 'i');

                    } else if (posArrays == 3) {
                        palabraOrganizada = reemplazarChar(palabraOrganizada, 'ó', 0, letras, 'o');

                    } else if (posArrays == 4) {
                        palabraOrganizada = reemplazarChar(palabraOrganizada, 'ú', 0, letras, 'u');

                    }
                    ArregloTildes[posArrays] = ArregloTildes[posArrays].replaceFirst(String.valueOf(ArregloTildes[posArrays].charAt(0)), "");

                    return retornarTildes(palabraOrganizada, posArrays + 1, posPalabra);

                } else {
                    return retornarTildes(palabraOrganizada, posArrays + 1, posPalabra);

                }
            }
        }
    }

    public static String tratamientoTildes(String palabra, int pos, int posTildes) {
        if (posTildes > tildes.length - 1) {
            return palabra;
        } else {

            if (pos > palabra.length() - 1) {
                return tratamientoTildes(palabra, 0, posTildes + 1);
            } else if (palabra.charAt(pos) == tildes[posTildes]) {

                ArregloTildes[posTildes] += SinTildes[posTildes];

                palabra = palabra.replaceFirst(String.valueOf(palabra.charAt(pos)), String.valueOf(SinTildes[posTildes]));

                return tratamientoTildes(palabra, pos + 1, posTildes);

            } else {
                return tratamientoTildes(palabra, pos + 1, posTildes);

            }

        }

    }

    public static String tratamientoCondiciones(String texto, int pos, char[] split, int posSplit) {
        if (posSplit > split.length - 1) {
            return texto;
        } else {
            if (texto.contains(String.valueOf(split[posSplit]))) {
                texto = texto.replace(String.valueOf(split[posSplit]), "");
            } else {
                return tratamientoCondiciones(texto, pos, split, posSplit + 1);

            }
        }
        return tratamientoCondiciones(texto, pos, split, posSplit + 1);

    }

}
