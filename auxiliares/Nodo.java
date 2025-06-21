package auxiliares;

public class Nodo {

    public int valor;
    public Nodo siguiente;
    public Nodo anterior;
    
    public Nodo(int valor) {
        this.valor = valor;
        this.siguiente = null;
        this.anterior = null;
    }
}