import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // for

        ArrayList<Integer> dp = new ArrayList<>();

        for (int num : arr) {
            int pos = Collections.binarySearch(dp, num);

            if (pos < 0) {
                pos = -(pos + 1); // 삽입 위치로 변환
            } // if

            if (pos == dp.size()) {
                dp.add(num);      // 제일 큰 경우 뒤에 추가
            } else {
                dp.set(pos, num); // 더 작은 값으로 교체
            } // if ~ else
        } // for

        System.out.println(dp.size());
    } // main
} // class
