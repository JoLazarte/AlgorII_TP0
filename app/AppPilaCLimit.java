package app;

import implementacionesTDA.PilaCapacLimImpl;

public class AppPilaCLimit {
    public static void main(String[] args) {
        // Ejemplo de uso de Pila con capacidad limitada
        System.out.println("=== Pila con capacidad limitada ===");
        PilaCapacLimImpl pila = new PilaCapacLimImpl(3);
        pila.inicializarPila();
        pila.apilar(1);
        pila.apilar(2);
        pila.apilar(3);
        System.out.println("Tope: " + pila.tope());
        
        
    
        
    }
}
