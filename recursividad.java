import com.sun.media.sound.SimpleSoundbank;

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
            System.out.println("");
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
        if (lista.length == 1 && lista[0] == n) {
            return true;
        }
        if (lista.length < index) {
            if (lista[index] == n) {
                return true;
            } else {
                buscarRecursivo(lista, n, index + 1);
            }
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        // int resultado = 0;
        // resultado = potencia(2, 2);
        // System.out.println(resultado);
        asterisco(0);
        asteriscoPiramidal(5);
        asteriscoPiramidal2(5);
        int[] lista = { 1, 2, 3, 4, 5, 6 };
        System.out.println(buscarRecursivo(lista, 2, 0));
    }
}
