package interfaces;

public interface GrafoAleatorioTDA {
    void inicializarGrafo(int n);
    void agregarArista(int origen,int destino, double probabilidad);
    void eliminarArista(int origen, int destino, double probabilidad);
    void mostrarGrafo();

}
