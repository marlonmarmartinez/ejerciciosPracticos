package ejerciciospracticas3;

import java.util.Arrays;

public class NailingPlanks {

    public static void main(String[] args) {
        int[] A = new int[4];
        int[] B = new int[4];
        int[] C = new int[5];
        A[0] = 1;
        B[0] = 4;
        A[1] = 4;
        B[1] = 5;
        A[2] = 5;
        B[2] = 9;
        A[3] = 8;
        B[3] = 10;

        C[0] = 4;
        C[1] = 6;
        C[2] = 7;
        C[3] = 10;
        C[4] = 2;
        
        System.out.println(solution(A, B, C));
    }

    public static int solution(int[] A, int[] B, int[] C) {
        // el algoritmo principal es que obteniendo el índice mínimo de clavos que
        // es necesario para clavar cada tabla utilizando la búsqueda binaria
        int N = A.length;
        int M = C.length;
        // matriz de dos dimensiones para guardar el índice original de la matriz C
        int[][] sortedNail = new int[M][2];
        for (int i = 0; i < M; i++) {
            sortedNail[i][0] = C[i];
            sortedNail[i][1] = i;
        }
        // usa la expresión lambda para ordenar la matriz de dos dimensiones
        Arrays.sort(sortedNail, (int x[], int y[]) -> x[0] - y[0]);
        int result = 0;
        for (int i = 0; i < N; i++) { // encuentre la posición en la lista de orejas que puede clavar cada tabla, y el valor máximo para todas las tablas es el resultado
            result = getMinIndex(A[i], B[i], sortedNail, result);
            if (result == - 1) {
                return - 1;
            }
        }
        return result + 1;
    }

    // para cada tabla, podemos usar la búsqueda binaria para obtener el índice mínimo de
    // ordenamos la variedad de clavos, y deberíamos revisar los clavos candidatos para obtener el
    // índice mínimo de la matriz original de clavos.
    public static int getMinIndex(int startPlank, int endPlank, int[][] nail, int preIndex) {
        int min = 0;
        int max = nail.length - 1;
        int minIndex = - 1;
        while (min <= max) {
            int mid = (min + max) / 2;
            if (nail[mid][0] < startPlank) {
                min = mid + 1;
            } else if (nail[mid][0] > endPlank) {
                max = mid - 1;
            } else {
                max = mid - 1;
                minIndex = mid;
            }
        }
        if (minIndex == - 1) {
            return - 1;
        }
        int minIndexOrigin = nail[minIndex][1];
        // Encuentra la posición original más pequeña del clavo que puede clavar la tabla
        for (int i = minIndex; i < nail.length; i++) {
            if (nail[i][0] > endPlank) {
                break;
            }
            minIndexOrigin = Math.min(minIndexOrigin, nail[i][1]);
            // Necesitamos el índice máximo de clavos para clavar cada tabla, así que
            // se puede omitir un índice más pequeño
            if (minIndexOrigin <= preIndex) {
                return preIndex;
            }
        }
        return minIndexOrigin;
    }
}
