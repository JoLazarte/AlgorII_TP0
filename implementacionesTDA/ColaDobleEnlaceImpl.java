package implementacionesTDA;

import auxiliares.Nodo;
import interfaces.ColaTDA;

public class ColaDobleEnlaceImpl implements ColaTDA {
    
    private Nodo cabeza;
    private Nodo ultimo;
    private int cantidadDeElementos;

    @Override
    public void inicializarCola() {
        cabeza = null;
        ultimo = null;
        cantidadDeElementos = 0;
    }

    @Override
    public void acolar(int x) {
        Nodo nuevo = new Nodo(x);
        //agrego el valor al  nuevo nodo
        if(colaVacia()){ //ultimo = cabeza = null
            cabeza=nuevo;
            ultimo=nuevo;
        } else {
            ultimo.siguiente = nuevo;
            nuevo.anterior = ultimo;
            ultimo = nuevo;
        }
        cantidadDeElementos++;
    }

    @Override
    public void desacolar() {
        if(cabeza == ultimo){
            cabeza = null;
            ultimo = null;
        }
        Nodo eliminar = cabeza;
        cabeza = cabeza.siguiente;
        cabeza.anterior = null;
        eliminar.siguiente = null;
        
        System.out.println("El ultimo Nodo tiene apunta a : " + ultimo.anterior + "y a :" + ultimo.siguiente );     
        cantidadDeElementos--;
    }

    @Override
    public int primero() {
        if(cabeza==null){
            return  0;
        } else {
            return cabeza.valor;
        }
    }

    @Override
    public boolean colaVacia() {
        return cabeza==null;
    }

    // Método para acceder al último elemento eficientemente
    public int ultimo() {
        if (colaVacia()) {
            throw new RuntimeException("Cola vacía");
        }
        return ultimo.valor;
    }
    
    // Método para obtener el tamaño eficientemente
    public int cantidadDeElementos() {
        return cantidadDeElementos;
    }

}
