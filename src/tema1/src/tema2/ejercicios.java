package src.tema1.src.tema2;

public class ejercicios {

    public static int encontrarDesigual(int[] lista1, int[] lista2) {
        if (lista1.length == lista2.length) {
            int index = 0;
            boolean iguales = true;
            while (index < lista1.length && iguales) {
                if (lista1[index] != lista2[index]) {
                    iguales = false;
                } else {
                    index++;
                }
            }
            return index;
        } else {
            return -1;
        }
    }

    public static int encontrarDesigualRecursivo(int[] lista1, int[] lista2, int inicio, int fin) {
        if (lista1.length == lista2.length) {
            if (lista1[inicio] == lista2[inicio] && (inicio < fin)) {
                return encontrarDesigualRecursivo(lista1, lista2, inicio + 1, fin);
            } else {
                return inicio;
            }
        } else {
            return -1;
        }
    }

    public static int encontrarDesigualDyV(int[] lista1, int[] lista2, int inicio, int fin) {
        if (lista1.length == lista2.length) {
            int mitad = (inicio + fin) / 2;
            if (lista1[mitad] != lista2[mitad] || (inicio < fin)) {
                return mitad;
            } else {
                int mitadIzq, mitadDrch;
                mitadIzq = encontrarDesigualDyV(lista1, lista2, inicio, mitad - 1);
                mitadDrch = encontrarDesigualDyV(lista1, lista2, mitad + 1, fin);
                if (mitadDrch == -1 && mitadIzq == -1) {
                    return -1;
                } else {
                    if (mitadDrch != -1) {
                        return mitadDrch;
                    } else {
                        return mitadIzq;
                    }
                }
            }
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] lista2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] lista1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] lista3 = {1, 2, 23, 4, 15, 6, 7, 8, 9, 10};

        long startTime = System.nanoTime();
        encontrarDesigual(lista1, lista2);
        long endTime = System.nanoTime();
        System.out.println("1. That took " + (endTime - startTime) + " nanoseconds");


        startTime = System.nanoTime();
        encontrarDesigual(lista1, lista3);
        endTime = System.nanoTime();
        System.out.println("2. That took " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        encontrarDesigualRecursivo(lista1, lista2, 0, lista1.length - 1);
        endTime = System.nanoTime();
        System.out.println("3. That took " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        encontrarDesigualRecursivo(lista2, lista3, 0, lista3.length - 1);
        endTime = System.nanoTime();
        System.out.println("4. That took " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        encontrarDesigualDyV(lista1, lista2, 0, lista1.length - 1);
        endTime = System.nanoTime();
        System.out.println("5. That took " + (endTime - startTime) + " nanoseconds");

        startTime = System.nanoTime();
        encontrarDesigualDyV(lista2, lista3, 0, lista3.length - 1);
        endTime = System.nanoTime();
        System.out.println("6. That took " + (endTime - startTime) + " nanoseconds");


    }
}
