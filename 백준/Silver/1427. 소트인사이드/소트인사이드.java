import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int[] A = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            A[i] = Integer.parseInt(str.substring(i, i + 1));
        } // for

        // selection sort
        for (int i = 0; i < str.length(); i++) {
            int max = i;
            for (int j = i + 1; j < str.length(); j++) {
                if (A[j] > A[max]) {
                    max = j;
                } // if
            } // for - j
            if (A[i] < A[max]) {
                int tmp = A[i];
                A[i] = A[max];
                A[max] = tmp;
            } // if
        } // for - i

        for (int i = 0; i < str.length(); i++) {
            System.out.print(A[i]);
        } // for

        System.out.println();
        br.close();
    } // main
} // class