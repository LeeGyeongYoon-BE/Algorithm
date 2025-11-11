import java.io.*;
import java.util.*;
public class Main {
    static class Pair implements Comparable<Pair> {
        int value;
        int originalIndex;
        Pair(int value, int originalIndex) {
            this.value = value;
            this.originalIndex = originalIndex;
        }

        @Override
        public int compareTo(Pair o) {
            return  this.value - o.value;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pair[] A = new Pair[N];
        for (int i = 0; i < N; i++) {
            int val = Integer.parseInt(br.readLine());
            A[i] = new Pair(val, i);
        }
        Arrays.sort(A);

        int maxMove = 0;
        for (int i = 0; i < N; i++){
            int move = A[i].originalIndex - i;
            maxMove = Math.max(move, maxMove);
        }
        System.out.println(maxMove+1);
    }
}