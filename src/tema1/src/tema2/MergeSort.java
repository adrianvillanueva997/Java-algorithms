package src.tema1.src.tema2;

public class MergeSort {
    public static int[] mergeSort(int[] lista, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            int[] listaIzq = new int[lista.length + 1], listaDrch = new int[lista.length + 1];
            for (int i = inicio; i < medio; i++) {
                listaIzq[i] = lista[i];
            }
            for (int i = medio + 1; i < fin; i++) {
                listaDrch[i] = lista[i];
            }
            mergeSort(listaIzq, inicio, medio);
            mergeSort(listaDrch, medio + 1, fin);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] lista = {3, 4, 6, 1};
        mergeSort(lista, 0, lista.length - 1);
    }
}
