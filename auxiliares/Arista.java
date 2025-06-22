package auxiliares;

public class Arista {
    public int destino;           // número del vértice al que apunta
    public double probabilidad;   // probabilidad asociada a esta arista
    public Arista siguiente;

    public Arista(int destino, double probabilidad) {
        this.destino = destino;
        this.probabilidad = probabilidad;
        this.siguiente = null;
    }
}

