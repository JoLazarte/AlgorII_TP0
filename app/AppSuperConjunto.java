package app;

import implementacionesTDA.SuperConjuntoImpl;

public class AppSuperConjunto {
     
    public static void main(String[] args) {
    // Ejemplo de uso de SuperConjunto
        System.out.println("\n=== SuperConjunto ===");
        SuperConjuntoImpl superConjunto = new SuperConjuntoImpl();
        superConjunto.inicializarConjunto();
        superConjunto.agregar(1);
        superConjunto.agregar(2);
        superConjunto.agregar(3);
        superConjunto.agregar(4);
        
        SuperConjuntoImpl subConjunto = new SuperConjuntoImpl();
        subConjunto.inicializarConjunto();
        subConjunto.agregar(1);
        subConjunto.agregar(2);
        
        System.out.println("Es subconjunto: " + superConjunto.esSubconjunto(subConjunto));

    }
}
