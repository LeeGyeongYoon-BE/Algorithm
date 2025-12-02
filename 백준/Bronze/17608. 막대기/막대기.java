import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N - 1; i++) {
            stack.push(Integer.parseInt(br.readLine()));
        } // for
        int ans = 1;
        int max = Integer.parseInt(br.readLine());

        while (!stack.isEmpty()) {
            int tall = stack.pop();
            if (tall > max) {
                ans++;
                max = tall;
            } // if
        } // while

        System.out.println(ans);
        br.close();
    } // main

} // class
