package ImplementacionesTDA;
import interfaces.ConjuntoRepetidosTDA;
import auxiliares.Nodo;


public class ConjuntoConRepetidos implements ConjuntoRepetidosTDA{
    private Nodo inicio;
    public void inicializar() {
        inicio = null;
    }

    public void agregar(int x) {
        Nodo actual = inicio;
        while (actual != null) {
            if (actual.valor == x) {
                actual.cantidad++; // Si ya existe, incrementa la cantidad
                return;
            }
            actual = actual.siguiente;
        }

        // Si no existe, crea un nuevo nodo al inicio
        Nodo nuevo = new Nodo(x);
        nuevo.siguiente = inicio;
        inicio = nuevo;
    }

    public void mostrar() {
        System.out.println(" Contenido del conjunto con repetidos:");
        Nodo actual = inicio;
        while (actual != null) {
            System.out.println("Valor: " + actual.valor + " - Cantidad: " + actual.cantidad);
            actual = actual.siguiente;
        }
    }

    public void eliminar(int x) {
        Nodo actual = inicio;
        Nodo anterior = null;

        while (actual != null) {
            if (actual.valor == x) {
                if (actual.cantidad > 1) {
                    actual.cantidad--;
                } else {
                    // Eliminar el nodo
                    if (anterior == null) {
                        inicio = actual.siguiente;
                    } else {
                        anterior.siguiente = actual.siguiente;
                    }
                }
                return;
            }
            anterior = actual;
            actual = actual.siguiente;
        }

        System.out.println(" El valor no se encontró en el conjunto.");
    }
}

