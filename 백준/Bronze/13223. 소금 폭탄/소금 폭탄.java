import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] nowTime = br.readLine().split(":");
        String[] saltTime = br.readLine().split(":");

        int nowTimeSeconds = Integer.parseInt(nowTime[0]) * 3600 + Integer.parseInt(nowTime[1]) * 60 + Integer.parseInt(nowTime[2]);
        int saltTimeSeconds = Integer.parseInt(saltTime[0]) * 3600 + Integer.parseInt(saltTime[1]) * 60 + Integer.parseInt(saltTime[2]);

        int ansTimeSeconds = saltTimeSeconds - nowTimeSeconds;
        if (ansTimeSeconds <= 0) {
            ansTimeSeconds += 3600 * 24;
        } // if

        System.out.printf("%02d:%02d:%02d", ansTimeSeconds / 3600, (ansTimeSeconds % 3600) / 60 , ansTimeSeconds % 60);
        System.out.println();

        br.close();
    } // main
} // class