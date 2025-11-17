import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] q = new int[n][3];
        for (int i = 0; i< n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            q[i][0] = Integer.parseInt(st.nextToken());
            q[i][1] = Integer.parseInt(st.nextToken());
            q[i][2] = Integer.parseInt(st.nextToken());
        }
        int ans = 0;
        for (int x = 1; x <= 9; x++){
            for (int y = 1; y <= 9; y++){
                for (int z = 1; z <= 9; z++){
                    if (x == y || y == z || x == z){
                        continue;
                    }
                    boolean psb = true;
                    for (int i = 0; i < n; i++){
                        int qx = q[i][0] / 100;
                        int qy = (q[i][0] / 10) % 10;
                        int qz = q[i][0] % 10;

                        int strike = 0;
                        int ball = 0;
                        if (x == qx){
                            strike++;
                        } else if (x == qy || x == qz){
                            ball++;
                        }
                        if (y == qy){
                            strike++;
                        } else if (y == qx || y == qz){
                            ball++;
                        }
                        if (z == qz) {
                            strike++;
                        } else if (z == qx || z == qy){
                            ball++;
                        }
                        if (strike != q[i][1] || ball != q[i][2]){
                            psb = false;
                            break;
                        }
                    }
                    if (psb){
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}