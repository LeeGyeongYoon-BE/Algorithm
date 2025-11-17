import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            q.add(i);
        } // for

        sb.append("<");
        while (q.size() != 1) {
            int count = 1;
            while (count != K) {
                q.offer(q.poll());
                count++;
            } // while
            sb.append(q.poll()).append(", ");
        } // while

        sb.append(q.poll()).append(">");

        System.out.println(sb);
        br.close();
    } // main
} // class
