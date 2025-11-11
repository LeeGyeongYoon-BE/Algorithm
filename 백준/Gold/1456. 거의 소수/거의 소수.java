import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long Min = Long.parseLong(st.nextToken());
        long Max = Long.parseLong(st.nextToken());
        long[] A = new long[10000001];
        for (int i = 2; i < 10000001; i++) {
            A[i] = i;
        } // for

        for (int i = 2; i <= Math.sqrt(10000001); i++) {
            if (A[i] == 0) {
                continue;
            } // if
            for (int j = i + i; j < 10000001; j += i) {
                A[j] = 0;
            } // for - j
        } // for - i

        int count = 0;
        for (int i = 2; i <= 10000000; i++) {
            if (A[i] != 0) {
                long temp = A[i];
                while ( (double) A[i] <= (double) Max / (double) temp ) {
                    if ((double) A[i] >= (double) Min / (double) temp) {
                        count++;
                    } // if
                    temp = temp * A[i];
                } // while
            } // if
        } // for
        System.out.println(count);
        br.close();
    } // main
} // class