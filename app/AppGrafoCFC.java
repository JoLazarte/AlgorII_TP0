package app;
import java.util.*;

import grafos.GrafoCFC;

public class AppGrafoCFC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // === EJEMPLO HARDCODEADO ===

        int nodos = 7;
        int aristas = 7;
        int[][] aux = {
                {0, 1},
                {1, 2},
                {2, 0},
                {3, 4},
                {4, 5},
                {5, 3},
                {6, 6}
        };

        /* PARA PROBAR INGRESO DE DATOS MARCAR COMO COMENTARIO EL EJEMPLO PROPUESTO ARRIBA
        int respuesta = -1;

        // === PREGUNTA SI ES DIRIGIDO ===
        while (respuesta != 0 && respuesta != 1) {
            System.out.print("¿El grafo es dirigido? (1 = sí, 0 = no): ");
            respuesta = sc.nextInt();
            if (respuesta != 0 && respuesta != 1) {
                System.out.println("Respuesta no válida. Ingrese 1 para sí o 0 para no.");
            }
        }

        if (respuesta == 0) {
            System.out.println("El programa solo funciona con grafos dirigidos.");
            return;
        }

        // === PROBAR INGRESO DE DATOS ===
        int nodos;
        int aristas;

        System.out.print("Ingrese la cantidad de nodos: ");
        nodos = sc.nextInt();

        System.out.println("Ingrese la cantidad de aristas:");
        aristas = sc.nextInt();

        int[][] aux = new int[aristas][2];
        System.out.println("Ingrese cada arista como: origen destino");

        for (int i = 0; i < aristas; i++) {
            int origen = sc.nextInt();
            int destino = sc.nextInt();
            aux[i][0] = origen;
            aux[i][1] = destino;
        }
       */
        // === ESTRUCTURA DEL GRAFO ===
        int[] grados = new int[nodos];
        for (int i = 0; i < aristas; i++) {
            grados[aux[i][0]]++;
        }

        int[][] grafo = new int[nodos][];
        for (int i = 0; i < nodos; i++) {
            grafo[i] = new int[grados[i]];
        }

        int[] indices = new int[nodos];
        for (int i = 0; i < aristas; i++) {
            int origen = aux[i][0];
            int destino = aux[i][1];
            grafo[origen][indices[origen]] = destino;
            indices[origen]++;
        }

        // === PROCESO PRINCIPAL ===
        int[][][] componentes = GrafoCFC.obtenerComponentesFuertementeConexas(grafo, nodos);

        for (int i = 0; i < componentes.length; i++) {
            System.out.print("Componente " + (i + 1) + ": ");
            for (int j = 0; j < componentes[i].length; j++) {
                System.out.print(componentes[i][j][0] + " ");
            }
            System.out.println();
        }
    }
}
