import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] cnt = new int[10];
        while (n > 0){
            cnt[n%10]++;
            n/=10;
        }
        int ans = (cnt[6] + cnt[9] + 1) / 2;
        for (int i = 0; i < 9; i++){
            if (i != 6){
                ans = Math.max(ans, cnt[i]);
            }
        }
        System.out.println(ans);
    }
}