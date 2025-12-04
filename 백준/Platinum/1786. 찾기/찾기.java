import java.io.*;
import java.util.*;

public class Main {
    static String T, P;
    static int[] skip;
    static List<Integer> answer = new ArrayList<>();

    private static void makeSkip(String pattern) {
        int m = pattern.length();
        skip = new int[m];
        int j = 0;

        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern.charAt(i) != pattern.charAt(j)) {
                j = skip[j - 1];
            }
            if (pattern.charAt(i) == pattern.charAt(j)) {
                skip[i] = ++j;
            }
        }
    }

    private static void kmpSearch(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();
        int j = 0;

        for (int i = 0; i < n; i++) {
            while (j > 0 && text.charAt(i) != pattern.charAt(j)) {
                j = skip[j - 1];
            }
            if (text.charAt(i) == pattern.charAt(j)) {
                if (j == m - 1) {
                    answer.add(i - m + 2); // (i - m + 1) + 1 → 1-based index
                    j = skip[j];
                } else {
                    j++;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = br.readLine();
        P = br.readLine();

        makeSkip(P);
        kmpSearch(T, P);

        System.out.println(answer.size());
        for (int pos : answer) {
            System.out.println(pos);
        }
    }
}
