import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            if ('A' <=  str.charAt(i) && str.charAt(i) <= 'Z') {
                sb.append((char) ('a' +  str.charAt(i) - 'A'));
            } else {
                sb.append((char) ('A' + str.charAt(i) - 'a'));
            }
        }
        System.out.println(sb);
    } // main
} // class
