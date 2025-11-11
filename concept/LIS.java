// 주어진 수열에서 증가하는 부분 수열 중 가장 긴 길이를 구하는 문제
// 부분 수열(Subsequence): 연속일 필요 없음
// 대표적인 동적 계획법(DP) 문제

// 길이만 구할 수도 있고, 실제 수열까지 구할 수도 있음
// 구현 방법에 따라 O(N²), O(N log N)로 나뉨
// 주로 DP 배열을 사용하거나 이진 탐색을 활용

// DP 방식
import java.io.*;
import java.util.*;

public class LIS_DP {
    public static void main(String[] args) throws IOException {
        int[] arr = {10, 20, 10, 30, 20, 50};
        int N = arr.length;
        int[] dp = new int[N];
        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[j] < arr[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } // if
            } // for - j
        } // for - i

        int maxLen = 0;
        for (int len : dp) maxLen = Math.max(maxLen, len);
        System.out.println("LIS 길이: " + maxLen);
    } // main
} // class

// 이진 탐색 활용
import java.io.*;
import java.util.*;

public class LIS_BinarySearch {
    public static void main(String[] args) {
        int[] arr = {10, 20, 10, 30, 20, 50};
        ArrayList<Integer> list = new ArrayList<>();

        for (int num : arr) {
            int idx = Collections.binarySearch(list, num);
            if (idx < 0) idx = -(idx + 1); // 삽입 위치 계산
            if (idx < list.size()) list.set(idx, num);
            else list.add(num);
        } // for

        System.out.println("LIS 길이: " + list.size());
    } // main
} // class
