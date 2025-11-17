import java.io.*;
import java.nio.file.Path;
import java.util.*;

class Student {
    int number;
    int scr;
    int postedAt;
    Student(int number, int scr, int postedAt) {
        this.number = number;
        this.scr = scr;
        this.postedAt = postedAt;
    }
}

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int r = Integer.parseInt(br.readLine());
        List<Student> post = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < r; i++) {
            int votedNumber = Integer.parseInt(st.nextToken());
            boolean alreadyVoted = false;
            for (int j = 0; j < post.size(); j++) {
                if (post.get(j).number == votedNumber) {
                    post.get(j).scr++;
                    alreadyVoted = true;
                    break;
                }
            }
            if (!alreadyVoted) {
                if (post.size() < n){
                    post.add(0, new Student(votedNumber, 1, i));
                } else {
                    Collections.sort(post, (o1, o2) ->
                            o1.scr == o2.scr ? o1.postedAt - o2.postedAt : o1.scr - o2.scr);
                    post.set(0, new Student(votedNumber, 1, i));
                }
            }
        }
        Collections.sort(post, (o1, o2) -> o1.number - o2.number);
        for (Student std : post) {
            System.out.print(std.number + " ");
        }
        System.out.println();
    }
}
