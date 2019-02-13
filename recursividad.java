import java.util.ArrayList;

public class recursividad {
    public static int potencia(int b, int e) {
        if (e == 0) {
            return 1;
        } else {
            return b * potencia(b, e - 1);
        }
    }

    // funcion recursiva a la que le pasas un numero n e imprime n asteriscos
    public static void asterisco(int n) {
        if (n > 0) {
            System.out.print("*");
            asterisco(n - 1);
        }
    }

    /*
     */
    public static void asteriscoPiramidal(int n) {
        if (n > 0) {
            for (int i = 0; i < n; i++) {
                System.out.print("*");
            }
            System.out.println();
            asteriscoPiramidal(n - 1);
        }
    }

    public static void asteriscoPiramidal2(int n) {
        if (n > 0) {
            asterisco(n);
            System.out.println();
            asteriscoPiramidal2(n - 1);
        }
    }

    public static boolean buscarRecursivo(int[] lista, int n, int index) {
        boolean encontrado = false;
        if (lista.length == 1 && lista[index] == n) {
            encontrado = true;
        } else {
            if (!encontrado && lista.length > index) {
                if (lista[index] == n) {
                    encontrado = true;
                } else {
                    buscarRecursivo(lista, n, ++index);
                }
            }
        }
        return encontrado;
    }

    public static ArrayList<Integer> devolverPares(int[] lista, int index, ArrayList<Integer> listaPar) {
        if (lista.length == 1) {
            if (lista[index] % 2 == 0) {
                listaPar.add(lista[index]);
                return listaPar;
            } else {
                return listaPar;
            }
        } else {
            if (lista.length > index) {
                if (lista[index] % 2 == 0) {
                    listaPar.add(lista[index]);
                }
                devolverPares(lista, ++index, listaPar);
            }
        }
        return listaPar;
    }

    public static void main(String[] args) {
        asterisco(0);
        asteriscoPiramidal(5);
        asteriscoPiramidal2(5);
        int[] lista = {1, 2, 3, 4, 5, 6};
        System.out.println(buscarRecursivo(lista, 1, 0));
        ArrayList<Integer> lista3;
        ArrayList<Integer> lista4 = new ArrayList<>();
        lista3 = devolverPares(lista, 0, lista4);
        for (Integer numero : lista3) {
            System.out.println(numero);
        }
    }
}
