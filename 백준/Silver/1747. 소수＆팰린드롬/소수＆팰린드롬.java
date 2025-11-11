import java.io.*;
import java.util.*;

class Main
{
    static long[] A;
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        A = new long[10000001];
        for (int i = 2; i < 10000001; i++) {
            A[i] = i;
        } // for

        // 소수 판별
        for (int i = 2; i <= Math.sqrt(10000001); i++) {
            if (A[i] == 0) {
                continue;
            } // if
            for (int j = i + i; j < 10000001; j += i) {
                A[j] = 0;
            } // for - j
        } // for - i

        for (int i = N; i < A.length; i++) {
            if (A[i] != 0 && isPalind(i)) {
                System.out.println(i);
                break;
            } // if
        } // for

        br.close();
    } // main

    private static boolean isPalind(int num) {
        String s = Integer.toString(num);
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    } // isPalind

} // class