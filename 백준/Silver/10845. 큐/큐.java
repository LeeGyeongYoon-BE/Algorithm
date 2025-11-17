import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();
        int lastValue = 0;
        while(N-->0){
            st = new StringTokenizer(br.readLine());
            String order = st.nextToken();
            if (order.equals("push")){
                lastValue = Integer.parseInt(st.nextToken());
                queue.offer(lastValue);
            } else if (order.equals("pop")){
                if (!queue.isEmpty()){
                    sb.append(queue.poll()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (order.equals("size")){
                sb.append(queue.size()).append("\n");
            } else if (order.equals("empty")){
                if (queue.isEmpty()){
                    sb.append("1\n");
                } else {
                    sb.append("0\n");
                }
            } else if (order.equals("front")){
                if (!queue.isEmpty()){
                    sb.append(queue.peek()).append("\n");
                } else {
                    sb.append("-1\n");
                }
            } else if (order.equals("back")){
                if (!queue.isEmpty()){
                    sb.append(lastValue).append("\n");
                } else {
                    sb.append("-1\n");
                }
            }
        }
        System.out.println(sb);
    } // main
} // class
