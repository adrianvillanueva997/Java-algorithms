package src.tema1;

public class cosas_arrays {

    public static boolean compararArrays(int[] lista1, int[] lista2, int index) {
        boolean igual = true;
        if (lista1.length == lista2.length) {
            if (igual && index < lista1.length) {
                if (lista1[index] == lista2[index]) {
                    return compararArrays(lista1, lista2, ++index);
                } else {
                    igual = false;
                    return igual;
                }
            }
        } else {
            igual = false;
            return igual;
        }
        return igual;
    }

    public static void main(String[] args) {
        int[] lista1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] lista2 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] lista3 = {1, 2, 3, 4, 1, 6, 7, 8, 9, 10};
        System.out.println(compararArrays(lista1, lista2, 0));

    }

}
