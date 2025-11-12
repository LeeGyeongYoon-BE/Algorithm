import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine()); // 수열의 길이
        int[] arr = new int[N];                  // 입력 수열
        int[] lis = new int[N];                  // LIS 배열 (값 저장용)
        int[] idx = new int[N];                  // 각 원소가 LIS의 몇 번째 위치에 들어갔는지 저장

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // for

        // LIS 배열의 길이를 나타내는 변수
        int len = 0;
        lis[0] = arr[0];
        idx[0] = 0; // 첫 원소는 0번째 위치
        len = 1;    // LIS 길이 1로 초기화

        // O(N log N) LIS 알고리즘
        for (int i = 1; i < N; i++) {
            int now = arr[i];

            // LIS의 마지막 값보다 큰 경우 → LIS에 추가
            if (now > lis[len - 1]) {
                lis[len] = now;
                idx[i] = len; // 이 원소는 len번째 위치에 들어감
                len++;
            } else {
                // 이분 탐색으로 LIS 배열에서 교체 위치 탐색
                int pos = Arrays.binarySearch(lis, 0, len, now);
                if (pos < 0) pos = -(pos + 1); // 삽입 위치로 변환
                lis[pos] = now;                 // 해당 위치 값 갱신
                idx[i] = pos;                   // 이 원소는 pos 위치에 들어감
            } // if ~ else
        } // for

        // 실제 LIS 수열을 복원하기 위한 스택
        Stack<Integer> stack = new Stack<>();
        int target = len - 1; // 복원할 LIS의 마지막 인덱스

        // 뒤에서부터 추적
        for (int i = N - 1; i >= 0; i--) {
            // idx[i]가 현재 찾는 위치와 같으면 LIS에 포함됨
            if (idx[i] == target) {
                stack.push(arr[i]);
                target--; // 그 다음 위치로 이동
            } // if
        } // for

        // 결과 출력
        sb.append(len).append("\n"); // LIS의 길이 출력
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" "); // 수열 원소 출력
        } // while

        System.out.println(sb);
        br.close();
    } // main
} // class
