import java.io.*;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;


public class Main {
    static boolean isPalindrome(char[] s, int l, int r){
        while (l <= r){
            if (s[l] != s[r]){
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            char[] s = br.readLine().toCharArray();
            int l = 0, r = s.length - 1;
            int ans = 0;
            while(l <= r){
                if (s[l] != s[r]){
                    if (isPalindrome(s, l, r-1) || isPalindrome(s, l+1, r)) {
                        ans = 1;
                    } else {
                        ans = 2;
                    }
                    break;
                }
                l++;
                r--;
            }
            sb.append(ans).append("\n");
        }
        System.out.print(sb);
    }
}
