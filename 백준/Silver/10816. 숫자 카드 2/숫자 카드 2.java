import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 1. 상근이가 가지고 있는 카드 수
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 카드 개수를 저장할 map
        HashMap<Integer, Integer> map = new HashMap<>();

        // 2. 카드 입력받아서 map에 저장 (key: 숫자, value: 개수)
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // 3. 검사할 숫자 수
        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        // 4. 각 숫자에 대해 map에서 개수 출력
        for (int i = 0; i < m; i++) {
            int key = Integer.parseInt(st.nextToken());
            sb.append(map.getOrDefault(key, 0)).append(" ");
        }

        // 5. 결과 출력
        System.out.println(sb);
    }
}
