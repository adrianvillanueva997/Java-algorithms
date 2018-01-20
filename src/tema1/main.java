/*
 * Copyright (C) 2018 Adrián Villanueva Martínez
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package tema1;

/**
 *
 * @author Adrián Villanueva Martínez
 */
public class main {

    //ejercicio 2 Codificar  una  función  que  determine  si  un  número  natural  es  o  no  un  número  primo. 
    //Calcular su complejidad de forma razonada.
    public static boolean esPrimo(int numero) {
        boolean primo = true;
        int contador = 2;
        int numeroArreglado = ((numero / 2) + 1);
        while ((contador != numeroArreglado) && (primo)) {
            if (numero % contador == 0) {
                primo = false;
            }
            contador++;
        }
        return primo;
    }

    //Codificar  una  función  que  calcule  el  producto  de  dos  matrices  cuadradas  de  orden  n  de números enteros. Calcular su complejidad de forma razonada.
    public static int[][] calcularMatriz(int[][] matrizA, int[][] matrizB) {
        int fila1 = matrizA.length;
        int columna1 = matrizA[0].length;
        int columna2 = matrizB[0].length;
        int[][] matrizResultado = new int[fila1][columna2];
        if (fila1 == columna2) {
            for (int i = 0; i < fila1; i++) {
                for (int j = 0; j < columna2; j++) {
                    for (int k = 0; k < columna1; k++) {
                        matrizResultado[i][j] += matrizA[i][k] * matrizB[k][j];
                    }
                }
            }
        } else {
            return matrizResultado;
        }
        return matrizResultado;
    }

    //ejercicio 4
    //Construir una función recursiva que determine si una cadena es un palíndromo. Calcular su complejidad de forma razonada, utilizando la correspondiente reducción.
    public static boolean esPalindromo(String palabra) {
        palabra = palabra.replace(" ", ""); //0(1)
        if (palabra.length() == 0 || palabra.length() == 1) {
            return true;
        }
        if (palabra.charAt(0) == palabra.charAt(palabra.length() - 1)) {
            return esPalindromo(palabra.substring(1, palabra.length() - 1));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(esPrimo(7));
        int[][] A = new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}};
        int[][] B = new int[][]{{3, 3, 3}, {4, 4, 4}, {5, 5, 5}};
        int[][] C;
        C = calcularMatriz(A, B);
        for (int i = 0; i < C.length; i++) {
            for (int j = 0; j < C.length; j++) {
                System.out.println(C[i][j]);
            }
        }
        String palabra = "nazi ni vida divinizan";
        System.out.println(esPalindromo(palabra));

        int[] lista = new int[]{1, 2, 3, 4, 5};
        for (int i = 0; i < lista.length; i++) {
            System.out.println(lista[i]);
        }
    }
}
