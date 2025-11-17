import java.io.*;
import java.util.*;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        Queue<Integer> q = new LinkedList<>();
        while (true) {
            int cmd = Integer.parseInt(br.readLine());
            if (cmd == -1) {
                break;
            }
            else if (cmd == 0) {
                if (q.isEmpty()) {
                    continue;
                }
                q.poll();
            } else {
                if (q.size() < N){
                    q.offer(cmd);
                }
                else {
                    continue;
                }
            }
        }
        if (q.isEmpty()) {
            bw.write("empty\n");
        } else {
            while (!q.isEmpty()) {
                bw.write(q.poll() + " ");
            }
        }
        bw.write("\n");
        bw.flush();
    }
}