import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        Stack<Character> stack = new Stack<>();
        int tmp = 1; // 곱셈 누적값
        int ans = 0;

        for (int i = 0; i < input.length; i++) {
            char c = input[i];

            if (c == '(') {
                stack.push(c);
                tmp *= 2;
            } else if (c == '[') {
                stack.push(c);
                tmp *= 3;
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    ans = 0;
                    break;
                } // if
                if (input[i - 1] == '(') ans += tmp;
                stack.pop();
                tmp /= 2;
            } else if (c == ']') {
                if (stack.isEmpty() || stack.peek() != '[') {
                    ans = 0;
                    break;
                } // if
                if (input[i - 1] == '[') ans += tmp;
                stack.pop();
                tmp /= 3;
            } // if ~ else
        } // for

        if (!stack.isEmpty()) ans = 0;
        System.out.println(ans);

        br.close();
    } // main
} // class
