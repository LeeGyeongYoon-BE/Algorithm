import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] num = br.readLine().toCharArray();

        Stack<Character> stack = new Stack<>();

        int removeCount = 0;
        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && removeCount < K && stack.peek() < num[i]) {
                stack.pop();
                removeCount++;
            } // while
            stack.push(num[i]);
        } // for

        // 아직 제거 횟수가 남았을 수 있음
        while (removeCount < K) {
            stack.pop();
            removeCount++;
        } // while

        StringBuilder sb = new StringBuilder();
        for (char c : stack) sb.append(c);
        System.out.println(sb);
    } // main
} // class
