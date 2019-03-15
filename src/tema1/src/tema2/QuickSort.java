package src.tema1.src.tema2;

public class QuickSort {
    public static int pivotar(int[] lista, int inicio, int fin) {
        int i = inicio;
        int p = lista[i];
        for (int j = inicio + 1; j <= fin; j++) {
            if (lista[j] <= p) {
                i++;
                if (i != j) {
                    int swap = lista[i];
                    lista[i] = lista[j];
                    lista[j] = swap;
                }
            }
        }
        int swap = lista[inicio];
        lista[inicio] = lista[i];
        lista[i] = swap;
        return i;
    }

    public static int seleccion(int[] lista, int k) {
        int inicio = 1;
        int fin = lista.length - 1;
        int x = pivotar(lista, inicio, fin);
        while (k != x) {
            if (x > k) {
                fin = x - 1;
            } else {
                inicio = x + 1;
            }
            x = pivotar(lista, inicio, fin);
        }
        return lista[x];
    }

    public static void quickSort(int[] lista, int inicio, int fin) {
        if (inicio < fin) {
            int x = pivotar(lista, inicio, fin);
            quickSort(lista, inicio, x - 1);
            quickSort(lista, x + 1, fin);
        }
    }

    public static void main(String[] args) {
        int[] lista = {3, 41, 10, 9, 18, 20, 5, 2, 0};
        quickSort(lista, 0, lista.length - 1);
        for (int i : lista) {
            System.out.print(i + ", ");
        }
        System.out.println("\nSeleccion");
        int[] lista2 = {3, 41, 10, 9, 18, 20, 5, 2, 0};
        System.out.println(seleccion(lista2, 1));

    }
}
