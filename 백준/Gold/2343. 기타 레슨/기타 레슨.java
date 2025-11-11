import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

class Main
{
    public static boolean isPossible(int[] lengths, int videoLength, int videoCount){
        int currentLength = 0;
        int currentCount = 1;
        for (int len : lengths){
            if (len > videoLength) {
                return false;
            }
            if (currentLength + len > videoLength) {
                if (++currentCount > videoCount){
                    return false;
                }
                currentLength = 0;
            }
            currentLength += len;
        }
        return true;
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] lengths = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            lengths[i] = Integer.parseInt(st.nextToken());
        }
        int l = 1, r = n*10000, ans = -1;
        while(l<=r){
            int mid = (l+r)/2;
            if (isPossible(lengths, mid, m)) {
                ans = mid;
                r = mid-1;
            } else {
                l = mid+1;
            }
        }
        System.out.println(ans);

    }
}