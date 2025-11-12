import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        boolean[] xLine = new boolean[N];
        boolean[] yLine = new boolean[M];


        for (int i = 0; i < N; i++) {
            String[] str = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                String target = str[j];
                if (target.equals("X")) {
                    xLine[i] = true;
                    yLine[j] = true;
                } // if
            } // for - j
        } // for - i

        int countX = 0;
        for (int i = 0; i < N; i++) {
            if (!xLine[i]) {
                countX++;
            } // if
        } // for

        int countY = 0;
        for (int i = 0; i < M; i++) {
            if (!yLine[i]) {
                countY++;
            } // if
        } // for

        System.out.println(Math.max(countX, countY));

        br.close();
    } // main
} // class