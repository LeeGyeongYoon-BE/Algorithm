import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            int[] a = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++){
                a[i] = Integer.parseInt(st.nextToken());
            }
            int[] b = new int[M];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < M; i++){
                b[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(a);
            Arrays.sort(b);

            int ans = 0;
            int bi = 0;
            for (int i = 0; i < N; i++){
                while (bi < M && b[bi] < a[i]){
                    bi++;
                }
                ans += bi;
            }
            System.out.println(ans);
        }
    }
}