import java.io.*;
import java.util.*;

public class Main {

    static class State{
        int[] x;
        State(int[] _X){
            x = new int[3];
            for (int i =0; i < 3; i++) x[i] = _X[i];
        }
        State move(int from, int to, int[] Limit){
            int[] nx = new int[]{x[0], x[1], x[2]};
            if (x[from] + x[to] >= Limit[to]){
                nx[from] -= Limit[to] - x[to];
                nx[to] = Limit[to];
            } else {
                nx[to] += nx[from];
                nx[from] = 0;
            }
            return new State(nx);
        }
    }
    static StringBuilder sb = new StringBuilder();
    static int[] Limit;
    static boolean[] possible;
    static boolean[][][] visit;

    static void bfs(int x1, int x2, int x3){
        Queue<State> q = new LinkedList<>();
        visit[x1][x2][x3] = true;
        q.add(new State(new int[]{x1, x2, x3}));

        while (!q.isEmpty()){
            State st = q.poll();
            if (st.x[0] == 0) possible[st.x[2]] = true;
            for (int from = 0; from < 3; from++){
                for (int to = 0; to < 3; to++){
                    if (from == to) continue;
                    State nxt = st.move(from, to, Limit);

                    if (!visit[nxt.x[0]][nxt.x[1]][nxt.x[2]]){
                        visit[nxt.x[0]][nxt.x[1]][nxt.x[2]] = true;
                        q.add(nxt);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        Limit = new int[3];
        for (int i = 0; i < 3; i++) {
            Limit[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[205][205][205];
        possible = new boolean[205];

        bfs(0, 0, Limit[2]);
        for (int i = 0; i <= Limit[2]; i++){
            if (possible[i]) sb.append(i).append(" ");
        }
        System.out.println(sb.toString());
    }
}
