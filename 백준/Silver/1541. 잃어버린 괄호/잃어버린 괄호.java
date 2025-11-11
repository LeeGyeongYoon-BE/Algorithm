import java.io.*;
import java.util.*;
public class Main {
    static int answer = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] example =  br.readLine().split("-");
        for (int i = 0; i < example.length; i++) {
            int temp = mySum(example[i]);
            if (i == 0) answer +=  temp;
            else answer -= temp;
        }
        System.out.println(answer);
    }
    private static int mySum(String string){
        int sum = 0;
        String[] str = string.split("[+]");
        for (int i = 0; i < str.length; i++) {
            sum += Integer.parseInt(str[i]);
        }
        return sum;
    }
}
