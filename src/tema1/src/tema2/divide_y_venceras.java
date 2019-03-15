package src.tema1.src.tema2;

public class divide_y_venceras {

    public static int maximoDyV(int[] array, int inicio, int fin) {
        if (inicio == fin) {
            return array[inicio];
        } else {
            int mitad = (inicio + fin) / 2;
            int maximoIzq = maximoDyV(array, inicio, mitad);
            int maximoDrcha = maximoDyV(array, mitad + 1, fin);
            if (maximoIzq > maximoDrcha) {
                return maximoIzq;
            } else {
                return maximoDrcha;
            }
        }
    }

    //la lista tiene que estar previamente ordenada
    public static int busquedaBinaria(int[] array, int dato, int inicio, int fin) {
        if (array[inicio] > dato || array[fin] < dato || array.length == 0)
            return -1;
        else {
            if (inicio > fin) {
                return -1;
            } else {
                int mitad = (inicio + fin) / 2;
                if (array[mitad] == dato) {
                    return mitad;
                } else {
                    if (array[mitad] > dato) {
                        return busquedaBinaria(array, dato, inicio, mitad - 1);
                    } else {
                        return busquedaBinaria(array, dato, mitad + 1, fin);
                    }

                }

            }
        }
    }

    public static void escribirArray(int[] array, int inicio, int fin) {
        if (inicio == fin) {
            System.out.println(array[inicio]);
        } else {
            int mitad = (inicio + fin) / 2;
            escribirArray(array, inicio, mitad);
            escribirArray(array, mitad + 1, fin);
        }
    }

    public static boolean compararArrays(int[] array1, int[] array2, int inicio, int fin) {
        if (array1.length == array2.length) {
            int mitad = (inicio + fin) / 2;
            if (array1[mitad] != array2[mitad]) {
                return false;
            } else {
                if (inicio > fin) {
                    return true;
                } else {
                    return compararArrays(array1, array2, inicio, mitad - 1)
                            && compararArrays(array1, array2, mitad + 1, fin);
                }
            }
        } else {
            return false;
        }
    }

    public static boolean compararMatrices(int[][] lista1, int[][] lista2, int inicio, int fin) {
        if (inicio == fin) {
            int columna = 0;
            boolean iguales = true;
            while (columna < lista1.length && iguales) {
                iguales = (lista1[inicio][columna] == lista2[inicio][columna]);
                columna++;
            }
            return iguales;
        } else {
            int mitad = (inicio + fin) / 2;
            return (compararMatrices(lista1, lista2, inicio, mitad)
                    && compararMatrices(lista1, lista2, mitad + 1, fin));
        }

    }


    public static void main(String[] args) {
        int[] lista = {10, 21, 42, 63, 84, 55, 46, 7};
        int[] lista2 = {21, 32, 43, 10, 66, 90, 23};
        int[] lista3 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] lista4 = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[][] lista5 = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int[][] lista6 = {{1, 2, 3}, {4, 15, 6}, {7, 8, 9}};

        System.out.println(maximoDyV(lista, 0, lista.length - 1));
        System.out.println(maximoDyV(lista2, 0, lista2.length - 1));
        System.out.println(busquedaBinaria(lista3, 10, 0, lista3.length - 1));
        escribirArray(lista3, 0, lista3.length - 1);

        System.out.println(compararArrays(lista3, lista4, 0, lista3.length - 1));

        System.out.println(compararMatrices(lista5, lista5, 0, lista5.length - 1));
        System.out.println(compararMatrices(lista5, lista6, 0, lista5.length - 1));

    }
}
