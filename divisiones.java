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
            } else if (dividendo > 0) {
                return divisionEntera(dividendo - divisor, divisor) + 1;
            }
        }
        return 1;
    }

    public static int interfazDivisiorRecursiva() {
        int cociente = divisionEnteraRec(30, 5);
        return cociente;
    }

    public static void main(String[] args) {
        System.out.println(divisionEntera(30, 2));
        System.out.println(interfazDivisiorRecursiva());
    }
}
