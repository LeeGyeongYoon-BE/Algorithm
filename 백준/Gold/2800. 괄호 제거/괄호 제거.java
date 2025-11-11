import java.io.*;
import java.util.*;

public class Main {

    static String input;
    static List<int[]> bracketPairs = new ArrayList<>();
    static Set<String> result = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        input = br.readLine();

        // 괄호 위치 찾기
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                stack.push(i);
            } else if (input.charAt(i) == ')') {
                int start = stack.pop();
                bracketPairs.add(new int[]{start, i});
            } // if ~ else if
        } // for

        // 모든 조합으로 괄호 제거
        dfs(0, new boolean[bracketPairs.size()]);

        // 결과 정렬 후 출력
        List<String> list = new ArrayList<>(result);
        Collections.sort(list);
        for (String s : list) {
            System.out.println(s);
        } // for
    } // main

    // 조합으로 괄호 제거
    static void dfs(int idx, boolean[] selected) {
        if (idx == bracketPairs.size()) {
            StringBuilder sb = new StringBuilder();
            boolean[] remove = new boolean[input.length()];
            for (int i = 0; i < bracketPairs.size(); i++) {
                if (selected[i]) {
                    remove[bracketPairs.get(i)[0]] = true;
                    remove[bracketPairs.get(i)[1]] = true;
                } // if
            } // for
            for (int i = 0; i < input.length(); i++) {
                if (!remove[i]) sb.append(input.charAt(i));
            } // for
            if (!sb.toString().equals(input)) // 원래 식 제외
                result.add(sb.toString());
            return;
        } // if

        // 선택 안함
        dfs(idx + 1, selected);
        // 선택함
        selected[idx] = true;
        dfs(idx + 1, selected);
        selected[idx] = false;
    } // dfs
} // class
