package src.Tema5;

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
        if (sinSolucion) {
            solucion[0] = -1;
        }
        return solucion;
    }

    public static void main(String[] args) {
        float[] monedas = {2f, 1f, 0.5f, 0.20f, 0.10f, 0.05f, 0.02f, 0.01f};
        float cantidad = 11.30f;
        int[] cambio = funcionCambio(monedas, cantidad);
        if (cambio[0] == -1) {
            System.out.println("No hay solucion");
        } else {
            for (int i = 0; i < cambio.length; i++) {
                System.out.println("Monedas de " + monedas[i] + "€ : " + cambio[i]);
            }
        }
    }
}
