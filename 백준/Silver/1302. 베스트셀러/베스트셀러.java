import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String name = br.readLine();
            map.put(name, map.getOrDefault(name, 0) + 1); // ✅ 등장 횟수 세기
        } // for

        // 최댓값 찾기
        int max = Collections.max(map.values());

        // 최댓값을 가진 책들 중 사전순으로 가장 앞선 것 찾기
        List<String> bestsellers = new ArrayList<>();
        for (String key : map.keySet()) {
            if (map.get(key) == max) {
                bestsellers.add(key);
            } // if
        } // for

        Collections.sort(bestsellers);

        System.out.println(bestsellers.get(0)); // ✅ 사전순 첫 번째 출력
        br.close();
    } // main
} // class
