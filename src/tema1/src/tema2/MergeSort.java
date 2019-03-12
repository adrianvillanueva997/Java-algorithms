package src.tema1.src.tema2;

public class MergeSort {
    public static void mergeSort(int[] lista, int inicio, int fin) {
        if (inicio < fin) {
            int medio = (inicio + fin) / 2;
            int[] listaIzq = new int[lista.length + 1], listaDrch = new int[lista.length + 1];
            for (int i = inicio; i <= medio; i++) {
                listaIzq[i] = lista[i];
            }
            for (int i = (medio + 1); i <= fin; i++) {
                listaDrch[i] = lista[i];
            }
            mergeSort(listaIzq, inicio, medio);
            mergeSort(listaDrch, medio + 1, fin);
            merge(listaIzq, listaDrch, lista, inicio, medio, fin);
        }
    }

    public static void merge(int[] listaIzq, int[] listaDrch, int[] lista, int inicio, int medio, int fin) {
        listaIzq[medio + 1] = Integer.MAX_VALUE;
        listaDrch[fin + 1] = Integer.MAX_VALUE;
        int i = inicio;
        int j = medio + 1;
        for (int index = inicio; index <= fin; index++) {
            if (listaIzq[i] < listaDrch[j]) {
                lista[index] = listaIzq[i];
                i++;
            } else {
                lista[index] = listaDrch[j];
                j++;
            }

        }

    }

    public static void main(String[] args) {
        int[] lista = {5, 6, 1, 9};
        mergeSort(lista, 0, lista.length - 1);
        for (int i : lista) {
            System.out.print(i + ", ");
        }
    }
}
