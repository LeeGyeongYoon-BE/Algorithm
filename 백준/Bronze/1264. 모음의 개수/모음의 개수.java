import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] alphabet = {'a', 'e', 'i', 'o', 'u'};
        while (true) {
            String str = br.readLine();
            if (str.equals("#")) {
                break;
            } // if

            str = str.toLowerCase();
            
            int count = 0;
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < alphabet.length; j++) {
                    if (str.charAt(i) == alphabet[j]) {
                        count++;
                    }
                }
            }
            System.out.println(count);
        } // while
        br.close();
    } // main
} // class