package implementacionesTDA;

import auxiliares.Nodo;
import interfaces.PilaTDA;

public class PilaCapacLimImpl implements PilaTDA{
    
    private Nodo tope;
    private int capacidadMaxima;
    private int cantidadElementos;

    public PilaCapacLimImpl(int capacidadMaxima) {
        this.capacidadMaxima = capacidadMaxima;
        this.cantidadElementos = 0;
        this.tope = null;
    }

    @Override
    public void inicializarPila() {
        tope = null;
        cantidadElementos = 0;
    }

    @Override
    public void apilar(int x) {
        if (cantidadElementos >= capacidadMaxima) {
            throw new RuntimeException("Pila llena - capacidad máxima alcanzada");
        }
        Nodo nuevo = new Nodo(x);
        nuevo.siguiente = tope;
        tope = nuevo;
        cantidadElementos++;
        System.out.println("La nueva longitud de la pila es: " + cantidadElementos);
    }

    @Override
    public void desapilar() {
        if (pilaVacia()) {
            throw new RuntimeException("Pila vacía");
        }
        Nodo eliminar = tope;
            //asigno como primer nodo al siguiente de la  pila
            tope = tope.siguiente;
            eliminar.siguiente = null;
            cantidadElementos--;  //Decrementa el contador de la longitud de la pila
            System.out.println("La nueva longitud de la pila es: " + cantidadElementos);
    }

    @Override
    public int tope() {
        if (pilaVacia()) {
            throw new RuntimeException("Pila vacía");
        }
        return tope.valor;
    }

    @Override
    public boolean pilaVacia() {
        return tope == null;
    }
    
    public boolean pilaLlena() {
        return cantidadElementos >= capacidadMaxima;
    }
   
}

