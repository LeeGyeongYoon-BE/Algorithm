import java.io.*;
import java.util.*;

class Job {
    int index;
    int priority;
    Job(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }
}

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int M = Integer.parseInt(input[1]);

            Queue<Job> q = new LinkedList<>();
            Integer[] prioritySequence = new Integer[N];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {

                prioritySequence[i] = Integer.parseInt(st.nextToken());
                q.offer(new Job(i, prioritySequence[i]));
            }

            Arrays.sort(prioritySequence, Collections.reverseOrder());

            for (int i = 0; i < N; i++) {
                while (q.peek().priority != prioritySequence[i]) {
                    q.offer(q.poll());
                }
                if (q.peek().index == M){
                    System.out.println(i + 1);
                    break;
                }
                q.poll();
            }

        }
    }
}