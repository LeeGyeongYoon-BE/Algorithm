import java.io.*;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }
        Set<Integer> sums = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                sums.add(arr[i] + arr[j]);
            }
        }
        int ans = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++){
                int target = arr[i] - arr[j];
                if (sums.contains(target)) {
                    ans = Math.max(ans, arr[i]);
                }
            }
        }
        System.out.println(ans);
    }
}
