package src.Tema4;

import java.util.ArrayDeque;

import static src.Tema4.Grafo.profundidad;

public class Ejercicios {
    public static <Clave, Info, Coste> int contarAristas(Grafo<Clave, Info, Coste> grafo) {
        Lista<Clave> vertices = grafo.listaVertices();
        int contador = 0;
        for (int i = 1; i <= vertices.longitud(); i++) {
            Clave clave = vertices.consultar(i);
            if (grafo.gradoEntrada(clave) != 0 && grafo.gradoSalida(clave) == 0) {
                contador += 1;
            }
        }
        return contador;
    }

    public static <Clave, Info, Coste> int contarBucles(Grafo<Clave, Info, Coste> grafo) {
        Lista<Clave> vertices = grafo.listaVertices();
        int contador = 0;
        for (int i = 1; i <= vertices.longitud(); i++) {
            Clave clave = vertices.consultar(i);
            Lista<Clave> sucesores = grafo.listaSucesores(clave);
            if (sucesores.buscar(clave) != 0) {
                contador += 1;
            }
        }
        return contador;
    }

    public static <Clave, Info, Coste> void recAnchura(Grafo<Clave, Info, Coste> gr) {
        if (gr.esVacio()) {
            ArrayDeque<Clave> cola = new ArrayDeque<>();
            Lista<Clave> noVisitados = gr.listaVertices();
            Lista<Clave> sucesores = new Lista<>();
            Clave v;
            while (!noVisitados.esVacia()) {
                v = noVisitados.consultar(1);
                cola.add(v);
                while (!cola.isEmpty()) {
                    v = cola.pop();
                    if (noVisitados.buscar(v) != 0) {
                        System.out.println(v + " - ");
                        noVisitados.borrar(noVisitados.buscar(v));
                        sucesores = gr.listaSucesores(v);
                        for (int i = 0; i <= sucesores.longitud(); i++) {
                            cola.add(sucesores.consultar(i));
                        }
                    }
                }
            }
        }
    }


    public static void main(String[] args) {
        Grafo<String, String, Integer> grafoCiudades = new Grafo<String, String, Integer>();
        grafoCiudades.insertarVertice("BAR", "Barcelona");
        grafoCiudades.insertarVertice("MAD", "Madrid");
        grafoCiudades.insertarVertice("COR", "La Coru�a");
        grafoCiudades.insertarVertice("SEV", "Sevilla");
        grafoCiudades.insertarVertice("VAL", "Valencia");
        grafoCiudades.insertarVertice("BIL", "Bilbao");
        grafoCiudades.insertarVertice("CUE", "Cuenca");
        grafoCiudades.insertarVertice("JAE", "Jaen");

        grafoCiudades.insertarArista("COR", "BIL", 644);
        grafoCiudades.insertarArista("COR", "MAD", 609);

        grafoCiudades.insertarArista("BIL", "BAR", 620);
        grafoCiudades.insertarArista("BIL", "MAD", 395);

        grafoCiudades.insertarArista("BAR", "BIL", 620);
        grafoCiudades.insertarArista("BAR", "VAL", 649);

        grafoCiudades.insertarArista("MAD", "COR", 609);
        grafoCiudades.insertarArista("MAD", "VAL", 352);
        grafoCiudades.insertarArista("MAD", "SEV", 538);

        grafoCiudades.insertarArista("VAL", "MAD", 352);
        grafoCiudades.insertarArista("VAL", "SEV", 697);

        grafoCiudades.insertarArista("SEV", "MAD", 538);

        grafoCiudades.insertarArista("CUE", "JAE", 356);

        System.out.println(grafoCiudades);

        profundidad(grafoCiudades, "BAR");

        System.out.println("\n*** FIN ***");
        System.out.println(contarAristas(grafoCiudades));
        System.out.println(contarBucles(grafoCiudades));


    }
}
