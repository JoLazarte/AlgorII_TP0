package implementacionesTDA;

import auxiliares.Nodo;
import interfaces.ConjuntoTDA;

public class SuperConjuntoImpl implements ConjuntoTDA {

    private Nodo primero;


    @Override
    public void inicializarConjunto() {
        primero = null;
    }

    @Override
    public void agregar(int x) {

        Nodo nuevo = new Nodo(x);
        if(primero == null){ //this.conjuntoVacio()
            primero = nuevo;

        }
        if(pertenece(x)){ //uniqueness of the elements
            nuevo = null;
        }
        Nodo current = primero; 
        while(current.siguiente != null){
            current = current.siguiente;
        }
        current.siguiente = nuevo;
    }

    @Override
    public int elegir() {
        if (conjuntoVacio()) {
            throw new RuntimeException("Conjunto vacío");
        }
        return primero.valor;
    }
    
    @Override
    public void sacar(int x) {
        if(primero != null) {
            if(primero.valor == x) {
                primero = primero.siguiente;
            }
            Nodo current = primero; //x is somewhere btw the set
            Nodo anterior = null;
            while(current != null ){
                if(current.valor == x && anterior != null){ //find the node
                    anterior.siguiente = current.siguiente; //previous' next  becomes current's next
                }
                anterior = current; //update pointers
                current = current.siguiente;
            }
        }
    }

    @Override
    public boolean pertenece(int x) {
        if (primero != null) { //this.conjuntoVacio()
            Nodo current = primero;
        //move till the end of the set
            while (current != null) {
                if (current.valor == x) {
                    return true;
                }
                current = current.siguiente;
            }
         }//value not found:
        return false;
    }

    @Override
    public boolean conjuntoVacio() {
        return primero == null;
    }
    
     // Método específico: verificar si un conjunto es subconjunto
    public boolean esSubconjunto(ConjuntoTDA conjunto) {
        // Crear una copia del conjunto para no modificar el original
        ConjuntoTDA copia = new SuperConjuntoImpl();
        copia.inicializarConjunto();
        
        // Copiar elementos del conjunto original
        while (!conjunto.conjuntoVacio()) {
            int elemento = conjunto.elegir();
            copia.agregar(elemento);
            conjunto.sacar(elemento);
        }
        
        // Verificar si todos los elementos de la copia están en este superconjunto
        boolean esSubconjunto = true;
        while (!copia.conjuntoVacio() && esSubconjunto) {
            int elemento = copia.elegir();
            if (!this.pertenece(elemento)) {
                esSubconjunto = false;
            }
            conjunto.agregar(elemento); // Restaurar elemento original
            copia.sacar(elemento);
        }
        
        return esSubconjunto;
    }
    
    // Método específico: calcular complemento
    public ConjuntoTDA complemento(ConjuntoTDA conjunto) {
        if (!esSubconjunto(conjunto)) {
            throw new RuntimeException("El conjunto no es subconjunto del superconjunto");
        }
        
        ConjuntoTDA complemento = new SuperConjuntoImpl();
        complemento.inicializarConjunto();
        
        // Agregar al complemento todos los elementos del superconjunto que no están en el conjunto
        Nodo actual = primero;
        while (actual != null) {
            if (!conjunto.pertenece(actual.valor)) {
                complemento.agregar(actual.valor);
            }
            actual = actual.siguiente;
        }
        
        return complemento;
    }
    
}
