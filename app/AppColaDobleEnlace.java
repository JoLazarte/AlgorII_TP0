package app;

import implementacionesTDA.ColaDobleEnlaceImpl;

public class AppColaDobleEnlace {
    public static void main(String[] args) {
         // Ejemplo de uso de Cola cíclica
        System.out.println("\n=== Cola cíclica doblemente enlazada ===");
        ColaDobleEnlaceImpl cola = new ColaDobleEnlaceImpl();
        cola.inicializarCola();
        cola.acolar(1);
        cola.acolar(2);
        cola.acolar(3);
        System.out.println("Primero: " + cola.primero());
        System.out.println("Último: " + cola.ultimo());
        System.out.println("Tamaño: " + cola.cantidadDeElementos());
    }
}
