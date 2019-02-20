package src.tema1;

public class divisiones {
    public static int pasos = 0;
    public static int memoria = 0;

    public static void paso() {
        pasos++;
    }

    public static void resetPasos() {
        pasos = 0;
    }

    public static void memo() {
        memoria++;
    }

    public static void resetMemoria() {
        memoria = 0;
    }

    public static void imprimirPasos() {
        System.out.println("[INFO] Pasos: " + pasos);
    }

    public static void imprimirMemoria() {
        System.out.println("[INFO] Memoria : " + memoria);
    }

    public static int divisionEntera(int dividendo, int divisor) {
        int cociente = 0;
        memo();
        memo();
        paso();
        paso();//declaracion y asignacion
        paso();
        if (dividendo == divisor) {
            cociente = 1;
            paso();
            paso();
            return cociente;
        } else {
            paso();
            if (divisor > dividendo) {
                paso();
                return cociente;
            }
            while (dividendo > 0) {
                paso();
                paso(); //asignacion del dividendo
                paso(); //resta del divisor
                paso(); //suma del cociente
                dividendo -= divisor;
                cociente++;
            }
            paso();
        }
        paso();
        return cociente;
    }

    public static int divisionEnteraRec(int dividendo, int divisor) {
        paso();
        memo();
        memo();
        if (dividendo == divisor) {
            paso();
            return 1;
        } else {
            paso();
            if (divisor > dividendo) {
                paso();
                return 0;
            } else {
                paso();
                paso();
                paso();
                return divisionEnteraRec(dividendo - divisor, divisor) + 1;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(divisionEntera(100, 2));
        imprimirPasos();
        resetPasos();
        imprimirMemoria();
        resetMemoria();
        System.out.println(divisionEnteraRec(100, 2));
        imprimirPasos();
        imprimirMemoria();
        resetPasos();
        resetMemoria();
    }
}
