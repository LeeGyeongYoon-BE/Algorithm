import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N =  Integer.parseInt(br.readLine());
        int ans = 0;
        while(N-->0){
            char[] input =  br.readLine().toCharArray();
            char[] st =  new char[input.length];
            int idx = -1;
            for (char ch : input){
                if (idx < 0) {
                    st[++idx] = ch;
                } else if (st[idx] == ch) {
                    idx--;
                } else {
                    st[++idx] = ch;
                }
            }
            if (idx < 0) {
                ans++;
            }

        } // while
        System.out.println(ans);
    } // main
} // class
