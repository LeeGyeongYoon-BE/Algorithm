import java.io.*;
import java.util.*;


public class Main {
    static int calculateCount(int[] lengths, long cutLength){
        int cnt = 0;
        for (int l : lengths) {
            cnt += l / cutLength;
        }
        return cnt;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] len = new int[k];
        for (int i = 0; i < k; i++) {
            len[i] = Integer.parseInt(br.readLine());
        }
        long l = 1, r = (1L << 31) - 1, ans = -1;
        while (l <= r){
            long m = l + (r - l) / 2;
            if (calculateCount(len, m) >= n){
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println(ans);

    }
}
