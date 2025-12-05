import java.io.*;

public class Main {
    static int n;
    static StringBuilder sb = new StringBuilder();
    static int[] selected;
    static boolean[] used;

    static void rec_func(int k){
        if (k == n + 1){
            for (int i = 1; i <= n; i++){
                sb.append(selected[i]);
                if (i < n) sb.append(" ");  // 마지막 공백 제거
            }
            sb.append("\n");
        } else {
            for (int cand = 1; cand <= n; cand++){
                if (!used[cand]){
                    selected[k] = cand;
                    used[cand] = true;

                    rec_func(k + 1);

                    used[cand] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        selected = new int[n + 1];
        used = new boolean[n + 1];

        rec_func(1);
        System.out.print(sb);
    }
}
