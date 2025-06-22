package grafosCFC;
public class GrafoCFC {

    // Encuentra todas las componentes fuertemente conexas
    public static int[][][] obtenerComponentesFuertementeConexas(int[][] grafo, int nodos) {
        boolean[] procesado = new boolean[nodos];
        int[][][] resultadoTemp = new int[nodos][nodos][1];
        int contadorComponentes = 0;

        for (int i = 0; i < nodos; i++) {
            if (!procesado[i]) {
                boolean[] puedeIr = new boolean[nodos];
                boolean[] puedeVolver = new boolean[nodos];

                recorridoNodo(grafo, i, puedeIr);
                recorridoNodoInverso(grafo, i, puedeVolver, nodos);

                int cantidad = 0;
                for (int j = 0; j < nodos; j++) {
                    if (puedeIr[j] && puedeVolver[j]) {
                        resultadoTemp[contadorComponentes][cantidad][0] = j;
                        procesado[j] = true;
                        cantidad++;
                    }
                }

                int[][] componente = new int[cantidad][1];
                for (int j = 0; j < cantidad; j++) {
                    componente[j][0] = resultadoTemp[contadorComponentes][j][0];
                }

                resultadoTemp[contadorComponentes] = componente;
                contadorComponentes++;
            }
        }

        int[][][] resultadoFinal = new int[contadorComponentes][][];
        for (int i = 0; i < contadorComponentes; i++) {
            resultadoFinal[i] = resultadoTemp[i];
        }

        return resultadoFinal;
    }

    // Marca todos los nodos alcanzables desde un nodo (recorrido normal)
    public static void recorridoNodo(int[][] grafo, int nodo, boolean[] visitado) {
        visitado[nodo] = true;
        for (int i = 0; i < grafo[nodo].length; i++) {
            int destino = grafo[nodo][i];
            if (!visitado[destino]) {
                recorridoNodo(grafo, destino, visitado);
            }
        }
    }

    // Marca todos los nodos que pueden llegar al nodo dado (recorrido inverso)
    public static void recorridoNodoInverso(int[][] grafo, int nodo, boolean[] visitado, int nodos) {
        for (int i = 0; i < nodos; i++) {
            for (int j = 0; j < grafo[i].length; j++) {
                if (grafo[i][j] == nodo && !visitado[i]) {
                    visitado[i] = true;
                    recorridoNodoInverso(grafo, i, visitado, nodos);
                    break;
                }
            }
        }
        visitado[nodo] = true;
    }
}

