import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String line = br.readLine();
            if (line.equals(".")) {
                break; // 입력 종료
            } // if

            Stack<Character> stack = new Stack<>();
            boolean isBalanced = true;

            for (int i = 0; i < line.length(); i++) {
                char c = line.charAt(i);

                if (c == '(' || c == '[') {
                    stack.push(c);
                } else if (c == ')') {
                    if (!stack.isEmpty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    } // if ~ else
                } else if (c == ']') {
                    if (!stack.isEmpty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        isBalanced = false;
                        break;
                    } // if ~ else
                } // if ~ else
            } // for

            if (stack.isEmpty() && isBalanced) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            } // if ~ else
        } // while

        br.close();
    } // main
} // class
