package src.Tema3;

public class Ejercicios {
    //ArbolBin<Integer> arbolBin;

    public static int contarNodos(ArbolBin<Integer> arbolBin) {
        if (arbolBin.esVacio()) {
            return 0;
        } else {
            int nodosIzq = contarNodos(arbolBin.hijoIzquierdo());
            int nodosDrch = contarNodos(arbolBin.hijoDerecho());
            return 1 + nodosIzq + nodosDrch; //preorden (se suma la raiz antes)
        }
    }

    //funcion que devuelve para un arbol binario de numeros enteros, la suma de todos sus nodos
    // aka la suma de todos los numeros contenidos en los nodos del arbol
    public static int sumarNodos(ArbolBin<Integer> arbolBin) {
        if (arbolBin.esVacio()) {
            return 0;
        } else {
            return arbolBin.raiz() + sumarNodos(arbolBin.hijoDerecho()) + sumarNodos(arbolBin.hijoIzquierdo());
        }
    }

    public static int contarParesNodo(ArbolBin<Integer> arbolBin) {
        if (arbolBin.esVacio()) {
            return 0;
        } else {
            if (arbolBin.raiz() % 2 == 0) {
                return 1 + contarNodos(arbolBin.hijoDerecho()) + contarNodos(arbolBin.hijoIzquierdo());
            } else {
                return contarNodos(arbolBin.hijoDerecho()) + contarNodos(arbolBin.hijoIzquierdo());
            }
        }
    }

    public static int contarNodosHoja(ArbolBin<Integer> arbolBin) {
        if (arbolBin.esVacio()) {
            return 0;
        } else {
            if (arbolBin.hijoDerecho().esVacio() && arbolBin.hijoIzquierdo().esVacio()) {
                return 1;
            } else {
                return contarNodosHoja(arbolBin.hijoIzquierdo()) + contarNodosHoja(arbolBin.hijoDerecho());

            }
        }
    }

    public static boolean compararArboles(ArbolBin<Integer> arbol1, ArbolBin<Integer> arbol2) {
        if (arbol1.esVacio() && arbol2.esVacio()) {
            return true;
        } else if (arbol1.esVacio() || arbol2.esVacio()) {
            return false;
        } else {
            if (!arbol1.raiz().equals(arbol2.raiz())) {
                return false;
            } else {
                return compararArboles(arbol1.hijoIzquierdo(), arbol2.hijoIzquierdo())
                        && compararArboles(arbol1.hijoDerecho(), arbol2.hijoDerecho());
            }
        }

    }

    public static void main(String[] args) {
        //ArbolBin<Integer> g = new ArbolBin<Integer>(new ArbolBin<Character>(),'G',new ArbolBin<Character>());
        ArbolBin<Integer> d = new ArbolBin<Integer>(new ArbolBin<Integer>(), 4, new ArbolBin<Integer>());
        ArbolBin<Integer> f = new ArbolBin<Integer>(new ArbolBin<Integer>(), 6, new ArbolBin<Integer>());
        //ArbolBin<Character> e = new ArbolBin<Character>(new ArbolBin<Character>(),'E',f);
        ArbolBin<Integer> e = new ArbolBin<Integer>(new ArbolBin<Integer>(), 5, f);
        ArbolBin<Integer> b = new ArbolBin<Integer>(d, 2, new ArbolBin<Integer>());
        ArbolBin<Integer> c = new ArbolBin<Integer>(e, 3, new ArbolBin<Integer>());
        ArbolBin<Integer> a = new ArbolBin<Integer>(b, 1, c);
        a.dibujar(1);
        System.out.println("Numero de nodos: " + contarNodos(a));
        System.out.println("Suma de los nodos: " + sumarNodos(a));
        System.out.println("Suma de los nodos pares:" + contarParesNodo(a));
        System.out.println("Suma de los nodos hoja: " + contarNodosHoja(a));

    }

}
