import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String target = br.readLine();

        String replaced = str.replaceAll(target, "");
        int length = str.length() - replaced.length();
        int count = length / target.length();

        System.out.println(count);
        br.close();
    } // main
} // class