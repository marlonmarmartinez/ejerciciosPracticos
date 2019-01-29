package ejerciciospracticas4;

import java.util.stream.IntStream;

public class DwarfsRafting {

    public static void main(String[] args) {
         int N = 4;String  S = "1B 1C 4B 1D 2A" ; String T = "3B 2D";
         System.out.println(solution(N, S, T));
    }
    //solucion con bug
    
    private static int[] dwarfs;
    private static int[] capacity;

    public static int solution(int N, String S, String T) {
        if (N % 2 == 1) {
            return -1;
        }
        S = S.toLowerCase();
        T = T.toLowerCase();
        int[] barrels = parseString(S, N);
        dwarfs = parseString(T, N);
        capacity = new int[4];
        for (int i = 0; i < barrels.length; i++) {
            capacity[i] = (N * N / 4) - barrels[i];
        }
        int diagonal = getBalanced(0, 3);
        int antiDiagonal = getBalanced(1, 2);
        if (diagonal < 0 || antiDiagonal < 0) {
            return -1;
        }
        return diagonal + antiDiagonal - IntStream.of(dwarfs).sum();
    }

    private static int charToInt(char letter) {
        return letter - 'a';
    }

    private static int getBalanced(int left, int right) {
        int balance = Math.min(capacity[left], capacity[right]);
        if (balance < Math.max(dwarfs[left], dwarfs[right])) {
            return -1;
        } else {
            return balance * 2;
        }
    }

    private static int[] parseString(String in, int N) {
        if (in.isEmpty()) {
            return new int[4];
        }
        int[] data = new int[4];
        String[] chunks = in.split(" ");
        for (String chunk : chunks) {
            int column = Integer.parseInt(chunk.substring(0, chunk.length() - 1));
            int row = charToInt(chunk.charAt(chunk.length() - 1));
            if (column <= N / 2) {
                if (row < N / 2) {
                    data[0]++;
                } else {
                    data[1]++;
                }
            } else {
                if (row < N / 2) {
                    data[2]++;
                } else {
                    data[3]++;
                }
            }
        }
        return data;
    }
}
