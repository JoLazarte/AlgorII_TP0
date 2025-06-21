package interfaces;

public interface ConjuntoTDA {
    void inicializarConjunto();
    void agregar(int x);
    int elegir();
    void sacar(int x);
    boolean pertenece(int x);
    boolean conjuntoVacio();
}