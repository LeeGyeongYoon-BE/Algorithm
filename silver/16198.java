import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] W;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            W[i] = Integer.parseInt(st.nextToken());
        } // for

        dfs(new ArrayList<>(), 0);
        System.out.println(max);
    } // main

    static void dfs(List<Integer> list, int energy) {
        if (list.size() == N) {
            max = Math.max(max, energy);
            return;
        } // if

        for (int i = 1; i < N - 1; i++) {
            if (!list.contains(i)) { // i번째 구슬이 제거되지 않았는지 확인
                // i 제거 시 얻는 에너지
                int left = i - 1;
                while (list.contains(left)) left--;
                int right = i + 1;
                while (list.contains(right)) right++;
                int gain = W[left] * W[right];

                list.add(i);
                dfs(list, energy + gain);
                list.remove(list.size() - 1); // 백트래킹
            } // if
        } // for
    } // dfs
} // class
