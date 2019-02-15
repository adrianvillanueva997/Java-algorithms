package src.tema1;

public class divisiones {

    public static int divisionEntera(int dividendo, int divisor) {
        int cociente = 0;
        if (dividendo == divisor) {
            cociente = 1;
            return cociente;
        } else {
            if (divisor > dividendo) {
                return cociente;
            }
            while (dividendo > 0) {
                dividendo -= divisor;
                cociente++;
            }
        }
        return cociente;
    }

    public static int divisionEnteraRec(int dividendo, int divisor) {
        if (dividendo == divisor) {
            return 1;
        } else {
            if (divisor > dividendo) {
                return 0;
            } else {
                return divisionEnteraRec(dividendo - divisor, divisor) + 1;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(divisionEntera(30, 2));
        System.out.println(divisionEnteraRec(30, 2));
    }
}
