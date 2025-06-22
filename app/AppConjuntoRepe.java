package app;

import implementacionesTDA.ConjuntoConRepetidos;

public class AppConjuntoRepe {
    public static void main(String[] args) {
        ConjuntoConRepetidos conjunto = new ConjuntoConRepetidos();
        conjunto.inicializar();

        conjunto.agregar(10);
        conjunto.agregar(5);
        conjunto.agregar(10);
        conjunto.agregar(7);
        conjunto.agregar(5);
        conjunto.agregar(5);

        conjunto.mostrar();

        conjunto.eliminar(5);  // Resta cantidad
        conjunto.eliminar(7);  // Elimina nodo (cantidad = 1)
        conjunto.eliminar(100); // No existe

        conjunto.mostrar();
    }
}
