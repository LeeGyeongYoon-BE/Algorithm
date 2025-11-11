import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // for
        Arrays.sort(arr);

        int count = 0;

        for (int i = 0; i < N; i++) {
            long target = arr[i];
            int start = 0;
            int end = N - 1;
            while (start < end) {
                if (arr[start] + arr[end] == target) {
                    if (start != i && end != i){
                        count++;
                        break;
                    } else if (start == i) {
                        start++;
                    } else if (end == i){
                        end--;
                    } // if ~ else if
                } else if (arr[start] + arr[end] > target) {
                    end--;
                } else {
                    start++;
                } // if ~ else
            } // while
        } // for
        System.out.println(count);

        br.close();
    } // main
} // class
