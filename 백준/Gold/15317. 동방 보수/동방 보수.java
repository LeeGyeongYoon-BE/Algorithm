import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
    static long calcNeedAmount(int[] cost, int[] budget, int assignCount){
        long needAmount = 0;
        for (int i = 0; i < assignCount; i++){
            needAmount += Math.max(cost[i] - budget[budget.length - assignCount + i], 0);
        }
        return needAmount;
    }
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        
        int[] cost = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            cost[i] = Integer.parseInt(st.nextToken());
        }
        
        int[] budget = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++){
            budget[i] = Integer.parseInt(st.nextToken());
        }
        
        Arrays.sort(cost);
        Arrays.sort(budget);
        
        int l = 0, r = Math.min(N, M), ans = 0;
        while (l <= r){
            int m = (l + r) / 2;
            if (calcNeedAmount(cost, budget, m) <= X){
                ans = m;
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        System.out.println(ans);
    }
    
}