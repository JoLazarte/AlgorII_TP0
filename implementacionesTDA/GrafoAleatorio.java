package implementacionesTDA;
import auxiliares.Arista;
import interfaces.GrafoAleatorioTDA;


public class GrafoAleatorio implements GrafoAleatorioTDA{
    private Arista[] listaDeVertices;
    private int cantidadVertices;

    public void inicializarGrafo(int n) {
        cantidadVertices = n;
        listaDeVertices = new Arista[n];

    }

    public void agregarArista(int origen, int destino, double probabilidad) {
        Arista nueva = new Arista(destino, probabilidad);
        nueva.siguiente = listaDeVertices[origen];
        listaDeVertices[origen] = nueva;
    }

    public void eliminarArista(int origen, int destino, double probabilidad) {
        Arista actual = listaDeVertices[origen];
        Arista anterior = null;

        while (actual != null) {
            if (actual.destino == destino && actual.probabilidad == probabilidad) {
                if (anterior == null) {
                    // Es la primera arista de la lista
                    listaDeVertices[origen] = actual.siguiente;
                } else {
                    // Es una arista en el medio o final
                    anterior.siguiente = actual.siguiente;
                }
                System.out.println("Arista eliminada: (origen:" + origen + " →  destino:" + destino + " →  probabilidad:" + probabilidad + ")");
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }

        System.out.println("⚠️ Arista no encontrada: " + origen + " → " + destino);
    }


    public void mostrarGrafo() {
        for (int i = 0; i < cantidadVertices; i++) {
            System.out.print("🔵 Vertice " + i + ": ");
            Arista actual = listaDeVertices[i];
            while (actual != null) {
                System.out.print("→ (" + actual.destino + ", p=" + actual.probabilidad + ") ");
                actual = actual.siguiente;
            }
            System.out.println();
        }
    }
}

