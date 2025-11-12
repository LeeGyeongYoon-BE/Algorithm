import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] cArr = br.readLine().toCharArray();
        int[] alp = new int[26];
        for (int i = 0; i < cArr.length; i++) {
            if ('a' <= cArr[i] && cArr[i] <= 'z') {
                alp[cArr[i] - 'a']++;
            } else {
                alp[cArr[i] - 'A']++;
            } // if ~ else
        } // for

        int maxIdx = 0;
        int maxCount = 0;
        for (int i = 0; i < alp.length; i++) {
            int count = alp[i];
            if (count > maxCount) {
                maxCount = count;
                maxIdx = i;
            } else if (count == maxCount) {
                maxIdx = 987654321;
            } // if ~ else
        } // for
 
        if (maxIdx == 987654321) {
            System.out.println('?');
        } else {
            System.out.println((char) (maxIdx + 'A'));
        } // if ~ else
        
        br.close();
    } // main
} // class