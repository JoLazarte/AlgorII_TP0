package app;

import implementacionesTDA.GrafoAleatorio;

public class AppGrafoAleatorio {
    public static void main(String[] args) {
        GrafoAleatorio grafo = new GrafoAleatorio();
        grafo.inicializarGrafo(5); // vértices 0 al 4

        grafo.agregarArista(0, 1, 0.5);
        grafo.agregarArista(0, 2, 0.8);
        grafo.agregarArista(1, 3, 0.4);
        grafo.agregarArista(2, 4, 0.9);
        grafo.agregarArista(4, 0, 0.3);
        grafo.agregarArista(1,3,0.2);

        grafo.mostrarGrafo();

        grafo.eliminarArista(1,3,0.4);

        grafo.mostrarGrafo();
    }
}
