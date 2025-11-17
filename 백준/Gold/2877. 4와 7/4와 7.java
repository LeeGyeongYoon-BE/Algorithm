import java.io.*;
import java.nio.file.Path;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String ans = Integer.toBinaryString(n + 1).replace('0', '4').replace('1', '7');
        System.out.println(ans.substring(1));
    }
}
