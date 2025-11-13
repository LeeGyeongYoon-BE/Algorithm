import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
    static int calcTotalBudget(int[] budgets, int budgetLimit) {
        int sum = 0;
        for (int budget : budgets)
            sum += Math.min(budget, budgetLimit);
        return sum;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] budgets = new int[N];
        int maxBudget = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            budgets[i] = Integer.parseInt(st.nextToken());
            maxBudget = Math.max(maxBudget, budgets[i]);
        }
        int M = Integer.parseInt(br.readLine());

        int l = 1, r = maxBudget, ans = -1;
        while (l <= r) {
            int m = (l + r) / 2;
            int totalBudget = calcTotalBudget(budgets, m);
            if (totalBudget <= M) {
                ans = m;
                l = m + 1;
            }
            else r = m - 1;
        }
        System.out.println(ans);
    }
}