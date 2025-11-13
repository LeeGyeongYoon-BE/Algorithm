import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        } // for

        // 정렬 + 중복 제거
        int[] sorted = Arrays.stream(arr).distinct().sorted().toArray();

        // 각 숫자의 압축값(순서) 저장
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < sorted.length; i++) {
            map.put(sorted[i], i);
        } // for

        // 원본 배열을 압축값으로 변환
        for (int i = 0; i < N; i++) {
            sb.append(map.get(arr[i])).append(" ");
        } // for

        System.out.println(sb);
    } // main
} // class
