import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input =  br.readLine().toCharArray();
        int openCount = 0;
        int ans = 0;
        for (int i = 0; i <  input.length; i++) {
            if (input[i] == '(') {
                openCount++;
            } else {
                openCount--;
                if (input[i - 1] == '('){
                    ans +=  openCount;
                } else {
                    ans++;
                }
            }
        }
        System.out.println(ans);
    } // main
} // class
