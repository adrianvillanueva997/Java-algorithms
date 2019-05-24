package src.Tema5;

import java.util.ArrayList;

public class Avance_Rapido {

    public static int seleccionar(float[] monedas, float cantidad, float acumulado) {
        int cont = 0;
        int valor = -1;
        boolean salir = false;
        while ((cont < monedas.length) && !salir) {
            if (acumulado + monedas[cont] <= cantidad) {
                salir = true;
                valor = cont;
            }
            cont++;
        }
        return valor;

    }

    public static int[] funcionCambio(float[] monedas, float cantidad) {
        int[] solucion = new int[monedas.length];
        for (int i = 0; i < solucion.length; i++) {
            solucion[i] = 0;
        }
        float acumulado = 0.0f;
        boolean sinSolucion = false;
        while ((acumulado != cantidad) && !sinSolucion) {
            int x = seleccionar(monedas, cantidad, acumulado);
            if (x == -1) {
                sinSolucion = true;
            } else {
                acumulado = acumulado + monedas[x];
                solucion[x]++;
            }
        }
        if (!sinSolucion) {
            int[] sinSol = new int[]{-1};
            return sinSol;
        }
        return solucion;
    }

    public static void main(String[] args) {

    }

}
