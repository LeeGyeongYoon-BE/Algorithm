import java.io.*;
import java.util.*;

public class Main {
    static String input;
    static boolean[] used;
    static ArrayList<Integer> result = new ArrayList<>();
    static boolean finished = false;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        used = new boolean[51]; // 최대 50까지 가능

        dfs(0);

        StringBuilder sb = new StringBuilder();
        for (int n : result) {
            sb.append(n).append(" ");
        } // for
        System.out.print(sb);
        
        br.close();
    } // main

    static void dfs(int idx) {
        if (finished) return;

        if (idx == input.length()) {
            // 1부터 max까지 정확히 사용됐는지 체크
            int max = 0;
            for (int n : result) max = Math.max(max, n);

            for (int i = 1; i <= max; i++) {
                if (!used[i]) return;
            } // for

            // 정답 발견
            finished = true;
            return;
        } // if

        // 1자리 숫자
        if (idx + 1 <= input.length()) {
            int num = Integer.parseInt(input.substring(idx, idx + 1));

            if (num >= 1 && !used[num]) {
                used[num] = true;
                result.add(num);
                dfs(idx + 1);
                if (finished) return;
                used[num] = false;
                result.remove(result.size() - 1);
            } // if
        } // if

        // 2자리 숫자
        if (idx + 2 <= input.length()) {
            int num = Integer.parseInt(input.substring(idx, idx + 2));

            if (num >= 1 && num <= 50 && !used[num]) {
                used[num] = true;
                result.add(num);
                dfs(idx + 2);
                if (finished) return;
                used[num] = false;
                result.remove(result.size() - 1);
            } // if
        } // if
    } // dfs
} // class
