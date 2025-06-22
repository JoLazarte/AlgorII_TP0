package auxiliares;

public class Nodo {
    public int valor;
    public int cantidad;
    public Nodo siguiente;

    public Nodo(int valor) {
        this.valor = valor;
        this.cantidad = 1;
        this.siguiente = null;
    }
}

