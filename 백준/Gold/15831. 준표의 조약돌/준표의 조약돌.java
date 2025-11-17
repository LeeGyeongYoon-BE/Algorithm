import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());
        char[] color = br.readLine().toCharArray();

        int countBlack = 0;
        int countWhite = 0;
        int nextIndex = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (nextIndex < n) {
                if (color[nextIndex] == 'B' && countBlack == b) {
                    break;
                }
                if (color[nextIndex++] == 'W') {
                    countWhite++;
                } else {
                    countBlack++;
                }
            }
            if (countWhite >= w) {
                ans = Math.max(ans, nextIndex - i);
            }
            if (color[i] == 'W') {
                countWhite--;
            } else {
                countBlack--;
            }
        }
        sb.append(ans);
        System.out.println(sb);
    }
}
