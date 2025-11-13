import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Map<String, String> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String name = st.nextToken();
            String status = st.nextToken();

            if (status.equals("enter")) {
                map.put(name, status);   // 입장
            } else {
                map.remove(name);        // 퇴장
            } // if ~ else
        } // for

        // 남은 사람 이름들만 가져오기
        List<String> list = new ArrayList<>(map.keySet());

        // 역순(내림차순) 정렬
        Collections.sort(list, Collections.reverseOrder());

        for (String name : list) {
            System.out.println(name);
        } // for

        br.close();
    } // main
} // class
